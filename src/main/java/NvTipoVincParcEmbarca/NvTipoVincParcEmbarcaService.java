/*    */ package NvTipoVincParcEmbarca;
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
/*    */ public class NvTipoVincParcEmbarcaService
/*    */ {
/*    */   public NvTipoVincParcEmbarca salvar(NvTipoVincParcEmbarca nvTipoVincParcEmbarca)
/*    */   {
/* 23 */     NvTipoVincParcEmbarcaDAO dao = new NvTipoVincParcEmbarcaDAO();
/* 24 */     if (nvTipoVincParcEmbarca.getSeqNvTipoVincParcEmbarca() == null) {
/* 25 */       nvTipoVincParcEmbarca.setDataCadastro(new Date());
/* 26 */       return dao.inserir(nvTipoVincParcEmbarca);
/*    */     }
/* 28 */     return dao.alterar(nvTipoVincParcEmbarca);
/*    */   }
/*    */   
/*    */   public List<NvTipoVincParcEmbarca> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     NvTipoVincParcEmbarcaDAO dao = new NvTipoVincParcEmbarcaDAO();
/* 34 */     List<NvTipoVincParcEmbarca> listaNvTipoVincParcEmbarca = new ArrayList();
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
/* 46 */     listaNvTipoVincParcEmbarca = dao.listar(condicao);
/* 47 */     return listaNvTipoVincParcEmbarca;
/*    */   }
/*    */   
/*    */   public boolean deletar(NvTipoVincParcEmbarca nvTipoVincParcEmbarca) {
/* 51 */     NvTipoVincParcEmbarcaDAO dao = new NvTipoVincParcEmbarcaDAO();
/* 52 */     return dao.deletar(nvTipoVincParcEmbarca);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvTipoVincParcEmbarca/NvTipoVincParcEmbarcaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */