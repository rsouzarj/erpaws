/*    */ package NvTipoCertificado;
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
/*    */ public class NvTipoCertificadoService
/*    */ {
/*    */   public NvTipoCertificado salvar(NvTipoCertificado nvTipoCertificado)
/*    */   {
/* 23 */     NvTipoCertificadoDAO dao = new NvTipoCertificadoDAO();
/* 24 */     if (nvTipoCertificado.getSeqNvTipoCertificado() == null) {
/* 25 */       nvTipoCertificado.setDataCadastro(new Date());
/* 26 */       return dao.inserir(nvTipoCertificado);
/*    */     }
/* 28 */     return dao.alterar(nvTipoCertificado);
/*    */   }
/*    */   
/*    */   public List<NvTipoCertificado> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     NvTipoCertificadoDAO dao = new NvTipoCertificadoDAO();
/* 34 */     List<NvTipoCertificado> listaNvTipoCertificado = new ArrayList();
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
/* 46 */     listaNvTipoCertificado = dao.listar(condicao);
/* 47 */     return listaNvTipoCertificado;
/*    */   }
/*    */   
/*    */   public NvTipoCertificado buscar(String pSeqNvTipoCertificado) {
/* 51 */     NvTipoCertificadoDAO dao = new NvTipoCertificadoDAO();
/* 52 */     List<NvTipoCertificado> listaNvTipoCertificado = new ArrayList();
/* 53 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 55 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_nv_tipo_certificado", GeneroCondicaoWhere.igual, String.valueOf(pSeqNvTipoCertificado), TipoCondicaoWhere.Numero);
/*    */     
/* 57 */     listaNvTipoCertificado = dao.listar(condicao);
/* 58 */     return (NvTipoCertificado)listaNvTipoCertificado.get(0);
/*    */   }
/*    */   
/*    */   public boolean deletar(NvTipoCertificado nvTipoCertificado) {
/* 62 */     NvTipoCertificadoDAO dao = new NvTipoCertificadoDAO();
/* 63 */     return dao.deletar(nvTipoCertificado);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvTipoCertificado/NvTipoCertificadoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */