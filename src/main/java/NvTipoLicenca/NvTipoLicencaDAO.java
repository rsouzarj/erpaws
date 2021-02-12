/*     */ package NvTipoLicenca;
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
/*     */ public class NvTipoLicencaDAO
/*     */ {
/*     */   public NvTipoLicenca inserir(NvTipoLicenca nvTipoLicenca)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_NV_TIPO_LICENCA");
/*  28 */       nvTipoLicenca.setSeqNvTipoLicenca(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into NV_TIPO_LICENCA (SEQ_NV_TIPO_LICENCA,SEQ_EMPRESA,SITUACAO,DATA_CADASTRO,CODIGO,NOME) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, nvTipoLicenca.getSeqNvTipoLicenca());
/*  38 */       ps.setString(2, nvTipoLicenca.getSeqEmpresa());
/*  39 */       ps.setString(3, nvTipoLicenca.getSituacao());
/*     */       try {
/*  41 */         ps.setDate(4, new java.sql.Date(nvTipoLicenca.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  43 */         ps.setDate(4, null);
/*     */       }
/*  45 */       ps.setString(5, nvTipoLicenca.getCodigo());
/*  46 */       ps.setString(6, nvTipoLicenca.getNome());
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(NvTipoLicencaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return nvTipoLicenca;
/*     */   }
/*     */   
/*     */   public NvTipoLicenca alterar(NvTipoLicenca nvTipoLicenca) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update NV_TIPO_LICENCA set SEQ_EMPRESA = ?,SITUACAO = ?,DATA_CADASTRO = ?,CODIGO = ?,NOME = ? where SEQ_NV_TIPO_LICENCA = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, nvTipoLicenca.getSeqEmpresa());
/*  67 */       ps.setString(2, nvTipoLicenca.getSituacao());
/*     */       try {
/*  69 */         ps.setDate(3, new java.sql.Date(nvTipoLicenca.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  71 */         ps.setDate(3, null);
/*     */       }
/*  73 */       ps.setString(4, nvTipoLicenca.getCodigo());
/*  74 */       ps.setString(5, nvTipoLicenca.getNome());
/*  75 */       ps.setString(6, nvTipoLicenca.getSeqNvTipoLicenca());
/*  76 */       ps.execute();
/*  77 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  80 */       Logger.getLogger(NvTipoLicencaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  81 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  84 */     return nvTipoLicenca;
/*     */   }
/*     */   
/*     */   public List<NvTipoLicenca> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  89 */       Conexao conexao = new Conexao();
/*  90 */       Connection conn = Conexao.getConnection();
/*  91 */       String sql = "SELECT * FROM NV_TIPO_LICENCA" + sClausula.montarsClausula();
/*  92 */       System.out.println(sql);
/*     */       
/*  94 */       List<NvTipoLicenca> listaNvTipoLicenca = new ArrayList();
/*  95 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  96 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  98 */       while (rs.next()) {
/*  99 */         NvTipoLicenca nvTipoLicenca = new NvTipoLicenca();
/* 100 */         nvTipoLicenca.setSeqNvTipoLicenca(rs.getString("SEQ_NV_TIPO_LICENCA"));
/* 101 */         nvTipoLicenca.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         nvTipoLicenca.setSituacao(rs.getString("SITUACAO"));
/* 103 */         nvTipoLicenca.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 104 */         nvTipoLicenca.setCodigo(rs.getString("CODIGO"));
/* 105 */         nvTipoLicenca.setNome(rs.getString("NOME"));
/* 106 */         listaNvTipoLicenca.add(nvTipoLicenca);
/*     */       }
/*     */       
/* 109 */       ps.execute();
/* 110 */       ps.close();
/*     */       
/* 112 */       return listaNvTipoLicenca;
/*     */     } catch (SQLException ex) {
/* 114 */       Logger.getLogger(NvTipoLicencaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 115 */       System.out.println(ex.getMessage()); }
/* 116 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(NvTipoLicenca nvTipoLicenca)
/*     */   {
/*     */     try {
/* 122 */       Conexao conexao = new Conexao();
/* 123 */       Connection conn = Conexao.getConnection();
/* 124 */       String sql = "DELETE FROM NV_TIPO_LICENCA WHERE SEQ_NV_TIPO_LICENCA =  ? ";
/*     */       
/* 126 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 128 */       ps.setString(1, nvTipoLicenca.getSeqNvTipoLicenca());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvTipoLicenca/NvTipoLicencaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */