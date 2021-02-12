/*     */ package NvVistoriaStatus;
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
/*     */ public class NvVistoriaStatusDAO
/*     */ {
/*     */   public NvVistoriaStatus inserir(NvVistoriaStatus nvVistoriaStatus)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_NV_VISTORIA_STATUS");
/*  28 */       nvVistoriaStatus.setSeqNvVistoriaStatus(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into NV_VISTORIA_STATUS (SEQ_NV_VISTORIA_STATUS,SEQ_EMPRESA,SITUACAO,NOME,DATA_CADASTRO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, nvVistoriaStatus.getSeqNvVistoriaStatus());
/*  38 */       ps.setString(2, nvVistoriaStatus.getSeqEmpresa());
/*  39 */       ps.setString(3, nvVistoriaStatus.getSituacao());
/*  40 */       ps.setString(4, nvVistoriaStatus.getNome());
/*     */       try {
/*  42 */         ps.setDate(5, new java.sql.Date(nvVistoriaStatus.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  44 */         ps.setDate(5, null);
/*     */       }
/*     */       
/*  47 */       ps.execute();
/*  48 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  51 */       Logger.getLogger(NvVistoriaStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  52 */       System.out.println(ex.getMessage());
/*     */     }
/*  54 */     return nvVistoriaStatus;
/*     */   }
/*     */   
/*     */   public NvVistoriaStatus alterar(NvVistoriaStatus nvVistoriaStatus) {
/*     */     try {
/*  59 */       Conexao conexao = new Conexao();
/*  60 */       Connection conn = Conexao.getConnection();
/*  61 */       String sql = "update NV_VISTORIA_STATUS set SEQ_EMPRESA = ?,SITUACAO = ?,NOME = ?,DATA_CADASTRO = ? where SEQ_NV_VISTORIA_STATUS = ?";
/*     */       
/*  63 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  65 */       ps.setString(1, nvVistoriaStatus.getSeqEmpresa());
/*  66 */       ps.setString(2, nvVistoriaStatus.getSituacao());
/*  67 */       ps.setString(3, nvVistoriaStatus.getNome());
/*     */       try {
/*  69 */         ps.setDate(4, new java.sql.Date(nvVistoriaStatus.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  71 */         ps.setDate(4, null);
/*     */       }
/*  73 */       ps.setString(5, nvVistoriaStatus.getSeqNvVistoriaStatus());
/*  74 */       ps.execute();
/*  75 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  78 */       Logger.getLogger(NvVistoriaStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  79 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  82 */     return nvVistoriaStatus;
/*     */   }
/*     */   
/*     */   public List<NvVistoriaStatus> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  87 */       Conexao conexao = new Conexao();
/*  88 */       Connection conn = Conexao.getConnection();
/*  89 */       String sql = "SELECT * FROM NV_VISTORIA_STATUS" + sClausula.montarsClausula();
/*  90 */       System.out.println(sql);
/*     */       
/*  92 */       List<NvVistoriaStatus> listaNvVistoriaStatus = new ArrayList();
/*  93 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  94 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  96 */       while (rs.next()) {
/*  97 */         NvVistoriaStatus nvVistoriaStatus = new NvVistoriaStatus();
/*  98 */         nvVistoriaStatus.setSeqNvVistoriaStatus(rs.getString("SEQ_NV_VISTORIA_STATUS"));
/*  99 */         nvVistoriaStatus.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 100 */         nvVistoriaStatus.setSituacao(rs.getString("SITUACAO"));
/* 101 */         nvVistoriaStatus.setNome(rs.getString("NOME"));
/* 102 */         nvVistoriaStatus.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 103 */         listaNvVistoriaStatus.add(nvVistoriaStatus);
/*     */       }
/*     */       
/* 106 */       ps.execute();
/* 107 */       ps.close();
/*     */       
/* 109 */       return listaNvVistoriaStatus;
/*     */     } catch (SQLException ex) {
/* 111 */       Logger.getLogger(NvVistoriaStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 112 */       System.out.println(ex.getMessage()); }
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(NvVistoriaStatus nvVistoriaStatus)
/*     */   {
/*     */     try {
/* 119 */       Conexao conexao = new Conexao();
/* 120 */       Connection conn = Conexao.getConnection();
/* 121 */       String sql = "DELETE FROM NV_VISTORIA_STATUS WHERE SEQ_NV_VISTORIA_STATUS =  ? ";
/*     */       
/* 123 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 125 */       ps.setString(1, nvVistoriaStatus.getSeqNvVistoriaStatus());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvVistoriaStatus/NvVistoriaStatusDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */