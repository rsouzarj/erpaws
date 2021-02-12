/*     */ package DocumentoItemServico;
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
/*     */ public class DocumentoItemServicoDAO
/*     */ {
/*     */   public DocumentoItemServico inserir(DocumentoItemServico documentoItemServico)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_DOCUMENTO_ITEM_SERVICO");
/*  28 */       documentoItemServico.setSeqDocumentoItemServico(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into DOCUMENTO_ITEM_SERVICO (SEQ_DOCUMENTO_ITEM_SERVICO,SEQ_SERVICO_ESCOPO,DATA_CADASTRO,SITUACAO,SEQ_EMPRESA,SEQ_DOCUMENTO, seq_colaborador) values  (?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, documentoItemServico.getSeqDocumentoItemServico());
/*  38 */       ps.setString(2, documentoItemServico.getSeqServicoEscopo());
/*     */       try {
/*  40 */         ps.setDate(3, new java.sql.Date(documentoItemServico.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  42 */         ps.setDate(3, null);
/*     */       }
/*  44 */       ps.setString(4, documentoItemServico.getSituacao());
/*  45 */       ps.setString(5, documentoItemServico.getSeqEmpresa());
/*  46 */       ps.setString(6, documentoItemServico.getSeqDocumento());
/*  47 */       ps.setString(7, documentoItemServico.getSeqColaborador());
/*     */       
/*  49 */       ps.execute();
/*  50 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  53 */       Logger.getLogger(DocumentoItemServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  54 */       System.out.println(ex.getMessage());
/*     */     }
/*  56 */     return documentoItemServico;
/*     */   }
/*     */   
/*     */   public DocumentoItemServico alterar(DocumentoItemServico documentoItemServico) {
/*     */     try {
/*  61 */       Conexao conexao = new Conexao();
/*  62 */       Connection conn = Conexao.getConnection();
/*  63 */       String sql = "update DOCUMENTO_ITEM_SERVICO set SITUACAO = ?, seq_colaborador = ? where SEQ_DOCUMENTO_ITEM_SERVICO = ?";
/*     */       
/*  65 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  67 */       ps.setString(1, documentoItemServico.getSituacao());
/*  68 */       ps.setString(2, documentoItemServico.getSeqColaborador());
/*  69 */       ps.setString(3, documentoItemServico.getSeqDocumentoItemServico());
/*  70 */       ps.execute();
/*  71 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  74 */       Logger.getLogger(DocumentoItemServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  75 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  78 */     return documentoItemServico;
/*     */   }
/*     */   
/*     */   public List<DocumentoItemServico> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  83 */       Conexao conexao = new Conexao();
/*  84 */       Connection conn = Conexao.getConnection();
/*  85 */       String sql = "SELECT DOCUMENTO_ITEM_SERVICO.*, SERVICO_ESCOPO.NOME servicoEscopoNome,  colaborador.NOME colaboradorNome FROM DOCUMENTO_ITEM_SERVICO inner join SERVICO_ESCOPO on SERVICO_ESCOPO.SEQ_SERVICO_ESCOPO = DOCUMENTO_ITEM_SERVICO.SEQ_SERVICO_ESCOPO left join colaborador on colaborador.seq_colaborador = DOCUMENTO_ITEM_SERVICO.SEQ_colaborador " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */       List<DocumentoItemServico> listaDocumentoItemServico = new ArrayList();
/*  97 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  98 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 100 */       while (rs.next()) {
/* 101 */         DocumentoItemServico documentoItemServico = new DocumentoItemServico();
/* 102 */         documentoItemServico.setSeqDocumentoItemServico(rs.getString("SEQ_DOCUMENTO_ITEM_SERVICO"));
/* 103 */         documentoItemServico.setSeqServicoEscopo(rs.getString("SEQ_SERVICO_ESCOPO"));
/* 104 */         documentoItemServico.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 105 */         documentoItemServico.setSituacao(rs.getString("SITUACAO"));
/* 106 */         documentoItemServico.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 107 */         documentoItemServico.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/* 108 */         documentoItemServico.setServicoEscopoNome(rs.getString("servicoEscopoNome"));
/* 109 */         documentoItemServico.setSeqColaborador(rs.getString("seq_colaborador"));
/* 110 */         documentoItemServico.setColaboradorNome(rs.getString("colaboradorNome"));
/* 111 */         listaDocumentoItemServico.add(documentoItemServico);
/*     */       }
/*     */       
/* 114 */       ps.execute();
/* 115 */       ps.close();
/*     */       
/* 117 */       return listaDocumentoItemServico;
/*     */     } catch (SQLException ex) {
/* 119 */       Logger.getLogger(DocumentoItemServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 120 */       System.out.println(ex.getMessage()); }
/* 121 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(DocumentoItemServico documentoItemServico)
/*     */   {
/*     */     try {
/* 127 */       Conexao conexao = new Conexao();
/* 128 */       Connection conn = Conexao.getConnection();
/* 129 */       String sql = "DELETE FROM DOCUMENTO_ITEM_SERVICO WHERE SEQ_DOCUMENTO_ITEM_SERVICO =  ? ";
/*     */       
/* 131 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 133 */       ps.setString(1, documentoItemServico.getSeqDocumentoItemServico());
/*     */       
/* 135 */       ps.execute();
/* 136 */       ps.close();
/*     */       
/* 138 */       return true;
/*     */     } catch (SQLException ex) {
/* 140 */       System.out.println(ex.getMessage()); }
/* 141 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemServico/DocumentoItemServicoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */