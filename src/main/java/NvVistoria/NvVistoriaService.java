/*    */ package NvVistoria;
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
/*    */ public class NvVistoriaService
/*    */ {
/*    */   public NvVistoria salvar(NvVistoria nvVistoria)
/*    */   {
/* 23 */     NvVistoriaDAO dao = new NvVistoriaDAO();
/* 24 */     if (nvVistoria.getSeqNvVistoria() == null) {
/* 25 */       nvVistoria.setDataCadastro(new Date());
/* 26 */       return dao.inserir(nvVistoria);
/*    */     }
/* 28 */     return dao.alterar(nvVistoria);
/*    */   }
/*    */   
/*    */   public List<NvVistoria> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     NvVistoriaDAO dao = new NvVistoriaDAO();
/* 34 */     List<NvVistoria> listaNvVistoria = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nv_embarcacao.nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "nv_vistoria.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 40 */     if (pSituacao == Situacao.ATIVO) {
/* 41 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "nv_vistoria.situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 42 */     } else if (pSituacao == Situacao.INATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "nv_vistoria.situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 46 */     listaNvVistoria = dao.listar(condicao);
/* 47 */     return listaNvVistoria;
/*    */   }
/*    */   
/*    */   public NvVistoria buscar(String pSeqNvVistoria) {
/* 51 */     NvVistoriaDAO dao = new NvVistoriaDAO();
/* 52 */     List<NvVistoria> listaNvVistoria = new ArrayList();
/* 53 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 55 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nv_vistoria.seq_nv_vistoria", GeneroCondicaoWhere.igual, String.valueOf(pSeqNvVistoria), TipoCondicaoWhere.Numero);
/*    */     
/* 57 */     listaNvVistoria = dao.listar(condicao);
/* 58 */     return (NvVistoria)listaNvVistoria.get(0);
/*    */   }
/*    */   
/*    */   public boolean deletar(NvVistoria nvVistoria) {
/* 62 */     NvVistoriaDAO dao = new NvVistoriaDAO();
/* 63 */     return dao.deletar(nvVistoria);
/*    */   }

            public NvVistoria aprovar(NvVistoria nvVistoria) {
/* 62 */     NvVistoriaDAO dao = new NvVistoriaDAO();
/* 63 */     return dao.aprovar(nvVistoria);
/*    */   }




/*    */   
/*    */   public List<NvVistoria> listar(ClausulaWhere sClausula) {
/* 67 */     NvVistoriaDAO dao = new NvVistoriaDAO();
/* 68 */     return dao.listar(sClausula);
/*    */   }
/*    */ }

