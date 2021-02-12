/*    */ package NvPais;
/*    */ 
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
/*    */ public class NvPais
/*    */ {
/*    */   private String seqNvPais;
/*    */   private String codigo;
/*    */   private String nomePortugues;
/*    */   private String nomeIngles;
/*    */   private String situacao;
/*    */   private Date dataCadastro;
/*    */   
/*    */   public String getSeqNvPais()
/*    */   {
/* 24 */     return this.seqNvPais;
/*    */   }
/*    */   
/*    */   public void setSeqNvPais(String seqNvPais) {
/* 28 */     this.seqNvPais = seqNvPais;
/*    */   }
/*    */   
/*    */   public String getCodigo() {
/* 32 */     return this.codigo;
/*    */   }
/*    */   
/*    */   public void setCodigo(String codigo) {
/* 36 */     this.codigo = codigo;
/*    */   }
/*    */   
/*    */   public String getNomePortugues() {
/* 40 */     return this.nomePortugues;
/*    */   }
/*    */   
/*    */   public void setNomePortugues(String nomePortugues) {
/* 44 */     this.nomePortugues = nomePortugues;
/*    */   }
/*    */   
/*    */   public String getNomeIngles() {
/* 48 */     return this.nomeIngles;
/*    */   }
/*    */   
/*    */   public void setNomeIngles(String nomeIngles) {
/* 52 */     this.nomeIngles = nomeIngles;
/*    */   }
/*    */   
/*    */   public String getSituacao() {
/* 56 */     return this.situacao;
/*    */   }
/*    */   
/*    */   public void setSituacao(String situacao) {
/* 60 */     this.situacao = situacao;
/*    */   }
/*    */   
/*    */   public Date getDataCadastro() {
/* 64 */     return this.dataCadastro;
/*    */   }
/*    */   
/*    */   public void setDataCadastro(Date dataCadastro) {
/* 68 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvPais/NvPais.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */