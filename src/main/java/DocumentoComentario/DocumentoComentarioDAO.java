/*     */ package DocumentoComentario;
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
/*     */ public class DocumentoComentarioDAO
/*     */ {
/*     */   public DocumentoComentario inserir(DocumentoComentario documentoComentario)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_DOCUMENTO_COMENTARIO");
/*  28 */       documentoComentario.setSeqDocumentoComentario(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into DOCUMENTO_COMENTARIO (SEQ_DOCUMENTO_COMENTARIO,COMENTARIO,SEQ_DOCUMENTO,SEQ_USUARIO,SEQ_EMPRESA,DATA_CADASTRO) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, documentoComentario.getSeqDocumentoComentario());
/*  38 */       ps.setString(2, documentoComentario.getComentario());
/*  39 */       ps.setString(3, documentoComentario.getSeqDocumento());
/*  40 */       ps.setString(4, documentoComentario.getSeqUsuario());
/*  41 */       ps.setString(5, documentoComentario.getSeqEmpresa());
/*     */       try {
/*  43 */         ps.setDate(6, new java.sql.Date(documentoComentario.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  45 */         ps.setDate(6, null);
/*     */       }
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(DocumentoComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return documentoComentario;
/*     */   }
/*     */   
/*     */   public DocumentoComentario alterar(DocumentoComentario documentoComentario) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update DOCUMENTO_COMENTARIO set COMENTARIO = ?,SEQ_DOCUMENTO = ?,SEQ_USUARIO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ? where SEQ_DOCUMENTO_COMENTARIO = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, documentoComentario.getComentario());
/*  67 */       ps.setString(2, documentoComentario.getSeqDocumento());
/*  68 */       ps.setString(3, documentoComentario.getSeqUsuario());
/*  69 */       ps.setString(4, documentoComentario.getSeqEmpresa());
/*     */       try {
/*  71 */         ps.setDate(5, new java.sql.Date(documentoComentario.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  73 */         ps.setDate(5, null);
/*     */       }
/*  75 */       ps.setString(6, documentoComentario.getSeqDocumentoComentario());
/*  76 */       ps.execute();
/*  77 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  80 */       Logger.getLogger(DocumentoComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  81 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  84 */     return documentoComentario;
/*     */   }
/*     */   
/*     */   public List<DocumentoComentario> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  89 */       Conexao conexao = new Conexao();
/*  90 */       Connection conn = Conexao.getConnection();
/*  91 */       String sql = "SELECT DOCUMENTO_COMENTARIO.*,usuario.usuario \n FROM DOCUMENTO_COMENTARIO \n inner join usuario on usuario.seq_usuario = DOCUMENTO_COMENTARIO.seq_usuario " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  96 */       List<DocumentoComentario> listaDocumentoComentario = new ArrayList();
/*  97 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  98 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 100 */       while (rs.next()) {
/* 101 */         DocumentoComentario documentoComentario = new DocumentoComentario();
/* 102 */         documentoComentario.setSeqDocumentoComentario(rs.getString("SEQ_DOCUMENTO_COMENTARIO"));
/* 103 */         documentoComentario.setComentario(rs.getString("COMENTARIO"));
/* 104 */         documentoComentario.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/* 105 */         documentoComentario.setSeqUsuario(rs.getString("SEQ_USUARIO"));
/* 106 */         documentoComentario.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 107 */         documentoComentario.setUsuario(rs.getString("USUARIO"));
/* 108 */         documentoComentario.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 109 */         listaDocumentoComentario.add(documentoComentario);
/*     */       }
/*     */       
/* 112 */       ps.execute();
/* 113 */       ps.close();
/*     */       
/* 115 */       return listaDocumentoComentario;
/*     */     } catch (SQLException ex) {
/* 117 */       Logger.getLogger(DocumentoComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 118 */       System.out.println(ex.getMessage()); }
/* 119 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(DocumentoComentario documentoComentario)
/*     */   {
/*     */     try {
/* 125 */       Conexao conexao = new Conexao();
/* 126 */       Connection conn = Conexao.getConnection();
/* 127 */       String sql = "DELETE FROM DOCUMENTO_COMENTARIO WHERE SEQ_DOCUMENTO_COMENTARIO =  ? ";
/*     */       
/* 129 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 131 */       ps.setString(1, documentoComentario.getSeqDocumentoComentario());
/*     */       
/* 133 */       ps.execute();
/* 134 */       ps.close();
/*     */       
/* 136 */       return true;
/*     */     } catch (SQLException ex) {
/* 138 */       System.out.println(ex.getMessage()); }
/* 139 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoComentario/DocumentoComentarioDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */