/*     */ package TipoDocumentoGerar;
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
/*     */ public class TipoDocumentoGerarDAO
/*     */ {
/*     */   public TipoDocumentoGerar inserir(TipoDocumentoGerar tipoDocumentoGerar)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_TIPO_DOCUMENTO_GERAR");
/*  28 */       tipoDocumentoGerar.setSeqTipoDocumentoGerar(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into TIPO_DOCUMENTO_GERAR (SEQ_TIPO_DOCUMENTO_GERAR,SEQ_TIPO_DOCUMENTO_FILHO,SEQ_TIPO_DOCUMENTO_PAI) values  (?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, tipoDocumentoGerar.getSeqTipoDocumentoGerar());
/*  38 */       ps.setString(2, tipoDocumentoGerar.getSeqTipoDocumentoFilho());
/*  39 */       ps.setString(3, tipoDocumentoGerar.getSeqTipoDocumentoPai());
/*     */       
/*  41 */       ps.execute();
/*  42 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  45 */       Logger.getLogger(TipoDocumentoGerarDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  46 */       System.out.println(ex.getMessage());
/*     */     }
/*  48 */     return tipoDocumentoGerar;
/*     */   }
/*     */   
/*     */   public TipoDocumentoGerar alterar(TipoDocumentoGerar tipoDocumentoGerar) {
/*     */     try {
/*  53 */       Conexao conexao = new Conexao();
/*  54 */       Connection conn = Conexao.getConnection();
/*  55 */       String sql = "update TIPO_DOCUMENTO_GERAR set SEQ_TIPO_DOCUMENTO_FILHO = ?,SEQ_TIPO_DOCUMENTO_PAI = ? where SEQ_TIPO_DOCUMENTO_GERAR = ?";
/*     */       
/*  57 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  59 */       ps.setString(1, tipoDocumentoGerar.getSeqTipoDocumentoFilho());
/*  60 */       ps.setString(2, tipoDocumentoGerar.getSeqTipoDocumentoPai());
/*  61 */       ps.setString(3, tipoDocumentoGerar.getSeqTipoDocumentoGerar());
/*  62 */       ps.execute();
/*  63 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  66 */       Logger.getLogger(TipoDocumentoGerarDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  67 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  70 */     return tipoDocumentoGerar;
/*     */   }
/*     */   
/*     */   public List<TipoDocumentoGerar> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  75 */       Conexao conexao = new Conexao();
/*  76 */       Connection conn = Conexao.getConnection();
/*  77 */       String sql = "select \ntipo_documento_gerar.*,\ntipo_documento.NOMe tipo_documento_filho\nfrom \ntipo_documento_gerar\ninner join tipo_documento on tipo_documento.seq_tipo_documento = tipo_documento_gerar.seq_tipo_documento_filho " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  85 */       List<TipoDocumentoGerar> listaTipoDocumentoGerar = new ArrayList();
/*  86 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  87 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  89 */       while (rs.next()) {
/*  90 */         TipoDocumentoGerar tipoDocumentoGerar = new TipoDocumentoGerar();
/*  91 */         tipoDocumentoGerar.setSeqTipoDocumentoGerar(rs.getString("SEQ_TIPO_DOCUMENTO_GERAR"));
/*  92 */         tipoDocumentoGerar.setSeqTipoDocumentoFilho(rs.getString("SEQ_TIPO_DOCUMENTO_FILHO"));
/*  93 */         tipoDocumentoGerar.setSeqTipoDocumentoPai(rs.getString("SEQ_TIPO_DOCUMENTO_PAI"));
/*  94 */         tipoDocumentoGerar.setTipoDocumentoFilho(rs.getString("tipo_documento_filho"));
/*  95 */         listaTipoDocumentoGerar.add(tipoDocumentoGerar);
/*     */       }
/*     */       
/*  98 */       ps.execute();
/*  99 */       ps.close();
/*     */       
/* 101 */       return listaTipoDocumentoGerar;
/*     */     } catch (SQLException ex) {
/* 103 */       Logger.getLogger(TipoDocumentoGerarDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 104 */       System.out.println(ex.getMessage()); }
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(TipoDocumentoGerar tipoDocumentoGerar)
/*     */   {
/*     */     try {
/* 111 */       Conexao conexao = new Conexao();
/* 112 */       Connection conn = Conexao.getConnection();
/* 113 */       String sql = "DELETE FROM TIPO_DOCUMENTO_GERAR WHERE SEQ_TIPO_DOCUMENTO_GERAR =  ? ";
/*     */       
/* 115 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 117 */       ps.setString(1, tipoDocumentoGerar.getSeqTipoDocumentoGerar());
/*     */       
/* 119 */       ps.execute();
/* 120 */       ps.close();
/*     */       
/* 122 */       return true;
/*     */     } catch (SQLException ex) {
/* 124 */       System.out.println(ex.getMessage()); }
/* 125 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoDocumentoGerar/TipoDocumentoGerarDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */