/*     */ package DocumentoItemEquipamento;
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
/*     */ public class DocumentoItemEquipamentoDAO
/*     */ {
/*     */   public DocumentoItemEquipamento inserir(DocumentoItemEquipamento documentoItemEquipamento)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_DOCUMENTO_ITEM_EQUIPAMENTO");
/*  28 */       documentoItemEquipamento.setSeqDocumentoItemEquipamento(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into DOCUMENTO_ITEM_EQUIPAMENTO (SEQ_DOCUMENTO_ITEM_EQUIPAMENTO,SEQ_EQUIPAMENTO,SEQ_DOCUMENTO) values  (?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, documentoItemEquipamento.getSeqDocumentoItemEquipamento());
/*  38 */       ps.setString(2, documentoItemEquipamento.getSeqEquipamento());
/*  39 */       ps.setString(3, documentoItemEquipamento.getSeqDocumento());
/*     */       
/*  41 */       ps.execute();
/*  42 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  45 */       Logger.getLogger(DocumentoItemEquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  46 */       System.out.println(ex.getMessage());
/*     */     }
/*  48 */     return documentoItemEquipamento;
/*     */   }
/*     */   
/*     */   public DocumentoItemEquipamento alterar(DocumentoItemEquipamento documentoItemEquipamento) {
/*     */     try {
/*  53 */       Conexao conexao = new Conexao();
/*  54 */       Connection conn = Conexao.getConnection();
/*  55 */       String sql = "update DOCUMENTO_ITEM_EQUIPAMENTO set SEQ_EQUIPAMENTO = ?,SEQ_DOCUMENTO = ? where SEQ_DOCUMENTO_ITEM_EQUIPAMENTO = ?";
/*     */       
/*  57 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  59 */       ps.setString(1, documentoItemEquipamento.getSeqEquipamento());
/*  60 */       ps.setString(2, documentoItemEquipamento.getSeqDocumento());
/*  61 */       ps.setString(3, documentoItemEquipamento.getSeqDocumentoItemEquipamento());
/*  62 */       ps.execute();
/*  63 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  66 */       Logger.getLogger(DocumentoItemEquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  67 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  70 */     return documentoItemEquipamento;
/*     */   }
/*     */   
/*     */   public List<DocumentoItemEquipamento> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  75 */       Conexao conexao = new Conexao();
/*  76 */       Connection conn = Conexao.getConnection();
/*  77 */       String sql = "SELECT * FROM DOCUMENTO_ITEM_EQUIPAMENTO" + sClausula.montarsClausula();
/*  78 */       System.out.println(sql);
/*     */       
/*  80 */       List<DocumentoItemEquipamento> listaDocumentoItemEquipamento = new ArrayList();
/*  81 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  82 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  84 */       while (rs.next()) {
/*  85 */         DocumentoItemEquipamento documentoItemEquipamento = new DocumentoItemEquipamento();
/*  86 */         documentoItemEquipamento.setSeqDocumentoItemEquipamento(rs.getString("SEQ_DOCUMENTO_ITEM_EQUIPAMENTO"));
/*  87 */         documentoItemEquipamento.setSeqEquipamento(rs.getString("SEQ_EQUIPAMENTO"));
/*  88 */         documentoItemEquipamento.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/*  89 */         listaDocumentoItemEquipamento.add(documentoItemEquipamento);
/*     */       }
/*     */       
/*  92 */       ps.execute();
/*  93 */       ps.close();
/*     */       
/*  95 */       return listaDocumentoItemEquipamento;
/*     */     } catch (SQLException ex) {
/*  97 */       Logger.getLogger(DocumentoItemEquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  98 */       System.out.println(ex.getMessage()); }
/*  99 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(DocumentoItemEquipamento documentoItemEquipamento)
/*     */   {
/*     */     try {
/* 105 */       Conexao conexao = new Conexao();
/* 106 */       Connection conn = Conexao.getConnection();
/* 107 */       String sql = "DELETE FROM DOCUMENTO_ITEM_EQUIPAMENTO WHERE SEQ_DOCUMENTO_ITEM_EQUIPAMENTO =  ? ";
/*     */       
/* 109 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 111 */       ps.setString(1, documentoItemEquipamento.getSeqDocumentoItemEquipamento());
/*     */       
/* 113 */       ps.execute();
/* 114 */       ps.close();
/*     */       
/* 116 */       return true;
/*     */     } catch (SQLException ex) {
/* 118 */       System.out.println(ex.getMessage()); }
/* 119 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemEquipamento/DocumentoItemEquipamentoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */