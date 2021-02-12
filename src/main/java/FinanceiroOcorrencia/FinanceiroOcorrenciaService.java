/*    */ package FinanceiroOcorrencia;
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
/*    */ public class FinanceiroOcorrenciaService
/*    */ {
/*    */   public FinanceiroOcorrencia salvar(FinanceiroOcorrencia financeiroOcorrencia)
/*    */   {
/* 19 */     FinanceiroOcorrenciaDAO dao = new FinanceiroOcorrenciaDAO();
/* 20 */     if (financeiroOcorrencia.getSeqFinanceiroOcorrencia() == null) {
/* 21 */       financeiroOcorrencia.setDataCadastro(new Date());
/* 22 */       return dao.inserir(financeiroOcorrencia);
/*    */     }
/* 24 */     return dao.alterar(financeiroOcorrencia);
/*    */   }
/*    */   
/*    */   public List<FinanceiroOcorrencia> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 29 */     FinanceiroOcorrenciaDAO dao = new FinanceiroOcorrenciaDAO();
/* 30 */     List<FinanceiroOcorrencia> listaFinanceiroOcorrencia = new ArrayList();
/* 31 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 33 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 34 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 36 */     if (pSituacao == Situacao.ATIVO) {
/* 37 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 38 */     } else if (pSituacao == Situacao.INATIVO) {
/* 39 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 42 */     listaFinanceiroOcorrencia = dao.listar(condicao);
/* 43 */     return listaFinanceiroOcorrencia;
/*    */   }
/*    */   
/*    */   public boolean deletar(FinanceiroOcorrencia financeiroOcorrencia) {
/* 47 */     FinanceiroOcorrenciaDAO dao = new FinanceiroOcorrenciaDAO();
/* 48 */     return dao.deletar(financeiroOcorrencia);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FinanceiroOcorrencia/FinanceiroOcorrenciaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */