/*     */ package NvTipoCertificado;
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
/*     */ public class NvTipoCertificadoDAO
/*     */ {
/*     */   public NvTipoCertificado inserir(NvTipoCertificado nvTipoCertificado)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_NV_TIPO_CERTIFICADO");
/*  28 */       nvTipoCertificado.setSeqNvTipoCertificado(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into NV_TIPO_CERTIFICADO (SEQ_NV_TIPO_CERTIFICADO,SEQ_EMPRESA,SITUACAO,DATA_CADASTRO,CODIGO,NOME) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, nvTipoCertificado.getSeqNvTipoCertificado());
/*  38 */       ps.setString(2, nvTipoCertificado.getSeqEmpresa());
/*  39 */       ps.setString(3, nvTipoCertificado.getSituacao());
/*     */       try {
/*  41 */         ps.setDate(4, new java.sql.Date(nvTipoCertificado.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  43 */         ps.setDate(4, null);
/*     */       }
/*  45 */       ps.setString(5, nvTipoCertificado.getCodigo());
/*  46 */       ps.setString(6, nvTipoCertificado.getNome());
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(NvTipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return nvTipoCertificado;
/*     */   }
/*     */   
/*     */   public NvTipoCertificado alterar(NvTipoCertificado nvTipoCertificado) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update NV_TIPO_CERTIFICADO set SEQ_EMPRESA = ?,SITUACAO = ?,DATA_CADASTRO = ?,CODIGO = ?,NOME = ? where SEQ_NV_TIPO_CERTIFICADO = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, nvTipoCertificado.getSeqEmpresa());
/*  67 */       ps.setString(2, nvTipoCertificado.getSituacao());
/*     */       try {
/*  69 */         ps.setDate(3, new java.sql.Date(nvTipoCertificado.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  71 */         ps.setDate(3, null);
/*     */       }
/*  73 */       ps.setString(4, nvTipoCertificado.getCodigo());
/*  74 */       ps.setString(5, nvTipoCertificado.getNome());
/*  75 */       ps.setString(6, nvTipoCertificado.getSeqNvTipoCertificado());
/*  76 */       ps.execute();
/*  77 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  80 */       Logger.getLogger(NvTipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  81 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  84 */     return nvTipoCertificado;
/*     */   }
/*     */   
/*     */   public List<NvTipoCertificado> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  89 */       Conexao conexao = new Conexao();
/*  90 */       Connection conn = Conexao.getConnection();
/*  91 */       String sql = "SELECT * FROM NV_TIPO_CERTIFICADO" + sClausula.montarsClausula();
/*  92 */       System.out.println(sql);
/*     */       
/*  94 */       List<NvTipoCertificado> listaNvTipoCertificado = new ArrayList();
/*  95 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  96 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  98 */       while (rs.next()) {
/*  99 */         NvTipoCertificado nvTipoCertificado = new NvTipoCertificado();
/* 100 */         nvTipoCertificado.setSeqNvTipoCertificado(rs.getString("SEQ_NV_TIPO_CERTIFICADO"));
/* 101 */         nvTipoCertificado.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         nvTipoCertificado.setSituacao(rs.getString("SITUACAO"));
/* 103 */         nvTipoCertificado.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 104 */         nvTipoCertificado.setCodigo(rs.getString("CODIGO"));
/* 105 */         nvTipoCertificado.setNome(rs.getString("NOME"));
/* 106 */         listaNvTipoCertificado.add(nvTipoCertificado);
/*     */       }
/*     */       
/* 109 */       ps.execute();
/* 110 */       ps.close();
/*     */       
/* 112 */       return listaNvTipoCertificado;
/*     */     } catch (SQLException ex) {
/* 114 */       Logger.getLogger(NvTipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 115 */       System.out.println(ex.getMessage()); }
/* 116 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(NvTipoCertificado nvTipoCertificado)
/*     */   {
/*     */     try {
/* 122 */       Conexao conexao = new Conexao();
/* 123 */       Connection conn = Conexao.getConnection();
/* 124 */       String sql = "DELETE FROM NV_TIPO_CERTIFICADO WHERE SEQ_NV_TIPO_CERTIFICADO =  ? ";
/*     */       
/* 126 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 128 */       ps.setString(1, nvTipoCertificado.getSeqNvTipoCertificado());
/*     */       
/* 130 */       ps.execute();
/* 131 */       ps.close();
/*     */       
/* 133 */       return true;
/*     */     } catch (SQLException ex) {
/* 135 */       System.out.println(ex.getMessage()); }
/* 136 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvTipoCertificado/NvTipoCertificadoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */