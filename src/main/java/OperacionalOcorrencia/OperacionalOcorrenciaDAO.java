/*     */ package OperacionalOcorrencia;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OperacionalOcorrenciaDAO
/*     */ {
/*     */   public OperacionalOcorrencia inserir(OperacionalOcorrencia operacionalOcorrencia)
/*     */   {
/*     */     try
/*     */     {
/*  33 */       String seq = Sequence.buscarNumeroSequence("SEQ_OP_OCORRENCIA");
/*  34 */       operacionalOcorrencia.setSeqOperacionalOcorrencia(seq);
/*  35 */       Conexao conexao = new Conexao();
/*  36 */       Connection conn = Conexao.getConnection();
/*  37 */       String sql = "insert into OPERACIONAL_OCORRENCIA (SEQ_OP_OCORRENCIA,SEQ_OPERACIONAL,DATA,DATA_CADASTRO,SEQ_USUARIO,SEQ_OP_ETAPA_ANTERIOR,SEQ_OP_ETAPA_POSTERIOR,TIPO,DESCRICAO) values  (?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  41 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  43 */       ps.setString(1, operacionalOcorrencia.getSeqOperacionalOcorrencia());
/*  44 */       ps.setString(2, operacionalOcorrencia.getSeqOperacional());
/*  45 */       ps.setDate(3, new java.sql.Date(operacionalOcorrencia.getData().getTime()));
/*     */       
/*  47 */       Timestamp data = new Timestamp(operacionalOcorrencia.getDataCadastro().getTime());
/*  48 */       ps.setTimestamp(4, data);
/*     */       
/*  50 */       ps.setString(5, operacionalOcorrencia.getSeqUsuario());
/*  51 */       ps.setObject(6, operacionalOcorrencia.getSeqOperacionalEtapaAnterior());
/*  52 */       ps.setObject(7, operacionalOcorrencia.getSeqOperacionalEtapaPosterior());
/*  53 */       ps.setString(8, operacionalOcorrencia.getTipo());
/*  54 */       ps.setString(9, operacionalOcorrencia.getDescricao());
/*     */       
/*  56 */       ps.execute();
/*  57 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  60 */       Logger.getLogger(OperacionalOcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  61 */       System.out.println(ex.getMessage());
/*     */     }
/*  63 */     return operacionalOcorrencia;
/*     */   }
/*     */   
/*     */   public OperacionalOcorrencia alterar(OperacionalOcorrencia operacionalOcorrencia) {
/*     */     try {
/*  68 */       Conexao conexao = new Conexao();
/*  69 */       Connection conn = Conexao.getConnection();
/*  70 */       String sql = "update OPERACIONAL_OCORRENCIA set SEQ_OPERACIONAL = ?,DATA = ?,DATA_CADASTRO = ?,SEQ_USUARIO = ?,SEQ_OPERACIONAL_ETAPA_ANTERIOR = ?,SEQ_OPERACIONAL_ETAPA_POSTERIOR = ?,TIPO = ?,DESCRICAO = ? where SEQ_OPERACIONAL_OCORRENCIA = ?";
/*     */       
/*  72 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  74 */       ps.setString(1, operacionalOcorrencia.getSeqOperacional());
/*  75 */       ps.setDate(2, new java.sql.Date(operacionalOcorrencia.getData().getTime()));
/*  76 */       ps.setDate(3, new java.sql.Date(operacionalOcorrencia.getDataCadastro().getTime()));
/*  77 */       ps.setString(4, operacionalOcorrencia.getSeqUsuario());
/*  78 */       ps.setString(5, operacionalOcorrencia.getSeqOperacionalEtapaAnterior());
/*  79 */       ps.setString(6, operacionalOcorrencia.getSeqOperacionalEtapaPosterior());
/*  80 */       ps.setString(7, operacionalOcorrencia.getTipo());
/*  81 */       ps.setString(8, operacionalOcorrencia.getDescricao());
/*  82 */       ps.setString(9, operacionalOcorrencia.getSeqOperacionalOcorrencia());
/*  83 */       ps.execute();
/*  84 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  87 */       Logger.getLogger(OperacionalOcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  88 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  91 */     return operacionalOcorrencia;
/*     */   }
/*     */   
/*     */   public List<OperacionalOcorrencia> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  96 */       Conexao conexao = new Conexao();
/*  97 */       Connection conn = Conexao.getConnection();
/*  98 */       String sql = "SELECT \nOPERACIONAL_OCORRENCIA.*,\nusuario.usuario,\noperacional_etapa1.nome etapa_anterior,\noperacional_etapa2.nome etapa_posterior\nFROM \nOPERACIONAL_OCORRENCIA\nleft join usuario on usuario.seq_usuario = OPERACIONAL_OCORRENCIA.seq_usuario\nleft join operacional_etapa operacional_etapa1 on operacional_etapa1.seq_operacional_etapa = OPERACIONAL_OCORRENCIA.seq_operacional_etapa_anterior\nleft join operacional_etapa operacional_etapa2 on operacional_etapa2.seq_operacional_etapa = OPERACIONAL_OCORRENCIA.seq_operacional_etapa_posterior\n" + sClausula.montarsClausula();
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
/* 111 */       List<OperacionalOcorrencia> listaOperacionalOcorrencia = new ArrayList();
/* 112 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 113 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 115 */       while (rs.next()) {
/* 116 */         OperacionalOcorrencia operacionalOcorrencia = new OperacionalOcorrencia();
/* 117 */         operacionalOcorrencia.setSeqOperacionalOcorrencia(rs.getString("SEQ_OP_OCORRENCIA"));
/* 118 */         operacionalOcorrencia.setSeqOperacional(rs.getString("SEQ_Operacinal"));
/* 119 */         operacionalOcorrencia.setData(rs.getDate("DATA"));
/* 120 */         operacionalOcorrencia.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 121 */         operacionalOcorrencia.setSeqUsuario(rs.getString("SEQ_USUARIO"));
/* 122 */         operacionalOcorrencia.setSeqOperacionalEtapaAnterior(rs.getString("SEQ_OPERACIONAL_ETAPA_ANTERIOR"));
/* 123 */         operacionalOcorrencia.setSeqOperacionalEtapaPosterior(rs.getString("SEQ_OPERACIONAL_ETAPA_POSTERIOR"));
/* 124 */         operacionalOcorrencia.setTipo(rs.getString("TIPO"));
/* 125 */         operacionalOcorrencia.setDescricao(rs.getString("DESCRICAO"));
/*     */         
/* 127 */         java.util.Date data = rs.getTimestamp("DATA_CADASTRO");
/* 128 */         String dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
/*     */         
/* 130 */         operacionalOcorrencia.setDataFmt(dataFormatada);
/* 131 */         operacionalOcorrencia.setUsuario(rs.getString("USUARIO"));
/* 132 */         operacionalOcorrencia.setEtapaAnterior(rs.getString("ETAPA_ANTERIOR"));
/* 133 */         operacionalOcorrencia.setEtapaPosterior(rs.getString("ETAPA_POSTERIOR"));
/*     */         
/* 135 */         listaOperacionalOcorrencia.add(operacionalOcorrencia);
/*     */       }
/*     */       
/* 138 */       ps.execute();
/* 139 */       ps.close();
/*     */       
/* 141 */       return listaOperacionalOcorrencia;
/*     */     } catch (SQLException ex) {
/* 143 */       Logger.getLogger(OperacionalOcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 144 */       System.out.println(ex.getMessage()); }
/* 145 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(OperacionalOcorrencia operacionalOcorrencia)
/*     */   {
/*     */     try {
/* 151 */       Conexao conexao = new Conexao();
/* 152 */       Connection conn = Conexao.getConnection();
/* 153 */       String sql = "DELETE FROM OPERACIONAL_OCORRENCIA WHERE SEQ_OP_OCORRENCIA =  ? ";
/*     */       
/* 155 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 157 */       ps.setString(1, operacionalOcorrencia.getSeqOperacionalOcorrencia());
/*     */       
/* 159 */       ps.execute();
/* 160 */       ps.close();
/*     */       
/* 162 */       return true;
/*     */     } catch (SQLException ex) {
/* 164 */       System.out.println(ex.getMessage()); }
/* 165 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/OperacionalOcorrencia/OperacionalOcorrenciaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */