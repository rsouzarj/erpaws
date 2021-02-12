/*     */ package Empresa;
/*     */ 
/*     */ import ClausulaSQL.ClausulaWhere;
/*     */ import Util.Conexao;
/*     */ import Util.Sequence;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EmpresaDAO
/*     */ {
/*     */   public Empresa inserir(Empresa empresa)
/*     */   {
/*     */     try
/*     */     {
/*  28 */       String seq = Sequence.buscarNumeroSequence("SEQ_EMPRESA");
/*  29 */       empresa.setSeqEmpresa(seq);
/*  30 */       Conexao conexao = new Conexao();
/*  31 */       Connection conn = Conexao.getConnection();
/*  32 */       String sql = "insert into EMPRESA (SEQ_EMPRESA,SGBD_SENHA,EMAIL_ACESSO,SITUACAO,RAZAO_SOCIAL,FANTASIA,CNPJ,LOGRADOURO,COMPLEMENTO,BAIRRO,CIDADE,UF,CEP,TELEFONE,EMAIL,PESSOA_CONTATO,CHAVE,NAVAL,NV_SEQ_TIPO_PARCEIRO_VISTORIAD,SEQ_TIPO_VINCULO_VENDEDOR,USUARIO,SGBD,SGBD_URL,SGBD_USUARIO,DATA_CADASTRO,SENHA, proximo_codigo_parceiro, tipo_numeracao_cod_parceiro) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  36 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  38 */       ps.setString(1, empresa.getSeqEmpresa());
/*  39 */       ps.setString(2, empresa.getSgbdSenha());
/*  40 */       ps.setString(3, empresa.getEmailAcesso());
/*  41 */       ps.setString(4, empresa.getSituacao());
/*  42 */       ps.setString(5, empresa.getRazaoSocial());
/*  43 */       ps.setString(6, empresa.getFantasia());
/*  44 */       ps.setString(7, empresa.getCnpj());
/*  45 */       ps.setString(8, empresa.getLogradouro());
/*  46 */       ps.setString(9, empresa.getComplemento());
/*  47 */       ps.setString(10, empresa.getBairro());
/*  48 */       ps.setString(11, empresa.getCidade());
/*  49 */       ps.setString(12, empresa.getUf());
/*  50 */       ps.setString(13, empresa.getCep());
/*  51 */       ps.setString(14, empresa.getTelefone());
/*  52 */       ps.setString(15, empresa.getEmail());
/*  53 */       ps.setString(16, empresa.getPessoaContato());
/*  54 */       ps.setString(17, empresa.getChave());
/*  55 */       ps.setString(18, empresa.getNaval());
/*  56 */       ps.setString(19, empresa.getNvSeqTipoParceiroVistoriad());
/*  57 */       ps.setString(20, empresa.getSeqTipoVinculoVendedor());
/*  58 */       ps.setString(21, empresa.getUsuario());
/*  59 */       ps.setString(22, empresa.getSgbd());
/*  60 */       ps.setString(23, empresa.getSgbdUrl());
/*  61 */       ps.setString(24, empresa.getSgbdUsuario());
/*  62 */       ps.setDate(25, new java.sql.Date(empresa.getDataCadastro().getTime()));
/*  63 */       ps.setString(26, empresa.getSenha());
/*  64 */       ps.setString(27, empresa.getProximoCodigoParceiro());
/*  65 */       ps.setString(28, empresa.getTipoNumeracaoCodParceiro());
/*     */       
/*  67 */       ps.execute();
/*  68 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  71 */       Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  72 */       System.out.println(ex.getMessage());
/*     */     }
/*  74 */     return empresa;
/*     */   }
/*     */   
/*     */   public Empresa alterar(Empresa empresa) {
/*     */     try {
/*  79 */       Conexao conexao = new Conexao();
/*  80 */       Connection conn = Conexao.getConnection();
/*  81 */       String sql = "update EMPRESA set SGBD_SENHA = ?,EMAIL_ACESSO = ?,SITUACAO = ?,RAZAO_SOCIAL = ?,FANTASIA = ?,CNPJ = ?,LOGRADOURO = ?,COMPLEMENTO = ?,BAIRRO = ?,CIDADE = ?,UF = ?,CEP = ?,TELEFONE = ?,EMAIL = ?,PESSOA_CONTATO = ?,CHAVE = ?,NAVAL = ?,NV_SEQ_TIPO_PARCEIRO_VISTORIAD = ?,SEQ_TIPO_VINCULO_VENDEDOR = ?,USUARIO = ?,SGBD = ?,SGBD_URL = ?,SGBD_USUARIO = ?,DATA_CADASTRO = ?,SENHA = ?,proximo_codigo_parceiro = ?, tipo_numeracao_cod_parceiro = ?  where SEQ_EMPRESA = ? ";
/*     */       
/*     */ 
/*     */ 
/*  85 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  87 */       ps.setString(1, empresa.getSgbdSenha());
/*  88 */       ps.setString(2, empresa.getEmailAcesso());
/*  89 */       ps.setString(3, empresa.getSituacao());
/*  90 */       ps.setString(4, empresa.getRazaoSocial());
/*  91 */       ps.setString(5, empresa.getFantasia());
/*  92 */       ps.setString(6, empresa.getCnpj());
/*  93 */       ps.setString(7, empresa.getLogradouro());
/*  94 */       ps.setString(8, empresa.getComplemento());
/*  95 */       ps.setString(9, empresa.getBairro());
/*  96 */       ps.setString(10, empresa.getCidade());
/*  97 */       ps.setString(11, empresa.getUf());
/*  98 */       ps.setString(12, empresa.getCep());
/*  99 */       ps.setString(13, empresa.getTelefone());
/* 100 */       ps.setString(14, empresa.getEmail());
/* 101 */       ps.setString(15, empresa.getPessoaContato());
/* 102 */       ps.setString(16, empresa.getChave());
/* 103 */       ps.setString(17, empresa.getNaval());
/* 104 */       ps.setObject(18, empresa.getNvSeqTipoParceiroVistoriad(), 1);
/* 105 */       ps.setObject(19, empresa.getSeqTipoVinculoVendedor(), 1);
/* 106 */       ps.setString(20, empresa.getUsuario());
/* 107 */       ps.setString(21, empresa.getSgbd());
/* 108 */       ps.setString(22, empresa.getSgbdUrl());
/* 109 */       ps.setString(23, empresa.getSgbdUsuario());
/* 110 */       ps.setDate(24, new java.sql.Date(empresa.getDataCadastro().getTime()));
/* 111 */       ps.setString(25, empresa.getSenha());
/* 112 */       ps.setString(26, empresa.getProximoCodigoParceiro());
/* 113 */       ps.setString(27, empresa.getTipoNumeracaoCodParceiro());
/* 114 */       ps.setString(28, empresa.getSeqEmpresa());
/* 115 */       ps.execute();
/* 116 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/* 119 */       Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 120 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/* 123 */     return empresa;
/*     */   }
/*     */   
/*     */   public List<Empresa> listar(ClausulaWhere sClausula) {
/*     */     try {
/* 128 */       Conexao conexao = new Conexao();
/* 129 */       Connection conn = Conexao.getConnection();
/* 130 */       String sql = "SELECT * FROM EMPRESA" + sClausula.montarsClausula();
/* 131 */       System.out.println(sql);
/*     */       
/* 133 */       List<Empresa> listaEmpresa = new ArrayList();
/* 134 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 135 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 137 */       while (rs.next()) {
/* 138 */         Empresa empresa = new Empresa();
/* 139 */         empresa.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 140 */         empresa.setSgbdSenha(rs.getString("SGBD_SENHA"));
/* 141 */         empresa.setEmailAcesso(rs.getString("EMAIL_ACESSO"));
/* 142 */         empresa.setSituacao(rs.getString("SITUACAO"));
/* 143 */         empresa.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
/* 144 */         empresa.setFantasia(rs.getString("FANTASIA"));
/* 145 */         empresa.setCnpj(rs.getString("CNPJ"));
/* 146 */         empresa.setLogradouro(rs.getString("LOGRADOURO"));
/* 147 */         empresa.setComplemento(rs.getString("COMPLEMENTO"));
/* 148 */         empresa.setBairro(rs.getString("BAIRRO"));
/* 149 */         empresa.setCidade(rs.getString("CIDADE"));
/* 150 */         empresa.setUf(rs.getString("UF"));
/* 151 */         empresa.setCep(rs.getString("CEP"));
/* 152 */         empresa.setTelefone(rs.getString("TELEFONE"));
/* 153 */         empresa.setEmail(rs.getString("EMAIL"));
/* 154 */         empresa.setPessoaContato(rs.getString("PESSOA_CONTATO"));
/* 155 */         empresa.setChave(rs.getString("CHAVE"));
/* 156 */         empresa.setNaval(rs.getString("NAVAL"));
/* 157 */         empresa.setNvSeqTipoParceiroVistoriad(rs.getString("NV_SEQ_TIPO_PARCEIRO_VISTORIAD"));
/* 158 */         empresa.setSeqTipoVinculoVendedor(rs.getString("SEQ_TIPO_VINCULO_VENDEDOR"));
/* 159 */         empresa.setUsuario(rs.getString("USUARIO"));
/* 160 */         empresa.setSgbd(rs.getString("SGBD"));
/* 161 */         empresa.setSgbdUrl(rs.getString("SGBD_URL"));
/* 162 */         empresa.setSgbdUsuario(rs.getString("SGBD_USUARIO"));
/* 163 */         empresa.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 164 */         empresa.setSenha(rs.getString("SENHA"));
/* 165 */         empresa.setProximoCodigoParceiro(rs.getString("proximo_codigo_parceiro"));
/* 166 */         empresa.setTipoNumeracaoCodParceiro(rs.getString("tipo_numeracao_cod_parceiro"));
/* 167 */         empresa.setIntegracao(rs.getString("integracao"));
/* 168 */         listaEmpresa.add(empresa);
/*     */       }
/*     */       
/* 171 */       ps.execute();
/* 172 */       ps.close();
/*     */       
/* 174 */       return listaEmpresa;
/*     */     } catch (SQLException ex) {
/* 176 */       Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 177 */       System.out.println(ex.getMessage()); }
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(Empresa empresa)
/*     */   {
/*     */     try {
/* 184 */       Conexao conexao = new Conexao();
/* 185 */       Connection conn = Conexao.getConnection();
/* 186 */       String sql = "DELETE FROM EMPRESA WHERE SEQ_EMPRESA =  ? ";
/*     */       
/* 188 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 190 */       ps.setString(1, empresa.getSeqEmpresa());
/*     */       
/* 192 */       ps.execute();
/* 193 */       ps.close();
/*     */       
/* 195 */       return true;
/*     */     } catch (SQLException ex) {
/* 197 */       System.out.println(ex.getMessage()); }
/* 198 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Empresa/EmpresaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */