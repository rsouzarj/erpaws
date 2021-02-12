/*     */ package UpPrestacao;
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
/*     */ public class UpPrestacaoDAO
/*     */ {
/*     */   public UpPrestacao inserir(UpPrestacao upload)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_UPLOAD");
/*  28 */       upload.setSeqUpload(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into COMP_PRESTACAO (SEQ_UPLOAD,DATA_CADASTRO,SEQ_DOCUMENTO,SEQ_USUARIO,URL,NOME_ARQUIVO,SEQ_EMPRESA,SEQ_FINANCEIRO) values  (?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, upload.getSeqUpload());
/*     */       try {
/*  39 */         ps.setDate(2, new java.sql.Date(upload.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  41 */         ps.setDate(2, null);
/*     */       }
/*  43 */       ps.setString(3, upload.getSeqDocumento());
/*  44 */       ps.setString(4, upload.getSeqUsuario());
/*  46 */       ps.setString(5, upload.getUrl());
/*  47 */       ps.setString(6, upload.getNomeArquivo());
/*  48 */       ps.setString(7, upload.getSeqEmpresa());
/*  50 */       ps.setString(8, upload.getSeqFinanceiro());       
/*  52 */       ps.execute();
/*  53 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  56 */       Logger.getLogger(UpPrestacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  57 */       System.out.println(ex.getMessage());
/*     */     }
/*  59 */     return upload;
/*     */   }
/*     */   /*     */   
/*     */   public UpPrestacao alterar(UpPrestacao upload) {
/*     */     try {
/*  64 */       Conexao conexao = new Conexao();
/*  65 */       Connection conn = Conexao.getConnection();
/*  66 */       String sql = "update COMP_PRESTACAO set DATA_CADASTRO = ?,SEQ_DOCUMENTO = ?,SEQ_USUARIO = ?,URL = ?,NOME_ARQUIVO = ?,SEQ_EMPRESA = ?,SEQ_FINANCEIRO where SEQ_UPLOAD = ?";
/*     */       
/*  68 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       try
/*     */       {
/*  71 */         ps.setDate(1, new java.sql.Date(upload.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  73 */         ps.setDate(1, null);
/*     */       }
/*  75 */       ps.setString(2, upload.getSeqDocumento());
/*  77 */       ps.setString(3, upload.getSeqUsuario());
/*  78 */       ps.setString(4, upload.getUrl());
/*  79 */       ps.setString(5, upload.getNomeArquivo());
/*  80 */       ps.setString(6, upload.getSeqEmpresa());
/*  83 */       ps.setString(7, upload.getSeqFinanceiro()); 
                ps.setString(8, upload.getSeqUpload());
                
/*  84 */       ps.execute();
/*  85 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  88 */       Logger.getLogger(UpPrestacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  89 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  92 */     return upload;
/*     */   }
/*     */   /*     */   
/*     */   public List<UpPrestacao> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  97 */       Conexao conexao = new Conexao();
/*  98 */       Connection conn = Conexao.getConnection();
/*  99 */       String sql = "SELECT COMP_PRESTACAO.*, usuario.usuario nomeUsuario FROM UPLOAD inner join usuario on usuario.seq_usuario = upload.seq_usuario" + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 104 */       System.out.println(sql);
/*     */       
/* 106 */       List<UpPrestacao> listaUpload = new ArrayList();
/* 107 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 108 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 110 */       while (rs.next()) {
/* 111 */         UpPrestacao upload = new UpPrestacao();
/* 112 */         upload.setSeqUpload(rs.getString("SEQ_UPLOAD"));
/* 113 */         upload.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 114 */         upload.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/* 116 */         upload.setSeqUsuario(rs.getString("SEQ_USUARIO"));
/* 117 */         upload.setUrl(rs.getString("URL"));
/* 118 */         upload.setNomeArquivo(rs.getString("NOME_ARQUIVO"));
/* 119 */         upload.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 122 */         upload.setSeqFinanceiro(rs.getString("SEQ_FINANCEIRO"));
/* 123 */         listaUpload.add(upload);
/*     */       }
/*     */       
/* 126 */       ps.execute();
/* 127 */       ps.close();
/*     */       
/* 129 */       return listaUpload;
/*     */     } catch (SQLException ex) {
/* 131 */       Logger.getLogger(UpPrestacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 132 */       System.out.println(ex.getMessage()); }
/* 133 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(UpPrestacao upload)
/*     */   {
/*     */     try {
/* 139 */       Conexao conexao = new Conexao();
/* 140 */       Connection conn = Conexao.getConnection();
/* 141 */       String sql = "DELETE FROM COMP_PRESTACAO WHERE SEQ_UPLOAD =  ? ";
/*     */       
/* 143 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 145 */       ps.setString(1, upload.getSeqUpload());
/*     */       
/* 147 */       ps.execute();
/* 148 */       ps.close();
/*     */       
/* 150 */       return true;
/*     */     } catch (SQLException ex) {
/* 152 */       System.out.println(ex.getMessage()); }
/* 153 */     return false;
/*     */   }
/*     */ }
