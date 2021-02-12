/*    */ package CentralRelacionamento;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
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
/*    */ public class CentralRelacionamentoDAO
/*    */ {
/*    */   public List<CentralRelacionamento> listar(ClausulaWhere sClausula)
/*    */   {
/*    */     try
/*    */     {
/* 27 */       Conexao conexao = new Conexao();
/* 28 */       Connection conn = Conexao.getConnection();
/* 29 */       String sql = "SELECT * FROM vw_central_relacionamento" + sClausula.montarsClausula();
/* 30 */       System.out.println(sql);
/*    */       
/* 32 */       List<CentralRelacionamento> listaCentralRelacionamento = new ArrayList();
/* 33 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 34 */       ResultSet rs = ps.executeQuery();
/*    */       
/* 36 */       while (rs.next()) {
/* 37 */         CentralRelacionamento centralRelacionamento = new CentralRelacionamento();
/* 38 */         centralRelacionamento.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 39 */         centralRelacionamento.setNivel(rs.getString("NIVEL"));
/* 40 */         centralRelacionamento.setClienteDataCadastro(rs.getDate("CLIENTE_DATA_CADASTRO"));
/* 41 */         centralRelacionamento.setUsuario(rs.getString("USUARIO"));
/* 42 */         centralRelacionamento.setSeqParceiroVendedor(rs.getString("SEQ_PARCEIRO_VENDEDOR"));
/* 43 */         centralRelacionamento.setVendedor(rs.getString("VENDEDOR"));
/* 44 */         centralRelacionamento.setTipoParceiro(rs.getString("TIPO_PARCEIRO"));
/* 45 */         centralRelacionamento.setSeqParceiroCliente(rs.getString("SEQ_PARCEIRO_CLIENTE"));
/* 46 */         centralRelacionamento.setCliente(rs.getString("CLIENTE"));
/* 47 */         centralRelacionamento.setClienteTipo(rs.getString("CLIENTE_TIPO"));
/* 48 */         centralRelacionamento.setClienteDocumento(rs.getString("CLIENTE_DOCUMENTO"));
/* 49 */         centralRelacionamento.setClienteFantasia(rs.getString("CLIENTE_FANTASIA"));
/* 50 */         centralRelacionamento.setClienteLogradouro(rs.getString("CLIENTE_LOGRADOURO"));
/* 51 */         centralRelacionamento.setClienteNumero(rs.getString("CLIENTE_NUMERO"));
/* 52 */         centralRelacionamento.setClienteComplemento(rs.getString("CLIENTE_COMPLEMENTO"));
/* 53 */         centralRelacionamento.setClienteBairro(rs.getString("CLIENTE_BAIRRO"));
/* 54 */         centralRelacionamento.setClienteCidade(rs.getString("CLIENTE_CIDADE"));
/* 55 */         centralRelacionamento.setClienteUf(rs.getString("CLIENTE_UF"));
/* 56 */         centralRelacionamento.setClienteCep(rs.getString("CLIENTE_CEP"));
/* 57 */         centralRelacionamento.setClienteTelefone1(rs.getString("CLIENTE_TELEFONE_1"));
/* 58 */         centralRelacionamento.setClienteTelefone2(rs.getString("CLIENTE_TELEFONE_2"));
/* 59 */         centralRelacionamento.setClienteTelefone3(rs.getString("CLIENTE_TELEFONE_3"));
/* 60 */         centralRelacionamento.setClienteTelefone4(rs.getString("CLIENTE_TELEFONE_4"));
/* 61 */         centralRelacionamento.setClienteEmail(rs.getString("CLIENTE_EMAIL"));
/* 62 */         centralRelacionamento.setClientePessoaContato(rs.getString("CLIENTE_PESSOA_CONTATO"));
/* 63 */         centralRelacionamento.setSeqParceiroUsuario(rs.getString("SEQ_PARCEIRO_USUARIO"));
/* 64 */         centralRelacionamento.setSeqUsuario(rs.getString("SEQ_USUARIO"));
/* 65 */         listaCentralRelacionamento.add(centralRelacionamento);
/*    */       }
/*    */       
/* 68 */       ps.execute();
/* 69 */       ps.close();
/*    */       
/* 71 */       return listaCentralRelacionamento;
/*    */     } catch (SQLException ex) {
/* 73 */       Logger.getLogger(CentralRelacionamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 74 */       System.out.println(ex.getMessage()); }
/* 75 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/CentralRelacionamento/CentralRelacionamentoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */