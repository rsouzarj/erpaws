/*    */ package CentroCusto;
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
/*    */ public class CentroCustoService
/*    */ {
/*    */   public CentroCusto salvar(CentroCusto centroCusto)
/*    */   {
/* 23 */     CentroCustoDAO dao = new CentroCustoDAO();
/* 24 */     if (centroCusto.getSeqCentroCusto() == null) {
/* 25 */       centroCusto.setDataCadastro(new Date());
/* 26 */       return dao.inserir(centroCusto);
/*    */     }
/* 28 */     return dao.alterar(centroCusto);
/*    */   }
/*    */   
/*    */   public List<CentroCusto> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     CentroCustoDAO dao = new CentroCustoDAO();
/* 34 */     List<CentroCusto> listaCentroCusto = new ArrayList();
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
/* 46 */     listaCentroCusto = dao.listar(condicao);
/* 47 */     return listaCentroCusto;
/*    */   }
/*    */   
/*    */   public boolean deletar(CentroCusto centroCusto) {
/* 51 */     CentroCustoDAO dao = new CentroCustoDAO();
/* 52 */     return dao.deletar(centroCusto);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/CentroCusto/CentroCustoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */