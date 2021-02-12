/*    */ package Financeiro;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import FinanceiroItem.FinanceiroItemService;
/*    */ import java.io.PrintStream;
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
/*    */ public class FinanceiroService
/*    */ {
/*    */   public Financeiro salvar(Financeiro financeiro)
/*    */   {
/* 24 */     FinanceiroDAO dao = new FinanceiroDAO();
/* 25 */     if (financeiro.getSeqFinanceiro() == null) {
/* 26 */       financeiro.setDataCadastro(new Date());
/* 27 */       System.out.println("SALVAR");
/* 28 */       return dao.inserir(financeiro);
/*    */     }
/* 30 */     System.out.println("ALTERAR");
/* 31 */     return dao.alterar(financeiro);
/*    */   }
/*    */   
/*    */   public List<Financeiro> listar(String pSeqEmpresa, String pSeqFinanceiro)
/*    */   {
/* 36 */     FinanceiroDAO dao = new FinanceiroDAO();
/* 37 */     List<Financeiro> listaFinanceiro = new ArrayList();
/* 38 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 40 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "financeiro.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/* 41 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.seq_financeiro", GeneroCondicaoWhere.igual, String.valueOf(pSeqFinanceiro), TipoCondicaoWhere.Numero);
/*    */     
/* 43 */     listaFinanceiro = dao.listar(condicao);
/*    */     
/* 45 */     if (listaFinanceiro.size() > 0) {
/* 46 */       for (Financeiro lista : listaFinanceiro) {
/* 47 */         if (lista.getOrigemLCM().equals("4")) {
/* 48 */           FinanceiroItemService financeiroItemService = new FinanceiroItemService();
/* 49 */           lista.setListaFinanceiroItem(financeiroItemService.listarPorSeqFinanceiro(lista.getSeqFinanceiro()));
/*    */         }
/*    */       }
/*    */     }
/* 53 */     return listaFinanceiro;
/*    */   }
/*    */   
/*    */   public Financeiro listarSeq(String pSeqEmpresa, String pSeqFinanceiro) {
/* 57 */     FinanceiroDAO dao = new FinanceiroDAO();
/* 58 */     List<Financeiro> listaFinanceiro = new ArrayList();
/* 59 */     Financeiro retorno = null;
/* 60 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 62 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "financeiro.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/* 63 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.seq_financeiro", GeneroCondicaoWhere.igual, String.valueOf(pSeqFinanceiro), TipoCondicaoWhere.Numero);
/*    */     
/* 65 */     listaFinanceiro = dao.listar(condicao);
/*    */     
/* 67 */     if (listaFinanceiro.size() > 0) {
/* 68 */       retorno = (Financeiro)listaFinanceiro.get(0);
/*    */     }
/*    */    
/*    */ 
/*    */ 
/*    */ 
/* 74 */     return retorno;
/*    */   }
/*    */   
/*    */   public List<Financeiro> listarFiltro(ClausulaWhere pCondicao) {
/* 78 */     FinanceiroDAO dao = new FinanceiroDAO();
/* 79 */     List<Financeiro> listaFinanceiro = new ArrayList();
/*    */     
/* 81 */     listaFinanceiro = dao.listar(pCondicao);
/*    */     
/*    */ 
/* 84 */     return listaFinanceiro;
/*    */   }
/*    */   
/*    */ 
 /*    */ public Financeiro aprovar(Financeiro financeiro) {
        /* 62 */ FinanceiroDAO dao = new FinanceiroDAO();
        /* 63 */ return dao.alterar(financeiro);
        /*    */    }

/*    */   public boolean deletar(Financeiro financeiro)
/*    */   {
/* 97 */     FinanceiroDAO dao = new FinanceiroDAO();
/* 98 */     return dao.deletar(financeiro);
/*    */   }
/*    */ }

