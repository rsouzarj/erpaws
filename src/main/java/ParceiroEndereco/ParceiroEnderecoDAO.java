/*     */ package ParceiroEndereco;
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
/*     */ public class ParceiroEnderecoDAO
/*     */ {
/*     */   public ParceiroEndereco inserir(ParceiroEndereco parceiroEndereco)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_PARCEIRO_ENDERECO");
/*  28 */       parceiroEndereco.setSeqParceiroEndereco(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into PARCEIRO_ENDERECO (SEQ_PARCEIRO_ENDERECO,SITUACAO,DATA_CADASTRO,SEQ_TIPO_ENDERECO,LOGRADOURO,NUMERO,COMPLEMENTO,BAIRRO,CIDADE,UF,CEP,PESSOA_CONTATO,TELEFONE_1,EMAIL,INFO,SEQ_PARCEIRO) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, parceiroEndereco.getSeqParceiroEndereco());
/*  38 */       ps.setString(2, parceiroEndereco.getSituacao());
/*     */       try {
/*  40 */         ps.setDate(3, new java.sql.Date(parceiroEndereco.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  42 */         ps.setDate(3, null);
/*     */       }
/*  44 */       ps.setString(4, parceiroEndereco.getSeqTipoEndereco());
/*  45 */       ps.setString(5, parceiroEndereco.getLogradouro());
/*  46 */       ps.setString(6, parceiroEndereco.getNumero());
/*  47 */       ps.setString(7, parceiroEndereco.getComplemento());
/*  48 */       ps.setString(8, parceiroEndereco.getBairro());
/*  49 */       ps.setString(9, parceiroEndereco.getCidade());
/*  50 */       ps.setString(10, parceiroEndereco.getUf());
/*  51 */       ps.setString(11, parceiroEndereco.getCep());
/*  52 */       ps.setString(12, parceiroEndereco.getPessoaContato());
/*  53 */       ps.setString(13, parceiroEndereco.getTelefone1());
/*  54 */       ps.setString(14, parceiroEndereco.getEmail());
/*  55 */       ps.setString(15, parceiroEndereco.getInfo());
/*  56 */       ps.setString(16, parceiroEndereco.getSeqParceiro());
/*     */       
/*  58 */       ps.execute();
/*  59 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  62 */       Logger.getLogger(ParceiroEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  63 */       System.out.println(ex.getMessage());
/*     */     }
/*  65 */     return parceiroEndereco;
/*     */   }
/*     */   
/*     */   public ParceiroEndereco alterar(ParceiroEndereco parceiroEndereco) {
/*     */     try {
/*  70 */       Conexao conexao = new Conexao();
/*  71 */       Connection conn = Conexao.getConnection();
/*  72 */       String sql = "update PARCEIRO_ENDERECO set SITUACAO = ?,DATA_CADASTRO = ?,SEQ_TIPO_ENDERECO = ?,LOGRADOURO = ?,NUMERO = ?,COMPLEMENTO = ?,BAIRRO = ?,CIDADE = ?,UF = ?,CEP = ?,PESSOA_CONTATO = ?,TELEFONE_1 = ?,EMAIL = ?,INFO = ?,SEQ_PARCEIRO = ? where SEQ_PARCEIRO_ENDERECO = ?";
/*     */       
/*  74 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  76 */       ps.setString(1, parceiroEndereco.getSituacao());
/*     */       try {
/*  78 */         ps.setDate(2, new java.sql.Date(parceiroEndereco.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  80 */         ps.setDate(2, null);
/*     */       }
/*  82 */       ps.setString(3, parceiroEndereco.getSeqTipoEndereco());
/*  83 */       ps.setString(4, parceiroEndereco.getLogradouro());
/*  84 */       ps.setString(5, parceiroEndereco.getNumero());
/*  85 */       ps.setString(6, parceiroEndereco.getComplemento());
/*  86 */       ps.setString(7, parceiroEndereco.getBairro());
/*  87 */       ps.setString(8, parceiroEndereco.getCidade());
/*  88 */       ps.setString(9, parceiroEndereco.getUf());
/*  89 */       ps.setString(10, parceiroEndereco.getCep());
/*  90 */       ps.setString(11, parceiroEndereco.getPessoaContato());
/*  91 */       ps.setString(12, parceiroEndereco.getTelefone1());
/*  92 */       ps.setString(13, parceiroEndereco.getEmail());
/*  93 */       ps.setString(14, parceiroEndereco.getInfo());
/*  94 */       ps.setString(15, parceiroEndereco.getSeqParceiro());
/*  95 */       ps.setString(16, parceiroEndereco.getSeqParceiroEndereco());
/*  96 */       ps.execute();
/*  97 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/* 100 */       Logger.getLogger(ParceiroEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 101 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/* 104 */     return parceiroEndereco;
/*     */   }
/*     */   
/*     */   public List<ParceiroEndereco> listar(ClausulaWhere sClausula) {
/*     */     try {
/* 109 */       Conexao conexao = new Conexao();
/* 110 */       Connection conn = Conexao.getConnection();
/* 111 */       String sql = "SELECT PARCEIRO_ENDERECO.*, tipo_endereco.nome tipo_endereco FROM PARCEIRO_ENDERECO inner join tipo_endereco on tipo_endereco.seq_tipo_endereco = parceiro_endereco.seq_tipo_endereco  " + sClausula.montarsClausula();
/*     */       
/* 113 */       List<ParceiroEndereco> listaParceiroEndereco = new ArrayList();
/* 114 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 115 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 117 */       while (rs.next()) {
/* 118 */         ParceiroEndereco parceiroEndereco = new ParceiroEndereco();
/* 119 */         parceiroEndereco.setSeqParceiroEndereco(rs.getString("SEQ_PARCEIRO_ENDERECO"));
/* 120 */         parceiroEndereco.setSituacao(rs.getString("SITUACAO"));
/* 121 */         parceiroEndereco.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 122 */         parceiroEndereco.setSeqTipoEndereco(rs.getString("SEQ_TIPO_ENDERECO"));
/* 123 */         parceiroEndereco.setLogradouro(rs.getString("LOGRADOURO"));
/* 124 */         parceiroEndereco.setNumero(rs.getString("NUMERO"));
/* 125 */         parceiroEndereco.setComplemento(rs.getString("COMPLEMENTO"));
/* 126 */         parceiroEndereco.setBairro(rs.getString("BAIRRO"));
/* 127 */         parceiroEndereco.setCidade(rs.getString("CIDADE"));
/* 128 */         parceiroEndereco.setUf(rs.getString("UF"));
/* 129 */         parceiroEndereco.setCep(rs.getString("CEP"));
/* 130 */         parceiroEndereco.setPessoaContato(rs.getString("PESSOA_CONTATO"));
/* 131 */         parceiroEndereco.setTelefone1(rs.getString("TELEFONE_1"));
/* 132 */         parceiroEndereco.setEmail(rs.getString("EMAIL"));
/* 133 */         parceiroEndereco.setInfo(rs.getString("INFO"));
/* 134 */         parceiroEndereco.setSeqParceiro(rs.getString("SEQ_PARCEIRO"));
/* 135 */         parceiroEndereco.setTipoEndereco(rs.getString("tipo_endereco"));
/* 136 */         listaParceiroEndereco.add(parceiroEndereco);
/*     */       }
/*     */       
/* 139 */       ps.execute();
/* 140 */       ps.close();
/*     */       
/* 142 */       return listaParceiroEndereco;
/*     */     } catch (SQLException ex) {
/* 144 */       Logger.getLogger(ParceiroEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 145 */       System.out.println(ex.getMessage()); }
/* 146 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(ParceiroEndereco parceiroEndereco)
/*     */   {
/*     */     try {
/* 152 */       Conexao conexao = new Conexao();
/* 153 */       Connection conn = Conexao.getConnection();
/* 154 */       String sql = "DELETE FROM PARCEIRO_ENDERECO WHERE SEQ_PARCEIRO_ENDERECO =  ? ";
/*     */       
/* 156 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 158 */       ps.setString(1, parceiroEndereco.getSeqParceiroEndereco());
/*     */       
/* 160 */       ps.execute();
/* 161 */       ps.close();
/*     */       
/* 163 */       return true;
/*     */     } catch (SQLException ex) {
/* 165 */       System.out.println(ex.getMessage()); }
/* 166 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ParceiroEndereco/ParceiroEnderecoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */