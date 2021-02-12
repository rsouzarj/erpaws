/*     */ package TipoEndereco;
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
/*     */ public class TipoEnderecoDAO
/*     */ {
/*     */   public TipoEndereco inserir(TipoEndereco tipoEndereco)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_TIPO_ENDERECO");
/*  28 */       tipoEndereco.setSeqTipoEndereco(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into TIPO_ENDERECO (SEQ_TIPO_ENDERECO,NOME,DATA_CADASTRO,SEQ_EMPRESA,SITUACAO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, tipoEndereco.getSeqTipoEndereco());
/*  38 */       ps.setString(2, tipoEndereco.getNome());
/*     */       try {
/*  40 */         ps.setDate(3, new java.sql.Date(tipoEndereco.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  42 */         ps.setDate(3, null);
/*     */       }
/*  44 */       ps.setString(4, tipoEndereco.getSeqEmpresa());
/*  45 */       ps.setString(5, tipoEndereco.getSituacao());
/*     */       
/*  47 */       ps.execute();
/*  48 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  51 */       Logger.getLogger(TipoEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  52 */       System.out.println(ex.getMessage());
/*     */     }
/*  54 */     return tipoEndereco;
/*     */   }
/*     */   
/*     */   public TipoEndereco alterar(TipoEndereco tipoEndereco) {
/*     */     try {
/*  59 */       Conexao conexao = new Conexao();
/*  60 */       Connection conn = Conexao.getConnection();
/*  61 */       String sql = "update TIPO_ENDERECO set NOME = ?,DATA_CADASTRO = ?,SEQ_EMPRESA = ?,SITUACAO = ? where SEQ_TIPO_ENDERECO = ?";
/*     */       
/*  63 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  65 */       ps.setString(1, tipoEndereco.getNome());
/*     */       try {
/*  67 */         ps.setDate(2, new java.sql.Date(tipoEndereco.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  69 */         ps.setDate(2, null);
/*     */       }
/*  71 */       ps.setString(3, tipoEndereco.getSeqEmpresa());
/*  72 */       ps.setString(4, tipoEndereco.getSituacao());
/*  73 */       ps.setString(5, tipoEndereco.getSeqTipoEndereco());
/*  74 */       ps.execute();
/*  75 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  78 */       Logger.getLogger(TipoEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  79 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  82 */     return tipoEndereco;
/*     */   }
/*     */   
/*     */   public List<TipoEndereco> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  87 */       Conexao conexao = new Conexao();
/*  88 */       Connection conn = Conexao.getConnection();
/*  89 */       String sql = "SELECT * FROM TIPO_ENDERECO" + sClausula.montarsClausula();
/*  90 */       System.out.println(sql);
/*     */       
/*  92 */       List<TipoEndereco> listaTipoEndereco = new ArrayList();
/*  93 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  94 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  96 */       while (rs.next()) {
/*  97 */         TipoEndereco tipoEndereco = new TipoEndereco();
/*  98 */         tipoEndereco.setSeqTipoEndereco(rs.getString("SEQ_TIPO_ENDERECO"));
/*  99 */         tipoEndereco.setNome(rs.getString("NOME"));
/* 100 */         tipoEndereco.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 101 */         tipoEndereco.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         tipoEndereco.setSituacao(rs.getString("SITUACAO"));
/* 103 */         listaTipoEndereco.add(tipoEndereco);
/*     */       }
/*     */       
/* 106 */       ps.execute();
/* 107 */       ps.close();
/*     */       
/* 109 */       return listaTipoEndereco;
/*     */     } catch (SQLException ex) {
/* 111 */       Logger.getLogger(TipoEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 112 */       System.out.println(ex.getMessage()); }
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(TipoEndereco tipoEndereco)
/*     */   {
/*     */     try {
/* 119 */       Conexao conexao = new Conexao();
/* 120 */       Connection conn = Conexao.getConnection();
/* 121 */       String sql = "DELETE FROM TIPO_ENDERECO WHERE SEQ_TIPO_ENDERECO =  ? ";
/*     */       
/* 123 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 125 */       ps.setString(1, tipoEndereco.getSeqTipoEndereco());
/*     */       
/* 127 */       ps.execute();
/* 128 */       ps.close();
/*     */       
/* 130 */       return true;
/*     */     } catch (SQLException ex) {
/* 132 */       System.out.println(ex.getMessage()); }
/* 133 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoEndereco/TipoEnderecoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */