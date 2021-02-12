/*    */ package FinanceiroItem;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import Util.Situacao;
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
/*    */ public class FinanceiroItemService
/*    */ {
/*    */   public FinanceiroItem salvar(FinanceiroItem financeiroItem)
/*    */   {
/* 23 */     FinanceiroItemDAO dao = new FinanceiroItemDAO();
/* 24 */     if (financeiroItem.getSeqFinanceiroItem() == null) {
/* 25 */       financeiroItem.setDataCadastro(new Date());
/* 26 */       return dao.inserir(financeiroItem);
/*    */     }
/* 28 */     return dao.alterar(financeiroItem);
/*    */   }
/*    */   
/*    */   public List<FinanceiroItem> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     FinanceiroItemDAO dao = new FinanceiroItemDAO();
/* 34 */     List<FinanceiroItem> listaFinanceiroItem = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 40 */     if (pSituacao == Situacao.ATIVO) {
/* 41 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 42 */     } else if (pSituacao == Situacao.INATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 46 */     listaFinanceiroItem = dao.listar(condicao);
/* 47 */     return listaFinanceiroItem;
/*    */   }
/*    */   
/*    */   public List<FinanceiroItem> listarPorSeqFinanceiro(String pSeqFinanceiro) {
/* 51 */     FinanceiroItemDAO dao = new FinanceiroItemDAO();
/* 52 */     List<FinanceiroItem> listaFinanceiroItem = new ArrayList();
/* 53 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 55 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_financeiro", GeneroCondicaoWhere.igual, String.valueOf(pSeqFinanceiro), TipoCondicaoWhere.Numero);
/*    */     
/* 57 */     listaFinanceiroItem = dao.listar(condicao);
/* 58 */     return listaFinanceiroItem;
/*    */   }
/*    */   
/*    */   public boolean deletar(FinanceiroItem financeiroItem) {
/* 62 */     FinanceiroItemDAO dao = new FinanceiroItemDAO();
/* 63 */     return dao.deletar(financeiroItem);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FinanceiroItem/FinanceiroItemService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */