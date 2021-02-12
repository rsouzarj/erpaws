/*    */ package DocumentoItemFinanceiro;
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
/*    */ public class DocumentoItemFinanceiro
/*    */ {
/*    */   private String seqDocumentoItemFinanceiro;
/*    */   private String seqDocumento;
/*    */   private Date dataCadastro;
/*    */   private BigDecimal valor;
/*    */   private String seqFormaPagamento;
/*    */   private String seqConta;
/*    */   private String seqTipoMovimentoFinanceiro;
/*    */   private String seqEmpresa;
/*    */   private String situacao;
/*    */   
/*    */   public String getSeqDocumentoItemFinanceiro()
/*    */   {
/* 26 */     return this.seqDocumentoItemFinanceiro;
/*    */   }
/*    */   
/*    */   public void setSeqDocumentoItemFinanceiro(String seqDocumentoItemFinanceiro) {
/* 30 */     this.seqDocumentoItemFinanceiro = seqDocumentoItemFinanceiro;
/*    */   }
/*    */   
/*    */   public String getSeqDocumento() {
/* 34 */     return this.seqDocumento;
/*    */   }
/*    */   
/*    */   public void setSeqDocumento(String seqDocumento) {
/* 38 */     this.seqDocumento = seqDocumento;
/*    */   }
/*    */   
/*    */   public Date getDataCadastro() {
/* 42 */     return this.dataCadastro;
/*    */   }
/*    */   
/*    */   public void setDataCadastro(Date dataCadastro) {
/* 46 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */   
/*    */   public BigDecimal getValor() {
/* 50 */     return this.valor;
/*    */   }
/*    */   
/*    */   public void setValor(BigDecimal valor) {
/* 54 */     this.valor = valor;
/*    */   }
/*    */   
/*    */   public String getSeqFormaPagamento() {
/* 58 */     return this.seqFormaPagamento;
/*    */   }
/*    */   
/*    */   public void setSeqFormaPagamento(String seqFormaPagamento) {
/* 62 */     this.seqFormaPagamento = seqFormaPagamento;
/*    */   }
/*    */   
/*    */   public String getSeqConta() {
/* 66 */     return this.seqConta;
/*    */   }
/*    */   
/*    */   public void setSeqConta(String seqConta) {
/* 70 */     this.seqConta = seqConta;
/*    */   }
/*    */   
/*    */   public String getSeqTipoMovimentoFinanceiro() {
/* 74 */     return this.seqTipoMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public void setSeqTipoMovimentoFinanceiro(String seqTipoMovimentoFinanceiro) {
/* 78 */     this.seqTipoMovimentoFinanceiro = seqTipoMovimentoFinanceiro;
/*    */   }
/*    */   
/*    */   public String getSeqEmpresa() {
/* 82 */     return this.seqEmpresa;
/*    */   }
/*    */   
/*    */   public void setSeqEmpresa(String seqEmpresa) {
/* 86 */     this.seqEmpresa = seqEmpresa;
/*    */   }
/*    */   
/*    */   public String getSituacao() {
/* 90 */     return this.situacao;
/*    */   }
/*    */   
/*    */   public void setSituacao(String situacao) {
/* 94 */     this.situacao = situacao;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemFinanceiro/DocumentoItemFinanceiro.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */