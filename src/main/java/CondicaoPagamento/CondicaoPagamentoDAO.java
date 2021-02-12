/*     */ package CondicaoPagamento;
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
/*     */ public class CondicaoPagamentoDAO
/*     */ {
/*     */   public CondicaoPagamento inserir(CondicaoPagamento condicaoPagamento)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_CONDICAO_PAGAMENTO");
/*  28 */       condicaoPagamento.setSeqCondicaoPagamento(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into CONDICAO_PAGAMENTO (SEQ_CONDICAO_PAGAMENTO,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,NOME) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, condicaoPagamento.getSeqCondicaoPagamento());
/*  38 */       ps.setString(2, condicaoPagamento.getSeqEmpresa());
/*  39 */       ps.setDate(3, new java.sql.Date(condicaoPagamento.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, condicaoPagamento.getSituacao());
/*  41 */       ps.setString(5, condicaoPagamento.getNome());
/*     */       
/*  43 */       ps.execute();
/*  44 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  47 */       Logger.getLogger(CondicaoPagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  48 */       System.out.println(ex.getMessage());
/*     */     }
/*  50 */     return condicaoPagamento;
/*     */   }
/*     */   
/*     */   public CondicaoPagamento alterar(CondicaoPagamento condicaoPagamento) {
/*     */     try {
/*  55 */       Conexao conexao = new Conexao();
/*  56 */       Connection conn = Conexao.getConnection();
/*  57 */       String sql = "update CONDICAO_PAGAMENTO set SITUACAO = ?,NOME = ? where SEQ_CONDICAO_PAGAMENTO = ?";
/*     */       
/*  59 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  61 */       ps.setString(1, condicaoPagamento.getSituacao());
/*  62 */       ps.setString(2, condicaoPagamento.getNome());
/*  63 */       ps.setString(3, condicaoPagamento.getSeqCondicaoPagamento());
/*  64 */       ps.execute();
/*  65 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  68 */       Logger.getLogger(CondicaoPagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  69 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  72 */     return condicaoPagamento;
/*     */   }
/*     */   
/*     */   public List<CondicaoPagamento> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  77 */       Conexao conexao = new Conexao();
/*  78 */       Connection conn = Conexao.getConnection();
/*  79 */       String sql = "SELECT * FROM CONDICAO_PAGAMENTO" + sClausula.montarsClausula() + " order by nome";
/*     */       
/*     */ 
/*  82 */       List<CondicaoPagamento> listaCondicaoPagamento = new ArrayList();
/*  83 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  84 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  86 */       while (rs.next()) {
/*  87 */         CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
/*  88 */         condicaoPagamento.setSeqCondicaoPagamento(rs.getString("SEQ_CONDICAO_PAGAMENTO"));
/*  89 */         condicaoPagamento.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/*  90 */         condicaoPagamento.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  91 */         condicaoPagamento.setSituacao(rs.getString("SITUACAO"));
/*  92 */         condicaoPagamento.setNome(rs.getString("NOME"));
/*  93 */         listaCondicaoPagamento.add(condicaoPagamento);
/*     */       }
/*     */       
/*  96 */       ps.execute();
/*  97 */       ps.close();
/*     */       
/*  99 */       return listaCondicaoPagamento;
/*     */     } catch (SQLException ex) {
/* 101 */       Logger.getLogger(CondicaoPagamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 102 */       System.out.println(ex.getMessage()); }
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(CondicaoPagamento condicaoPagamento)
/*     */   {
/*     */     try {
/* 109 */       Conexao conexao = new Conexao();
/* 110 */       Connection conn = Conexao.getConnection();
/* 111 */       String sql = "DELETE FROM CONDICAO_PAGAMENTO WHERE SEQ_CONDICAO_PAGAMENTO =  ? ";
/*     */       
/* 113 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 115 */       ps.setString(1, condicaoPagamento.getSeqCondicaoPagamento());
/*     */       
/* 117 */       ps.execute();
/* 118 */       ps.close();
/*     */       
/* 120 */       return true;
/*     */     } catch (SQLException ex) {
/* 122 */       System.out.println(ex.getMessage()); }
/* 123 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/CondicaoPagamento/CondicaoPagamentoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */