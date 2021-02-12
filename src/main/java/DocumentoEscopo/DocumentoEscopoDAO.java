/*     */ package DocumentoEscopo;
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
/*     */ public class DocumentoEscopoDAO
/*     */ {
/*     */   public DocumentoEscopo inserir(DocumentoEscopo documentoEscopo)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_DOCUMENTO_ESCOPO");
/*  28 */       documentoEscopo.setSeqDocumentoEscopo(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into DOCUMENTO_ESCOPO (SEQ_DOCUMENTO_ESCOPO,SEQ_SERVICO_ESCOPO,SEQ_TIPO_DOCUMENTO) values  (?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, documentoEscopo.getSeqDocumentoEscopo());
/*  38 */       ps.setString(2, documentoEscopo.getSeqServicoEscopo());
/*  39 */       ps.setString(3, documentoEscopo.getSeqTipoDocumento());
/*     */       
/*  41 */       ps.execute();
/*  42 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  45 */       Logger.getLogger(DocumentoEscopoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  46 */       System.out.println(ex.getMessage());
/*     */     }
/*  48 */     return documentoEscopo;
/*     */   }
/*     */   
/*     */   public DocumentoEscopo alterar(DocumentoEscopo documentoEscopo) {
/*     */     try {
/*  53 */       Conexao conexao = new Conexao();
/*  54 */       Connection conn = Conexao.getConnection();
/*  55 */       String sql = "update DOCUMENTO_ESCOPO set SEQ_SERVICO_ESCOPO = ?,SEQ_TIPO_DOCUMENTO = ? where SEQ_DOCUMENTO_ESCOPO = ?";
/*     */       
/*  57 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  59 */       ps.setString(1, documentoEscopo.getSeqServicoEscopo());
/*  60 */       ps.setString(2, documentoEscopo.getSeqTipoDocumento());
/*  61 */       ps.setString(3, documentoEscopo.getSeqDocumentoEscopo());
/*  62 */       ps.execute();
/*  63 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  66 */       Logger.getLogger(DocumentoEscopoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  67 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  70 */     return documentoEscopo;
/*     */   }
/*     */   
/*     */   public List<DocumentoEscopo> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  75 */       Conexao conexao = new Conexao();
/*  76 */       Connection conn = Conexao.getConnection();
/*  77 */       String sql = "SELECT documento_escopo.*, SERVICO_ESCOPO.nome nomeEscopo, \n tipo_documento.nome nomeDocumento \n FROM DOCUMENTO_ESCOPO \n inner join SERVICO_ESCOPO on servico_escopo.seq_servico_escopo = documento_escopo.SEQ_SERVICO_ESCOPO \n  inner join tipo_documento on tipo_documento.seq_tipo_documento = documento_escopo.SEQ_tipo_documento \n " + sClausula.montarsClausula() + " order by tipo_documento.nome, SERVICO_ESCOPO.nome asc";
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  86 */       List<DocumentoEscopo> listaDocumentoEscopo = new ArrayList();
/*  87 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  88 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  90 */       while (rs.next()) {
/*  91 */         DocumentoEscopo documentoEscopo = new DocumentoEscopo();
/*  92 */         documentoEscopo.setSeqDocumentoEscopo(rs.getString("SEQ_DOCUMENTO_ESCOPO"));
/*  93 */         documentoEscopo.setSeqServicoEscopo(rs.getString("SEQ_SERVICO_ESCOPO"));
/*  94 */         documentoEscopo.setSeqTipoDocumento(rs.getString("SEQ_TIPO_DOCUMENTO"));
/*  95 */         documentoEscopo.setNomeDocumento(rs.getString("nomeDocumento"));
/*  96 */         documentoEscopo.setNomeServicoEscopo(rs.getString("nomeEscopo"));
/*  97 */         listaDocumentoEscopo.add(documentoEscopo);
/*     */       }
/*     */       
/* 100 */       ps.execute();
/* 101 */       ps.close();
/*     */       
/* 103 */       return listaDocumentoEscopo;
/*     */     } catch (SQLException ex) {
/* 105 */       Logger.getLogger(DocumentoEscopoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 106 */       System.out.println(ex.getMessage()); }
/* 107 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(DocumentoEscopo documentoEscopo)
/*     */   {
/*     */     try {
/* 113 */       Conexao conexao = new Conexao();
/* 114 */       Connection conn = Conexao.getConnection();
/* 115 */       String sql = "DELETE FROM DOCUMENTO_ESCOPO WHERE SEQ_DOCUMENTO_ESCOPO =  ? ";
/*     */       
/* 117 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 119 */       ps.setString(1, documentoEscopo.getSeqDocumentoEscopo());
/*     */       
/* 121 */       ps.execute();
/* 122 */       ps.close();
/*     */       
/* 124 */       return true;
/*     */     } catch (SQLException ex) {
/* 126 */       System.out.println(ex.getMessage()); }
/* 127 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoEscopo/DocumentoEscopoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */