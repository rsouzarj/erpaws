/*    */ package PlanoItem;
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
/*    */ public class PlanoItemService
/*    */ {
/*    */   public PlanoItem salvar(PlanoItem planoItem)
/*    */   {
/* 23 */     PlanoItemDAO dao = new PlanoItemDAO();
/* 24 */     if (planoItem.getSeqPlanoItem() == null) {
/* 25 */       planoItem.setDataCadastro(new Date());
/* 26 */       return dao.inserir(planoItem);
/*    */     }
/* 28 */     return dao.alterar(planoItem);
/*    */   }
/*    */   
/*    */   public List<PlanoItem> listar(String pSeqEmpresa, String pIdentificacaoLista, Situacao pSituacao)
/*    */   {
/* 33 */     PlanoItemDAO dao = new PlanoItemDAO();
/* 34 */     List<PlanoItem> listaPlanoItem = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "identificacao_lista", GeneroCondicaoWhere.contem, pIdentificacaoLista, TipoCondicaoWhere.Texto);
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 40 */     if (pSituacao == Situacao.ATIVO) {
/* 41 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 42 */     } else if (pSituacao == Situacao.INATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 46 */     listaPlanoItem = dao.listar(condicao);
/* 47 */     return listaPlanoItem;
/*    */   }
/*    */   
/*    */   public boolean deletar(PlanoItem planoItem) {
/* 51 */     PlanoItemDAO dao = new PlanoItemDAO();
/* 52 */     return dao.deletar(planoItem);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/PlanoItem/PlanoItemService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */