/*    */ package NvTpVistoriaTpCertificado;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
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
/*    */ 
/*    */ public class NvTpVistoriaTpCertificadoService
/*    */ {
/*    */   public NvTpVistoriaTpCertificado salvar(NvTpVistoriaTpCertificado nvTpVistoriaTpCertificado)
/*    */   {
/* 22 */     NvTpVistoriaTpCertificadoDAO dao = new NvTpVistoriaTpCertificadoDAO();
/* 23 */     return dao.inserir(nvTpVistoriaTpCertificado);
/*    */   }
/*    */   
/*    */   public List<NvTpVistoriaTpCertificado> listarPorTipoVistoria(String pSeqTipoVistoria) {
/* 27 */     NvTpVistoriaTpCertificadoDAO dao = new NvTpVistoriaTpCertificadoDAO();
/* 28 */     List<NvTpVistoriaTpCertificado> listaNvTpVistoriaTpCertificado = new ArrayList();
/* 29 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 31 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "NV_TP_VISTORIA_TP_CERTIFICADO.seq_nv_tipo_vistoria", GeneroCondicaoWhere.igual, String.valueOf(pSeqTipoVistoria), TipoCondicaoWhere.Numero);
/*    */     
/* 33 */     listaNvTpVistoriaTpCertificado = dao.listar(condicao);
/* 34 */     return listaNvTpVistoriaTpCertificado;
/*    */   }
/*    */   
/*    */   public List<NvTpVistoriaTpCertificado> listarPorTipoCertificado(String pSeqTipoCertificado) {
/* 38 */     NvTpVistoriaTpCertificadoDAO dao = new NvTpVistoriaTpCertificadoDAO();
/* 39 */     List<NvTpVistoriaTpCertificado> listaNvTpVistoriaTpCertificado = new ArrayList();
/* 40 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 42 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "NV_TP_VISTORIA_TP_CERTIFICADO.seq_nv_tipo_certificado", GeneroCondicaoWhere.igual, String.valueOf(pSeqTipoCertificado), TipoCondicaoWhere.Numero);
/*    */     
/* 44 */     listaNvTpVistoriaTpCertificado = dao.listar(condicao);
/* 45 */     return listaNvTpVistoriaTpCertificado;
/*    */   }
/*    */   
/*    */   public boolean deletar(NvTpVistoriaTpCertificado nvTpVistoriaTpCertificado) {
/* 49 */     NvTpVistoriaTpCertificadoDAO dao = new NvTpVistoriaTpCertificadoDAO();
/* 50 */     return dao.deletar(nvTpVistoriaTpCertificado.getSeqNvTipoVistoria(), nvTpVistoriaTpCertificado.getSeqNvTipoCertificado());
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvTpVistoriaTpCertificado/NvTpVistoriaTpCertificadoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */