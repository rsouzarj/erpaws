/*    */ package TipoColaborador;
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
/*    */ public class TipoColaboradorService
/*    */ {
/*    */   public TipoColaborador salvar(TipoColaborador tipoColaborador)
/*    */   {
/* 23 */     TipoColaboradorDAO dao = new TipoColaboradorDAO();
/* 24 */     if (tipoColaborador.getSeqTipoColaborador() == null) {
/* 25 */       tipoColaborador.setDataCadastro(new Date());
/* 26 */       return dao.inserir(tipoColaborador);
/*    */     }
/* 28 */     return dao.alterar(tipoColaborador);
/*    */   }
/*    */   
/*    */   public List<TipoColaborador> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     TipoColaboradorDAO dao = new TipoColaboradorDAO();
/* 34 */     List<TipoColaborador> listaTipoColaborador = new ArrayList();
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
/* 46 */     listaTipoColaborador = dao.listar(condicao);
/* 47 */     return listaTipoColaborador;
/*    */   }
/*    */   
/*    */   public boolean deletar(TipoColaborador tipoColaborador) {
/* 51 */     TipoColaboradorDAO dao = new TipoColaboradorDAO();
/* 52 */     return dao.deletar(tipoColaborador);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoColaborador/TipoColaboradorService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */