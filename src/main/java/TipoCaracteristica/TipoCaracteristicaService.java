/*    */ package TipoCaracteristica;
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
/*    */ public class TipoCaracteristicaService
/*    */ {
/*    */   public TipoCaracteristica salvar(TipoCaracteristica tipoCaracteristica)
/*    */   {
/* 23 */     TipoCaracteristicaDAO dao = new TipoCaracteristicaDAO();
/* 24 */     if (tipoCaracteristica.getSeqTipoCaracteristica() == null) {
/* 25 */       tipoCaracteristica.setDataCadastro(new Date());
/* 26 */       return dao.inserir(tipoCaracteristica);
/*    */     }
/* 28 */     return dao.alterar(tipoCaracteristica);
/*    */   }
/*    */   
/*    */   public List<TipoCaracteristica> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     TipoCaracteristicaDAO dao = new TipoCaracteristicaDAO();
/* 34 */     List<TipoCaracteristica> listaTipoCaracteristica = new ArrayList();
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
/* 46 */     listaTipoCaracteristica = dao.listar(condicao);
/* 47 */     return listaTipoCaracteristica;
/*    */   }
/*    */   
/*    */   public boolean deletar(TipoCaracteristica tipoCaracteristica) {
/* 51 */     TipoCaracteristicaDAO dao = new TipoCaracteristicaDAO();
/* 52 */     return dao.deletar(tipoCaracteristica);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoCaracteristica/TipoCaracteristicaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */