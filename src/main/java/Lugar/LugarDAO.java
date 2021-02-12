/*     */ package Lugar;
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
/*     */ public class LugarDAO
/*     */ {
/*     */   public Lugar inserir(Lugar lugar)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_LUGAR");
/*  28 */       lugar.setSeqLugar(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into LUGAR (SEQ_LUGAR,NOME,SITUACAO,SEQ_EMPRESA,DATA_CADASTRO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, lugar.getSeqLugar());
/*  38 */       ps.setString(2, lugar.getNome());
/*  39 */       ps.setString(3, lugar.getSituacao());
/*  40 */       ps.setString(4, lugar.getSeqEmpresa());
/*     */       try {
/*  42 */         ps.setDate(5, new java.sql.Date(lugar.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  44 */         ps.setDate(5, null);
/*     */       }
/*     */       
/*  47 */       ps.execute();
/*  48 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  51 */       Logger.getLogger(LugarDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  52 */       System.out.println(ex.getMessage());
/*     */     }
/*  54 */     return lugar;
/*     */   }
/*     */   
/*     */   public Lugar alterar(Lugar lugar) {
/*     */     try {
/*  59 */       Conexao conexao = new Conexao();
/*  60 */       Connection conn = Conexao.getConnection();
/*  61 */       String sql = "update LUGAR set NOME = ?,SITUACAO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ? where SEQ_LUGAR = ?";
/*     */       
/*  63 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  65 */       ps.setString(1, lugar.getNome());
/*  66 */       ps.setString(2, lugar.getSituacao());
/*  67 */       ps.setString(3, lugar.getSeqEmpresa());
/*     */       try {
/*  69 */         ps.setDate(4, new java.sql.Date(lugar.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  71 */         ps.setDate(4, null);
/*     */       }
/*  73 */       ps.setString(5, lugar.getSeqLugar());
/*  74 */       ps.execute();
/*  75 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  78 */       Logger.getLogger(LugarDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  79 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  82 */     return lugar;
/*     */   }
/*     */   
/*     */   public List<Lugar> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  87 */       Conexao conexao = new Conexao();
/*  88 */       Connection conn = Conexao.getConnection();
/*  89 */       String sql = "SELECT * FROM LUGAR" + sClausula.montarsClausula();
/*     */       
/*     */ 
/*  92 */       List<Lugar> listaLugar = new ArrayList();
/*  93 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  94 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  96 */       while (rs.next()) {
/*  97 */         Lugar lugar = new Lugar();
/*  98 */         lugar.setSeqLugar(rs.getString("SEQ_LUGAR"));
/*  99 */         lugar.setNome(rs.getString("NOME"));
/* 100 */         lugar.setSituacao(rs.getString("SITUACAO"));
/* 101 */         lugar.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         lugar.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 103 */         listaLugar.add(lugar);
/*     */       }
/*     */       
/* 106 */       ps.execute();
/* 107 */       ps.close();
/*     */       
/* 109 */       return listaLugar;
/*     */     } catch (SQLException ex) {
/* 111 */       Logger.getLogger(LugarDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 112 */       System.out.println(ex.getMessage()); }
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(Lugar lugar)
/*     */   {
/*     */     try {
/* 119 */       Conexao conexao = new Conexao();
/* 120 */       Connection conn = Conexao.getConnection();
/* 121 */       String sql = "DELETE FROM LUGAR WHERE SEQ_LUGAR =  ? ";
/*     */       
/* 123 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 125 */       ps.setString(1, lugar.getSeqLugar());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Lugar/LugarDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */