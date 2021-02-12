/*     */ package TipoColaborador;
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
/*     */ public class TipoColaboradorDAO
/*     */ {
/*     */   public TipoColaborador inserir(TipoColaborador tipoColaborador)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_TIPO_COLABORADOR");
/*  28 */       tipoColaborador.setSeqTipoColaborador(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into TIPO_COLABORADOR (SEQ_TIPO_COLABORADOR,NOME,DATA_CADASTRO,SEQ_EMPRESA,SITUACAO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, tipoColaborador.getSeqTipoColaborador());
/*  38 */       ps.setString(2, tipoColaborador.getNome());
/*     */       try {
/*  40 */         ps.setDate(3, new java.sql.Date(tipoColaborador.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  42 */         ps.setDate(3, null);
/*     */       }
/*  44 */       ps.setString(4, tipoColaborador.getSeqEmpresa());
/*  45 */       ps.setString(5, tipoColaborador.getSituacao());
/*     */       
/*  47 */       ps.execute();
/*  48 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  51 */       Logger.getLogger(TipoColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  52 */       System.out.println(ex.getMessage());
/*     */     }
/*  54 */     return tipoColaborador;
/*     */   }
/*     */   
/*     */   public TipoColaborador alterar(TipoColaborador tipoColaborador) {
/*     */     try {
/*  59 */       Conexao conexao = new Conexao();
/*  60 */       Connection conn = Conexao.getConnection();
/*  61 */       String sql = "update TIPO_COLABORADOR set NOME = ?,DATA_CADASTRO = ?,SEQ_EMPRESA = ?,SITUACAO = ? where SEQ_TIPO_COLABORADOR = ?";
/*     */       
/*  63 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  65 */       ps.setString(1, tipoColaborador.getNome());
/*     */       try {
/*  67 */         ps.setDate(2, new java.sql.Date(tipoColaborador.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  69 */         ps.setDate(2, null);
/*     */       }
/*  71 */       ps.setString(3, tipoColaborador.getSeqEmpresa());
/*  72 */       ps.setString(4, tipoColaborador.getSituacao());
/*  73 */       ps.setString(5, tipoColaborador.getSeqTipoColaborador());
/*  74 */       ps.execute();
/*  75 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  78 */       Logger.getLogger(TipoColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  79 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  82 */     return tipoColaborador;
/*     */   }
/*     */   
/*     */   public List<TipoColaborador> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  87 */       Conexao conexao = new Conexao();
/*  88 */       Connection conn = Conexao.getConnection();
/*  89 */       String sql = "SELECT * FROM TIPO_COLABORADOR" + sClausula.montarsClausula();
/*  90 */       System.out.println(sql);
/*     */       
/*  92 */       List<TipoColaborador> listaTipoColaborador = new ArrayList();
/*  93 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  94 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  96 */       while (rs.next()) {
/*  97 */         TipoColaborador tipoColaborador = new TipoColaborador();
/*  98 */         tipoColaborador.setSeqTipoColaborador(rs.getString("SEQ_TIPO_COLABORADOR"));
/*  99 */         tipoColaborador.setNome(rs.getString("NOME"));
/* 100 */         tipoColaborador.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 101 */         tipoColaborador.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         tipoColaborador.setSituacao(rs.getString("SITUACAO"));
/* 103 */         listaTipoColaborador.add(tipoColaborador);
/*     */       }
/*     */       
/* 106 */       ps.execute();
/* 107 */       ps.close();
/*     */       
/* 109 */       return listaTipoColaborador;
/*     */     } catch (SQLException ex) {
/* 111 */       Logger.getLogger(TipoColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 112 */       System.out.println(ex.getMessage()); }
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(TipoColaborador tipoColaborador)
/*     */   {
/*     */     try {
/* 119 */       Conexao conexao = new Conexao();
/* 120 */       Connection conn = Conexao.getConnection();
/* 121 */       String sql = "DELETE FROM TIPO_COLABORADOR WHERE SEQ_TIPO_COLABORADOR =  ? ";
/*     */       
/* 123 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 125 */       ps.setString(1, tipoColaborador.getSeqTipoColaborador());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoColaborador/TipoColaboradorDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */