/*    */ package NvTipoEmbarcacao;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NvTipoEmbarcacao
/*    */ {
/*    */   private String seqNvTipoEmbarcacao;
/*    */   private String codigo;
/*    */   private String nome;
/*    */   private String situacao;
/*    */   private Date dataCadastro;
/*    */   
/*    */   public String getSeqNvTipoEmbarcacao()
/*    */   {
/* 21 */     return this.seqNvTipoEmbarcacao;
/*    */   }
/*    */   
/*    */   public void setSeqNvTipoEmbarcacao(String seqNvTipoEmbarcacao) {
/* 25 */     this.seqNvTipoEmbarcacao = seqNvTipoEmbarcacao;
/*    */   }
/*    */   
/*    */   public String getCodigo() {
/* 29 */     return this.codigo;
/*    */   }
/*    */   
/*    */   public void setCodigo(String codigo) {
/* 33 */     this.codigo = codigo;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 37 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 41 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getSituacao() {
/* 45 */     return this.situacao;
/*    */   }
/*    */   
/*    */   public void setSituacao(String situacao) {
/* 49 */     this.situacao = situacao;
/*    */   }
/*    */   
/*    */   public Date getDataCadastro() {
/* 53 */     return this.dataCadastro;
/*    */   }
/*    */   
/*    */   public void setDataCadastro(Date dataCadastro) {
/* 57 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */ }

