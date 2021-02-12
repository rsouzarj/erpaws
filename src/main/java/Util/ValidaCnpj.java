/*    */ package Util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ValidaCnpj
/*    */ {
/* 10 */   private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
/* 11 */   private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
/*    */   
/*    */   private static int calcularDigito(String str, int[] peso) {
/* 14 */     int soma = 0;
/* 15 */     for (int indice = str.length() - 1; indice >= 0; indice--) {
/* 16 */       int digito = Integer.parseInt(str.substring(indice, indice + 1));
/* 17 */       soma += digito * peso[(peso.length - str.length() + indice)];
/*    */     }
/* 19 */     soma = 11 - soma % 11;
/* 20 */     return soma > 9 ? 0 : soma;
/*    */   }
/*    */   
/*    */   public static boolean isValidCNPJ(String cnpj) {
/* 24 */     if ((cnpj == null) || (cnpj.length() != 14)) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     Integer digito1 = Integer.valueOf(calcularDigito(cnpj.substring(0, 12), pesoCNPJ));
/* 29 */     Integer digito2 = Integer.valueOf(calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ));
/* 30 */     return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {}
/*    */ }
