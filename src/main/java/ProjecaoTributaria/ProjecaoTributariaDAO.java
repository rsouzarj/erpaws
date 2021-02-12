/*     */ package ProjecaoTributaria;
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
/*     */ public class ProjecaoTributariaDAO
/*     */ {
/*     */   public ProjecaoTributaria inserir(ProjecaoTributaria projecaoTributaria)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_PROJECAO_TRIBUTARIA");
/*  28 */       projecaoTributaria.setSeqProjecaoTributaria(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into PROJECAO_TRIBUTARIA (SEQ_PROJECAO_TRIBUTARIA,NOME,DATA_CADASTRO,SEQ_EMPRESA,SITUACAO,PERCENTUAL) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, projecaoTributaria.getSeqProjecaoTributaria());
/*  38 */       ps.setString(2, projecaoTributaria.getNome());
/*     */       try {
/*  40 */         ps.setDate(3, new java.sql.Date(projecaoTributaria.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  42 */         ps.setDate(3, null);
/*     */       }
/*  44 */       ps.setString(4, projecaoTributaria.getSeqEmpresa());
/*  45 */       ps.setString(5, projecaoTributaria.getSituacao());
/*  46 */       ps.setBigDecimal(6, projecaoTributaria.getPercentual());
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(ProjecaoTributariaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return projecaoTributaria;
/*     */   }
/*     */   
/*     */   public ProjecaoTributaria alterar(ProjecaoTributaria projecaoTributaria) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update PROJECAO_TRIBUTARIA set NOME = ?,DATA_CADASTRO = ?,SEQ_EMPRESA = ?,SITUACAO = ?,PERCENTUAL = ? where SEQ_PROJECAO_TRIBUTARIA = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, projecaoTributaria.getNome());
/*     */       try {
/*  68 */         ps.setDate(2, new java.sql.Date(projecaoTributaria.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  70 */         ps.setDate(2, null);
/*     */       }
/*  72 */       ps.setString(3, projecaoTributaria.getSeqEmpresa());
/*  73 */       ps.setString(4, projecaoTributaria.getSituacao());
/*  74 */       ps.setBigDecimal(5, projecaoTributaria.getPercentual());
/*  75 */       ps.setString(6, projecaoTributaria.getSeqProjecaoTributaria());
/*  76 */       ps.execute();
/*  77 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  80 */       Logger.getLogger(ProjecaoTributariaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  81 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  84 */     return projecaoTributaria;
/*     */   }
/*     */   
/*     */   public List<ProjecaoTributaria> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  89 */       Conexao conexao = new Conexao();
/*  90 */       Connection conn = Conexao.getConnection();
/*  91 */       String sql = "SELECT * FROM PROJECAO_TRIBUTARIA" + sClausula.montarsClausula() + " order by PROJECAO_TRIBUTARIA.percentual";
/*     */       
/*     */ 
/*  94 */       System.out.println(sql);
/*     */       
/*  96 */       List<ProjecaoTributaria> listaProjecaoTributaria = new ArrayList();
/*  97 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  98 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 100 */       while (rs.next()) {
/* 101 */         ProjecaoTributaria projecaoTributaria = new ProjecaoTributaria();
/* 102 */         projecaoTributaria.setSeqProjecaoTributaria(rs.getString("SEQ_PROJECAO_TRIBUTARIA"));
/* 103 */         projecaoTributaria.setNome(rs.getString("NOME"));
/* 104 */         projecaoTributaria.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 105 */         projecaoTributaria.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 106 */         projecaoTributaria.setSituacao(rs.getString("SITUACAO"));
/* 107 */         projecaoTributaria.setPercentual(rs.getBigDecimal("PERCENTUAL"));
/* 108 */         listaProjecaoTributaria.add(projecaoTributaria);
/*     */       }
/*     */       
/* 111 */       ps.execute();
/* 112 */       ps.close();
/*     */       
/* 114 */       return listaProjecaoTributaria;
/*     */     } catch (SQLException ex) {
/* 116 */       Logger.getLogger(ProjecaoTributariaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 117 */       System.out.println(ex.getMessage()); }
/* 118 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(ProjecaoTributaria projecaoTributaria)
/*     */   {
/*     */     try {
/* 124 */       Conexao conexao = new Conexao();
/* 125 */       Connection conn = Conexao.getConnection();
/* 126 */       String sql = "DELETE FROM PROJECAO_TRIBUTARIA WHERE SEQ_PROJECAO_TRIBUTARIA =  ? ";
/*     */       
/* 128 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 130 */       ps.setString(1, projecaoTributaria.getSeqProjecaoTributaria());
/*     */       
/* 132 */       ps.execute();
/* 133 */       ps.close();
/*     */       
/* 135 */       return true;
/*     */     } catch (SQLException ex) {
/* 137 */       System.out.println(ex.getMessage()); }
/* 138 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ProjecaoTributaria/ProjecaoTributariaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */