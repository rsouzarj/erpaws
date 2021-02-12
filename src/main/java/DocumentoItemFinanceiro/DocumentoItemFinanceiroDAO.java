/*     */ package DocumentoItemFinanceiro;
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
/*     */ public class DocumentoItemFinanceiroDAO
/*     */ {
/*     */   public DocumentoItemFinanceiro inserir(DocumentoItemFinanceiro documentoItemFinanceiro)
/*     */   {
/*     */     try
/*     */     {
/*  28 */       String seq = Sequence.buscarNumeroSequence("SEQ_DOCUMENTO_ITEM_FINANCEIRO");
/*  29 */       documentoItemFinanceiro.setSeqDocumentoItemFinanceiro(seq);
/*  30 */       Conexao conexao = new Conexao();
/*  31 */       Connection conn = Conexao.getConnection();
/*  32 */       String sql = "insert into DOCUMENTO_ITEM_FINANCEIRO (SEQ_DOCUMENTO_ITEM_FINANCEIRO,SEQ_DOCUMENTO,DATA_CADASTRO,VALOR,SEQ_FORMA_PAGAMENTO,SEQ_CONTA,SEQ_TIPO_MOVIMENTO_FINANCEIRO,SEQ_EMPRESA,SITUACAO) values  (?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  36 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  38 */       ps.setString(1, documentoItemFinanceiro.getSeqDocumentoItemFinanceiro());
/*  39 */       ps.setString(2, documentoItemFinanceiro.getSeqDocumento());
/*     */       try {
/*  41 */         ps.setDate(3, new java.sql.Date(documentoItemFinanceiro.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  43 */         ps.setDate(3, null);
/*     */       }
/*  45 */       ps.setBigDecimal(4, documentoItemFinanceiro.getValor());
/*  46 */       ps.setObject(5, documentoItemFinanceiro.getSeqFormaPagamento(), 1);
/*  47 */       ps.setObject(6, documentoItemFinanceiro.getSeqConta(), 1);
/*  48 */       ps.setObject(7, documentoItemFinanceiro.getSeqTipoMovimentoFinanceiro(), 1);
/*  49 */       ps.setString(8, documentoItemFinanceiro.getSeqEmpresa());
/*  50 */       ps.setString(9, documentoItemFinanceiro.getSituacao());
/*     */       
/*  52 */       ps.execute();
/*  53 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  56 */       Logger.getLogger(DocumentoItemFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  57 */       System.out.println(ex.getMessage());
/*     */     }
/*  59 */     return documentoItemFinanceiro;
/*     */   }
/*     */   
/*     */   public DocumentoItemFinanceiro alterar(DocumentoItemFinanceiro documentoItemFinanceiro) {
/*     */     try {
/*  64 */       Conexao conexao = new Conexao();
/*  65 */       Connection conn = Conexao.getConnection();
/*  66 */       String sql = "update DOCUMENTO_ITEM_FINANCEIRO set SEQ_DOCUMENTO = ?,DATA_CADASTRO = ?,VALOR = ?,SEQ_FORMA_PAGAMENTO = ?,SEQ_CONTA = ?,SEQ_TIPO_MOVIMENTO_FINANCEIRO = ?,SEQ_EMPRESA = ?,SITUACAO = ? where SEQ_DOCUMENTO_ITEM_FINANCEIRO = ?";
/*     */       
/*  68 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  70 */       ps.setString(1, documentoItemFinanceiro.getSeqDocumento());
/*     */       try {
/*  72 */         ps.setDate(2, new java.sql.Date(documentoItemFinanceiro.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  74 */         ps.setDate(2, null);
/*     */       }
/*  76 */       ps.setBigDecimal(3, documentoItemFinanceiro.getValor());
/*  77 */       ps.setObject(4, documentoItemFinanceiro.getSeqFormaPagamento(), 1);
/*  78 */       ps.setObject(5, documentoItemFinanceiro.getSeqConta(), 1);
/*  79 */       ps.setObject(6, documentoItemFinanceiro.getSeqTipoMovimentoFinanceiro(), 1);
/*  80 */       ps.setString(7, documentoItemFinanceiro.getSeqEmpresa());
/*  81 */       ps.setString(8, documentoItemFinanceiro.getSituacao());
/*  82 */       ps.setString(9, documentoItemFinanceiro.getSeqDocumentoItemFinanceiro());
/*  83 */       ps.execute();
/*  84 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  87 */       Logger.getLogger(DocumentoItemFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  88 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  91 */     return documentoItemFinanceiro;
/*     */   }
/*     */   
/*     */   public List<DocumentoItemFinanceiro> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  96 */       Conexao conexao = new Conexao();
/*  97 */       Connection conn = Conexao.getConnection();
/*  98 */       String sql = "SELECT * FROM DOCUMENTO_ITEM_FINANCEIRO" + sClausula.montarsClausula();
/*     */       
/*     */ 
/* 101 */       List<DocumentoItemFinanceiro> listaDocumentoItemFinanceiro = new ArrayList();
/* 102 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 103 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 105 */       while (rs.next()) {
/* 106 */         DocumentoItemFinanceiro documentoItemFinanceiro = new DocumentoItemFinanceiro();
/* 107 */         documentoItemFinanceiro.setSeqDocumentoItemFinanceiro(rs.getString("SEQ_DOCUMENTO_ITEM_FINANCEIRO"));
/* 108 */         documentoItemFinanceiro.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/* 109 */         documentoItemFinanceiro.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 110 */         documentoItemFinanceiro.setValor(rs.getBigDecimal("VALOR"));
/* 111 */         documentoItemFinanceiro.setSeqFormaPagamento(rs.getString("SEQ_FORMA_PAGAMENTO"));
/* 112 */         documentoItemFinanceiro.setSeqConta(rs.getString("SEQ_CONTA"));
/* 113 */         documentoItemFinanceiro.setSeqTipoMovimentoFinanceiro(rs.getString("SEQ_TIPO_MOVIMENTO_FINANCEIRO"));
/* 114 */         documentoItemFinanceiro.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 115 */         documentoItemFinanceiro.setSituacao(rs.getString("SITUACAO"));
/* 116 */         listaDocumentoItemFinanceiro.add(documentoItemFinanceiro);
/*     */       }
/*     */       
/* 119 */       ps.execute();
/* 120 */       ps.close();
/*     */       
/* 122 */       return listaDocumentoItemFinanceiro;
/*     */     } catch (SQLException ex) {
/* 124 */       Logger.getLogger(DocumentoItemFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 125 */       System.out.println(ex.getMessage()); }
/* 126 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(DocumentoItemFinanceiro documentoItemFinanceiro)
/*     */   {
/*     */     try {
/* 132 */       Conexao conexao = new Conexao();
/* 133 */       Connection conn = Conexao.getConnection();
/* 134 */       String sql = "DELETE FROM DOCUMENTO_ITEM_FINANCEIRO WHERE SEQ_DOCUMENTO_ITEM_FINANCEIRO =  ? ";
/*     */       
/* 136 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 138 */       ps.setString(1, documentoItemFinanceiro.getSeqDocumentoItemFinanceiro());
/*     */       
/* 140 */       ps.execute();
/* 141 */       ps.close();
/*     */       
/* 143 */       return true;
/*     */     } catch (SQLException ex) {
/* 145 */       System.out.println(ex.getMessage()); }
/* 146 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemFinanceiro/DocumentoItemFinanceiroDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */