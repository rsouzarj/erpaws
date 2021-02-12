/*     */ package NvCertificadoCalculo;
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
/*     */ public class NvCertificadoCalculoDAO
/*     */ {
/*     */   public NvCertificadoCalculo inserir(NvCertificadoCalculo nvCertificadoCalculo)
/*     */   {
/*     */     try
/*     */     {
/*  28 */       String seq = Sequence.buscarNumeroSequence("SEQ_NV_CERTIFICADO_CALCULO");
/*  29 */       nvCertificadoCalculo.setSeqNvCertificadoCalculo(seq);
/*  30 */       Conexao conexao = new Conexao();
/*  31 */       Connection conn = Conexao.getConnection();
/*  32 */       String sql = "insert into NV_CERTIFICADO_CALCULO (SEQ_NV_CERTIFICADO_CALCULO,MESES_PARA_DATA_VALIDADE,DATA_CADASTRO,SITUACAO,NOME,SEQ_EMPRESA, seq_nv_tipo_certificado) values  (?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  36 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  38 */       ps.setString(1, nvCertificadoCalculo.getSeqNvCertificadoCalculo());
/*  39 */       ps.setString(2, nvCertificadoCalculo.getMesesParaDataValidade());
/*     */       try {
/*  41 */         ps.setDate(3, new java.sql.Date(nvCertificadoCalculo.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  43 */         ps.setDate(3, null);
/*     */       }
/*  45 */       ps.setString(4, nvCertificadoCalculo.getSituacao());
/*  46 */       ps.setString(5, nvCertificadoCalculo.getNome());
/*  47 */       ps.setString(6, nvCertificadoCalculo.getSeqEmpresa());
/*  48 */       ps.setObject(7, nvCertificadoCalculo.getSeqNvTipoCertificado(), 1);
/*     */       
/*  50 */       ps.execute();
/*  51 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  54 */       Logger.getLogger(NvCertificadoCalculoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  55 */       System.out.println(ex.getMessage());
/*     */     }
/*  57 */     return nvCertificadoCalculo;
/*     */   }
/*     */   
/*     */   public NvCertificadoCalculo alterar(NvCertificadoCalculo nvCertificadoCalculo) {
/*     */     try {
/*  62 */       Conexao conexao = new Conexao();
/*  63 */       Connection conn = Conexao.getConnection();
/*  64 */       String sql = "update NV_CERTIFICADO_CALCULO set MESES_PARA_DATA_VALIDADE = ?,DATA_CADASTRO = ?,SITUACAO = ?,NOME = ?,SEQ_EMPRESA = ?, seq_nv_tipo_certificado = ? where SEQ_NV_CERTIFICADO_CALCULO = ?";
/*     */       
/*  66 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  68 */       ps.setString(1, nvCertificadoCalculo.getMesesParaDataValidade());
/*     */       try {
/*  70 */         ps.setDate(2, new java.sql.Date(nvCertificadoCalculo.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  72 */         ps.setDate(2, null);
/*     */       }
/*  74 */       ps.setString(3, nvCertificadoCalculo.getSituacao());
/*  75 */       ps.setString(4, nvCertificadoCalculo.getNome());
/*  76 */       ps.setString(5, nvCertificadoCalculo.getSeqEmpresa());
/*  77 */       ps.setObject(6, nvCertificadoCalculo.getSeqNvTipoCertificado(), 1);
/*  78 */       ps.setString(7, nvCertificadoCalculo.getSeqNvCertificadoCalculo());
/*  79 */       ps.execute();
/*  80 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  83 */       Logger.getLogger(NvCertificadoCalculoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  84 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  87 */     return nvCertificadoCalculo;
/*     */   }
/*     */   
/*     */   public List<NvCertificadoCalculo> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  92 */       Conexao conexao = new Conexao();
/*  93 */       Connection conn = Conexao.getConnection();
/*  94 */       String sql = "SELECT * FROM NV_CERTIFICADO_CALCULO" + sClausula.montarsClausula() + " order by nome asc";
/*  95 */       System.out.println(sql);
/*     */       
/*  97 */       List<NvCertificadoCalculo> listaNvCertificadoCalculo = new ArrayList();
/*  98 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  99 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 101 */       while (rs.next()) {
/* 102 */         NvCertificadoCalculo nvCertificadoCalculo = new NvCertificadoCalculo();
/* 103 */         nvCertificadoCalculo.setSeqNvCertificadoCalculo(rs.getString("SEQ_NV_CERTIFICADO_CALCULO"));
/* 104 */         nvCertificadoCalculo.setMesesParaDataValidade(rs.getString("MESES_PARA_DATA_VALIDADE"));
/* 105 */         nvCertificadoCalculo.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 106 */         nvCertificadoCalculo.setSituacao(rs.getString("SITUACAO"));
/* 107 */         nvCertificadoCalculo.setNome(rs.getString("NOME"));
/* 108 */         nvCertificadoCalculo.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 109 */         nvCertificadoCalculo.setSeqNvTipoCertificado(rs.getString("seq_nv_tipo_certificado"));
/* 110 */         listaNvCertificadoCalculo.add(nvCertificadoCalculo);
/*     */       }
/*     */       
/* 113 */       ps.execute();
/* 114 */       ps.close();
/*     */       
/* 116 */       return listaNvCertificadoCalculo;
/*     */     } catch (SQLException ex) {
/* 118 */       Logger.getLogger(NvCertificadoCalculoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 119 */       System.out.println(ex.getMessage()); }
/* 120 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(NvCertificadoCalculo nvCertificadoCalculo)
/*     */   {
/*     */     try {
/* 126 */       Conexao conexao = new Conexao();
/* 127 */       Connection conn = Conexao.getConnection();
/* 128 */       String sql = "DELETE FROM NV_CERTIFICADO_CALCULO WHERE SEQ_NV_CERTIFICADO_CALCULO =  ? ";
/*     */       
/* 130 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 132 */       ps.setString(1, nvCertificadoCalculo.getSeqNvCertificadoCalculo());
/*     */       
/* 134 */       ps.execute();
/* 135 */       ps.close();
/*     */       
/* 137 */       return true;
/*     */     } catch (SQLException ex) {
/* 139 */       System.out.println(ex.getMessage()); }
/* 140 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvCertificadoCalculo/NvCertificadoCalculoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */