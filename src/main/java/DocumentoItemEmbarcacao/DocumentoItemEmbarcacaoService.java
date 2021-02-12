/*    */ package DocumentoItemEmbarcacao;
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
/*    */ public class DocumentoItemEmbarcacaoService
/*    */ {
/*    */   public DocumentoItemEmbarcacao salvar(DocumentoItemEmbarcacao documentoItemEmbarcacao)
/*    */   {
/* 23 */     DocumentoItemEmbarcacaoDAO dao = new DocumentoItemEmbarcacaoDAO();
/* 24 */     if (documentoItemEmbarcacao.getSeqDocumentoItemEmbarcacao() == null) {
/* 25 */       return dao.inserir(documentoItemEmbarcacao);
/*    */     }
/* 27 */     return dao.alterar(documentoItemEmbarcacao);
/*    */   }
/*    */   
/*    */   public List<DocumentoItemEmbarcacao> listarPorDocumento(String pSeqDocumento)
/*    */   {
/* 32 */     DocumentoItemEmbarcacaoDAO dao = new DocumentoItemEmbarcacaoDAO();
/* 33 */     List<DocumentoItemEmbarcacao> listaDocumentoItemEmbarcacao = new ArrayList();
/* 34 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 36 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_documento", GeneroCondicaoWhere.igual, pSeqDocumento, TipoCondicaoWhere.Texto);
/*    */     
/* 38 */     listaDocumentoItemEmbarcacao = dao.listar(condicao);
/* 39 */     return listaDocumentoItemEmbarcacao;
/*    */   }
/*    */   
/*    */   public boolean deletar(DocumentoItemEmbarcacao documentoItemEmbarcacao) {
/* 43 */     DocumentoItemEmbarcacaoDAO dao = new DocumentoItemEmbarcacaoDAO();
/* 44 */     return dao.deletar(documentoItemEmbarcacao);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemEmbarcacao/DocumentoItemEmbarcacaoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */