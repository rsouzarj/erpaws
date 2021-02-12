/*    */ package DocumentoEscopo;
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
/*    */ public class DocumentoEscopoService
/*    */ {
/*    */   public DocumentoEscopo salvar(DocumentoEscopo documentoEscopo)
/*    */   {
/* 23 */     DocumentoEscopoDAO dao = new DocumentoEscopoDAO();
/* 24 */     if (documentoEscopo.getSeqDocumentoEscopo() == null) {
/* 25 */       return dao.inserir(documentoEscopo);
/*    */     }
/* 27 */     return dao.alterar(documentoEscopo);
/*    */   }
/*    */   
/*    */   public List<DocumentoEscopo> listar(String pSeqTipoDocumento, String pSeqServicoEscopo)
/*    */   {
/* 32 */     DocumentoEscopoDAO dao = new DocumentoEscopoDAO();
/* 33 */     List<DocumentoEscopo> listaDocumentoEscopo = new ArrayList();
/* 34 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 36 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "documento_escopo.seq_tipo_documento", GeneroCondicaoWhere.contem, String.valueOf(pSeqTipoDocumento), TipoCondicaoWhere.Numero);
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "documento_escopo.seq_servico_escopo", GeneroCondicaoWhere.contem, String.valueOf(pSeqServicoEscopo), TipoCondicaoWhere.Numero);
/*    */     
/* 39 */     listaDocumentoEscopo = dao.listar(condicao);
/* 40 */     return listaDocumentoEscopo;
/*    */   }
/*    */   
/*    */   public boolean deletar(DocumentoEscopo documentoEscopo) {
/* 44 */     DocumentoEscopoDAO dao = new DocumentoEscopoDAO();
/* 45 */     return dao.deletar(documentoEscopo);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoEscopo/DocumentoEscopoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */