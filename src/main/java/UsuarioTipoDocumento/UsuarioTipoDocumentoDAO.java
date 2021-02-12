/*     */ package UsuarioTipoDocumento;
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
/*     */ public class UsuarioTipoDocumentoDAO
/*     */ {
/*     */   public UsuarioTipoDocumento inserir(UsuarioTipoDocumento usuarioTipoDocumento)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_USUARIO_TIPO_DOCUMENTO");
/*  28 */       usuarioTipoDocumento.setSeqUsuarioTipoDocumento(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into USUARIO_TIPO_DOCUMENTO (SEQ_USUARIO_TIPO_DOCUMENTO,SEQ_TIPO_DOCUMENTO,SEQ_USUARIO) values  (?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, usuarioTipoDocumento.getSeqUsuarioTipoDocumento());
/*  38 */       ps.setString(2, usuarioTipoDocumento.getSeqTipoDocumento());
/*  39 */       ps.setString(3, usuarioTipoDocumento.getSeqUsuario());
/*     */       
/*  41 */       ps.execute();
/*  42 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  45 */       Logger.getLogger(UsuarioTipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  46 */       System.out.println(ex.getMessage());
/*     */     }
/*  48 */     return usuarioTipoDocumento;
/*     */   }
/*     */   
/*     */   public UsuarioTipoDocumento alterar(UsuarioTipoDocumento usuarioTipoDocumento) {
/*     */     try {
/*  53 */       Conexao conexao = new Conexao();
/*  54 */       Connection conn = Conexao.getConnection();
/*  55 */       String sql = "update USUARIO_TIPO_DOCUMENTO set SEQ_TIPO_DOCUMENTO = ?,SEQ_USUARIO = ? where SEQ_USUARIO_TIPO_DOCUMENTO = ?";
/*     */       
/*  57 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  59 */       ps.setString(1, usuarioTipoDocumento.getSeqTipoDocumento());
/*  60 */       ps.setString(2, usuarioTipoDocumento.getSeqUsuario());
/*  61 */       ps.setString(3, usuarioTipoDocumento.getSeqUsuarioTipoDocumento());
/*  62 */       ps.execute();
/*  63 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  66 */       Logger.getLogger(UsuarioTipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  67 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  70 */     return usuarioTipoDocumento;
/*     */   }
/*     */   
/*     */   public List<UsuarioTipoDocumento> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  75 */       Conexao conexao = new Conexao();
/*  76 */       Connection conn = Conexao.getConnection();
/*  77 */       String sql = "select \nUSUARIO_TIPO_DOCUMENTO.* ,\ntipo_documento.nome tipoDocumentoNome\nfrom  \nUSUARIO_TIPO_DOCUMENTO\ninner join tipo_documento on tipo_documento.seq_tipo_documento =  USUARIO_TIPO_DOCUMENTO.seq_tipo_documento " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */       System.out.println(sql);
/*     */       
/*  86 */       List<UsuarioTipoDocumento> listaUsuarioTipoDocumento = new ArrayList();
/*  87 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  88 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  90 */       while (rs.next()) {
/*  91 */         UsuarioTipoDocumento usuarioTipoDocumento = new UsuarioTipoDocumento();
/*  92 */         usuarioTipoDocumento.setSeqUsuarioTipoDocumento(rs.getString("SEQ_USUARIO_TIPO_DOCUMENTO"));
/*  93 */         usuarioTipoDocumento.setSeqTipoDocumento(rs.getString("SEQ_TIPO_DOCUMENTO"));
/*  94 */         usuarioTipoDocumento.setSeqUsuario(rs.getString("SEQ_USUARIO"));
/*  95 */         usuarioTipoDocumento.setTipoDocumentoNome(rs.getString("tipoDocumentoNome"));
/*  96 */         listaUsuarioTipoDocumento.add(usuarioTipoDocumento);
/*     */       }
/*     */       
/*  99 */       ps.execute();
/* 100 */       ps.close();
/*     */       
/* 102 */       return listaUsuarioTipoDocumento;
/*     */     } catch (SQLException ex) {
/* 104 */       Logger.getLogger(UsuarioTipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 105 */       System.out.println(ex.getMessage()); }
/* 106 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(UsuarioTipoDocumento usuarioTipoDocumento)
/*     */   {
/*     */     try {
/* 112 */       Conexao conexao = new Conexao();
/* 113 */       Connection conn = Conexao.getConnection();
/* 114 */       String sql = "DELETE FROM USUARIO_TIPO_DOCUMENTO WHERE SEQ_USUARIO_TIPO_DOCUMENTO =  ? ";
/*     */       
/* 116 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 118 */       ps.setString(1, usuarioTipoDocumento.getSeqUsuarioTipoDocumento());
/*     */       
/* 120 */       ps.execute();
/* 121 */       ps.close();
/*     */       
/* 123 */       return true;
/*     */     } catch (SQLException ex) {
/* 125 */       System.out.println(ex.getMessage()); }
/* 126 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/UsuarioTipoDocumento/UsuarioTipoDocumentoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */