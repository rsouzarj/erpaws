/*    */ package Integracao_CIGAM;
/*    */ 
/*    */ import Empresa.Empresa;
/*    */ import Empresa.EmpresaService;
/*    */ import Parceiro.Parceiro;
/*    */ import Parceiro.ParceiroService;
/*    */ import Usuario.Usuario;
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
/*    */ public class UsuarioCigamDAO
/*    */ {
/*    */   public List<Usuario> listar(String pChave)
/*    */   {
/*    */     try
/*    */     {
/* 30 */       ConexaoBancoCIGAM conexao = new ConexaoBancoCIGAM();
/* 31 */       Connection conn = ConexaoBancoCIGAM.getConnection("CIGAM");
/* 32 */       String sql = "select * \nfrom\ngeusuari\n";
/*    */       
/*    */ 
/*    */ 
/* 36 */       System.out.println(sql);
/*    */       
/* 38 */       List<Usuario> listaUsuario = new ArrayList();
/* 39 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 40 */       ResultSet rs = ps.executeQuery();
/*    */       
/* 42 */       EmpresaService empresaService = new EmpresaService();
/* 43 */       Empresa empresa = empresaService.buscarEmpresaPorChave(pChave);
/*    */       
/* 45 */       ParceiroService parceiroService = new ParceiroService();
/* 46 */       Parceiro parceiro = new Parceiro();
/* 47 */       while (rs.next()) {
/* 48 */         Usuario usuario = new Usuario();
/* 49 */         usuario.setUsuario(rs.getString("usuario"));
/*    */         
/*    */ 
/* 52 */         parceiro = parceiroService.buscar(empresa.getSeqEmpresa(), rs.getString("campo20"));
/*    */         
/* 54 */         usuario.setSeqParceiro(parceiro.getSeqParceiro());
/*    */         
/* 56 */         usuario.setSenha(rs.getString("SENHA"));
/* 57 */         usuario.setEmail(rs.getString("campo23"));
/* 58 */         usuario.setSituacao("ATIVO");
/* 59 */         usuario.setCor(null);
/* 60 */         usuario.setDataCadastro(new Date());
/* 61 */         usuario.setSeqEmpresa(empresa.getSeqEmpresa());
/* 62 */         usuario.setSeqUnidadeNegocio(null);
/* 63 */         usuario.setSeqDepartamento(null);
/* 64 */         usuario.setNivel("1");
/* 65 */         usuario.setChaveOrigem(rs.getString("cd_usuario"));
/* 66 */         listaUsuario.add(usuario);
/*    */       }
/*    */       
/*    */ 
/* 70 */       ps.execute();
/* 71 */       ps.close();
/*    */       
/* 73 */       return listaUsuario;
/*    */     } catch (SQLException ex) {
/* 75 */       Logger.getLogger(UsuarioCigamDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 76 */       System.out.println(ex.getMessage()); }
/* 77 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM/UsuarioCigamDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */