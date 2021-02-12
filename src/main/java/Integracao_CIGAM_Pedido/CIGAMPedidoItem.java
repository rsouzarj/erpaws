/*    */ package Integracao_CIGAM_Pedido;
/*    */ 
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
/*    */ public class CIGAMPedidoItem
/*    */ {
/*    */   String pin;
/*    */   String statusRegistro;
/*    */   List<CIGAMPedido> pedidoJson;
/*    */   
/*    */   public String getPin()
/*    */   {
/* 21 */     return this.pin;
/*    */   }
/*    */   
/*    */   public void setPin(String pin) {
/* 25 */     this.pin = pin;
/*    */   }
/*    */   
/*    */   public String getStatusRegistro() {
/* 29 */     return this.statusRegistro;
/*    */   }
/*    */   
/*    */   public void setStatusRegistro(String statusRegistro) {
/* 33 */     this.statusRegistro = statusRegistro;
/*    */   }
/*    */   
/*    */   public List<CIGAMPedido> getPedidoJson() {
/* 37 */     return this.pedidoJson;
/*    */   }
/*    */   
/*    */   public void setPedidoJson(List<CIGAMPedido> pedidoJson) {
/* 41 */     this.pedidoJson = pedidoJson;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM_Pedido/CIGAMPedidoItem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */