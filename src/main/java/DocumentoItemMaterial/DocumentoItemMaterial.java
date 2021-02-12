/*     */ package DocumentoItemMaterial;
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
/*     */ 
/*     */ 
/*     */ public class DocumentoItemMaterial
/*     */ {
/*     */   private String seqDocumentoItemMaterial;
/*     */   private String seqEmpresa;
/*     */   private String seqDocumento;
/*     */   private Date dataCadastro;
/*     */   private String situacao;
/*     */   private String seqMaterial;
/*     */   private BigDecimal seqUnidade;
/*     */   private BigDecimal vlUnitario;
/*     */   private BigDecimal qtde;
/*     */   private BigDecimal precoTabela;
/*     */   private BigDecimal precoTotal;
/*     */   private String materialCodigo;
/*     */   private String materialReferencia;
/*     */   private String materialNome;
/*     */   private BigDecimal vlDesconto;
/*     */   private String tag1;
/*     */   private String tipoDesconto;
/*     */   private BigDecimal qtdeAnterior;
/*     */   private BigDecimal qtdePeriodo;
/*     */   private BigDecimal qtdeAcumulado;
/*     */   private BigDecimal vlPeriodo;
/*     */   private BigDecimal vlAcumulado;
/*     */   boolean chkTaxaCambio;
/*     */   private String descricao;
/*     */   
/*     */   public String getSeqDocumentoItemMaterial()
/*     */   {
/*  46 */     return this.seqDocumentoItemMaterial;
/*     */   }
/*     */   
/*     */   public void setSeqDocumentoItemMaterial(String seqDocumentoItemMaterial) {
/*  50 */     this.seqDocumentoItemMaterial = seqDocumentoItemMaterial;
/*     */   }
/*     */   
/*     */   public String getSeqEmpresa() {
/*  54 */     return this.seqEmpresa;
/*     */   }
/*     */   
/*     */   public void setSeqEmpresa(String seqEmpresa) {
/*  58 */     this.seqEmpresa = seqEmpresa;
/*     */   }
/*     */   
/*     */   public String getSeqDocumento() {
/*  62 */     return this.seqDocumento;
/*     */   }
/*     */   
/*     */   public void setSeqDocumento(String seqDocumento) {
/*  66 */     this.seqDocumento = seqDocumento;
/*     */   }
/*     */   
/*     */   public Date getDataCadastro() {
/*  70 */     return this.dataCadastro;
/*     */   }
/*     */   
/*     */   public void setDataCadastro(Date dataCadastro) {
/*  74 */     this.dataCadastro = dataCadastro;
/*     */   }
/*     */   
/*     */   public String getSituacao() {
/*  78 */     return this.situacao;
/*     */   }
/*     */   
/*     */   public void setSituacao(String situacao) {
/*  82 */     this.situacao = situacao;
/*     */   }
/*     */   
/*     */   public String getSeqMaterial() {
/*  86 */     return this.seqMaterial;
/*     */   }
/*     */   
/*     */   public void setSeqMaterial(String seqMaterial) {
/*  90 */     this.seqMaterial = seqMaterial;
/*     */   }
/*     */   
/*     */   public BigDecimal getVlUnitario() {
/*  94 */     return this.vlUnitario;
/*     */   }
/*     */   
/*     */   public void setVlUnitario(BigDecimal vlUnitario) {
/*  98 */     this.vlUnitario = vlUnitario;
/*     */   }
/*     */   
/*     */   public BigDecimal getQtde() {
/* 102 */     return this.qtde;
/*     */   }
/*     */   
/*     */   public void setQtde(BigDecimal qtde) {
/* 106 */     this.qtde = qtde;
/*     */   }
/*     */   
/*     */   public BigDecimal getPrecoTabela() {
/* 110 */     return this.precoTabela;
/*     */   }
/*     */   
/*     */   public void setPrecoTabela(BigDecimal precoTabela) {
/* 114 */     this.precoTabela = precoTabela;
/*     */   }
/*     */   
/*     */   public BigDecimal getPrecoTotal() {
/* 118 */     return this.precoTotal;
/*     */   }
/*     */   
/*     */   public void setPrecoTotal(BigDecimal precoTotal) {
/* 122 */     this.precoTotal = precoTotal;
/*     */   }
/*     */   
/*     */   public String getMaterialNome() {
/* 126 */     return this.materialNome;
/*     */   }
/*     */   
/*     */   public void setMaterialNome(String materialNome) {
/* 130 */     this.materialNome = materialNome;
/*     */   }
/*     */   
/*     */   public String getMaterialCodigo() {
/* 134 */     return this.materialCodigo;
/*     */   }
/*     */   
/*     */   public void setMaterialCodigo(String materialCodigo) {
/* 138 */     this.materialCodigo = materialCodigo;
/*     */   }
/*     */   
/*     */   public String getMaterialReferencia() {
/* 142 */     return this.materialReferencia;
/*     */   }
/*     */   
/*     */   public void setMaterialReferencia(String materialReferencia) {
/* 146 */     this.materialReferencia = materialReferencia;
/*     */   }
/*     */   
/*     */   public BigDecimal getVlDesconto() {
/* 150 */     return this.vlDesconto;
/*     */   }
/*     */   
/*     */   public void setVlDesconto(BigDecimal vlDesconto) {
/* 154 */     this.vlDesconto = vlDesconto;
/*     */   }
/*     */   
/*     */   public String getTag1() {
/* 158 */     return this.tag1;
/*     */   }
/*     */   
/*     */   public void setTag1(String tag1) {
/* 162 */     this.tag1 = tag1;
/*     */   }
/*     */   
/*     */   public String getTipoDesconto() {
/* 166 */     return this.tipoDesconto;
/*     */   }
/*     */   
/*     */   public void setTipoDesconto(String tipoDesconto) {
/* 170 */     this.tipoDesconto = tipoDesconto;
/*     */   }
/*     */   
/*     */   public BigDecimal getSeqUnidade() {
/* 174 */     return this.seqUnidade;
/*     */   }
/*     */   
/*     */   public void setSeqUnidade(BigDecimal seqUnidade) {
/* 178 */     this.seqUnidade = seqUnidade;
/*     */   }
/*     */   
/*     */   public BigDecimal getQtdeAnterior() {
/* 182 */     return this.qtdeAnterior;
/*     */   }
/*     */   
/*     */   public void setQtdeAnterior(BigDecimal qtdeAnterior) {
/* 186 */     this.qtdeAnterior = qtdeAnterior;
/*     */   }
/*     */   
/*     */   public BigDecimal getQtdePeriodo() {
/* 190 */     return this.qtdePeriodo;
/*     */   }
/*     */   
/*     */   public void setQtdePeriodo(BigDecimal qtdePeriodo) {
/* 194 */     this.qtdePeriodo = qtdePeriodo;
/*     */   }
/*     */   
/*     */   public BigDecimal getQtdeAcumulado() {
/* 198 */     return this.qtdeAcumulado;
/*     */   }
/*     */   
/*     */   public void setQtdeAcumulado(BigDecimal qtdeAcumulado) {
/* 202 */     this.qtdeAcumulado = qtdeAcumulado;
/*     */   }
/*     */   
/*     */   public BigDecimal getVlPeriodo() {
/* 206 */     return this.vlPeriodo;
/*     */   }
/*     */   
/*     */   public void setVlPeriodo(BigDecimal vlPeriodo) {
/* 210 */     this.vlPeriodo = vlPeriodo;
/*     */   }
/*     */   
/*     */   public BigDecimal getVlAcumulado() {
/* 214 */     return this.vlAcumulado;
/*     */   }
/*     */   
/*     */   public void setVlAcumulado(BigDecimal vlAcumulado) {
/* 218 */     this.vlAcumulado = vlAcumulado;
/*     */   }
/*     */   
/*     */   public String getDescricao() {
/* 222 */     return this.descricao;
/*     */   }
/*     */   
/*     */   public void setDescricao(String descricao) {
/* 226 */     this.descricao = descricao;
/*     */   }
/*     */   
/*     */   public boolean isChkTaxaCambio() {
/* 230 */     return this.chkTaxaCambio;
/*     */   }
/*     */   
/*     */   public void setChkTaxaCambio(boolean chkTaxaCambio) {
/* 234 */     this.chkTaxaCambio = chkTaxaCambio;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemMaterial/DocumentoItemMaterial.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */