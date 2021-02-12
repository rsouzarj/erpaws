/*     */ package Material;
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
/*     */ public class Material
/*     */ {
/*     */   private String seqMaterial;
/*     */   private String seqEmpresa;
/*     */   private String codigo;
/*     */   private String referencia;
/*     */   private String nome;
/*     */   private String descricao;
/*     */   private Date dataCadastro;
/*     */   private String situacao;
/*     */   private BigDecimal qtdeEstoque;
/*     */   private String seqMaterialFamilia;
/*     */   
/*     */   public String getSeqMaterial()
/*     */   {
/*  29 */     return this.seqMaterial;
/*     */   }
/*     */   
/*     */   public void setSeqMaterial(String seqMaterial) {
/*  33 */     this.seqMaterial = seqMaterial;
/*     */   }
/*     */   
/*     */   public String getSeqEmpresa() {
/*  37 */     return this.seqEmpresa;
/*     */   }
/*     */   
/*     */   public void setSeqEmpresa(String seqEmpresa) {
/*  41 */     this.seqEmpresa = seqEmpresa;
/*     */   }
/*     */   
/*     */   public String getCodigo() {
/*  45 */     return this.codigo;
/*     */   }
/*     */   
/*     */   public void setCodigo(String codigo) {
/*  49 */     this.codigo = codigo;
/*     */   }
/*     */   
/*     */   public String getReferencia() {
/*  53 */     return this.referencia;
/*     */   }
/*     */   
/*     */   public void setReferencia(String referencia) {
/*  57 */     this.referencia = referencia;
/*     */   }
/*     */   
/*     */   public String getNome() {
/*  61 */     return this.nome;
/*     */   }
/*     */   
/*     */   public void setNome(String nome) {
/*  65 */     this.nome = nome;
/*     */   }
/*     */   
/*     */   public String getDescricao() {
/*  69 */     return this.descricao;
/*     */   }
/*     */   
/*     */   public void setDescricao(String descricao) {
/*  73 */     this.descricao = descricao;
/*     */   }
/*     */   
/*     */   public Date getDataCadastro() {
/*  77 */     return this.dataCadastro;
/*     */   }
/*     */   
/*     */   public void setDataCadastro(Date dataCadastro) {
/*  81 */     this.dataCadastro = dataCadastro;
/*     */   }
/*     */   
/*     */   public String getSituacao() {
/*  85 */     return this.situacao;
/*     */   }
/*     */   
/*     */   public void setSituacao(String situacao) {
/*  89 */     this.situacao = situacao;
/*     */   }
/*     */   
/*     */   public BigDecimal getQtdeEstoque() {
/*  93 */     return this.qtdeEstoque;
/*     */   }
/*     */   
/*     */   public void setQtdeEstoque(BigDecimal qtdeEstoque) {
/*  97 */     this.qtdeEstoque = qtdeEstoque;
/*     */   }
/*     */   
/*     */   public String getSeqMaterialFamilia() {
/* 101 */     return this.seqMaterialFamilia;
/*     */   }
/*     */   
/*     */   public void setSeqMaterialFamilia(String seqMaterialFamilia) {
/* 105 */     this.seqMaterialFamilia = seqMaterialFamilia;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Material/Material.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */