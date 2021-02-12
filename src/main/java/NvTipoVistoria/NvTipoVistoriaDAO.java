/*     */ package NvTipoVistoria;
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
/*     */ public class NvTipoVistoriaDAO
/*     */ {
/*     */   public NvTipoVistoria inserir(NvTipoVistoria nvTipoVistoria)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_NV_TIPO_VISTORIA");
/*  28 */       nvTipoVistoria.setSeqNvTipoVistoria(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into NV_TIPO_VISTORIA (SEQ_NV_TIPO_VISTORIA,SEQ_EMPRESA,SITUACAO,DATA_CADASTRO,CODIGO,NOME) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, nvTipoVistoria.getSeqNvTipoVistoria());
/*  38 */       ps.setString(2, nvTipoVistoria.getSeqEmpresa());
/*  39 */       ps.setString(3, nvTipoVistoria.getSituacao());
/*     */       try {
/*  41 */         ps.setDate(4, new java.sql.Date(nvTipoVistoria.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  43 */         ps.setDate(4, null);
/*     */       }
/*  45 */       ps.setString(5, nvTipoVistoria.getCodigo());
/*  46 */       ps.setString(6, nvTipoVistoria.getNome());
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(NvTipoVistoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return nvTipoVistoria;
/*     */   }
/*     */   
/*     */   public NvTipoVistoria alterar(NvTipoVistoria nvTipoVistoria) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update NV_TIPO_VISTORIA set SEQ_EMPRESA = ?,SITUACAO = ?,DATA_CADASTRO = ?,CODIGO = ?,NOME = ? where SEQ_NV_TIPO_VISTORIA = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, nvTipoVistoria.getSeqEmpresa());
/*  67 */       ps.setString(2, nvTipoVistoria.getSituacao());
/*     */       try {
/*  69 */         ps.setDate(3, new java.sql.Date(nvTipoVistoria.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  71 */         ps.setDate(3, null);
/*     */       }
/*  73 */       ps.setString(4, nvTipoVistoria.getCodigo());
/*  74 */       ps.setString(5, nvTipoVistoria.getNome());
/*  75 */       ps.setString(6, nvTipoVistoria.getSeqNvTipoVistoria());
/*  76 */       ps.execute();
/*  77 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  80 */       Logger.getLogger(NvTipoVistoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  81 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  84 */     return nvTipoVistoria;
/*     */   }
/*     */   
/*     */   public List<NvTipoVistoria> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  89 */       Conexao conexao = new Conexao();
/*  90 */       Connection conn = Conexao.getConnection();
/*  91 */       String sql = "SELECT * FROM NV_TIPO_VISTORIA" + sClausula.montarsClausula();
/*  92 */       System.out.println(sql);
/*     */       
/*  94 */       List<NvTipoVistoria> listaNvTipoVistoria = new ArrayList();
/*  95 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  96 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  98 */       while (rs.next()) {
/*  99 */         NvTipoVistoria nvTipoVistoria = new NvTipoVistoria();
/* 100 */         nvTipoVistoria.setSeqNvTipoVistoria(rs.getString("SEQ_NV_TIPO_VISTORIA"));
/* 101 */         nvTipoVistoria.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         nvTipoVistoria.setSituacao(rs.getString("SITUACAO"));
/* 103 */         nvTipoVistoria.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 104 */         nvTipoVistoria.setCodigo(rs.getString("CODIGO"));
/* 105 */         nvTipoVistoria.setNome(rs.getString("NOME"));
/* 106 */         listaNvTipoVistoria.add(nvTipoVistoria);
/*     */       }
/*     */       
/* 109 */       ps.execute();
/* 110 */       ps.close();
/*     */       
/* 112 */       return listaNvTipoVistoria;
/*     */     } catch (SQLException ex) {
/* 114 */       Logger.getLogger(NvTipoVistoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 115 */       System.out.println(ex.getMessage()); }
/* 116 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(NvTipoVistoria nvTipoVistoria)
/*     */   {
/*     */     try {
/* 122 */       Conexao conexao = new Conexao();
/* 123 */       Connection conn = Conexao.getConnection();
/* 124 */       String sql = "DELETE FROM NV_TIPO_VISTORIA WHERE SEQ_NV_TIPO_VISTORIA =  ? ";
/*     */       
/* 126 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 128 */       ps.setString(1, nvTipoVistoria.getSeqNvTipoVistoria());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvTipoVistoria/NvTipoVistoriaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */