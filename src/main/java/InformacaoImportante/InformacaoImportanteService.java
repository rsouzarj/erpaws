/*    */ package InformacaoImportante;
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
/*    */ public class InformacaoImportanteService
/*    */ {
/*    */   public InformacaoImportante salvar(InformacaoImportante informacaoImportante)
/*    */   {
/* 23 */     InformacaoImportanteDAO dao = new InformacaoImportanteDAO();
/* 24 */     if (informacaoImportante.getSeqInformacaoImportante() == null) {
/* 25 */       informacaoImportante.setDataCadastro(new Date());
/* 26 */       return dao.inserir(informacaoImportante);
/*    */     }
/* 28 */     return dao.alterar(informacaoImportante);
/*    */   }
/*    */   
/*    */   public List<InformacaoImportante> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     InformacaoImportanteDAO dao = new InformacaoImportanteDAO();
/* 34 */     List<InformacaoImportante> listaInformacaoImportante = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "descricao", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 40 */     if (pSituacao == Situacao.ATIVO) {
/* 41 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 42 */     } else if (pSituacao == Situacao.INATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 46 */     listaInformacaoImportante = dao.listar(condicao);
/* 47 */     return listaInformacaoImportante;
/*    */   }
/*    */   
/*    */   public boolean deletar(InformacaoImportante informacaoImportante) {
/* 51 */     InformacaoImportanteDAO dao = new InformacaoImportanteDAO();
/* 52 */     return dao.deletar(informacaoImportante);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/InformacaoImportante/InformacaoImportanteService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */