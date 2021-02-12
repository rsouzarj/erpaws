/*     */ package FormaPagamento;
/*     */ 
/*     */ import ClausulaSQL.ClausulaWhere;
/*     */ import Util.Conexao;
/*     */ import Util.Sequence;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormaPagamentoDAO
/*     */ {
/*     */   public FormaPagamento inserir(FormaPagamento formaPagamento)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_FORMA_PAGAMENTO");
/*  28 */       formaPagamento.setSeqFormaPagamento(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into FORMA_PAGAMENTO (SEQ_FORMA_PAGAMENTO,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,NOME, teste) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, formaPagamento.getSeqFormaPagamento());
/*  38 */       ps.setString(2, formaPagamento.getSeqEmpresa());
/*  39 */       ps.setDate(3, new java.sql.Date(formaPagamento.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, formaPagamento.getSituacao());
/*  41 */       ps.setString(5, formaPagamento.getNome());
/*  42 */       ps.setString(6, formaPagamento.getTeste());
/*     */       
/*  44 */       ps.execute();
/*  45 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  48 */       Logger.getLogger(FormaPagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  49 */       System.out.println(ex.getMessage());
/*     */     }
/*  51 */     return formaPagamento;
/*     */   }
/*     */   
/*     */   public FormaPagamento alterar(FormaPagamento formaPagamento) {
/*     */     try {
/*  56 */       Conexao conexao = new Conexao();
/*  57 */       Connection conn = Conexao.getConnection();
/*  58 */       String sql = "update FORMA_PAGAMENTO set SEQ_EMPRESA = ?,DATA_CADASTRO = ?,SITUACAO = ?,NOME = ?, teste = ? where SEQ_FORMA_PAGAMENTO = ? ";
/*     */       
/*  60 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  62 */       ps.setString(1, formaPagamento.getSeqEmpresa());
/*  63 */       ps.setDate(2, new java.sql.Date(formaPagamento.getDataCadastro().getTime()));
/*  64 */       ps.setString(3, formaPagamento.getSituacao());
/*  65 */       ps.setString(4, formaPagamento.getNome());
/*  66 */       ps.setString(5, formaPagamento.getTeste());
/*  67 */       ps.setString(6, formaPagamento.getSeqFormaPagamento());
/*  68 */       ps.execute();
/*  69 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  72 */       Logger.getLogger(FormaPagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  73 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  76 */     return formaPagamento;
/*     */   }
/*     */   
/*     */   public List<FormaPagamento> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  81 */       Conexao conexao = new Conexao();
/*  82 */       Connection conn = Conexao.getConnection();
/*  83 */       String sql = "SELECT * FROM FORMA_PAGAMENTO" + sClausula.montarsClausula() + "order by nome";
/*     */       
/*     */ 
/*  86 */       List<FormaPagamento> listaFormaPagamento = new ArrayList();
/*  87 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  88 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  90 */       while (rs.next()) {
/*  91 */         FormaPagamento formaPagamento = new FormaPagamento();
/*  92 */         formaPagamento.setSeqFormaPagamento(rs.getString("SEQ_FORMA_PAGAMENTO"));
/*  93 */         formaPagamento.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/*  94 */         formaPagamento.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  95 */         formaPagamento.setSituacao(rs.getString("SITUACAO"));
/*  96 */         formaPagamento.setNome(rs.getString("NOME"));
/*  97 */         formaPagamento.setTeste(rs.getString("TESTE"));
/*  98 */         listaFormaPagamento.add(formaPagamento);
/*     */       }
/*     */       
/* 101 */       ps.execute();
/* 102 */       ps.close();
/*     */       
/* 104 */       return listaFormaPagamento;
/*     */     } catch (SQLException ex) {
/* 106 */       Logger.getLogger(FormaPagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 107 */       System.out.println(ex.getMessage()); }
/* 108 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(FormaPagamento formaPagamento)
/*     */   {
/*     */     try {
/* 114 */       Conexao conexao = new Conexao();
/* 115 */       Connection conn = Conexao.getConnection();
/* 116 */       String sql = "DELETE FROM FORMA_PAGAMENTO WHERE SEQ_FORMA_PAGAMENTO =  ? ";
/*     */       
/* 118 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 120 */       ps.setString(1, formaPagamento.getSeqFormaPagamento());
/*     */       
/* 122 */       ps.execute();
/* 123 */       ps.close();
/*     */       
/* 125 */       return true;
/*     */     } catch (SQLException ex) {
/* 127 */       System.out.println(ex.getMessage()); }
/* 128 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FormaPagamento/FormaPagamentoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */