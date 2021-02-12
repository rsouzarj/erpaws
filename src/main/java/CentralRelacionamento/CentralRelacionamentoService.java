/*    */ package CentralRelacionamento;
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
/*    */ public class CentralRelacionamentoService
/*    */ {
/*    */   public List<CentralRelacionamento> listarCarteiraPorUsuario(String pSeqUsuario)
/*    */   {
/* 22 */     CentralRelacionamentoDAO dao = new CentralRelacionamentoDAO();
/* 23 */     List<CentralRelacionamento> listaCentralRelacionamento = new ArrayList();
/* 24 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 26 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_usuario", GeneroCondicaoWhere.igual, String.valueOf(pSeqUsuario), TipoCondicaoWhere.Numero);
/*    */     
/* 28 */     listaCentralRelacionamento = dao.listar(condicao);
/* 29 */     return listaCentralRelacionamento;
/*    */   }
/*    */   
/*    */   public List<CentralRelacionamento> listarCarteiraPorNivel(String pNivel) {
/* 33 */     CentralRelacionamentoDAO dao = new CentralRelacionamentoDAO();
/* 34 */     List<CentralRelacionamento> listaCentralRelacionamento = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nivel", GeneroCondicaoWhere.ComecaPor, pNivel + ".", TipoCondicaoWhere.Texto);
/*    */     
/* 39 */     listaCentralRelacionamento = dao.listar(condicao);
/* 40 */     return listaCentralRelacionamento;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/CentralRelacionamento/CentralRelacionamentoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */