/*    */ package TipoMovimentoFinanceiro;
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
/*    */ public class TipoMovimentoFinanceiroService
/*    */ {
/*    */   public TipoMovimentoFinanceiro salvar(TipoMovimentoFinanceiro tipoMovimentoFinanceiro)
/*    */   {
/* 23 */     TipoMovimentoFinanceiroDAO dao = new TipoMovimentoFinanceiroDAO();
/* 24 */     if (tipoMovimentoFinanceiro.getSeqTipoMovimentoFinanceiro() == null) {
/* 25 */       tipoMovimentoFinanceiro.setDataCadastro(new Date());
/* 26 */       dao.inserir(tipoMovimentoFinanceiro);
/* 27 */       return tipoMovimentoFinanceiro;
/*    */     }
/* 29 */     dao.alterar(tipoMovimentoFinanceiro);
/* 30 */     return tipoMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public List<TipoMovimentoFinanceiro> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 35 */     TipoMovimentoFinanceiroDAO dao = new TipoMovimentoFinanceiroDAO();
/* 36 */     List<TipoMovimentoFinanceiro> listaTipoMovimentoFinanceiro = new ArrayList();
/* 37 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "TIPO_MOVIMENTO_FINANCEIRO.nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 40 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.or, "FINANCEIRO_CATEGORIA.nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 41 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "TIPO_MOVIMENTO_FINANCEIRO.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 43 */     if (pSituacao == Situacao.ATIVO) {
/* 44 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "TIPO_MOVIMENTO_FINANCEIRO.situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 45 */     } else if (pSituacao == Situacao.INATIVO) {
/* 46 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "TIPO_MOVIMENTO_FINANCEIRO.situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 49 */     listaTipoMovimentoFinanceiro = dao.listar(condicao);
/* 50 */     return listaTipoMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public List<TipoMovimentoFinanceiro> listarPorNatureza(String pSeqEmpresa, String pNatureza) {
/* 54 */     TipoMovimentoFinanceiroDAO dao = new TipoMovimentoFinanceiroDAO();
/* 55 */     List<TipoMovimentoFinanceiro> listaTipoMovimentoFinanceiro = new ArrayList();
/* 56 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 58 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "TIPO_MOVIMENTO_FINANCEIRO.nome", GeneroCondicaoWhere.contem, pNatureza, TipoCondicaoWhere.Texto);
/* 59 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "TIPO_MOVIMENTO_FINANCEIRO.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 61 */     listaTipoMovimentoFinanceiro = dao.listar(condicao);
/* 62 */     return listaTipoMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public List<TipoMovimentoFinanceiro> listarPorOperacao(String pSeqEmpresa, Situacao pSituacao, String operacao) {
/* 66 */     TipoMovimentoFinanceiroDAO dao = new TipoMovimentoFinanceiroDAO();
/* 67 */     List<TipoMovimentoFinanceiro> listaTipoMovimentoFinanceiro = new ArrayList();
/* 68 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 70 */     /*condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "TIPO_MOVIMENTO_FINANCEIRO.nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);*/
/* 71 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "TIPO_MOVIMENTO_FINANCEIRO.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/* 72 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "TIPO_MOVIMENTO_FINANCEIRO.operacao", GeneroCondicaoWhere.igual, operacao, TipoCondicaoWhere.Texto);
/*    */     
/* 74 */     if (pSituacao == Situacao.ATIVO) {
/* 75 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "TIPO_MOVIMENTO_FINANCEIRO.situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 76 */     } else if (pSituacao == Situacao.INATIVO) {
/* 77 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "TIPO_MOVIMENTO_FINANCEIRO.situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 80 */     listaTipoMovimentoFinanceiro = dao.listar(condicao);
/* 81 */     return listaTipoMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public boolean deletar(TipoMovimentoFinanceiro tipoMovimentoFinanceiro) {
/* 85 */     TipoMovimentoFinanceiroDAO dao = new TipoMovimentoFinanceiroDAO();
/* 86 */     return dao.deletar(tipoMovimentoFinanceiro);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoMovimentoFinanceiro/TipoMovimentoFinanceiroService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */