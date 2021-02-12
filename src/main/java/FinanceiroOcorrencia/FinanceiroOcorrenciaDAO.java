/*     */ package FinanceiroOcorrencia;
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
/*     */ public class FinanceiroOcorrenciaDAO
/*     */ {
/*     */   public FinanceiroOcorrencia inserir(FinanceiroOcorrencia financeiroOcorrencia)
/*     */   {
/*     */     try
/*     */     {
/*  23 */       String seq = Sequence.buscarNumeroSequence("SEQ_FINANCEIRO_OCORRENCIA");
/*  24 */       financeiroOcorrencia.setSeqFinanceiroOcorrencia(seq);
/*  25 */       Conexao conexao = new Conexao();
/*  26 */       Connection conn = Conexao.getConnection();
/*  27 */       String sql = "insert into FINANCEIRO_OCORRENCIA (SEQ_FINANCEIRO_OCORRENCIA,DATA_CADASTRO,SEQ_FINANCEIRO,DESCRICAO,STATUS_ANTERIOR,STATUS_POSTERIOR,TIPO,SEQ_EMPRESA,SEQ_USUARIO) values  (?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  31 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  33 */       ps.setString(1, financeiroOcorrencia.getSeqFinanceiroOcorrencia());
/*     */       try
/*     */       {
/*  36 */         ps.setDate(2, new java.sql.Date(financeiroOcorrencia.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  38 */         ps.setDate(2, null);
/*     */       }
/*  40 */       ps.setString(3, financeiroOcorrencia.getSeqFinanceiro());
/*  41 */       ps.setString(4, financeiroOcorrencia.getDescricao());
/*  42 */       ps.setString(5, financeiroOcorrencia.getStatusAnterior());
/*  43 */       ps.setString(6, financeiroOcorrencia.getStatusPosterior());
/*  44 */       ps.setString(7, financeiroOcorrencia.getTipo());
/*  45 */       ps.setString(8, financeiroOcorrencia.getSeqEmpresa());
/*  46 */       ps.setString(9, financeiroOcorrencia.getSeqUsuario());
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(FinanceiroOcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return financeiroOcorrencia;
/*     */   }
/*     */   
/*     */   public FinanceiroOcorrencia alterar(FinanceiroOcorrencia financeiroOcorrencia) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update FINANCEIRO_OCORRENCIA set DATA_CADASTRO = ?,SEQ_FINANCEIRO = ?,DESCRICAO = ?,STATUS_ANTERIOR = ?,STATUS_POSTERIOR = ?,TIPO = ?,SEQ_EMPRESA = ?,SEQ_USUARIO = ? where SEQ_FINANCEIRO_OCORRENCIA = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       try
/*     */       {
/*  67 */         ps.setDate(1, new java.sql.Date(financeiroOcorrencia.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  69 */         ps.setDate(1, null);
/*     */       }
/*  71 */       ps.setString(2, financeiroOcorrencia.getSeqFinanceiro());
/*  72 */       ps.setString(3, financeiroOcorrencia.getDescricao());
/*  73 */       ps.setString(4, financeiroOcorrencia.getStatusAnterior());
/*  74 */       ps.setString(5, financeiroOcorrencia.getStatusPosterior());
/*  75 */       ps.setString(6, financeiroOcorrencia.getTipo());
/*  76 */       ps.setString(7, financeiroOcorrencia.getSeqEmpresa());
/*  77 */       ps.setString(8, financeiroOcorrencia.getSeqUsuario());
/*  78 */       ps.setString(9, financeiroOcorrencia.getSeqFinanceiroOcorrencia());
/*  79 */       ps.execute();
/*  80 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  83 */       Logger.getLogger(FinanceiroOcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  84 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  87 */     return financeiroOcorrencia;
/*     */   }
/*     */   
/*     */   public List<FinanceiroOcorrencia> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  92 */       Conexao conexao = new Conexao();
/*  93 */       Connection conn = Conexao.getConnection();
/*  94 */       String sql = "SELECT * FROM FINANCEIRO_OCORRENCIA" + sClausula.montarsClausula();
/*  95 */       System.out.println(sql);
/*     */       
/*  97 */       List<FinanceiroOcorrencia> listaFinanceiroOcorrencia = new ArrayList();
/*  98 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  99 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 101 */       while (rs.next()) {
/* 102 */         FinanceiroOcorrencia financeiroOcorrencia = new FinanceiroOcorrencia();
/* 103 */         financeiroOcorrencia.setSeqFinanceiroOcorrencia(rs.getString("SEQ_FINANCEIRO_OCORRENCIA"));
/* 104 */         financeiroOcorrencia.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 105 */         financeiroOcorrencia.setSeqFinanceiro(rs.getString("SEQ_FINANCEIRO"));
/* 106 */         financeiroOcorrencia.setDescricao(rs.getString("DESCRICAO"));
/* 107 */         financeiroOcorrencia.setStatusAnterior(rs.getString("STATUS_ANTERIOR"));
/* 108 */         financeiroOcorrencia.setStatusPosterior(rs.getString("STATUS_POSTERIOR"));
/* 109 */         financeiroOcorrencia.setTipo(rs.getString("TIPO"));
/* 110 */         financeiroOcorrencia.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 111 */         financeiroOcorrencia.setSeqUsuario(rs.getString("SEQ_USUARIO"));
/* 112 */         listaFinanceiroOcorrencia.add(financeiroOcorrencia);
/*     */       }
/*     */       
/* 115 */       ps.execute();
/* 116 */       ps.close();
/*     */       
/* 118 */       return listaFinanceiroOcorrencia;
/*     */     } catch (SQLException ex) {
/* 120 */       Logger.getLogger(FinanceiroOcorrenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 121 */       System.out.println(ex.getMessage()); }
/* 122 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(FinanceiroOcorrencia financeiroOcorrencia)
/*     */   {
/*     */     try {
/* 128 */       Conexao conexao = new Conexao();
/* 129 */       Connection conn = Conexao.getConnection();
/* 130 */       String sql = "DELETE FROM FINANCEIRO_OCORRENCIA WHERE SEQ_FINANCEIRO_OCORRENCIA =  ? ";
/*     */       
/* 132 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 134 */       ps.setString(1, financeiroOcorrencia.getSeqFinanceiroOcorrencia());
/*     */       
/* 136 */       ps.execute();
/* 137 */       ps.close();
/*     */       
/* 139 */       return true;
/*     */     } catch (SQLException ex) {
/* 141 */       System.out.println(ex.getMessage()); }
/* 142 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FinanceiroOcorrencia/FinanceiroOcorrenciaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */