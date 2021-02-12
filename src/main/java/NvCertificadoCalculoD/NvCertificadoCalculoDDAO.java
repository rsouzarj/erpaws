/*     */ package NvCertificadoCalculoD;
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
/*     */ public class NvCertificadoCalculoDDAO
/*     */ {
/*     */   public NvCertificadoCalculoD inserir(NvCertificadoCalculoD nvCertificadoCalculoD)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_NV_CERTIFICADO_CALCULO_D");
/*  28 */       nvCertificadoCalculoD.setSeqNvCertificadoCalculoD(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into NV_CERTIFICADO_CALCULO_D (SEQ_NV_CERTIFICADO_CALCULO_D,ORDEM,MESES_INICIAR,MESES_FINALIZAR,SEQ_NV_CERTIFICADO_CALCULO,AREALIZAR) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, nvCertificadoCalculoD.getSeqNvCertificadoCalculoD());
/*  38 */       ps.setString(2, nvCertificadoCalculoD.getOrdem());
/*  39 */       ps.setString(3, nvCertificadoCalculoD.getMesesIniciar());
/*  40 */       ps.setString(4, nvCertificadoCalculoD.getMesesFinalizar());
/*  41 */       ps.setString(5, nvCertificadoCalculoD.getSeqNvCertificadoCalculo());
/*  42 */       ps.setString(6, nvCertificadoCalculoD.getArealizar());
/*     */       
/*  44 */       ps.execute();
/*  45 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  48 */       Logger.getLogger(NvCertificadoCalculoDDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  49 */       System.out.println(ex.getMessage());
/*     */     }
/*  51 */     return nvCertificadoCalculoD;
/*     */   }
/*     */   
/*     */   public NvCertificadoCalculoD alterar(NvCertificadoCalculoD nvCertificadoCalculoD) {
/*     */     try {
/*  56 */       Conexao conexao = new Conexao();
/*  57 */       Connection conn = Conexao.getConnection();
/*  58 */       String sql = "update NV_CERTIFICADO_CALCULO_D set ORDEM = ?,MESES_INICIAR = ?,MESES_FINALIZAR = ?,SEQ_NV_CERTIFICADO_CALCULO = ?,AREALIZAR = ? where SEQ_NV_CERTIFICADO_CALCULO_D = ?";
/*     */       
/*  60 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  62 */       ps.setString(1, nvCertificadoCalculoD.getOrdem());
/*  63 */       ps.setString(2, nvCertificadoCalculoD.getMesesIniciar());
/*  64 */       ps.setString(3, nvCertificadoCalculoD.getMesesFinalizar());
/*  65 */       ps.setString(4, nvCertificadoCalculoD.getSeqNvCertificadoCalculo());
/*  66 */       ps.setString(5, nvCertificadoCalculoD.getArealizar());
/*  67 */       ps.setString(6, nvCertificadoCalculoD.getSeqNvCertificadoCalculoD());
/*  68 */       ps.execute();
/*  69 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  72 */       Logger.getLogger(NvCertificadoCalculoDDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  73 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  76 */     return nvCertificadoCalculoD;
/*     */   }
/*     */   
/*     */   public List<NvCertificadoCalculoD> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  81 */       Conexao conexao = new Conexao();
/*  82 */       Connection conn = Conexao.getConnection();
/*  83 */       String sql = "SELECT * FROM NV_CERTIFICADO_CALCULO_D" + sClausula.montarsClausula() + " order by ordem";
/*  84 */       System.out.println(sql);
/*     */       
/*  86 */       List<NvCertificadoCalculoD> listaNvCertificadoCalculoD = new ArrayList();
/*  87 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  88 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  90 */       while (rs.next()) {
/*  91 */         NvCertificadoCalculoD nvCertificadoCalculoD = new NvCertificadoCalculoD();
/*  92 */         nvCertificadoCalculoD.setSeqNvCertificadoCalculoD(rs.getString("SEQ_NV_CERTIFICADO_CALCULO_D"));
/*  93 */         nvCertificadoCalculoD.setOrdem(rs.getString("ORDEM"));
/*  94 */         nvCertificadoCalculoD.setMesesIniciar(rs.getString("MESES_INICIAR"));
/*  95 */         nvCertificadoCalculoD.setMesesFinalizar(rs.getString("MESES_FINALIZAR"));
/*  96 */         nvCertificadoCalculoD.setSeqNvCertificadoCalculo(rs.getString("SEQ_NV_CERTIFICADO_CALCULO"));
/*  97 */         nvCertificadoCalculoD.setArealizar(rs.getString("AREALIZAR"));
/*  98 */         listaNvCertificadoCalculoD.add(nvCertificadoCalculoD);
/*     */       }
/*     */       
/* 101 */       ps.execute();
/* 102 */       ps.close();
/*     */       
/* 104 */       return listaNvCertificadoCalculoD;
/*     */     } catch (SQLException ex) {
/* 106 */       Logger.getLogger(NvCertificadoCalculoDDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 107 */       System.out.println(ex.getMessage()); }
/* 108 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(NvCertificadoCalculoD nvCertificadoCalculoD)
/*     */   {
/*     */     try {
/* 114 */       Conexao conexao = new Conexao();
/* 115 */       Connection conn = Conexao.getConnection();
/* 116 */       String sql = "DELETE FROM NV_CERTIFICADO_CALCULO_D WHERE SEQ_NV_CERTIFICADO_CALCULO_D =  ? ";
/*     */       
/* 118 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 120 */       ps.setString(1, nvCertificadoCalculoD.getSeqNvCertificadoCalculoD());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvCertificadoCalculoD/NvCertificadoCalculoDDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */