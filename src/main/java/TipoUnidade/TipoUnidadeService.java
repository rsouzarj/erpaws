/*    */ package TipoUnidade;
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
/*    */ public class TipoUnidadeService
/*    */ {
/*    */   public TipoUnidade salvar(TipoUnidade tipoUnidade)
/*    */   {
/* 23 */     TipoUnidadeDAO dao = new TipoUnidadeDAO();
/* 24 */     if (tipoUnidade.getSeqTipoUnidade() == null) {
/* 25 */       tipoUnidade.setDataCadastro(new Date());
/* 26 */       return dao.inserir(tipoUnidade);
/*    */     }
/* 28 */     return dao.alterar(tipoUnidade);
/*    */   }
/*    */   
/*    */   public List<TipoUnidade> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     TipoUnidadeDAO dao = new TipoUnidadeDAO();
/* 34 */     List<TipoUnidade> listaTipoUnidade = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "DESCRICAO", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 40 */     if (pSituacao == Situacao.ATIVO) {
/* 41 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 42 */     } else if (pSituacao == Situacao.INATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 46 */     listaTipoUnidade = dao.listar(condicao);
/* 47 */     return listaTipoUnidade;
/*    */   }
/*    */   
/*    */   public boolean deletar(TipoUnidade tipoUnidade) {
/* 51 */     TipoUnidadeDAO dao = new TipoUnidadeDAO();
/* 52 */     return dao.deletar(tipoUnidade);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoUnidade/TipoUnidadeService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */