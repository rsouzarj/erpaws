/*     */ package Documento;
/*     */ 
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.mail.MessagingException;
/*     */ import javax.mail.Multipart;
/*     */ import javax.mail.internet.MimeBodyPart;
/*     */ import javax.mail.internet.MimeMultipart;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentoTeste
/*     */ {
/*     */   public static void main(String[] args)
/*     */   {
/*  76 */     MimeBodyPart textPart = new MimeBodyPart();
/*  77 */     Multipart mps = new MimeMultipart();
/*  78 */     DocumentoService ds = new DocumentoService();
/*     */     
/*     */ 
/*  81 */     String pConteudo = "<b>TESTE</b>,<br><br><br><br><br> A <b>Ordem de Serviço</b> de Código <b>TESTE</b>, da TESTE - TESTE, foi finalizada.<br><br> Para que possamos implementar ações para melhor atendê-lo, solicitamos que participe da Pesquisa de Satisfação <a href='http://191.252.65.76/erp/pesquisa.jsf?se=61&sd=1332&spc=81505' >Clicando Aqui</a>.<br><br><br><br><br>Agradecemos a preferência,<br><br><br><br>Atenciosamente,<br><br><br><br><b>AWS SERVICE</b><br/><h5><b>**E-mail enviado de forma automática, favor não responder.**</b></h5>";
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
/*     */     try
/*     */     {
/*  95 */       textPart.setContent(pConteudo, "text/html");
/*     */     } catch (MessagingException ex) {
/*  97 */       Logger.getLogger(DocumentoTeste.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     try
/*     */     {
/* 101 */       mps.addBodyPart(textPart);
/*     */     } catch (MessagingException ex) {
/* 103 */       Logger.getLogger(DocumentoTeste.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 105 */     ds.enviarEmailParceiro("alex@crossystem.com.br", mps);
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Documento/DocumentoTeste.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */