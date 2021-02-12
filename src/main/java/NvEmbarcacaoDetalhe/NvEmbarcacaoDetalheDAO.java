/*     */ package NvEmbarcacaoDetalhe;
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
/*     */ public class NvEmbarcacaoDetalheDAO
/*     */ {
/*     */   public NvEmbarcacaoDetalhe inserir(NvEmbarcacaoDetalhe nvEmbarcacaoDetalhe)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_NV_EMBARCACAO_DETALHE");
/*  28 */       nvEmbarcacaoDetalhe.setSeqNvEmbarcacaoDetalhe(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into NV_EMBARCACAO_DETALHE (SEQ_NV_EMBARCACAO_DETALHE,DETALHE_4,DETALHE_2,DETALHE_3,SEQ_NV_EMBARCACAO,DETALHE_1, ORDEM) values  (?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, nvEmbarcacaoDetalhe.getSeqNvEmbarcacaoDetalhe());
/*  38 */       ps.setString(2, nvEmbarcacaoDetalhe.getDetalhe4());
/*  39 */       ps.setString(3, nvEmbarcacaoDetalhe.getDetalhe2());
/*  40 */       ps.setString(4, nvEmbarcacaoDetalhe.getDetalhe3());
/*  41 */       ps.setString(5, nvEmbarcacaoDetalhe.getSeqNvEmbarcacao());
/*  42 */       ps.setString(6, nvEmbarcacaoDetalhe.getDetalhe1());
/*  43 */       ps.setString(7, nvEmbarcacaoDetalhe.getOrdem());
/*     */       
/*  45 */       ps.execute();
/*  46 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  49 */       Logger.getLogger(NvEmbarcacaoDetalheDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  50 */       System.out.println(ex.getMessage());
/*     */     }
/*  52 */     return nvEmbarcacaoDetalhe;
/*     */   }
/*     */   
/*     */   public NvEmbarcacaoDetalhe alterar(NvEmbarcacaoDetalhe nvEmbarcacaoDetalhe) {
/*     */     try {
/*  57 */       Conexao conexao = new Conexao();
/*  58 */       Connection conn = Conexao.getConnection();
/*  59 */       String sql = "update NV_EMBARCACAO_DETALHE set DETALHE_4 = ?,DETALHE_2 = ?,DETALHE_3 = ?, DETALHE_1 = ? where SEQ_NV_EMBARCACAO_DETALHE = ?";
/*     */       
/*  61 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  63 */       ps.setString(1, nvEmbarcacaoDetalhe.getDetalhe4());
/*  64 */       ps.setString(2, nvEmbarcacaoDetalhe.getDetalhe2());
/*  65 */       ps.setString(3, nvEmbarcacaoDetalhe.getDetalhe3());
/*  66 */       ps.setString(4, nvEmbarcacaoDetalhe.getDetalhe1());
/*  67 */       ps.setString(5, nvEmbarcacaoDetalhe.getSeqNvEmbarcacaoDetalhe());
/*  68 */       ps.execute();
/*  69 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  72 */       Logger.getLogger(NvEmbarcacaoDetalheDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  73 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  76 */     return nvEmbarcacaoDetalhe;
/*     */   }
/*     */   
/*     */   public List<NvEmbarcacaoDetalhe> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  81 */       Conexao conexao = new Conexao();
/*  82 */       Connection conn = Conexao.getConnection();
/*  83 */       String sql = "SELECT * FROM NV_EMBARCACAO_DETALHE" + sClausula.montarsClausula();
/*  84 */       System.out.println(sql);
/*     */       
/*  86 */       List<NvEmbarcacaoDetalhe> listaNvEmbarcacaoDetalhe = new ArrayList();
/*  87 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  88 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  90 */       while (rs.next()) {
/*  91 */         NvEmbarcacaoDetalhe nvEmbarcacaoDetalhe = new NvEmbarcacaoDetalhe();
/*  92 */         nvEmbarcacaoDetalhe.setSeqNvEmbarcacaoDetalhe(rs.getString("SEQ_NV_EMBARCACAO_DETALHE"));
/*  93 */         nvEmbarcacaoDetalhe.setDetalhe4(rs.getString("DETALHE_4"));
/*  94 */         nvEmbarcacaoDetalhe.setDetalhe2(rs.getString("DETALHE_2"));
/*  95 */         nvEmbarcacaoDetalhe.setDetalhe3(rs.getString("DETALHE_3"));
/*  96 */         nvEmbarcacaoDetalhe.setSeqNvEmbarcacao(rs.getString("SEQ_NV_EMBARCACAO"));
/*  97 */         nvEmbarcacaoDetalhe.setDetalhe1(rs.getString("DETALHE_1"));
/*  98 */         nvEmbarcacaoDetalhe.setOrdem(rs.getString("ORDEM"));
/*  99 */         listaNvEmbarcacaoDetalhe.add(nvEmbarcacaoDetalhe);
/*     */       }
/*     */       
/* 102 */       ps.execute();
/* 103 */       ps.close();
/*     */       
/* 105 */       return listaNvEmbarcacaoDetalhe;
/*     */     } catch (SQLException ex) {
/* 107 */       Logger.getLogger(NvEmbarcacaoDetalheDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 108 */       System.out.println(ex.getMessage()); }
/* 109 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(NvEmbarcacaoDetalhe nvEmbarcacaoDetalhe)
/*     */   {
/*     */     try {
/* 115 */       Conexao conexao = new Conexao();
/* 116 */       Connection conn = Conexao.getConnection();
/* 117 */       String sql = "DELETE FROM NV_EMBARCACAO_DETALHE WHERE SEQ_NV_EMBARCACAO =  ? ";
/*     */       
/* 119 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 121 */       ps.setString(1, nvEmbarcacaoDetalhe.getSeqNvEmbarcacao());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvEmbarcacaoDetalhe/NvEmbarcacaoDetalheDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */