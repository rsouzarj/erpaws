/*    */ package PlanoItem;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlanoItem
/*    */ {
/*    */   private String seqPlanoItem;
/*    */   private String nomePlano;
/*    */   private Date dataCadastro;
/*    */   private String seqEmpresa;
/*    */   private String situacao;
/*    */   private String identificacaoLista;
/*    */   
/*    */   public String getSituacao()
/*    */   {
/* 32 */     return this.situacao;
/*    */   }
/*    */   
/*    */   public void setSituacao(String situacao) {
/* 36 */     this.situacao = situacao;
/*    */   }
/*    */   
/*    */   public String getSeqPlanoItem() {
/* 40 */     return this.seqPlanoItem;
/*    */   }
/*    */   
/*    */   public void setSeqPlanoItem(String seqPlanoItem) {
/* 44 */     this.seqPlanoItem = seqPlanoItem;
/*    */   }
/*    */   
/*    */   public String getNomePlano() {
/* 48 */     return this.nomePlano;
/*    */   }
/*    */   
/*    */   public void setNomePlano(String nomePlano) {
/* 52 */     this.nomePlano = nomePlano;
/*    */   }
/*    */   
/*    */   public Date getDataCadastro() {
/* 56 */     return this.dataCadastro;
/*    */   }
/*    */   
/*    */   public void setDataCadastro(Date dataCadastro) {
/* 60 */     this.dataCadastro = dataCadastro;
/*    */   }
/*    */   
/*    */   public String getSeqEmpresa() {
/* 64 */     return this.seqEmpresa;
/*    */   }
/*    */   
/*    */   public void setSeqEmpresa(String seqEmpresa) {
/* 68 */     this.seqEmpresa = seqEmpresa;
/*    */   }
/*    */   
/*    */   public String getIdentificacaoLista() {
/* 72 */     return this.identificacaoLista;
/*    */   }
/*    */   
/*    */   public void setIdentificacaoLista(String identificacaoLista) {
/* 76 */     this.identificacaoLista = identificacaoLista;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/PlanoItem/PlanoItem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */