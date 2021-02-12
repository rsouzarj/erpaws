/*     */ package DocumentoOcorrencia;
/*     */ 
/*     */ import ClausulaSQL.ClausulaWhere;
/*     */ import Util.Conexao;
/*     */ import Util.Sequence;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.SimpleDateFormat;
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
/*     */ public class DocumentoOcorrenciaDAO
/*     */ {
/*     */   public DocumentoOcorrencia inserir(DocumentoOcorrencia documentoOcorrencia)
/*     */   {
/*     */     try
/*     */     {
/*  30 */       String seq = Sequence.buscarNumeroSequence("SEQ_DOCUMENTO_OCORRENCIA");
/*  31 */       documentoOcorrencia.setSeqDocumentoOcorrencia(seq);
/*  32 */       Conexao conexao = new Conexao();
/*  33 */       Connection conn = Conexao.getConnection();
/*  34 */       String sql = "insert into DOCUMENTO_OCORRENCIA (SEQ_DOCUMENTO_OCORRENCIA,SEQ_DOCUMENTO,DATA,DATA_CADASTRO,SEQ_USUARIO,SEQ_DOCUMENTO_ETAPA_ANTERIOR,SEQ_DOCUMENTO_ETAPA_POSTERIOR,TIPO,DESCRICAO) values  (?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  38 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  40 */       ps.setString(1, documentoOcorrencia.getSeqDocumentoOcorrencia());
/*  41 */       ps.setString(2, documentoOcorrencia.getSeqDocumento());
/*  42 */       ps.setDate(3, new java.sql.Date(documentoOcorrencia.getData().getTime()));
/*     */       
/*  44 */       Timestamp data = new Timestamp(documentoOcorrencia.getDataCadastro().getTime());
/*  45 */       ps.setTimestamp(4, data);
/*     */       
/*  47 */       ps.setString(5, documentoOcorrencia.getSeqUsuario());
/*  48 */       ps.setObject(6, documentoOcorrencia.getSeqDocumentoEtapaAnterior());
/*  49 */       ps.setObject(7, documentoOcorrencia.getSeqDocumentoEtapaPosterior());
/*  50 */       ps.setString(8, documentoOcorrencia.getTipo());
/*  51 */       ps.setString(9, documentoOcorrencia.getDescricao());
/*     */       
/*  53 */       ps.execute();
/*  54 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  57 */       Logger.getLogger(DocumentoOcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  58 */       System.out.println(ex.getMessage());
/*     */     }
/*  60 */     return documentoOcorrencia;
/*     */   }
/*     */   
/*     */   public DocumentoOcorrencia alterar(DocumentoOcorrencia documentoOcorrencia) {
/*     */     try {
/*  65 */       Conexao conexao = new Conexao();
/*  66 */       Connection conn = Conexao.getConnection();
/*  67 */       String sql = "update DOCUMENTO_OCORRENCIA set SEQ_DOCUMENTO = ?,DATA = ?,DATA_CADASTRO = ?,SEQ_USUARIO = ?,SEQ_DOCUMENTO_ETAPA_ANTERIOR = ?,SEQ_DOCUMENTO_ETAPA_POSTERIOR = ?,TIPO = ?,DESCRICAO = ? where SEQ_DOCUMENTO_OCORRENCIA = ?";
/*     */       
/*  69 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  71 */       ps.setString(1, documentoOcorrencia.getSeqDocumento());
/*  72 */       ps.setDate(2, new java.sql.Date(documentoOcorrencia.getData().getTime()));
/*  73 */       ps.setDate(3, new java.sql.Date(documentoOcorrencia.getDataCadastro().getTime()));
/*  74 */       ps.setString(4, documentoOcorrencia.getSeqUsuario());
/*  75 */       ps.setString(5, documentoOcorrencia.getSeqDocumentoEtapaAnterior());
/*  76 */       ps.setString(6, documentoOcorrencia.getSeqDocumentoEtapaPosterior());
/*  77 */       ps.setString(7, documentoOcorrencia.getTipo());
/*  78 */       ps.setString(8, documentoOcorrencia.getDescricao());
/*  79 */       ps.setString(9, documentoOcorrencia.getSeqDocumentoOcorrencia());
/*  80 */       ps.execute();
/*  81 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  84 */       Logger.getLogger(DocumentoOcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  85 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  88 */     return documentoOcorrencia;
/*     */   }
/*     */   
/*     */   public List<DocumentoOcorrencia> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  93 */       Conexao conexao = new Conexao();
/*  94 */       Connection conn = Conexao.getConnection();
/*  95 */       String sql = "SELECT \nDOCUMENTO_OCORRENCIA.*,\nusuario.usuario,\ndocumento_etapa1.nome etapa_anterior,\ndocumento_etapa2.nome etapa_posterior\nFROM \nDOCUMENTO_OCORRENCIA\nleft join usuario on usuario.seq_usuario = DOCUMENTO_OCORRENCIA.seq_usuario\nleft join documento_etapa documento_etapa1 on documento_etapa1.seq_documento_etapa = DOCUMENTO_OCORRENCIA.seq_documento_etapa_anterior\nleft join documento_etapa documento_etapa2 on documento_etapa2.seq_documento_etapa = DOCUMENTO_OCORRENCIA.seq_documento_etapa_posterior\n" + sClausula.montarsClausula();
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
/*     */ 
/*     */ 
/* 108 */       List<DocumentoOcorrencia> listaDocumentoOcorrencia = new ArrayList();
/* 109 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 110 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 112 */       while (rs.next()) {
/* 113 */         DocumentoOcorrencia documentoOcorrencia = new DocumentoOcorrencia();
/* 114 */         documentoOcorrencia.setSeqDocumentoOcorrencia(rs.getString("SEQ_DOCUMENTO_OCORRENCIA"));
/* 115 */         documentoOcorrencia.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/* 116 */         documentoOcorrencia.setData(rs.getDate("DATA"));
/* 117 */         documentoOcorrencia.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 118 */         documentoOcorrencia.setSeqUsuario(rs.getString("SEQ_USUARIO"));
/* 119 */         documentoOcorrencia.setSeqDocumentoEtapaAnterior(rs.getString("SEQ_DOCUMENTO_ETAPA_ANTERIOR"));
/* 120 */         documentoOcorrencia.setSeqDocumentoEtapaPosterior(rs.getString("SEQ_DOCUMENTO_ETAPA_POSTERIOR"));
/* 121 */         documentoOcorrencia.setTipo(rs.getString("TIPO"));
/* 122 */         documentoOcorrencia.setDescricao(rs.getString("DESCRICAO"));
/*     */         
/* 124 */         java.util.Date data = rs.getTimestamp("DATA_CADASTRO");
/* 125 */         String dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
/*     */         
/* 127 */         documentoOcorrencia.setDataFmt(dataFormatada);
/* 128 */         documentoOcorrencia.setUsuario(rs.getString("USUARIO"));
/* 129 */         documentoOcorrencia.setEtapaAnterior(rs.getString("ETAPA_ANTERIOR"));
/* 130 */         documentoOcorrencia.setEtapaPosterior(rs.getString("ETAPA_POSTERIOR"));
/*     */         
/* 132 */         listaDocumentoOcorrencia.add(documentoOcorrencia);
/*     */       }
/*     */       
/* 135 */       ps.execute();
/* 136 */       ps.close();
/*     */       
/* 138 */       return listaDocumentoOcorrencia;
/*     */     } catch (SQLException ex) {
/* 140 */       Logger.getLogger(DocumentoOcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 141 */       System.out.println(ex.getMessage()); }
/* 142 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(DocumentoOcorrencia documentoOcorrencia)
/*     */   {
/*     */     try {
/* 148 */       Conexao conexao = new Conexao();
/* 149 */       Connection conn = Conexao.getConnection();
/* 150 */       String sql = "DELETE FROM DOCUMENTO_OCORRENCIA WHERE SEQ_DOCUMENTO_OCORRENCIA =  ? ";
/*     */       
/* 152 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 154 */       ps.setString(1, documentoOcorrencia.getSeqDocumentoOcorrencia());
/*     */       
/* 156 */       ps.execute();
/* 157 */       ps.close();
/*     */       
/* 159 */       return true;
/*     */     } catch (SQLException ex) {
/* 161 */       System.out.println(ex.getMessage()); }
/* 162 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoOcorrencia/DocumentoOcorrenciaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */