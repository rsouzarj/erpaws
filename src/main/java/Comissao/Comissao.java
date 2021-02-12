/*     */ package Comissao;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Comissao
/*     */ {
/*     */   private String seqComissao;
/*     */   private Date dataCadastro;
/*     */   private String seqUsuario;
/*     */   private String descricao;
/*     */   private Date dataPrevBaixa;
/*     */   private Date dataBaixa;
/*     */   private String status;
/*     */   private String operacao;
/*     */   private String seqEmpresa;
/*     */   private BigDecimal valor;
/*     */   private String disponivelApp;
/*     */   
/*     */   public String getSeqComissao()
/*     */   {
/*  31 */     return this.seqComissao;
/*     */   }
/*     */   
/*     */   public void setSeqComissao(String seqComissao) {
/*  35 */     this.seqComissao = seqComissao;
/*     */   }
/*     */   
/*     */   public Date getDataCadastro() {
/*  39 */     return this.dataCadastro;
/*     */   }
/*     */   
/*     */   public void setDataCadastro(Date dataCadastro) {
/*  43 */     this.dataCadastro = dataCadastro;
/*     */   }
/*     */   
/*     */   public String getSeqUsuario() {
/*  47 */     return this.seqUsuario;
/*     */   }
/*     */   
/*     */   public void setSeqUsuario(String seqUsuario) {
/*  51 */     this.seqUsuario = seqUsuario;
/*     */   }
/*     */   
/*     */   public String getDescricao() {
/*  55 */     return this.descricao;
/*     */   }
/*     */   
/*     */   public void setDescricao(String descricao) {
/*  59 */     this.descricao = descricao;
/*     */   }
/*     */   
/*     */   public Date getDataPrevBaixa() {
/*  63 */     return this.dataPrevBaixa;
/*     */   }
/*     */   
/*     */   public void setDataPrevBaixa(Date dataPrevBaixa) {
/*  67 */     this.dataPrevBaixa = dataPrevBaixa;
/*     */   }
/*     */   
/*     */   public Date getDataBaixa() {
/*  71 */     return this.dataBaixa;
/*     */   }
/*     */   
/*     */   public void setDataBaixa(Date dataBaixa) {
/*  75 */     this.dataBaixa = dataBaixa;
/*     */   }
/*     */   
/*     */   public String getStatus() {
/*  79 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/*  83 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getOperacao() {
/*  87 */     return this.operacao;
/*     */   }
/*     */   
/*     */   public void setOperacao(String operacao) {
/*  91 */     this.operacao = operacao;
/*     */   }
/*     */   
/*     */   public String getSeqEmpresa() {
/*  95 */     return this.seqEmpresa;
/*     */   }
/*     */   
/*     */   public void setSeqEmpresa(String seqEmpresa) {
/*  99 */     this.seqEmpresa = seqEmpresa;
/*     */   }
/*     */   
/*     */   public BigDecimal getValor() {
/* 103 */     return this.valor;
/*     */   }
/*     */   
/*     */   public void setValor(BigDecimal valor) {
/* 107 */     this.valor = valor;
/*     */   }
/*     */   
/*     */   public String getDisponivelApp() {
/* 111 */     return this.disponivelApp;
/*     */   }
/*     */   
/*     */   public void setDisponivelApp(String disponivelApp) {
/* 115 */     this.disponivelApp = disponivelApp;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Comissao/Comissao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */