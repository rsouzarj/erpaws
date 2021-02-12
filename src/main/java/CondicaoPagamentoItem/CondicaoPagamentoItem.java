/*    */ package CondicaoPagamentoItem;
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
/*    */ 
/*    */ public class CondicaoPagamentoItem
/*    */ {
/*    */   private String seqCondicaoPagamentoItem;
/*    */   private String seqCondicaoPagamento;
/*    */   private String nome;
/*    */   private String dias;
/*    */   private BigDecimal rateioPerc;
/*    */   private BigDecimal acrescimo;
/*    */   private Date dataCadastro;
/*    */   private String situacao;
/*    */   
/*    */   public String getSeqCondicaoPagamentoItem()
/*    */   {
/* 28 */     return this.seqCondicaoPagamentoItem;
/*    */   }
/*    */   
/*    */   public void setSeqCondicaoPagamentoItem(String seqCondicaoPagamentoItem) {
/* 32 */     this.seqCondicaoPagamentoItem = seqCondicaoPagamentoItem;
/*    */   }
/*    */   
/*    */   public String getSeqCondicaoPagamento() {
/* 36 */     return this.seqCondicaoPagamento;
/*    */   }
/*    */   
/*    */   public void setSeqCondicaoPagamento(String seqCondicaoPagamento) {
/* 40 */     this.seqCondicaoPagamento = seqCondicaoPagamento;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 44 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 48 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getDias() {
/* 52 */     return this.dias;
/*    */   }
/*    */   
/*    */   public void setDias(String dias) {
/* 56 */     this.dias = dias;
/*    */   }
/*    */   
/*    */   public BigDecimal getRateioPerc() {
/* 60 */     return this.rateioPerc;
/*    */   }
/*    */   
/*    */   public void setRateioPerc(BigDecimal rateioPerc) {
/* 64 */     this.rateioPerc = rateioPerc;
/*    */   }
/*    */   
/*    */   public BigDecimal getAcrescimo() {
/* 68 */     return this.acrescimo;
/*    */   }
/*    */   
/*    */   public void setAcrescimo(BigDecimal acrescimo) {
/* 72 */     this.acrescimo = acrescimo;
/*    */   }
/*    */   
/*    */   public Date getDataCadastro() {
/* 76 */     return this.dataCadastro;
/*    */   }
/*    */   
/*    */   public void setDataCadastro(Date dataCadastro) {
/* 80 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */   
/*    */   public String getSituacao() {
/* 84 */     return this.situacao;
/*    */   }
/*    */   
/*    */   public void setSituacao(String situacao) {
/* 88 */     this.situacao = situacao;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/CondicaoPagamentoItem/CondicaoPagamentoItem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */