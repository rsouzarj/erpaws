/*    */ package Integracao_CIGAM;
/*    */ 
/*    */ import Empresa.Empresa;
/*    */ import Empresa.EmpresaService;
/*    */ import Parceiro.Parceiro;
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
/*    */ public class ParceiroCigamDAO
/*    */ {
/*    */   public List<Parceiro> listar(String pChave)
/*    */   {
/*    */     try
/*    */     {
/* 28 */       ConexaoBancoCIGAM conexao = new ConexaoBancoCIGAM();
/* 29 */       Connection conn = ConexaoBancoCIGAM.getConnection("CIGAM");
/* 30 */       String sql = "select * \nfrom\ngeempres\n";
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 36 */       List<Parceiro> listaParceiro = new ArrayList();
/* 37 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 38 */       ResultSet rs = ps.executeQuery();
/*    */       
/* 40 */       EmpresaService empresaService = new EmpresaService();
/* 41 */       Empresa empresa = empresaService.buscarEmpresaPorChave(pChave);
/*    */       
/* 43 */       while (rs.next()) {
/* 44 */         Parceiro parceiro = new Parceiro();
/* 45 */         parceiro.setNome(rs.getString("NOME_COMPLETO"));
/* 46 */         if (rs.getString("pessoa").equals("0")) {
/* 47 */           parceiro.setTipo("Pessoa Física");
/*    */         }
/*    */         
/* 50 */         parceiro.setTipo("Pessoa Jurídica");
/*    */         
/* 52 */         parceiro.setDocumento(rs.getString("CNPJ_CPF"));
/* 53 */         parceiro.setFantasia(rs.getString("FANTASIA"));
/* 54 */         parceiro.setLogradouro(rs.getString("ENDERECO"));
/* 55 */         parceiro.setNumero(rs.getString("NUMERO"));
/* 56 */         parceiro.setComplemento(rs.getString("COMPLEMENTO"));
/* 57 */         parceiro.setBairro(rs.getString("BAIRRO"));
/* 58 */         parceiro.setCidade(rs.getString("MUNICIPIO"));
/* 59 */         parceiro.setUf(rs.getString("UF"));
/* 60 */         parceiro.setCep(rs.getString("CEP"));
/* 61 */         parceiro.setTelefone1(rs.getString("FONE"));
/* 62 */         parceiro.setTelefone2(rs.getString("FAX_FONE"));
/* 63 */         parceiro.setTelefone3("");
/* 64 */         parceiro.setTelefone4("");
/* 65 */         parceiro.setEmail("");
/* 66 */         parceiro.setPessoaContato(rs.getString("CONTATO"));
/* 67 */         parceiro.setSituacao("ATIVO");
/* 68 */         parceiro.setSeqEmpresa(empresa.getSeqEmpresa());
/*    */         
/*    */ 
/*    */ 
/* 72 */         parceiro.setDataCadastro(new Date());
/* 73 */         parceiro.setCodigo(rs.getString("CD_EMPRESA"));
/* 74 */         parceiro.setSenha("");
/* 75 */         parceiro.setDataNascimento(rs.getDate("DT_ANIVERSARIO"));
/* 76 */         parceiro.setAtividadePrincipal("");
/* 77 */         parceiro.setChaveOrigem(rs.getString("CD_EMPRESA"));
/*    */         
/* 79 */         parceiro.setTag1(rs.getString("cd_representant"));
/* 80 */         parceiro.setTag2(rs.getString("divisao"));
/*    */         
/*    */ 
/*    */ 
/* 84 */         listaParceiro.add(parceiro);
/*    */       }
/*    */       
/* 87 */       ps.close();
/*    */       
/* 89 */       return listaParceiro;
/*    */     } catch (SQLException ex) {
/* 91 */       Logger.getLogger(ParceiroCigamDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 92 */       System.out.println(ex.getMessage()); }
/* 93 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM/ParceiroCigamDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */