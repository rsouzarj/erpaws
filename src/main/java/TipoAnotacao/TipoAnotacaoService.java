/*    */ package TipoAnotacao;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import Util.Situacao;
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
/*    */ public class TipoAnotacaoService
/*    */ {
/*    */   public TipoAnotacao salvar(TipoAnotacao tipoAnotacao)
/*    */   {
/* 22 */     TipoAnotacaoDAO dao = new TipoAnotacaoDAO();
/* 23 */     if (tipoAnotacao.getSeqTipoAnotacao() == null) {
/* 24 */       dao.inserir(tipoAnotacao);
/* 25 */       return tipoAnotacao;
/*    */     }
/* 27 */     dao.alterar(tipoAnotacao);
/* 28 */     return tipoAnotacao;
/*    */   }
/*    */   
/*    */   public List<TipoAnotacao> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     TipoAnotacaoDAO dao = new TipoAnotacaoDAO();
/* 34 */     List<TipoAnotacao> listaTipoAnotacao = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/* 36 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 39 */     if (pSituacao == Situacao.ATIVO) {
/* 40 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 41 */     } else if (pSituacao == Situacao.INATIVO) {
/* 42 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 45 */     listaTipoAnotacao = dao.listar(condicao);
/* 46 */     return listaTipoAnotacao;
/*    */   }
/*    */   
/*    */   public boolean deletar(TipoAnotacao tipoAnotacao) {
/* 50 */     TipoAnotacaoDAO dao = new TipoAnotacaoDAO();
/* 51 */     return dao.deletar(tipoAnotacao);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoAnotacao/TipoAnotacaoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */