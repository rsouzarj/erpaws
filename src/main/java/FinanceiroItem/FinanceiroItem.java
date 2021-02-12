/*    */ package FinanceiroItem;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FinanceiroItem
/*    */ {
/*    */   private String seqFinanceiroItem;
/*    */   private Date dataCadastro;
/*    */   private String seqFinanceiro;
/*    */   private BigDecimal quantidade;
/*    */   private String descricao;
/*    */   private BigDecimal valorUnitario;
/*    */   private BigDecimal valorTotal;
/*    */   private String seqEmpresa;
/*    */   private String seqUnidade;
           private String seqDocumento;
/*    */   
/*    */   public String getSeqFinanceiroItem()
/*    */   {
/* 28 */     return this.seqFinanceiroItem;
/*    */   }
/*    */   
/*    */   public void setSeqFinanceiroItem(String seqFinanceiroItem) {
/* 32 */     this.seqFinanceiroItem = seqFinanceiroItem;
/*    */   }
/*    */   
/*    */   public Date getDataCadastro() {
/* 36 */     return this.dataCadastro;
/*    */   }
/*    */   
/*    */   public void setDataCadastro(Date dataCadastro) {
/* 40 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */   
/*    */   public String getSeqFinanceiro() {
/* 44 */     return this.seqFinanceiro;
/*    */   }
/*    */   
/*    */   public void setSeqFinanceiro(String seqFinanceiro) {
/* 48 */     this.seqFinanceiro = seqFinanceiro;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getDescricao()
/*    */   {
/* 54 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 58 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public BigDecimal getValorUnitario() {
/* 62 */     return this.valorUnitario;
/*    */   }
/*    */   
/*    */   public void setValorUnitario(BigDecimal valorUnitario) {
/* 66 */     this.valorUnitario = valorUnitario;
/*    */   }
/*    */   
/*    */   public BigDecimal getValorTotal() {
/* 70 */     return this.valorTotal;
/*    */   }
/*    */   
/*    */   public void setValorTotal(BigDecimal valorTotal) {
/* 74 */     this.valorTotal = valorTotal;
/*    */   }
/*    */   
/*    */   public String getSeqEmpresa() {
/* 78 */     return this.seqEmpresa;
/*    */   }
/*    */   
/*    */   public void setSeqEmpresa(String seqEmpresa) {
/* 82 */     this.seqEmpresa = seqEmpresa;
/*    */   }
/*    */   
/*    */   public String getSeqUnidade() {
/* 86 */     return this.seqUnidade;
/*    */   }
/*    */   
/*    */   public void setSeqUnidade(String seqUnidade) {
/* 90 */     this.seqUnidade = seqUnidade;
/*    */   }
/*    */   
/*    */   public BigDecimal getQuantidade() {
/* 94 */     return this.quantidade;
/*    */   }
/*    */   
/*    */   public void setQuantidade(BigDecimal quantidade) {
/* 98 */     this.quantidade = quantidade;
/*    */   }
           
/*    */   public String getSeqDocumento() {
/* 44 */     return this.seqDocumento;
/*    */   }
/*    */   
/*    */   public void setSeqDocumento(String seqDocumento) {
/* 48 */     this.seqDocumento = seqDocumento;
/*    */   }           




/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FinanceiroItem/FinanceiroItem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */