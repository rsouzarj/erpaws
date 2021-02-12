/*    */ package _Teste;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.GregorianCalendar;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataPorExtenso
/*    */ {
/*    */   public static String NomeDoMes(int i, int tipo)
/*    */   {
/* 18 */     String[] mes = { "janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro" };
/*    */     
/*    */ 
/*    */ 
/* 22 */     if (tipo == 0)
/* 23 */       return mes[(i - 1)];
/* 24 */     return mes[(i - 1)].substring(0, 3);
/*    */   }
/*    */   
/*    */   public static String DataPorExtenso(String cidade, Date dt)
/*    */   {
/* 29 */     int d = dt.getDate();
/* 30 */     int m = dt.getMonth() + 1;
/* 31 */     int a = dt.getYear() + 1900;
/*    */     
/* 33 */     Calendar data = new GregorianCalendar(a, m - 1, d);
/* 34 */     int ds = data.get(7);
/*    */     
/* 36 */     return cidade + " " + d + " de " + NomeDoMes(m, 0) + " de " + a;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/_Teste/DataPorExtenso.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */