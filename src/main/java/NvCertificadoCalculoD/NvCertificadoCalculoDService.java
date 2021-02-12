/*    */ package NvCertificadoCalculoD;
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
/*    */ 
/*    */ public class NvCertificadoCalculoDService
/*    */ {
/*    */   public NvCertificadoCalculoD salvar(NvCertificadoCalculoD nvCertificadoCalculoD)
/*    */   {
/* 23 */     NvCertificadoCalculoDDAO dao = new NvCertificadoCalculoDDAO();
/* 24 */     if (nvCertificadoCalculoD.getSeqNvCertificadoCalculoD() == null) {
/* 25 */       return dao.inserir(nvCertificadoCalculoD);
/*    */     }
/* 27 */     return dao.alterar(nvCertificadoCalculoD);
/*    */   }
/*    */   
/*    */   public List<NvCertificadoCalculoD> listar(String pNvCertificadoCalculo)
/*    */   {
/* 32 */     NvCertificadoCalculoDDAO dao = new NvCertificadoCalculoDDAO();
/* 33 */     List<NvCertificadoCalculoD> listaNvCertificadoCalculoD = new ArrayList();
/* 34 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 36 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_nv_certificado_calculo", GeneroCondicaoWhere.igual, String.valueOf(pNvCertificadoCalculo), TipoCondicaoWhere.Numero);
/*    */     
/* 38 */     listaNvCertificadoCalculoD = dao.listar(condicao);
/* 39 */     return listaNvCertificadoCalculoD;
/*    */   }
/*    */   
/*    */   public boolean deletar(NvCertificadoCalculoD nvCertificadoCalculoD) {
/* 43 */     NvCertificadoCalculoDDAO dao = new NvCertificadoCalculoDDAO();
/* 44 */     return dao.deletar(nvCertificadoCalculoD);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvCertificadoCalculoD/NvCertificadoCalculoDService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */