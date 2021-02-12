/*    */ package Integracao_SAP;
/*    */ 
/*    */ import com.sap.smb.sbo.api.ICompany;
/*    */ import com.sap.smb.sbo.api.SBOCOMConstants;
/*    */ import com.sap.smb.sbo.api.SBOCOMUtil;
/*    */ import com.sap.smb.sbo.api.SBOErrorMessage;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConexaoSAP
/*    */ {
/*    */   static ICompany company;
/*    */   
/*    */   public static ICompany getConnection()
/*    */   {
/* 23 */     if ((company != null) && 
/* 24 */       (company.isConnected().booleanValue())) {
/* 25 */       return company;
/*    */     }
/*    */     
/*    */ 
/* 29 */     SBOErrorMessage errMsg = null;
/*    */     
/* 31 */     int rc = 0;
/*    */     
/*    */ 
/*    */     try
/*    */     {
/* 36 */       company = SBOCOMUtil.newCompany();
/* 37 */       company.setServer("Maquina01-PC");
/*    */       
/*    */ 
/* 40 */       company.setCompanyDB("SBO_TESTE1");
/* 41 */       company.setUserName("manager");
/* 42 */       company.setPassword("sapadmin");
/* 43 */       company.setDbServerType(SBOCOMConstants.BoDataServerTypes_dst_MSSQL2014);
/* 44 */       company.setUseTrusted(new Boolean(false));
/* 45 */       company.setLanguage(SBOCOMConstants.BoSuppLangs_ln_Portuguese_Br);
/* 46 */       company.setDbUserName("sa");
/* 47 */       company.setDbPassword("cross");
/*    */       
/* 49 */       company.setLicenseServer("192.168.1.13:30000");
/*    */       
/* 51 */       rc = company.connect();
/* 52 */       if (rc == 0) {
/* 53 */         System.out.println("Connected!");
/*    */       } else {
/* 55 */         errMsg = company.getLastError();
/* 56 */         System.out.println(errMsg.getErrorMessage() + " * " + errMsg.getErrorCode());
/*    */       }
/*    */       
/*    */ 
/* 60 */       return company;
/*    */     } catch (Exception e) {
/* 62 */       e.printStackTrace(); }
/* 63 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_SAP/ConexaoSAP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */