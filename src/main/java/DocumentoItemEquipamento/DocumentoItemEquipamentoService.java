/*    */ package DocumentoItemEquipamento;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocumentoItemEquipamentoService
/*    */ {
/*    */   public DocumentoItemEquipamento salvar(DocumentoItemEquipamento pDocumentoItemEquipamento)
/*    */   {
/* 21 */     DocumentoItemEquipamentoDAO dao = new DocumentoItemEquipamentoDAO();
/* 22 */     System.out.println("-------------------> " + pDocumentoItemEquipamento.getSeqDocumentoItemEquipamento());
/* 23 */     if (pDocumentoItemEquipamento.getSeqDocumentoItemEquipamento() == null) {
/* 24 */       return dao.inserir(pDocumentoItemEquipamento);
/*    */     }
/* 26 */     return dao.alterar(pDocumentoItemEquipamento);
/*    */   }
/*    */   
/*    */   public List<DocumentoItemEquipamento> listarPorDocumento(String pSeqDocumento)
/*    */   {
/* 31 */     DocumentoItemEquipamentoDAO dao = new DocumentoItemEquipamentoDAO();
/* 32 */     List<DocumentoItemEquipamento> listaDocumentoItemEquipamento = new ArrayList();
/* 33 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 35 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_documento", GeneroCondicaoWhere.igual, pSeqDocumento, TipoCondicaoWhere.Texto);
/*    */     
/* 37 */     listaDocumentoItemEquipamento = dao.listar(condicao);
/* 38 */     return listaDocumentoItemEquipamento;
/*    */   }
/*    */   
/*    */   public boolean deletar(DocumentoItemEquipamento documentoItemEquipamento) {
/* 42 */     DocumentoItemEquipamentoDAO dao = new DocumentoItemEquipamentoDAO();
/* 43 */     return dao.deletar(documentoItemEquipamento);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemEquipamento/DocumentoItemEquipamentoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */