/*    */ package Anotacao;
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
/*    */ public class AnotacaoService
/*    */ {
/*    */   public Anotacao salvar(Anotacao anotacao)
/*    */   {
/* 22 */     AnotacaoDAO dao = new AnotacaoDAO();
/* 23 */     if (anotacao.getSeqAnotacao() == null) {
/* 24 */       dao.inserir(anotacao);
/* 25 */       return anotacao;
/*    */     }
/* 27 */     dao.alterar(anotacao);
/* 28 */     return anotacao;
/*    */   }
/*    */   
/*    */   public List<Anotacao> listarPorParceiro(String pSeqParceiro)
/*    */   {
/* 33 */     AnotacaoDAO dao = new AnotacaoDAO();
/* 34 */     List<Anotacao> listaAnotacao = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/* 36 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "anotacao.seq_parceiro", GeneroCondicaoWhere.igual, String.valueOf(pSeqParceiro), TipoCondicaoWhere.Numero);
/*    */     
/*    */ 
/* 39 */     listaAnotacao = dao.listar(condicao);
/* 40 */     return listaAnotacao;
/*    */   }
/*    */   
/*    */   public boolean deletar(Anotacao anotacao) {
/* 44 */     AnotacaoDAO dao = new AnotacaoDAO();
/* 45 */     return dao.deletar(anotacao);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Anotacao/AnotacaoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */