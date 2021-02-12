/*    */ package _Teste;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Teste
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 14 */     Date data = new Date(System.currentTimeMillis());
/* 15 */     SimpleDateFormat formatarDate = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy'.'");
/* 16 */     String ano = formatarDate.format(data);
/* 17 */     System.out.println(ano);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/_Teste/Teste.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */