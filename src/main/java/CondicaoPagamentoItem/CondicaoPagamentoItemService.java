/*    */ package CondicaoPagamentoItem;
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
/*    */ public class CondicaoPagamentoItemService
/*    */ {
/*    */   public CondicaoPagamentoItem salvar(CondicaoPagamentoItem condicaoPagamentoItem)
/*    */   {
/* 23 */     CondicaoPagamentoItemDAO dao = new CondicaoPagamentoItemDAO();
/* 24 */     if (condicaoPagamentoItem.getSeqCondicaoPagamentoItem() == null) {
/* 25 */       condicaoPagamentoItem.setDataCadastro(new Date());
/* 26 */       dao.inserir(condicaoPagamentoItem);
/* 27 */       return condicaoPagamentoItem;
/*    */     }
/* 29 */     dao.alterar(condicaoPagamentoItem);
/* 30 */     return condicaoPagamentoItem;
/*    */   }
/*    */   
/*    */   public List<CondicaoPagamentoItem> listarPorCondicaoDePagamento(String pSeqCondicaoPagamento)
/*    */   {
/* 35 */     CondicaoPagamentoItemDAO dao = new CondicaoPagamentoItemDAO();
/* 36 */     List<CondicaoPagamentoItem> listaCondicaoPagamentoItem = new ArrayList();
/* 37 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "condicao_pagamento_item.seq_condicao_pagamento", GeneroCondicaoWhere.igual, String.valueOf(pSeqCondicaoPagamento), TipoCondicaoWhere.Numero);
/*    */     
/* 41 */     listaCondicaoPagamentoItem = dao.listar(condicao);
/* 42 */     return listaCondicaoPagamentoItem;
/*    */   }
/*    */   
/*    */   public boolean deletar(CondicaoPagamentoItem condicaoPagamentoItem) {
/* 46 */     CondicaoPagamentoItemDAO dao = new CondicaoPagamentoItemDAO();
/* 47 */     return dao.deletar(condicaoPagamentoItem);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/CondicaoPagamentoItem/CondicaoPagamentoItemService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */