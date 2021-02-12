/*    */ package FinanceiroEquipamento;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FinanceiroEquipamento
/*    */ {
/*    */   private String seqFinanceiroEquipamento;
/*    */   private String seqEquipamento;
/*    */   private BigDecimal valor;
/*    */   private String seqFinanceiro;
/*    */   private String nomeEquipamento;
/*    */   private String comentario;
/*    */   
/*    */   public String getComentario()
/*    */   {
/* 24 */     return this.comentario;
/*    */   }
/*    */   
/*    */   public void setComentario(String comentario) {
/* 28 */     this.comentario = comentario;
/*    */   }
/*    */   
/*    */   public String getSeqFinanceiroEquipamento() {
/* 32 */     return this.seqFinanceiroEquipamento;
/*    */   }
/*    */   
/*    */   public void setSeqFinanceiroEquipamento(String seqFinanceiroEquipamento) {
/* 36 */     this.seqFinanceiroEquipamento = seqFinanceiroEquipamento;
/*    */   }
/*    */   
/*    */   public String getSeqEquipamento() {
/* 40 */     return this.seqEquipamento;
/*    */   }
/*    */   
/*    */   public void setSeqEquipamento(String seqEquipamento) {
/* 44 */     this.seqEquipamento = seqEquipamento;
/*    */   }
/*    */   
/*    */   public BigDecimal getValor() {
/* 48 */     return this.valor;
/*    */   }
/*    */   
/*    */   public void setValor(BigDecimal valor) {
/* 52 */     this.valor = valor;
/*    */   }
/*    */   
/*    */   public String getSeqFinanceiro() {
/* 56 */     return this.seqFinanceiro;
/*    */   }
/*    */   
/*    */   public void setSeqFinanceiro(String seqFinanceiro) {
/* 60 */     this.seqFinanceiro = seqFinanceiro;
/*    */   }
/*    */   
/*    */   public String getNomeEquipamento() {
/* 64 */     return this.nomeEquipamento;
/*    */   }
/*    */   
/*    */   public void setNomeEquipamento(String nomeEquipamento) {
/* 68 */     this.nomeEquipamento = nomeEquipamento;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FinanceiroEquipamento/FinanceiroEquipamento.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */