/*    */ package TipoDocumentoGerar;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import Documento.Documento;
/*    */ import Documento.DocumentoService;
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
/*    */ public class TipoDocumentoGerarService
/*    */ {
/*    */   public TipoDocumentoGerar salvar(TipoDocumentoGerar tipoDocumentoGerar)
/*    */   {
/* 23 */     TipoDocumentoGerarDAO dao = new TipoDocumentoGerarDAO();
/* 24 */     if (tipoDocumentoGerar.getSeqTipoDocumentoGerar() == null) {
/* 25 */       return dao.inserir(tipoDocumentoGerar);
/*    */     }
/* 27 */     return dao.alterar(tipoDocumentoGerar);
/*    */   }
/*    */   
/*    */   public List<TipoDocumentoGerar> listar(String pSeqTipoDocumentoPai, String pSeqDocumentoPai)
/*    */   {
/* 32 */     TipoDocumentoGerarDAO dao = new TipoDocumentoGerarDAO();
/* 33 */     List<TipoDocumentoGerar> listaTipoDocumentoGerar = new ArrayList();
/* 34 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 36 */     List<Documento> listaItensBotaoGerar = new ArrayList();
/* 37 */     DocumentoService documentoService = new DocumentoService();
/*    */     
/* 39 */     listaItensBotaoGerar = documentoService.itensBotaoGerar(pSeqDocumentoPai);
/* 40 */     if ((listaItensBotaoGerar.isEmpty()) && (!pSeqTipoDocumentoPai.equals("301"))) {
/* 41 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_tipo_documento_pai", GeneroCondicaoWhere.igual, String.valueOf(pSeqTipoDocumentoPai), TipoCondicaoWhere.Numero);
/* 42 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_tipo_documento_filho", GeneroCondicaoWhere.diferente, String.valueOf("381"), TipoCondicaoWhere.Numero);
/*    */     } else {
/* 44 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_tipo_documento_pai", GeneroCondicaoWhere.igual, String.valueOf(pSeqTipoDocumentoPai), TipoCondicaoWhere.Numero);
/*    */     }
/* 46 */     listaTipoDocumentoGerar = dao.listar(condicao);
/* 47 */     return listaTipoDocumentoGerar;
/*    */   }
/*    */   
/*    */   public List<TipoDocumentoGerar> listarGerar(String pSeqTipoDocumentoPai) {
/* 51 */     TipoDocumentoGerarDAO dao = new TipoDocumentoGerarDAO();
/* 52 */     List<TipoDocumentoGerar> listaTipoDocumentoGerar = new ArrayList();
/* 53 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 55 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_tipo_documento_pai", GeneroCondicaoWhere.igual, String.valueOf(pSeqTipoDocumentoPai), TipoCondicaoWhere.Numero);
/*    */     
/* 57 */     listaTipoDocumentoGerar = dao.listar(condicao);
/* 58 */     return listaTipoDocumentoGerar;
/*    */   }
/*    */   
/*    */   public boolean deletar(TipoDocumentoGerar tipoDocumentoGerar) {
/* 62 */     TipoDocumentoGerarDAO dao = new TipoDocumentoGerarDAO();
/* 63 */     return dao.deletar(tipoDocumentoGerar);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoDocumentoGerar/TipoDocumentoGerarService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */