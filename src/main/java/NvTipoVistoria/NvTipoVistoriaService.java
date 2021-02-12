/*    */ package NvTipoVistoria;
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
/*    */ public class NvTipoVistoriaService
/*    */ {
/*    */   public NvTipoVistoria salvar(NvTipoVistoria nvTipoVistoria)
/*    */   {
/* 23 */     NvTipoVistoriaDAO dao = new NvTipoVistoriaDAO();
/* 24 */     if (nvTipoVistoria.getSeqNvTipoVistoria() == null) {
/* 25 */       nvTipoVistoria.setDataCadastro(new Date());
/* 26 */       return dao.inserir(nvTipoVistoria);
/*    */     }
/* 28 */     return dao.alterar(nvTipoVistoria);
/*    */   }
/*    */   
/*    */   public List<NvTipoVistoria> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     NvTipoVistoriaDAO dao = new NvTipoVistoriaDAO();
/* 34 */     List<NvTipoVistoria> listaNvTipoVistoria = new ArrayList();
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
/* 46 */     listaNvTipoVistoria = dao.listar(condicao);
/* 47 */     return listaNvTipoVistoria;
/*    */   }
/*    */   
/*    */   public boolean deletar(NvTipoVistoria nvTipoVistoria) {
/* 51 */     NvTipoVistoriaDAO dao = new NvTipoVistoriaDAO();
/* 52 */     return dao.deletar(nvTipoVistoria);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvTipoVistoria/NvTipoVistoriaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */