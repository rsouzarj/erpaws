/*    */ package Integracao_CIGAM;
/*    */ 
/*    */ import Empresa.Empresa;
/*    */ import Empresa.EmpresaService;
/*    */ import Util.Conexao;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConexaoBancoCIGAM
/*    */ {
/*    */   static Connection conn;
/*    */   
/*    */   public static void main(String[] args)
/*    */     throws SQLException
/*    */   {
/* 26 */     Connection con = getConnection("CIGAM");
/*    */   }
/*    */   
/*    */   public static Connection getConnection(String pChave) {
/*    */     try {
/* 31 */       if ((conn != null) && 
/* 32 */         (!conn.isClosed())) {
/* 33 */         return conn;
/*    */       }
/*    */     }
/*    */     catch (SQLException ex) {
/* 37 */       Logger.getLogger(ConexaoBancoCIGAM.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */     
/* 40 */     EmpresaService empresaService = new EmpresaService();
/* 41 */     Empresa empresa = empresaService.buscarEmpresaPorChave(pChave);
/*    */     
/* 43 */     if (empresa.getSgbd().equals("ORACLE")) {
/*    */       try {
/* 45 */         String url = "jdbc:oracle:thin:@" + empresa.getSgbdUrl();
/*    */         
/* 47 */         String usuario = empresa.getSgbdUsuario();
/* 48 */         String senha = empresa.getSgbdSenha();
/* 49 */         Class.forName("oracle.jdbc.driver.OracleDriver");
/* 50 */         Connection con = null;
/* 51 */         con = DriverManager.getConnection(url, usuario, senha);
/* 52 */         conn = con;
/* 53 */         System.out.println("Conectou no Oracle com Sucesso");
/* 54 */         return con;
/*    */       } catch (Exception e) {
/* 56 */         System.out.println(e);
/* 57 */         return null;
/*    */       }
/*    */     }
/* 60 */     if (empresa.getSgbd().equals("SQLSERVER")) {
/*    */       try {
/* 62 */         String URL = "jdbc:sqlserver://" + empresa.getSgbdUrl();
/* 63 */         String usuario = empresa.getSgbdUsuario();
/* 64 */         String password = empresa.getSgbdSenha();
/* 65 */         String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
/*    */         
/* 67 */         Class.forName(DRIVER);
/*    */         
/*    */ 
/* 70 */         Connection con = DriverManager.getConnection(URL, usuario, password);
/* 71 */         conn = con;
/* 72 */         System.out.println("Conectou no SQLSERVER com Sucesso");
/* 73 */         return con;
/*    */       } catch (SQLException ex) {
/* 75 */         Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
/* 76 */         System.out.println("Erro na conexao!");
/* 77 */         return null;
/*    */       } catch (ClassNotFoundException ex) {
/* 79 */         Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
/* 80 */         System.out.println("Erro na conexao!");
/* 81 */         return null;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 86 */     return null;
/*    */   }
/*    */   
/*    */   public static Connection getConn()
/*    */   {
/* 91 */     return conn;
/*    */   }
/*    */   
/*    */   public static void setConn(Connection conn) {
/* 95 */     conn = conn;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM/ConexaoBancoCIGAM.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */