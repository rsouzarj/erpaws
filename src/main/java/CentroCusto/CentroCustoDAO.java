/*     */ package CentroCusto;
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
/*     */ public class CentroCustoDAO
/*     */ {
/*     */   public CentroCusto inserir(CentroCusto centroCusto)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_CENTRO_CUSTO");
/*  28 */       centroCusto.setSeqCentroCusto(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into CENTRO_CUSTO (SEQ_CENTRO_CUSTO,NOME,SITUACAO,SEQ_EMPRESA,DATA_CADASTRO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, centroCusto.getSeqCentroCusto());
/*  38 */       ps.setString(2, centroCusto.getNome());
/*  39 */       ps.setString(3, centroCusto.getSituacao());
/*  40 */       ps.setString(4, centroCusto.getSeqEmpresa());
/*     */       try {
/*  42 */         ps.setDate(5, new java.sql.Date(centroCusto.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  44 */         ps.setDate(5, null);
/*     */       }
/*     */       
/*  47 */       ps.execute();
/*  48 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  51 */       Logger.getLogger(CentroCustoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  52 */       System.out.println(ex.getMessage());
/*     */     }
/*  54 */     return centroCusto;
/*     */   }
/*     */   
/*     */   public CentroCusto alterar(CentroCusto centroCusto) {
/*     */     try {
/*  59 */       Conexao conexao = new Conexao();
/*  60 */       Connection conn = Conexao.getConnection();
/*  61 */       String sql = "update CENTRO_CUSTO set NOME = ?,SITUACAO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ? where SEQ_CENTRO_CUSTO = ?";
/*     */       
/*  63 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  65 */       ps.setString(1, centroCusto.getNome());
/*  66 */       ps.setString(2, centroCusto.getSituacao());
/*  67 */       ps.setString(3, centroCusto.getSeqEmpresa());
/*     */       try {
/*  69 */         ps.setDate(4, new java.sql.Date(centroCusto.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  71 */         ps.setDate(4, null);
/*     */       }
/*  73 */       ps.setString(5, centroCusto.getSeqCentroCusto());
/*  74 */       ps.execute();
/*  75 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  78 */       Logger.getLogger(CentroCustoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  79 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  82 */     return centroCusto;
/*     */   }
/*     */   
/*     */   public List<CentroCusto> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  87 */       Conexao conexao = new Conexao();
/*  88 */       Connection conn = Conexao.getConnection();
/*  89 */       String sql = "SELECT * FROM CENTRO_CUSTO" + sClausula.montarsClausula() + "order by nome";
/*  90 */       System.out.println(sql);
/*     */       
/*  92 */       List<CentroCusto> listaCentroCusto = new ArrayList();
/*  93 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  94 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  96 */       while (rs.next()) {
/*  97 */         CentroCusto centroCusto = new CentroCusto();
/*  98 */         centroCusto.setSeqCentroCusto(rs.getString("SEQ_CENTRO_CUSTO"));
/*  99 */         centroCusto.setNome(rs.getString("NOME"));
/* 100 */         centroCusto.setSituacao(rs.getString("SITUACAO"));
/* 101 */         centroCusto.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         centroCusto.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 103 */         listaCentroCusto.add(centroCusto);
/*     */       }
/*     */       
/* 106 */       ps.execute();
/* 107 */       ps.close();
/*     */       
/* 109 */       return listaCentroCusto;
/*     */     } catch (SQLException ex) {
/* 111 */       Logger.getLogger(CentroCustoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 112 */       System.out.println(ex.getMessage()); }
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(CentroCusto centroCusto)
/*     */   {
/*     */     try {
/* 119 */       Conexao conexao = new Conexao();
/* 120 */       Connection conn = Conexao.getConnection();
/* 121 */       String sql = "DELETE FROM CENTRO_CUSTO WHERE SEQ_CENTRO_CUSTO =  ? ";
/*     */       
/* 123 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 125 */       ps.setString(1, centroCusto.getSeqCentroCusto());
/*     */       
/* 127 */       ps.execute();
/* 128 */       ps.close();
/*     */       
/* 130 */       return true;
/*     */     } catch (SQLException ex) {
/* 132 */       System.out.println(ex.getMessage()); }
/* 133 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/CentroCusto/CentroCustoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */