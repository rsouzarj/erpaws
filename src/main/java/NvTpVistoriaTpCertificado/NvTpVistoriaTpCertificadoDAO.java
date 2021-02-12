/*     */ package NvTpVistoriaTpCertificado;
/*     */ 
/*     */ import ClausulaSQL.ClausulaWhere;
/*     */ import Util.Conexao;
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
/*     */ public class NvTpVistoriaTpCertificadoDAO
/*     */ {
/*     */   public NvTpVistoriaTpCertificado inserir(NvTpVistoriaTpCertificado nvTpVistoriaTpCertificado)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       Conexao conexao = new Conexao();
/*  28 */       Connection conn = Conexao.getConnection();
/*  29 */       String sql = "insert into NV_TP_VISTORIA_TP_CERTIFICADO (SEQ_NV_TIPO_CERTIFICADO,SEQ_NV_TIPO_VISTORIA) values  (?,?)";
/*     */       
/*     */ 
/*     */ 
/*  33 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  35 */       ps.setString(1, nvTpVistoriaTpCertificado.getSeqNvTipoCertificado());
/*  36 */       ps.setString(2, nvTpVistoriaTpCertificado.getSeqNvTipoVistoria());
/*     */       
/*  38 */       ps.execute();
/*  39 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  42 */       Logger.getLogger(NvTpVistoriaTpCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  43 */       System.out.println(ex.getMessage());
/*     */     }
/*  45 */     return nvTpVistoriaTpCertificado;
/*     */   }
/*     */   
/*     */   public List<NvTpVistoriaTpCertificado> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  50 */       Conexao conexao = new Conexao();
/*  51 */       Connection conn = Conexao.getConnection();
/*  52 */       String sql = "select NV_TP_VISTORIA_TP_CERTIFICADO.* ,\nnv_tipo_vistoria.codigo codigo_vistoria,\nnv_tipo_vistoria.nome nome_vistoria,\nnv_tipo_certificado.codigo codigo_certificado,\nnv_tipo_certificado.nome nome_certificado\nFrom \nNV_TP_VISTORIA_TP_CERTIFICADO\ninner join nv_tipo_vistoria on nv_tipo_vistoria.seq_nv_tipo_vistoria = NV_TP_VISTORIA_TP_CERTIFICADO.seq_nv_tipo_vistoria\ninner join nv_tipo_certificado on nv_tipo_certificado.seq_nv_tipo_certificado = NV_TP_VISTORIA_TP_CERTIFICADO.seq_nv_tipo_certificado " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  62 */       System.out.println(sql);
/*     */       
/*  64 */       List<NvTpVistoriaTpCertificado> listaNvTpVistoriaTpCertificado = new ArrayList();
/*  65 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  66 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  68 */       while (rs.next()) {
/*  69 */         NvTpVistoriaTpCertificado nvTpVistoriaTpCertificado = new NvTpVistoriaTpCertificado();
/*  70 */         nvTpVistoriaTpCertificado.setSeqNvTipoCertificado(rs.getString("SEQ_NV_TIPO_CERTIFICADO"));
/*  71 */         nvTpVistoriaTpCertificado.setSeqNvTipoVistoria(rs.getString("SEQ_NV_TIPO_VISTORIA"));
/*  72 */         nvTpVistoriaTpCertificado.setCodigoVistoria(rs.getString("codigo_vistoria"));
/*  73 */         nvTpVistoriaTpCertificado.setNomeVistoria(rs.getString("nome_vistoria"));
/*  74 */         nvTpVistoriaTpCertificado.setCodigoCertificado(rs.getString("codigo_certificado"));
/*  75 */         nvTpVistoriaTpCertificado.setNomeCertificado(rs.getString("nome_certificado"));
/*     */         
/*  77 */         listaNvTpVistoriaTpCertificado.add(nvTpVistoriaTpCertificado);
/*     */       }
/*     */       
/*  80 */       ps.execute();
/*  81 */       ps.close();
/*     */       
/*  83 */       return listaNvTpVistoriaTpCertificado;
/*     */     } catch (SQLException ex) {
/*  85 */       Logger.getLogger(NvTpVistoriaTpCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  86 */       System.out.println(ex.getMessage()); }
/*  87 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(String pSeqNvTipoVistoria, String pSeqNvTipoCertificado)
/*     */   {
/*  92 */     boolean retorno = false;
/*  93 */     if (pSeqNvTipoVistoria != null) {
/*  94 */       retorno = deletarPorVistoria(pSeqNvTipoVistoria);
/*  95 */     } else if (pSeqNvTipoCertificado != null) {
/*  96 */       retorno = deletarPorCertificado(pSeqNvTipoCertificado);
/*     */     }
/*     */     
/*  99 */     return retorno;
/*     */   }
/*     */   
/*     */   private boolean deletarPorCertificado(String pSeqNvTipoCertificado) {
/*     */     try {
/* 104 */       Conexao conexao = new Conexao();
/* 105 */       Connection conn = Conexao.getConnection();
/* 106 */       String sql = "DELETE FROM NV_TP_VISTORIA_TP_CERTIFICADO WHERE SEQ_NV_TIPO_CERTIFICADO =  ? ";
/*     */       
/* 108 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 110 */       ps.setString(1, pSeqNvTipoCertificado);
/*     */       
/* 112 */       ps.execute();
/* 113 */       ps.close();
/*     */       
/* 115 */       return true;
/*     */     } catch (SQLException ex) {
/* 117 */       System.out.println(ex.getMessage()); }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   private boolean deletarPorVistoria(String pSeqNvTipoVistoria)
/*     */   {
/*     */     try {
/* 124 */       Conexao conexao = new Conexao();
/* 125 */       Connection conn = Conexao.getConnection();
/* 126 */       String sql = "DELETE FROM NV_TP_VISTORIA_TP_CERTIFICADO WHERE SEQ_NV_TIPO_VISTORIA =  ? ";
/*     */       
/* 128 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 130 */       ps.setString(1, pSeqNvTipoVistoria);
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvTpVistoriaTpCertificado/NvTpVistoriaTpCertificadoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */