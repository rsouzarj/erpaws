/*    */ package ProjecaoTributaria;
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
/*    */ public class ProjecaoTributaria
/*    */ {
/*    */   private String seqProjecaoTributaria;
/*    */   private String nome;
/*    */   private Date dataCadastro;
/*    */   private String seqEmpresa;
/*    */   private String situacao;
/*    */   private BigDecimal percentual;
/*    */   
/*    */   public String getSeqProjecaoTributaria()
/*    */   {
/* 25 */     return this.seqProjecaoTributaria;
/*    */   }
/*    */   
/*    */   public void setSeqProjecaoTributaria(String seqProjecaoTributaria) {
/* 29 */     this.seqProjecaoTributaria = seqProjecaoTributaria;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 33 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 37 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public Date getDataCadastro() {
/* 41 */     return this.dataCadastro;
/*    */   }
/*    */   
/*    */   public void setDataCadastro(Date dataCadastro) {
/* 45 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */   
/*    */   public String getSeqEmpresa() {
/* 49 */     return this.seqEmpresa;
/*    */   }
/*    */   
/*    */   public void setSeqEmpresa(String seqEmpresa) {
/* 53 */     this.seqEmpresa = seqEmpresa;
/*    */   }
/*    */   
/*    */   public String getSituacao() {
/* 57 */     return this.situacao;
/*    */   }
/*    */   
/*    */   public void setSituacao(String situacao) {
/* 61 */     this.situacao = situacao;
/*    */   }
/*    */   
/*    */   public BigDecimal getPercentual() {
/* 65 */     return this.percentual;
/*    */   }
/*    */   
/*    */   public void setPercentual(BigDecimal percentual) {
/* 69 */     this.percentual = percentual;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ProjecaoTributaria/ProjecaoTributaria.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */