/*    */ package FinanceiroEquipamento;
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
/*    */ public class FinanceiroEquipamentoService
/*    */ {
/*    */   public FinanceiroEquipamento salvar(FinanceiroEquipamento financeiroEquipamento)
/*    */   {
/* 23 */     FinanceiroEquipamentoDAO dao = new FinanceiroEquipamentoDAO();
/* 24 */     if (financeiroEquipamento.getSeqFinanceiroEquipamento() == null) {
/* 25 */       return dao.inserir(financeiroEquipamento);
/*    */     }
/* 27 */     return dao.alterar(financeiroEquipamento);
/*    */   }
/*    */   
/*    */   public List<FinanceiroEquipamento> listar(String pSeqFinanceiro)
/*    */   {
/* 32 */     FinanceiroEquipamentoDAO dao = new FinanceiroEquipamentoDAO();
/* 33 */     List<FinanceiroEquipamento> listaFinanceiroEquipamento = new ArrayList();
/* 34 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 36 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "financeiro_equipamento.seq_financeiro", GeneroCondicaoWhere.igual, pSeqFinanceiro, TipoCondicaoWhere.Numero);
/*    */     
/*    */ 
/* 39 */     listaFinanceiroEquipamento = dao.listar(condicao);
/* 40 */     return listaFinanceiroEquipamento;
/*    */   }
/*    */   
/*    */   public boolean deletar(FinanceiroEquipamento financeiroEquipamento) {
/* 44 */     FinanceiroEquipamentoDAO dao = new FinanceiroEquipamentoDAO();
/* 45 */     return dao.deletar(financeiroEquipamento);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FinanceiroEquipamento/FinanceiroEquipamentoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */