/*    */ package NvVistoriaStatus;
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
/*    */ public class NvVistoriaStatusService
/*    */ {
/*    */   public NvVistoriaStatus salvar(NvVistoriaStatus nvVistoriaStatus)
/*    */   {
/* 23 */     NvVistoriaStatusDAO dao = new NvVistoriaStatusDAO();
/* 24 */     if (nvVistoriaStatus.getSeqNvVistoriaStatus() == null) {
/* 25 */       nvVistoriaStatus.setDataCadastro(new Date());
/* 26 */       return dao.inserir(nvVistoriaStatus);
/*    */     }
/* 28 */     return dao.alterar(nvVistoriaStatus);
/*    */   }
/*    */   
/*    */   public List<NvVistoriaStatus> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     NvVistoriaStatusDAO dao = new NvVistoriaStatusDAO();
/* 34 */     List<NvVistoriaStatus> listaNvVistoriaStatus = new ArrayList();
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
/* 46 */     listaNvVistoriaStatus = dao.listar(condicao);
/* 47 */     return listaNvVistoriaStatus;
/*    */   }
/*    */   
/*    */   public boolean deletar(NvVistoriaStatus nvVistoriaStatus) {
/* 51 */     NvVistoriaStatusDAO dao = new NvVistoriaStatusDAO();
/* 52 */     return dao.deletar(nvVistoriaStatus);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvVistoriaStatus/NvVistoriaStatusService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */