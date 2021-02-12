/*    */ package FinanceiroCategoria;
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
/*    */ public class FinanceiroCategoriaService
/*    */ {
/*    */   public FinanceiroCategoria salvar(FinanceiroCategoria financeiroCategoria)
/*    */   {
/* 23 */     FinanceiroCategoriaDAO dao = new FinanceiroCategoriaDAO();
/* 24 */     if (financeiroCategoria.getSeqFinanceiroCategoria() == null) {
/* 25 */       financeiroCategoria.setDataCadastro(new Date());
/* 26 */       return dao.inserir(financeiroCategoria);
/*    */     }
/* 28 */     return dao.alterar(financeiroCategoria);
/*    */   }
/*    */   
/*    */   public List<FinanceiroCategoria> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     FinanceiroCategoriaDAO dao = new FinanceiroCategoriaDAO();
/* 34 */     List<FinanceiroCategoria> listaFinanceiroCategoria = new ArrayList();
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
/* 46 */     listaFinanceiroCategoria = dao.listar(condicao);
/* 47 */     return listaFinanceiroCategoria;
/*    */   }
/*    */   
/*    */   public boolean deletar(FinanceiroCategoria financeiroCategoria) {
/* 51 */     FinanceiroCategoriaDAO dao = new FinanceiroCategoriaDAO();
/* 52 */     return dao.deletar(financeiroCategoria);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FinanceiroCategoria/FinanceiroCategoriaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */