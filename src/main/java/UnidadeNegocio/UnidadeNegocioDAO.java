/*     */ package UnidadeNegocio;
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
/*     */ public class UnidadeNegocioDAO
/*     */ {
/*     */   public UnidadeNegocio inserir(UnidadeNegocio unidadeNegocio)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_UNIDADE_NEGOCIO");
/*  28 */       unidadeNegocio.setSeqUnidadeNegocio(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into UNIDADE_NEGOCIO (SEQ_UNIDADE_NEGOCIO,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,NOME,IM,CEP,BAIRRO,CIDADE,UF,COMPLEMENTO,NUMERO,LOGRADOURO,CNPJ,IDENTIFICACAO) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, unidadeNegocio.getSeqUnidadeNegocio());
/*  38 */       ps.setString(2, unidadeNegocio.getSeqEmpresa());
/*  39 */       ps.setDate(3, new java.sql.Date(unidadeNegocio.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, unidadeNegocio.getSituacao());
/*  41 */       ps.setString(5, unidadeNegocio.getNome());
/*     */       
/*  43 */       ps.setString(6, unidadeNegocio.getIm());
/*  44 */       ps.setString(7, unidadeNegocio.getCep());
/*  45 */       ps.setString(8, unidadeNegocio.getBairro());
/*  46 */       ps.setString(9, unidadeNegocio.getCidade());
/*  47 */       ps.setString(10, unidadeNegocio.getUf());
/*  48 */       ps.setString(11, unidadeNegocio.getComplemento());
/*  49 */       ps.setString(12, unidadeNegocio.getNumero());
/*  50 */       ps.setString(13, unidadeNegocio.getLogradouro());
/*  51 */       ps.setString(14, unidadeNegocio.getCnpj());
/*  52 */       ps.setString(15, unidadeNegocio.getIdentificacao());
/*     */       
/*  54 */       ps.execute();
/*  55 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  58 */       Logger.getLogger(UnidadeNegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  59 */       System.out.println(ex.getMessage());
/*     */     }
/*  61 */     return unidadeNegocio;
/*     */   }
/*     */   
/*     */   public UnidadeNegocio alterar(UnidadeNegocio unidadeNegocio) {
/*     */     try {
/*  66 */       Conexao conexao = new Conexao();
/*  67 */       Connection conn = Conexao.getConnection();
/*  68 */       String sql = "update UNIDADE_NEGOCIO set SEQ_EMPRESA = ?,DATA_CADASTRO = ?,SITUACAO = ?,NOME = ?, IM = ?,CEP = ?,BAIRRO = ?,CIDADE = ?,UF = ?, COMPLEMENTO = ?, NUMERO = ?, LOGRADOURO = ?, CNPJ = ?, IDENTIFICACAO = ? where SEQ_UNIDADE_NEGOCIO = ?";
/*     */       
/*  70 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  72 */       ps.setString(1, unidadeNegocio.getSeqEmpresa());
/*  73 */       ps.setDate(2, new java.sql.Date(unidadeNegocio.getDataCadastro().getTime()));
/*  74 */       ps.setString(3, unidadeNegocio.getSituacao());
/*  75 */       ps.setString(4, unidadeNegocio.getNome());
/*     */       
/*  77 */       ps.setString(5, unidadeNegocio.getIm());
/*  78 */       ps.setString(6, unidadeNegocio.getCep());
/*  79 */       ps.setString(7, unidadeNegocio.getBairro());
/*  80 */       ps.setString(8, unidadeNegocio.getCidade());
/*  81 */       ps.setString(9, unidadeNegocio.getUf());
/*  82 */       ps.setString(10, unidadeNegocio.getComplemento());
/*  83 */       ps.setString(11, unidadeNegocio.getNumero());
/*  84 */       ps.setString(12, unidadeNegocio.getLogradouro());
/*  85 */       ps.setString(13, unidadeNegocio.getCnpj());
/*  86 */       ps.setString(14, unidadeNegocio.getIdentificacao());
/*  87 */       ps.setString(15, unidadeNegocio.getSeqUnidadeNegocio());
/*  88 */       ps.execute();
/*  89 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  92 */       Logger.getLogger(UnidadeNegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  93 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  96 */     return unidadeNegocio;
/*     */   }
/*     */   
/*     */   public List<UnidadeNegocio> listar(ClausulaWhere sClausula) {
/*     */     try {
/* 101 */       Conexao conexao = new Conexao();
/* 102 */       Connection conn = Conexao.getConnection();
/* 103 */       String sql = "SELECT * FROM UNIDADE_NEGOCIO" + sClausula.montarsClausula() + " order by nome";
/*     */       
/*     */ 
/* 106 */       List<UnidadeNegocio> listaUnidadeNegocio = new ArrayList();
/* 107 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 108 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 110 */       while (rs.next()) {
/* 111 */         UnidadeNegocio unidadeNegocio = new UnidadeNegocio();
/* 112 */         unidadeNegocio.setSeqUnidadeNegocio(rs.getString("SEQ_UNIDADE_NEGOCIO"));
/* 113 */         unidadeNegocio.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 114 */         unidadeNegocio.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 115 */         unidadeNegocio.setSituacao(rs.getString("SITUACAO"));
/* 116 */         unidadeNegocio.setNome(rs.getString("NOME"));
/* 117 */         unidadeNegocio.setIdentificacao(rs.getString("IDENTIFICACAO"));
/*     */         
/* 119 */         unidadeNegocio.setIm(rs.getString("IM"));
/* 120 */         unidadeNegocio.setCep(rs.getString("CEP"));
/* 121 */         unidadeNegocio.setBairro(rs.getString("BAIRRO"));
/* 122 */         unidadeNegocio.setCidade(rs.getString("CIDADE"));
/* 123 */         unidadeNegocio.setUf(rs.getString("UF"));
/* 124 */         unidadeNegocio.setComplemento(rs.getString("COMPLEMENTO"));
/* 125 */         unidadeNegocio.setNumero(rs.getString("NUMERO"));
/* 126 */         unidadeNegocio.setLogradouro(rs.getString("LOGRADOURO"));
/* 127 */         unidadeNegocio.setCnpj(rs.getString("CNPJ"));
/*     */         
/* 129 */         listaUnidadeNegocio.add(unidadeNegocio);
/*     */       }
/*     */       
/* 132 */       ps.execute();
/* 133 */       ps.close();
/*     */       
/* 135 */       return listaUnidadeNegocio;
/*     */     } catch (SQLException ex) {
/* 137 */       Logger.getLogger(UnidadeNegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 138 */       System.out.println(ex.getMessage()); }
/* 139 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(UnidadeNegocio unidadeNegocio)
/*     */   {
/*     */     try {
/* 145 */       Conexao conexao = new Conexao();
/* 146 */       Connection conn = Conexao.getConnection();
/* 147 */       String sql = "DELETE FROM UNIDADE_NEGOCIO WHERE SEQ_UNIDADE_NEGOCIO =  ? ";
/*     */       
/* 149 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 151 */       ps.setString(1, unidadeNegocio.getSeqUnidadeNegocio());
/*     */       
/* 153 */       ps.execute();
/* 154 */       ps.close();
/*     */       
/* 156 */       return true;
/*     */     } catch (SQLException ex) {
/* 158 */       System.out.println(ex.getMessage()); }
/* 159 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/UnidadeNegocio/UnidadeNegocioDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */