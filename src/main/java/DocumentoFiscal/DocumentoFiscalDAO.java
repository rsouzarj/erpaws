/*     */ package DocumentoFiscal;
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
/*     */ public class DocumentoFiscalDAO
/*     */ {
/*     */   public DocumentoFiscal inserir(DocumentoFiscal documentoFiscal)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("seq_documento_fiscal");
/*  28 */       documentoFiscal.setSeqDocumentoFiscal(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into documento_fiscal (seq_documento_fiscal,NOME,SITUACAO,SEQ_EMPRESA,DATA_CADASTRO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, documentoFiscal.getSeqDocumentoFiscal());
/*  38 */       ps.setString(2, documentoFiscal.getNome());
/*  39 */       ps.setString(3, documentoFiscal.getSituacao());
/*  40 */       ps.setString(4, documentoFiscal.getSeqEmpresa());
/*     */       try {
/*  42 */         ps.setDate(5, new java.sql.Date(documentoFiscal.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  44 */         ps.setDate(5, null);
/*     */       }
/*     */       
/*  47 */       ps.execute();
/*  48 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  51 */       Logger.getLogger(DocumentoFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  52 */       System.out.println(ex.getMessage());
/*     */     }
/*  54 */     return documentoFiscal;
/*     */   }
/*     */   
/*     */   public DocumentoFiscal alterar(DocumentoFiscal documentoFiscal) {
/*     */     try {
/*  59 */       Conexao conexao = new Conexao();
/*  60 */       Connection conn = Conexao.getConnection();
/*  61 */       String sql = "update documento_fiscal set NOME = ?,SITUACAO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ? where seq_documento_fiscal = ?";
/*     */       
/*  63 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  65 */       ps.setString(1, documentoFiscal.getNome());
/*  66 */       ps.setString(2, documentoFiscal.getSituacao());
/*  67 */       ps.setString(3, documentoFiscal.getSeqEmpresa());
/*     */       try {
/*  69 */         ps.setDate(4, new java.sql.Date(documentoFiscal.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  71 */         ps.setDate(4, null);
/*     */       }
/*  73 */       ps.setString(5, documentoFiscal.getSeqDocumentoFiscal());
/*  74 */       ps.execute();
/*  75 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  78 */       Logger.getLogger(DocumentoFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  79 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  82 */     return documentoFiscal;
/*     */   }
/*     */   
/*     */   public List<DocumentoFiscal> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  87 */       Conexao conexao = new Conexao();
/*  88 */       Connection conn = Conexao.getConnection();
/*  89 */       String sql = "SELECT * FROM documento_fiscal" + sClausula.montarsClausula() + " order by nome";
/*  90 */       System.out.println(sql);
/*     */       
/*  92 */       List<DocumentoFiscal> listaDocumentoFiscal = new ArrayList();
/*  93 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  94 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  96 */       while (rs.next()) {
/*  97 */         DocumentoFiscal documentoFiscal = new DocumentoFiscal();
/*  98 */         documentoFiscal.setSeqDocumentoFiscal(rs.getString("seq_documento_fiscal"));
/*  99 */         documentoFiscal.setNome(rs.getString("NOME"));
/* 100 */         documentoFiscal.setSituacao(rs.getString("SITUACAO"));
/* 101 */         documentoFiscal.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         documentoFiscal.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 103 */         listaDocumentoFiscal.add(documentoFiscal);
/*     */       }
/*     */       
/* 106 */       ps.execute();
/* 107 */       ps.close();
/*     */       
/* 109 */       return listaDocumentoFiscal;
/*     */     } catch (SQLException ex) {
/* 111 */       Logger.getLogger(DocumentoFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 112 */       System.out.println(ex.getMessage()); }
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(DocumentoFiscal documentoFiscal)
/*     */   {
/*     */     try {
/* 119 */       Conexao conexao = new Conexao();
/* 120 */       Connection conn = Conexao.getConnection();
/* 121 */       String sql = "DELETE FROM documento_fiscal WHERE seq_documento_fiscal =  ? ";
/*     */       
/* 123 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 125 */       ps.setString(1, documentoFiscal.getSeqDocumentoFiscal());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoFiscal/DocumentoFiscalDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */