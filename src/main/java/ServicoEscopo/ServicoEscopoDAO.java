/*     */ package ServicoEscopo;
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
/*     */ public class ServicoEscopoDAO
/*     */ {
/*     */   public ServicoEscopo inserir(ServicoEscopo servicoEscopo)
/*     */   {
/*     */     try
/*     */     {
/*  23 */       String seq = Sequence.buscarNumeroSequence("SEQ_SERVICO_ESCOPO");
/*  24 */       servicoEscopo.setSeqServicoEscopo(seq);
/*  25 */       Conexao conexao = new Conexao();
/*  26 */       Connection conn = Conexao.getConnection();
/*  27 */       String sql = "insert into SERVICO_ESCOPO (SEQ_SERVICO_ESCOPO,NOME,SITUACAO,SEQ_EMPRESA,DATA_CADASTRO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  31 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  33 */       ps.setString(1, servicoEscopo.getSeqServicoEscopo());
/*  34 */       ps.setString(2, servicoEscopo.getNome());
/*  35 */       ps.setString(3, servicoEscopo.getSituacao());
/*  36 */       ps.setString(4, servicoEscopo.getSeqEmpresa());
/*     */       try {
/*  38 */         ps.setDate(5, new java.sql.Date(servicoEscopo.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  40 */         ps.setDate(5, null);
/*     */       }
/*     */       
/*  43 */       ps.execute();
/*  44 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  47 */       Logger.getLogger(ServicoEscopoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  48 */       System.out.println(ex.getMessage());
/*     */     }
/*  50 */     return servicoEscopo;
/*     */   }
/*     */   
/*     */   public ServicoEscopo alterar(ServicoEscopo servicoEscopo) {
/*     */     try {
/*  55 */       Conexao conexao = new Conexao();
/*  56 */       Connection conn = Conexao.getConnection();
/*  57 */       String sql = "update SERVICO_ESCOPO set NOME = ?,SITUACAO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ? where SEQ_SERVICO_ESCOPO = ?";
/*     */       
/*  59 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  61 */       ps.setString(1, servicoEscopo.getNome());
/*  62 */       ps.setString(2, servicoEscopo.getSituacao());
/*  63 */       ps.setString(3, servicoEscopo.getSeqEmpresa());
/*     */       try {
/*  65 */         ps.setDate(4, new java.sql.Date(servicoEscopo.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  67 */         ps.setDate(4, null);
/*     */       }
/*  69 */       ps.setString(5, servicoEscopo.getSeqServicoEscopo());
/*  70 */       ps.execute();
/*  71 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  74 */       Logger.getLogger(ServicoEscopoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  75 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  78 */     return servicoEscopo;
/*     */   }
/*     */   
/*     */   public List<ServicoEscopo> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  83 */       Conexao conexao = new Conexao();
/*  84 */       Connection conn = Conexao.getConnection();
/*  85 */       String sql = "SELECT * FROM SERVICO_ESCOPO" + sClausula.montarsClausula() + " order by nome asc";
/*     */       
/*     */ 
/*  88 */       List<ServicoEscopo> listaServicoEscopo = new ArrayList();
/*  89 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  90 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  92 */       while (rs.next()) {
/*  93 */         ServicoEscopo servicoEscopo = new ServicoEscopo();
/*  94 */         servicoEscopo.setSeqServicoEscopo(rs.getString("SEQ_SERVICO_ESCOPO"));
/*  95 */         servicoEscopo.setNome(rs.getString("NOME"));
/*  96 */         servicoEscopo.setSituacao(rs.getString("SITUACAO"));
/*  97 */         servicoEscopo.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/*  98 */         servicoEscopo.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  99 */         listaServicoEscopo.add(servicoEscopo);
/*     */       }
/*     */       
/* 102 */       ps.execute();
/* 103 */       ps.close();
/*     */       
/* 105 */       return listaServicoEscopo;
/*     */     } catch (SQLException ex) {
/* 107 */       Logger.getLogger(ServicoEscopoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 108 */       System.out.println(ex.getMessage()); }
/* 109 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(ServicoEscopo servicoEscopo)
/*     */   {
/*     */     try {
/* 115 */       Conexao conexao = new Conexao();
/* 116 */       Connection conn = Conexao.getConnection();
/* 117 */       String sql = "DELETE FROM SERVICO_ESCOPO WHERE SEQ_SERVICO_ESCOPO =  ? ";
/*     */       
/* 119 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 121 */       ps.setString(1, servicoEscopo.getSeqServicoEscopo());
/*     */       
/* 123 */       ps.execute();
/* 124 */       ps.close();
/*     */       
/* 126 */       return true;
/*     */     } catch (SQLException ex) {
/* 128 */       System.out.println(ex.getMessage()); }
/* 129 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ServicoEscopo/ServicoEscopoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */