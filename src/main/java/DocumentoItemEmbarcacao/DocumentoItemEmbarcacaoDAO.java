/*     */ package DocumentoItemEmbarcacao;
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
/*     */ public class DocumentoItemEmbarcacaoDAO
/*     */ {
/*     */   public DocumentoItemEmbarcacao inserir(DocumentoItemEmbarcacao documentoItemEmbarcacao)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_DOCUMENTO_ITEM_EMBARCACAO");
/*  28 */       documentoItemEmbarcacao.setSeqDocumentoItemEmbarcacao(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into DOCUMENTO_ITEM_EMBARCACAO (SEQ_DOCUMENTO_ITEM_EMBARCACAO,SEQ_NV_EMBARCACAO,SEQ_DOCUMENTO) values  (?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, documentoItemEmbarcacao.getSeqDocumentoItemEmbarcacao());
/*  38 */       ps.setString(2, documentoItemEmbarcacao.getSeqNvEmbarcacao());
/*  39 */       ps.setString(3, documentoItemEmbarcacao.getSeqDocumento());
/*     */       
/*  41 */       ps.execute();
/*  42 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  45 */       Logger.getLogger(DocumentoItemEmbarcacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  46 */       System.out.println(ex.getMessage());
/*     */     }
/*  48 */     return documentoItemEmbarcacao;
/*     */   }
/*     */   
/*     */   public DocumentoItemEmbarcacao alterar(DocumentoItemEmbarcacao documentoItemEmbarcacao) {
/*     */     try {
/*  53 */       Conexao conexao = new Conexao();
/*  54 */       Connection conn = Conexao.getConnection();
/*  55 */       String sql = "update DOCUMENTO_ITEM_EMBARCACAO set SEQ_NV_EMBARCACAO = ?,SEQ_DOCUMENTO = ? where SEQ_DOCUMENTO_ITEM_EMBARCACAO = ?";
/*     */       
/*  57 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  59 */       ps.setString(1, documentoItemEmbarcacao.getSeqNvEmbarcacao());
/*  60 */       ps.setString(2, documentoItemEmbarcacao.getSeqDocumento());
/*  61 */       ps.setString(3, documentoItemEmbarcacao.getSeqDocumentoItemEmbarcacao());
/*  62 */       ps.execute();
/*  63 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  66 */       Logger.getLogger(DocumentoItemEmbarcacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  67 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  70 */     return documentoItemEmbarcacao;
/*     */   }
/*     */   
/*     */   public List<DocumentoItemEmbarcacao> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  75 */       Conexao conexao = new Conexao();
/*  76 */       Connection conn = Conexao.getConnection();
/*  77 */       String sql = "SELECT * FROM DOCUMENTO_ITEM_EMBARCACAO" + sClausula.montarsClausula();
/*  78 */       System.out.println(sql);
/*     */       
/*  80 */       List<DocumentoItemEmbarcacao> listaDocumentoItemEmbarcacao = new ArrayList();
/*  81 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  82 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  84 */       while (rs.next()) {
/*  85 */         DocumentoItemEmbarcacao documentoItemEmbarcacao = new DocumentoItemEmbarcacao();
/*  86 */         documentoItemEmbarcacao.setSeqDocumentoItemEmbarcacao(rs.getString("SEQ_DOCUMENTO_ITEM_EMBARCACAO"));
/*  87 */         documentoItemEmbarcacao.setSeqNvEmbarcacao(rs.getString("SEQ_NV_EMBARCACAO"));
/*  88 */         documentoItemEmbarcacao.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/*  89 */         listaDocumentoItemEmbarcacao.add(documentoItemEmbarcacao);
/*     */       }
/*     */       
/*  92 */       ps.execute();
/*  93 */       ps.close();
/*     */       
/*  95 */       return listaDocumentoItemEmbarcacao;
/*     */     } catch (SQLException ex) {
/*  97 */       Logger.getLogger(DocumentoItemEmbarcacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  98 */       System.out.println(ex.getMessage()); }
/*  99 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(DocumentoItemEmbarcacao documentoItemEmbarcacao)
/*     */   {
/*     */     try {
/* 105 */       Conexao conexao = new Conexao();
/* 106 */       Connection conn = Conexao.getConnection();
/* 107 */       String sql = "DELETE FROM DOCUMENTO_ITEM_EMBARCACAO WHERE SEQ_DOCUMENTO_ITEM_EMBARCACAO =  ? ";
/*     */       
/* 109 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 111 */       ps.setString(1, documentoItemEmbarcacao.getSeqDocumentoItemEmbarcacao());
/*     */       
/* 113 */       ps.execute();
/* 114 */       ps.close();
/*     */       
/* 116 */       return true;
/*     */     } catch (SQLException ex) {
/* 118 */       System.out.println(ex.getMessage()); }
/* 119 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemEmbarcacao/DocumentoItemEmbarcacaoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */