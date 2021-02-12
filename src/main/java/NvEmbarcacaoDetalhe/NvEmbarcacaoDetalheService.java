/*    */ package NvEmbarcacaoDetalhe;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
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
/*    */ 
/*    */ 
/*    */ public class NvEmbarcacaoDetalheService
/*    */ {
/*    */   public NvEmbarcacaoDetalhe salvar(NvEmbarcacaoDetalhe nvEmbarcacaoDetalhe)
/*    */   {
/* 22 */     NvEmbarcacaoDetalheDAO dao = new NvEmbarcacaoDetalheDAO();
/* 23 */     if (nvEmbarcacaoDetalhe.getSeqNvEmbarcacaoDetalhe() == null) {
/* 24 */       return dao.inserir(nvEmbarcacaoDetalhe);
/*    */     }
/* 26 */     return dao.alterar(nvEmbarcacaoDetalhe);
/*    */   }
/*    */   
/*    */   public List<NvEmbarcacaoDetalhe> listar(String pSeqEmbarcacao)
/*    */   {
/* 31 */     NvEmbarcacaoDetalheDAO dao = new NvEmbarcacaoDetalheDAO();
/* 32 */     List<NvEmbarcacaoDetalhe> listaNvEmbarcacaoDetalhe = new ArrayList();
/* 33 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 35 */     condicao.AdicionarCondicaoManual("where NV_EMBARCACAO_DETALHE.seq_nv_embarcacao = " + pSeqEmbarcacao + " ORDER BY ORDEM");
/*    */     
/* 37 */     listaNvEmbarcacaoDetalhe = dao.listar(condicao);
/* 38 */     return listaNvEmbarcacaoDetalhe;
/*    */   }
/*    */   
/*    */   public boolean deletar(NvEmbarcacaoDetalhe nvEmbarcacaoDetalhe) {
/* 42 */     NvEmbarcacaoDetalheDAO dao = new NvEmbarcacaoDetalheDAO();
/* 43 */     return dao.deletar(nvEmbarcacaoDetalhe);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvEmbarcacaoDetalhe/NvEmbarcacaoDetalheService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */