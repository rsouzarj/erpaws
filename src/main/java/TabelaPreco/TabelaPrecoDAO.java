/*     */ package TabelaPreco;
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
/*     */ public class TabelaPrecoDAO
/*     */ {
/*     */   public TabelaPreco inserir(TabelaPreco tabelaPreco)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_TABELA_PRECO");
/*  28 */       tabelaPreco.setSeqTabelaPreco(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into TABELA_PRECO (SEQ_TABELA_PRECO,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,NOME,principal ) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, tabelaPreco.getSeqTabelaPreco());
/*  38 */       ps.setString(2, tabelaPreco.getSeqEmpresa());
/*  39 */       ps.setDate(3, new java.sql.Date(tabelaPreco.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, tabelaPreco.getSituacao());
/*  41 */       ps.setString(5, tabelaPreco.getNome());
/*  42 */       ps.setString(6, tabelaPreco.getPrincipal());
/*     */       
/*  44 */       ps.execute();
/*  45 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  48 */       Logger.getLogger(TabelaPrecoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  49 */       System.out.println(ex.getMessage());
/*     */     }
/*  51 */     return tabelaPreco;
/*     */   }
/*     */   
/*     */   public TabelaPreco alterar(TabelaPreco tabelaPreco) {
/*     */     try {
/*  56 */       Conexao conexao = new Conexao();
/*  57 */       Connection conn = Conexao.getConnection();
/*  58 */       String sql = "update TABELA_PRECO set SEQ_EMPRESA = ?,DATA_CADASTRO = ?,SITUACAO = ?,NOME = ?, principal = ? where SEQ_TABELA_PRECO = ?";
/*     */       
/*  60 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  62 */       ps.setString(1, tabelaPreco.getSeqEmpresa());
/*  63 */       ps.setDate(2, new java.sql.Date(tabelaPreco.getDataCadastro().getTime()));
/*  64 */       ps.setString(3, tabelaPreco.getSituacao());
/*  65 */       ps.setString(4, tabelaPreco.getNome());
/*  66 */       ps.setString(5, tabelaPreco.getPrincipal());
/*  67 */       ps.setString(6, tabelaPreco.getSeqTabelaPreco());
/*  68 */       ps.execute();
/*  69 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  72 */       Logger.getLogger(TabelaPrecoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  73 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  76 */     return tabelaPreco;
/*     */   }
/*     */   
/*     */   public List<TabelaPreco> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  81 */       Conexao conexao = new Conexao();
/*  82 */       Connection conn = Conexao.getConnection();
/*  83 */       String sql = "SELECT * FROM TABELA_PRECO" + sClausula.montarsClausula();
/*  84 */       System.out.println(sql);
/*     */       
/*  86 */       List<TabelaPreco> listaTabelaPreco = new ArrayList();
/*  87 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  88 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  90 */       while (rs.next()) {
/*  91 */         TabelaPreco tabelaPreco = new TabelaPreco();
/*  92 */         tabelaPreco.setSeqTabelaPreco(rs.getString("SEQ_TABELA_PRECO"));
/*  93 */         tabelaPreco.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/*  94 */         tabelaPreco.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  95 */         tabelaPreco.setSituacao(rs.getString("SITUACAO"));
/*  96 */         tabelaPreco.setNome(rs.getString("NOME"));
/*  97 */         tabelaPreco.setPrincipal(rs.getString("principal"));
/*  98 */         listaTabelaPreco.add(tabelaPreco);
/*     */       }
/*     */       
/* 101 */       ps.execute();
/* 102 */       ps.close();
/*     */       
/* 104 */       return listaTabelaPreco;
/*     */     } catch (SQLException ex) {
/* 106 */       Logger.getLogger(TabelaPrecoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 107 */       System.out.println(ex.getMessage()); }
/* 108 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(TabelaPreco tabelaPreco)
/*     */   {
/*     */     try {
/* 114 */       Conexao conexao = new Conexao();
/* 115 */       Connection conn = Conexao.getConnection();
/* 116 */       String sql = "DELETE FROM TABELA_PRECO WHERE SEQ_TABELA_PRECO =  ? ";
/*     */       
/* 118 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 120 */       ps.setString(1, tabelaPreco.getSeqTabelaPreco());
/*     */       
/* 122 */       ps.execute();
/* 123 */       ps.close();
/*     */       
/* 125 */       return true;
/*     */     } catch (SQLException ex) {
/* 127 */       System.out.println(ex.getMessage()); }
/* 128 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TabelaPreco/TabelaPrecoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */