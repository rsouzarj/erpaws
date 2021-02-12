/*    */ package Uf;
/*    */ 
/*    */ import Util.Conexao;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UfDAO
/*    */ {
/*    */   public List<Uf> listar()
/*    */   {
/*    */     try
/*    */     {
/* 27 */       Conexao conexao = new Conexao();
/* 28 */       Connection conn = Conexao.getConnection();
/* 29 */       String sql = "SELECT * FROM UF";
/*    */       
/* 31 */       List<Uf> listaUf = new ArrayList();
/* 32 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 33 */       ResultSet rs = ps.executeQuery();
/*    */       
/* 35 */       while (rs.next()) {
/* 36 */         Uf uf = new Uf();
/* 37 */         uf.setId(rs.getString("ID"));
/* 38 */         uf.setNome(rs.getString("NOME"));
/* 39 */         listaUf.add(uf);
/*    */       }
/*    */       
/* 42 */       ps.execute();
/* 43 */       ps.close();
/*    */       
/* 45 */       return listaUf;
/*    */     } catch (SQLException ex) {
/* 47 */       Logger.getLogger(UfDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 48 */       System.out.println(ex.getMessage()); }
/* 49 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Uf/UfDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */