/*    */ package MovimentoFinanceiro;
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
/*    */ public class MovimentoFinanceiroService
/*    */ {
/*    */   public MovimentoFinanceiro salvar(MovimentoFinanceiro movimentoFinanceiro)
/*    */   {
/* 23 */     MovimentoFinanceiroDAO dao = new MovimentoFinanceiroDAO();
/* 24 */     if (movimentoFinanceiro.getSeqMovimentoFinanceiro() == null) {
/* 25 */       movimentoFinanceiro.setDataCadastro(new Date());
/* 26 */       dao.inserir(movimentoFinanceiro);
/* 27 */       return movimentoFinanceiro;
/*    */     }
/* 29 */     dao.alterar(movimentoFinanceiro);
/* 30 */     return movimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public List<MovimentoFinanceiro> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 35 */     MovimentoFinanceiroDAO dao = new MovimentoFinanceiroDAO();
/* 36 */     List<MovimentoFinanceiro> listaMovimentoFinanceiro = new ArrayList();
/* 37 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 40 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 42 */     if (pSituacao == Situacao.ATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 44 */     } else if (pSituacao == Situacao.INATIVO) {
/* 45 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 48 */     listaMovimentoFinanceiro = dao.listar(condicao);
/* 49 */     return listaMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public boolean deletar(MovimentoFinanceiro movimentoFinanceiro) {
/* 53 */     MovimentoFinanceiroDAO dao = new MovimentoFinanceiroDAO();
/* 54 */     return dao.deletar(movimentoFinanceiro);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/MovimentoFinanceiro/MovimentoFinanceiroService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */