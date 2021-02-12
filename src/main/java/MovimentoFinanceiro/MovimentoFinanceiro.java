/*    */ package MovimentoFinanceiro;
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
/*    */ public class MovimentoFinanceiro
/*    */ {
/*    */   private String seqMovimentoFinanceiro;
/*    */   private String seqEmpresa;
/*    */   private Date dataCadastro;
/*    */   private String situacao;
/*    */   private String seqTipoMovimentoFinanceiro;
/*    */   private String operacao;
/*    */   private Date data;
/*    */   private BigDecimal valor;
/*    */   
/*    */   public String getSeqMovimentoFinanceiro()
/*    */   {
/* 27 */     return this.seqMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public void setSeqMovimentoFinanceiro(String seqMovimentoFinanceiro) {
/* 31 */     this.seqMovimentoFinanceiro = seqMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public String getSeqEmpresa() {
/* 35 */     return this.seqEmpresa;
/*    */   }
/*    */   
/*    */   public void setSeqEmpresa(String seqEmpresa) {
/* 39 */     this.seqEmpresa = seqEmpresa;
/*    */   }
/*    */   
/*    */   public Date getDataCadastro() {
/* 43 */     return this.dataCadastro;
/*    */   }
/*    */   
/*    */   public void setDataCadastro(Date dataCadastro) {
/* 47 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */   
/*    */   public String getSituacao() {
/* 51 */     return this.situacao;
/*    */   }
/*    */   
/*    */   public void setSituacao(String situacao) {
/* 55 */     this.situacao = situacao;
/*    */   }
/*    */   
/*    */   public String getSeqTipoMovimentoFinanceiro() {
/* 59 */     return this.seqTipoMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public void setSeqTipoMovimentoFinanceiro(String seqTipoMovimentoFinanceiro) {
/* 63 */     this.seqTipoMovimentoFinanceiro = seqTipoMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public String getOperacao() {
/* 67 */     return this.operacao;
/*    */   }
/*    */   
/*    */   public void setOperacao(String operacao) {
/* 71 */     this.operacao = operacao;
/*    */   }
/*    */   
/*    */   public Date getData() {
/* 75 */     return this.data;
/*    */   }
/*    */   
/*    */   public void setData(Date data) {
/* 79 */     this.data = data;
/*    */   }
/*    */   
/*    */   public BigDecimal getValor() {
/* 83 */     return this.valor;
/*    */   }
/*    */   
/*    */   public void setValor(BigDecimal valor) {
/* 87 */     this.valor = valor;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/MovimentoFinanceiro/MovimentoFinanceiro.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */