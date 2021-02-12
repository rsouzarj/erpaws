/*    */ package FinanceiroItemPc;
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
/*    */ public class FinanceiroItemPcService
/*    */ {
/*    */   public FinanceiroItemPc salvar(FinanceiroItemPc financeiroItemPc)
/*    */   {
/* 23 */     FinanceiroItemPcDAO dao = new FinanceiroItemPcDAO();
/* 24 */     if (financeiroItemPc.getSeqFinanceiroItemPc() == null) {
/* 25 */       financeiroItemPc.setDataCadastro(new Date());
/* 26 */       return dao.inserir(financeiroItemPc);
/*    */     }
/* 28 */     return dao.alterar(financeiroItemPc);
/*    */   }
/*    */   
/*    */   public List<FinanceiroItemPc> listar(String pSeqEmpresa, String pSeqFinanceiro)
/*    */   {
/* 33 */     FinanceiroItemPcDAO dao = new FinanceiroItemPcDAO();
/* 34 */     List<FinanceiroItemPc> listaFinanceiroItemPc = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/*    */ 
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "financeiro_item_pc.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro_item_pc.seq_financeiro", GeneroCondicaoWhere.igual, String.valueOf(pSeqFinanceiro), TipoCondicaoWhere.Numero);
/*    */     
/*    */ 
/*    */ 
/* 43 */     listaFinanceiroItemPc = dao.listar(condicao);
/* 44 */     return listaFinanceiroItemPc;
/*    */   }
/*    */   
/*    */   public boolean deletar(FinanceiroItemPc financeiroItemPc) {
/* 48 */     FinanceiroItemPcDAO dao = new FinanceiroItemPcDAO();
/* 49 */     return dao.deletar(financeiroItemPc);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FinanceiroItemPc/FinanceiroItemPcService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */