/*    */ package NvTipoLicenca;
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
/*    */ public class NvTipoLicencaService
/*    */ {
/*    */   public NvTipoLicenca salvar(NvTipoLicenca nvTipoLicenca)
/*    */   {
/* 23 */     NvTipoLicencaDAO dao = new NvTipoLicencaDAO();
/* 24 */     if (nvTipoLicenca.getSeqNvTipoLicenca() == null) {
/* 25 */       nvTipoLicenca.setDataCadastro(new Date());
/* 26 */       return dao.inserir(nvTipoLicenca);
/*    */     }
/* 28 */     return dao.alterar(nvTipoLicenca);
/*    */   }
/*    */   
/*    */   public List<NvTipoLicenca> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     NvTipoLicencaDAO dao = new NvTipoLicencaDAO();
/* 34 */     List<NvTipoLicenca> listaNvTipoLicenca = new ArrayList();
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
/* 46 */     listaNvTipoLicenca = dao.listar(condicao);
/* 47 */     return listaNvTipoLicenca;
/*    */   }
/*    */   
/*    */   public boolean deletar(NvTipoLicenca nvTipoLicenca) {
/* 51 */     NvTipoLicencaDAO dao = new NvTipoLicencaDAO();
/* 52 */     return dao.deletar(nvTipoLicenca);
/*    */   }
/*    */ }


