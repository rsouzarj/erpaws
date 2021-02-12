/*    */ package DocumentoOcorrencia;
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
/*    */ public class DocumentoOcorrenciaService
/*    */ {
/*    */   public DocumentoOcorrencia salvar(DocumentoOcorrencia documentoOcorrencia)
/*    */   {
/* 22 */     DocumentoOcorrenciaDAO dao = new DocumentoOcorrenciaDAO();
/* 23 */     if (documentoOcorrencia.getSeqDocumentoOcorrencia() == null) {
/* 24 */       documentoOcorrencia.setDataCadastro(new Date());
/* 25 */       documentoOcorrencia.setData(new Date());
/* 26 */       dao.inserir(documentoOcorrencia);
/* 27 */       return documentoOcorrencia;
/*    */     }
/* 29 */     dao.alterar(documentoOcorrencia);
/* 30 */     return documentoOcorrencia;
/*    */   }
/*    */   
/*    */   public List<DocumentoOcorrencia> listarPorDocumento(String pSeqDocumento)
/*    */   {
/* 35 */     DocumentoOcorrenciaDAO dao = new DocumentoOcorrenciaDAO();
/* 36 */     List<DocumentoOcorrencia> listaDocumentoOcorrencia = new ArrayList();
/* 37 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "documento_ocorrencia.seq_documento", GeneroCondicaoWhere.igual, String.valueOf(pSeqDocumento), TipoCondicaoWhere.Numero);
/*    */     
/* 41 */     listaDocumentoOcorrencia = dao.listar(condicao);
/* 42 */     return listaDocumentoOcorrencia;
/*    */   }
/*    */   
/*    */   public boolean deletar(DocumentoOcorrencia documentoOcorrencia) {
/* 46 */     DocumentoOcorrenciaDAO dao = new DocumentoOcorrenciaDAO();
/* 47 */     return dao.deletar(documentoOcorrencia);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoOcorrencia/DocumentoOcorrenciaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */