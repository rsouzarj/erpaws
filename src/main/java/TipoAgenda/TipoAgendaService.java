/*    */ package TipoAgenda;
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
/*    */ public class TipoAgendaService
/*    */ {
/*    */   public TipoAgenda salvar(TipoAgenda tipoAgenda)
/*    */   {
/* 22 */     TipoAgendaDAO dao = new TipoAgendaDAO();
/* 23 */     if (tipoAgenda.getSeqTipoAgenda() == null) {
/* 24 */       dao.inserir(tipoAgenda);
/* 25 */       return tipoAgenda;
/*    */     }
/* 27 */     dao.alterar(tipoAgenda);
/* 28 */     return tipoAgenda;
/*    */   }
/*    */   
/*    */   public List<TipoAgenda> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     TipoAgendaDAO dao = new TipoAgendaDAO();
/* 34 */     List<TipoAgenda> listaTipoAgenda = new ArrayList();
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
/* 46 */     listaTipoAgenda = dao.listar(condicao);
/* 47 */     return listaTipoAgenda;
/*    */   }
/*    */   
/*    */   public boolean deletar(TipoAgenda tipoAgenda) {
/* 51 */     TipoAgendaDAO dao = new TipoAgendaDAO();
/* 52 */     return dao.deletar(tipoAgenda);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoAgenda/TipoAgendaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */