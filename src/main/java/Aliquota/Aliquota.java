/*    */ package Aliquota;
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
/*    */ public class Aliquota
/*    */ {
/*    */   private String seqAliquota;
/*    */   private String codigo;
/*    */   private String seqEmpresa;
/*    */   private String tipoAliquota;
/*    */   private String situacao;
/*    */   private String nome;
/*    */   private String descricao;
/*    */   private BigDecimal percentual;
/*    */   private Date dataCadastro;
/*    */   
/*    */   public String getSeqAliquota()
/*    */   {
/* 29 */     return this.seqAliquota;
/*    */   }
/*    */   
/*    */   public void setSeqAliquota(String seqAliquota) {
/* 33 */     this.seqAliquota = seqAliquota;
/*    */   }
/*    */   
/*    */   public String getSeqEmpresa() {
/* 37 */     return this.seqEmpresa;
/*    */   }
/*    */   
/*    */   public void setSeqEmpresa(String seqEmpresa) {
/* 41 */     this.seqEmpresa = seqEmpresa;
/*    */   }
/*    */   
/*    */   public String getTipoAliquota() {
/* 45 */     return this.tipoAliquota;
/*    */   }
/*    */   
/*    */   public void setTipoAliquota(String tipoAliquota) {
/* 49 */     this.tipoAliquota = tipoAliquota;
/*    */   }
/*    */   
/*    */   public String getSituacao() {
/* 53 */     return this.situacao;
/*    */   }
/*    */   
/*    */   public void setSituacao(String situacao) {
/* 57 */     this.situacao = situacao;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 61 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 65 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 69 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 73 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public BigDecimal getPercentual() {
/* 77 */     return this.percentual;
/*    */   }
/*    */   
/*    */   public void setPercentual(BigDecimal percentual) {
/* 81 */     this.percentual = percentual;
/*    */   }
/*    */   
/*    */   public Date getDataCadastro() {
/* 85 */     return this.dataCadastro;
/*    */   }
/*    */   
/*    */   public void setDataCadastro(Date dataCadastro) {
/* 89 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */   
/*    */   public String getCodigo() {
/* 93 */     return this.codigo;
/*    */   }
/*    */   
/*    */   public void setCodigo(String codigo) {
/* 97 */     this.codigo = codigo;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Aliquota/Aliquota.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */