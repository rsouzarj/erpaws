/*    */ package DocumentoComentario;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
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
/*    */ public class DocumentoComentarioService
/*    */ {
/*    */   public DocumentoComentario salvar(DocumentoComentario documentoComentario)
/*    */   {
/* 23 */     DocumentoComentarioDAO dao = new DocumentoComentarioDAO();
/* 24 */     if (documentoComentario.getSeqDocumentoComentario() == null) {
/* 25 */       documentoComentario.setDataCadastro(new Date());
/* 26 */       return dao.inserir(documentoComentario);
/*    */     }
/* 28 */     return dao.alterar(documentoComentario);
/*    */   }
/*    */   
/*    */   public List<DocumentoComentario> listar(String pSeqEmpresa, String pSeqDocumento)
/*    */   {
/* 33 */     DocumentoComentarioDAO dao = new DocumentoComentarioDAO();
/* 34 */     List<DocumentoComentario> listaDocumentoComentario = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "DOCUMENTO_COMENTARIO.seq_documento", GeneroCondicaoWhere.igual, pSeqDocumento, TipoCondicaoWhere.Numero);
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "DOCUMENTO_COMENTARIO.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/*    */ 
/* 41 */     listaDocumentoComentario = dao.listar(condicao);
/* 42 */     return listaDocumentoComentario;
/*    */   }
/*    */   
/*    */   public boolean deletar(DocumentoComentario documentoComentario) {
/* 46 */     DocumentoComentarioDAO dao = new DocumentoComentarioDAO();
/* 47 */     return dao.deletar(documentoComentario);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoComentario/DocumentoComentarioService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */