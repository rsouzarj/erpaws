/*    */ package Uf;
/*    */ 
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
/*    */ public class UfService
/*    */ {
/*    */   public List<Uf> listar()
/*    */   {
/* 17 */     UfDAO dao = new UfDAO();
/* 18 */     List<Uf> listaUf = new ArrayList();
/* 19 */     listaUf = dao.listar();
/* 20 */     return listaUf;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Uf/UfService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */