/*    */ package ParceiroVinculo;
/*    */ 
/*    */ import Parceiro.Parceiro;
/*    */ import Parceiro.ParceiroService;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParceiroTeste
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 19 */     ParceiroService parceiroService = new ParceiroService();
/*    */     
/* 21 */     Parceiro parceiro = new Parceiro();
/*    */     
/* 23 */     parceiro.setNome("Bruno RIbeiro 2020");
/* 24 */     parceiro.setSeqTipoParceiro("389");
/* 25 */     parceiro.setSeqEmpresa("65");
/* 26 */     parceiro.setSeqParceiroInclusao("48292");
/* 27 */     parceiroService.salvar(parceiro);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ParceiroVinculo/ParceiroTeste.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */