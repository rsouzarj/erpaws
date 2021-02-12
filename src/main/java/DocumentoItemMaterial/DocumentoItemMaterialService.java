/*    */ package DocumentoItemMaterial;
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
/*    */ public class DocumentoItemMaterialService
/*    */ {
/*    */   public DocumentoItemMaterial salvar(DocumentoItemMaterial documentoItemMaterial)
/*    */   {
/* 23 */     DocumentoItemMaterialDAO dao = new DocumentoItemMaterialDAO();
/* 24 */     if (documentoItemMaterial.getSeqDocumentoItemMaterial() == null) {
/* 25 */       documentoItemMaterial.setSituacao("ATIVO");
/* 26 */       documentoItemMaterial.setDataCadastro(new Date());
/* 27 */       dao.inserir(documentoItemMaterial);
/* 28 */       return documentoItemMaterial;
/*    */     }
/* 30 */     dao.alterar(documentoItemMaterial);
/* 31 */     return documentoItemMaterial;
/*    */   }
/*    */   
/*    */   public List<DocumentoItemMaterial> listarPorDocumento(String pSeqDocumento)
/*    */   {
/* 36 */     DocumentoItemMaterialDAO dao = new DocumentoItemMaterialDAO();
/* 37 */     List<DocumentoItemMaterial> listaDocumentoItemMaterial = new ArrayList();
/* 38 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 40 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_documento", GeneroCondicaoWhere.igual, String.valueOf(pSeqDocumento), TipoCondicaoWhere.Numero);
/*    */     
/* 42 */     listaDocumentoItemMaterial = dao.listar(condicao);
/* 43 */     return listaDocumentoItemMaterial;
/*    */   }
/*    */   
/*    */   public boolean deletar(DocumentoItemMaterial documentoItemMaterial) {
/* 47 */     DocumentoItemMaterialDAO dao = new DocumentoItemMaterialDAO();
/* 48 */     return dao.deletar(documentoItemMaterial);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemMaterial/DocumentoItemMaterialService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */