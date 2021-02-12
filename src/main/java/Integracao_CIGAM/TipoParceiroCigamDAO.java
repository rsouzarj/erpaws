/*    */ package Integracao_CIGAM;
/*    */ 
/*    */ import Empresa.Empresa;
/*    */ import Empresa.EmpresaService;
/*    */ import Parceiro.Parceiro;
/*    */ import Parceiro.ParceiroService;
/*    */ import TipoParceiro.TipoParceiro;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TipoParceiroCigamDAO
/*    */ {
/*    */   public List<TipoParceiro> listar(String pChave)
/*    */   {
/*    */     try
/*    */     {
/* 30 */       ConexaoBancoCIGAM conexao = new ConexaoBancoCIGAM();
/* 31 */       Connection conn = ConexaoBancoCIGAM.getConnection("CIGAM");
/* 32 */       String sql = "select * \nfrom\ngedivisa\n";
/*    */       
/*    */ 
/*    */ 
/* 36 */       System.out.println(sql);
/*    */       
/* 38 */       List<TipoParceiro> listaTipoParceiro = new ArrayList();
/* 39 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 40 */       ResultSet rs = ps.executeQuery();
/*    */       
/* 42 */       EmpresaService empresaService = new EmpresaService();
/* 43 */       Empresa empresa = empresaService.buscarEmpresaPorChave(pChave);
/*    */       
/* 45 */       ParceiroService parceiroService = new ParceiroService();
/* 46 */       Parceiro parceiro = new Parceiro();
/* 47 */       while (rs.next()) {
/* 48 */         TipoParceiro tipoParceiro = new TipoParceiro();
/* 49 */         tipoParceiro.setNome(rs.getString("DESCRICAO_DIVIS"));
/* 50 */         tipoParceiro.setDataCadastro(new Date());
/* 51 */         tipoParceiro.setSituacao("ATIVO");
/* 52 */         tipoParceiro.setPortalComercial("Não");
/* 53 */         tipoParceiro.setOrdem("0");
/* 54 */         tipoParceiro.setSeqEmpresa(empresa.getSeqEmpresa());
/* 55 */         tipoParceiro.setChaveOrigem(rs.getString("DIVISAO"));
/* 56 */         listaTipoParceiro.add(tipoParceiro);
/*    */       }
/*    */       
/* 59 */       ps.execute();
/* 60 */       ps.close();
/*    */       
/* 62 */       return listaTipoParceiro;
/*    */     } catch (SQLException ex) {
/* 64 */       Logger.getLogger(TipoParceiroCigamDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 65 */       System.out.println(ex.getMessage()); }
/* 66 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM/TipoParceiroCigamDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */