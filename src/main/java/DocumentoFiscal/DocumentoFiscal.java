/*    */ package DocumentoFiscal;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocumentoFiscal
/*    */ {
/*    */   private String seqDocumentoFiscal;
/*    */   private String nome;
/*    */   private String situacao;
/*    */   private String seqEmpresa;
/*    */   private Date dataCadastro;
/*    */   
/*    */   public String getSeqDocumentoFiscal()
/*    */   {
/* 21 */     return this.seqDocumentoFiscal;
/*    */   }
/*    */   
/*    */   public void setSeqDocumentoFiscal(String seqDocumentoFiscal) {
/* 25 */     this.seqDocumentoFiscal = seqDocumentoFiscal;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 29 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 33 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getSituacao() {
/* 37 */     return this.situacao;
/*    */   }
/*    */   
/*    */   public void setSituacao(String situacao) {
/* 41 */     this.situacao = situacao;
/*    */   }
/*    */   
/*    */   public String getSeqEmpresa() {
/* 45 */     return this.seqEmpresa;
/*    */   }
/*    */   
/*    */   public void setSeqEmpresa(String seqEmpresa) {
/* 49 */     this.seqEmpresa = seqEmpresa;
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoFiscal/DocumentoFiscal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */