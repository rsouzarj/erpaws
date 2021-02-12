/*    */ package TipoVinculo;
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
/*    */ public class TipoVinculoService
/*    */ {
/*    */   public TipoVinculo salvar(TipoVinculo tipoVinculo)
/*    */   {
/* 23 */     TipoVinculoDAO dao = new TipoVinculoDAO();
/* 24 */     if (tipoVinculo.getSeqTipoVinculo() == null) {
/* 25 */       tipoVinculo.setDataCadastro(new Date());
/* 26 */       tipoVinculo.setSituacao("ATIVO");
/* 27 */       dao.inserir(tipoVinculo);
/* 28 */       return tipoVinculo;
/*    */     }
/* 30 */     dao.alterar(tipoVinculo);
/* 31 */     return tipoVinculo;
/*    */   }
/*    */   
/*    */   public List<TipoVinculo> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 36 */     TipoVinculoDAO dao = new TipoVinculoDAO();
/* 37 */     List<TipoVinculo> listaTipoVinculo = new ArrayList();
/* 38 */     ClausulaWhere condicao = new ClausulaWhere();
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/* 40 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/*    */     
/* 42 */     if (pSituacao == Situacao.ATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 44 */     } else if (pSituacao == Situacao.INATIVO) {
/* 45 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 48 */     listaTipoVinculo = dao.listar(condicao);
/* 49 */     return listaTipoVinculo;
/*    */   }
/*    */   
/*    */   public boolean deletar(TipoVinculo tipoVinculo) {
/* 53 */     TipoVinculoDAO dao = new TipoVinculoDAO();
/* 54 */     return dao.deletar(tipoVinculo);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoVinculo/TipoVinculoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */