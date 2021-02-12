/*    */ package NvCertificadoAntigo;
/*    */ 
         import NvCertificadoAntigo.*;
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
/*    */ public class NvCertificadoAntigoService
/*    */ {
/*    */   public NvCertificadoAntigo salvar(NvCertificadoAntigo nvCertificadoAntigo)
/*    */   {
/* 23 */     NvCertificadoAntigoDAO dao = new NvCertificadoAntigoDAO();
/* 24 */     if (nvCertificadoAntigo.getSeqNvCertificado() == null) {
/* 25 */       nvCertificadoAntigo.setDataCadastro(new Date());
/* 26 */       dao.inserir(nvCertificadoAntigo);
/* 27 */       return nvCertificadoAntigo;
/*    */     }
/* 29 */     dao.alterar(nvCertificadoAntigo);
/* 30 */     return nvCertificadoAntigo;
/*    */   }
/*    */   
/*    */   public List<NvCertificadoAntigo> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 35 */     NvCertificadoAntigoDAO dao = new NvCertificadoAntigoDAO();
/* 36 */     List<NvCertificadoAntigo> listaNvCertificado = new ArrayList();
/* 37 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "NV_CERTIFICADO.identificacao", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 40 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_CERTIFICADO.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 42 */     if (pSituacao == Situacao.ATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_CERTIFICADO.situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 44 */     } else if (pSituacao == Situacao.INATIVO) {
/* 45 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_CERTIFICADO.situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 48 */     listaNvCertificado = dao.listar(condicao);
/* 49 */     return listaNvCertificado;
/*    */   }
/*    */   
/*    */   public List<NvCertificadoAntigo> listarPorVistoria(String pSeqVistoria) {
/* 53 */     NvCertificadoAntigoDAO dao = new NvCertificadoAntigoDAO();
/* 54 */     List<NvCertificadoAntigo> listaNvCertificado = new ArrayList();
/* 55 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 57 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "NV_CERTIFICADO.seq_nv_vistoria", GeneroCondicaoWhere.igual,String.valueOf(pSeqVistoria), TipoCondicaoWhere.Texto);
/*    */     
/* 59 */     listaNvCertificado = dao.listar(condicao);
/* 60 */     return listaNvCertificado;
/*    */   }
   
            public List<NvCertificadoAntigo> listarC(String pSeqNvEmbarcacao)
/*    */   {
/* 31 */     NvCertificadoAntigoDAO dao = new NvCertificadoAntigoDAO();
/* 32 */     List<NvCertificadoAntigo> listaNvCertificado = new ArrayList();
/* 33 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
              condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "NV_CERTIFICADO.seq_nv_embarcacao", GeneroCondicaoWhere.igual,String.valueOf(pSeqNvEmbarcacao), TipoCondicaoWhere.Numero);

/* 37 */     listaNvCertificado = dao.listar(condicao);
/* 38 */     return listaNvCertificado;
/*    */   }
            
            
/*    */   public boolean deletar(NvCertificadoAntigo nvCertificado) {
/* 64 */     NvCertificadoAntigoDAO dao = new NvCertificadoAntigoDAO();
/* 65 */     return dao.deletar(nvCertificado);
/*    */   }
/*    */   
/*    */   public List<NvCertificadoAntigo> listar(ClausulaWhere sClausula) {
/* 69 */     NvCertificadoAntigoDAO dao = new NvCertificadoAntigoDAO();
/* 70 */     return dao.listar(sClausula);
/*    */   }
/*    */ }