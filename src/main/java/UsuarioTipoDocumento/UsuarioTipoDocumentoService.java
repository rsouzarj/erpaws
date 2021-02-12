/*    */ package UsuarioTipoDocumento;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UsuarioTipoDocumentoService
/*    */ {
/*    */   public UsuarioTipoDocumento salvar(UsuarioTipoDocumento usuarioTipoDocumento)
/*    */   {
/* 23 */     UsuarioTipoDocumentoDAO dao = new UsuarioTipoDocumentoDAO();
/* 24 */     if (usuarioTipoDocumento.getSeqUsuarioTipoDocumento() == null) {
/* 25 */       return dao.inserir(usuarioTipoDocumento);
/*    */     }
/* 27 */     return dao.alterar(usuarioTipoDocumento);
/*    */   }
/*    */   
/*    */   public List<UsuarioTipoDocumento> listar(String pSeqUsuario)
/*    */   {
/* 32 */     UsuarioTipoDocumentoDAO dao = new UsuarioTipoDocumentoDAO();
/* 33 */     List<UsuarioTipoDocumento> listaUsuarioTipoDocumento = new ArrayList();
/* 34 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 36 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "usuario_tipo_documento.seq_usuario", GeneroCondicaoWhere.igual, String.valueOf(pSeqUsuario), TipoCondicaoWhere.Numero);
/*    */     
/* 38 */     listaUsuarioTipoDocumento = dao.listar(condicao);
/* 39 */     return listaUsuarioTipoDocumento;
/*    */   }
/*    */   
/*    */   public boolean listarDocumento(String pSeqUsuario, String pSeqTipoDocumento) {
/* 43 */     UsuarioTipoDocumentoDAO dao = new UsuarioTipoDocumentoDAO();
/* 44 */     List<UsuarioTipoDocumento> listaUsuarioTipoDocumento = new ArrayList();
/* 45 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 47 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "usuario_tipo_documento.seq_usuario", GeneroCondicaoWhere.igual, String.valueOf(pSeqUsuario), TipoCondicaoWhere.Numero);
/* 48 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "usuario_tipo_documento.seq_tipo_documento", GeneroCondicaoWhere.igual, String.valueOf(pSeqTipoDocumento), TipoCondicaoWhere.Numero);
/*    */     
/* 50 */     listaUsuarioTipoDocumento = dao.listar(condicao);
/* 51 */     if (listaUsuarioTipoDocumento.isEmpty()) {
/* 52 */       return false;
/*    */     }
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public boolean deletar(UsuarioTipoDocumento usuarioTipoDocumento)
/*    */   {
/* 59 */     UsuarioTipoDocumentoDAO dao = new UsuarioTipoDocumentoDAO();
/* 60 */     return dao.deletar(usuarioTipoDocumento);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/UsuarioTipoDocumento/UsuarioTipoDocumentoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */