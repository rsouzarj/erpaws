/*    */ package MaterialFamilia;
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
/*    */ public class MaterialFamiliaService
/*    */ {
/*    */   public MaterialFamilia salvar(MaterialFamilia materialFamilia)
/*    */   {
/* 23 */     MaterialFamiliaDAO dao = new MaterialFamiliaDAO();
/* 24 */     if (materialFamilia.getSeqMaterialFamilia() == null) {
/* 25 */       materialFamilia.setDataCadastro(new Date());
/* 26 */       dao.inserir(materialFamilia);
/* 27 */       return materialFamilia;
/*    */     }
/* 29 */     dao.alterar(materialFamilia);
/* 30 */     return materialFamilia;
/*    */   }
/*    */   
/*    */   public List<MaterialFamilia> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 35 */     MaterialFamiliaDAO dao = new MaterialFamiliaDAO();
/* 36 */     List<MaterialFamilia> listaMaterialFamilia = new ArrayList();
/* 37 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 40 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 42 */     if (pSituacao == Situacao.ATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 44 */     } else if (pSituacao == Situacao.INATIVO) {
/* 45 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 48 */     listaMaterialFamilia = dao.listar(condicao);
/* 49 */     return listaMaterialFamilia;
/*    */   }
/*    */   
/*    */   public boolean deletar(MaterialFamilia materialFamilia) {
/* 53 */     MaterialFamiliaDAO dao = new MaterialFamiliaDAO();
/* 54 */     return dao.deletar(materialFamilia);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/MaterialFamilia/MaterialFamiliaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */