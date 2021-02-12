/*     */ package TipoUnidade;
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
/*     */ public class TipoUnidadeDAO
/*     */ {
/*     */   public TipoUnidade inserir(TipoUnidade tipoUnidade)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_TIPO_UNIDADE");
/*  28 */       tipoUnidade.setSeqTipoUnidade(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into TIPO_UNIDADE (SEQ_TIPO_UNIDADE,ABREVIATURA,SITUACAO,DESCRICAO,SEQ_EMPRESA,DATA_CADASTRO) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, tipoUnidade.getSeqTipoUnidade());
/*  38 */       ps.setString(2, tipoUnidade.getAbreviatura());
/*  39 */       ps.setString(3, tipoUnidade.getSituacao());
/*  40 */       ps.setString(4, tipoUnidade.getDescricao());
/*  41 */       ps.setString(5, tipoUnidade.getSeqEmpresa());
/*     */       try {
/*  43 */         ps.setDate(6, new java.sql.Date(tipoUnidade.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  45 */         ps.setDate(6, null);
/*     */       }
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(TipoUnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return tipoUnidade;
/*     */   }
/*     */   
/*     */   public TipoUnidade alterar(TipoUnidade tipoUnidade) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update TIPO_UNIDADE set ABREVIATURA = ?,SITUACAO = ?,DESCRICAO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ? where SEQ_TIPO_UNIDADE = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, tipoUnidade.getAbreviatura());
/*  67 */       ps.setString(2, tipoUnidade.getSituacao());
/*  68 */       ps.setString(3, tipoUnidade.getDescricao());
/*  69 */       ps.setString(4, tipoUnidade.getSeqEmpresa());
/*     */       try {
/*  71 */         ps.setDate(5, new java.sql.Date(tipoUnidade.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  73 */         ps.setDate(5, null);
/*     */       }
/*  75 */       ps.setString(6, tipoUnidade.getSeqTipoUnidade());
/*  76 */       ps.execute();
/*  77 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  80 */       Logger.getLogger(TipoUnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  81 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  84 */     return tipoUnidade;
/*     */   }
/*     */   
/*     */   public List<TipoUnidade> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  89 */       Conexao conexao = new Conexao();
/*  90 */       Connection conn = Conexao.getConnection();
/*  91 */       String sql = "SELECT * FROM TIPO_UNIDADE" + sClausula.montarsClausula() + "order by ABREVIATURA";
/*     */       
/*     */ 
/*  94 */       List<TipoUnidade> listaTipoUnidade = new ArrayList();
/*  95 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  96 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  98 */       while (rs.next()) {
/*  99 */         TipoUnidade tipoUnidade = new TipoUnidade();
/* 100 */         tipoUnidade.setSeqTipoUnidade(rs.getString("SEQ_TIPO_UNIDADE"));
/* 101 */         tipoUnidade.setAbreviatura(rs.getString("ABREVIATURA"));
/* 102 */         tipoUnidade.setSituacao(rs.getString("SITUACAO"));
/* 103 */         tipoUnidade.setDescricao(rs.getString("DESCRICAO"));
/* 104 */         tipoUnidade.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 105 */         tipoUnidade.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 106 */         listaTipoUnidade.add(tipoUnidade);
/*     */       }
/*     */       
/* 109 */       ps.execute();
/* 110 */       ps.close();
/*     */       
/* 112 */       return listaTipoUnidade;
/*     */     } catch (SQLException ex) {
/* 114 */       Logger.getLogger(TipoUnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 115 */       System.out.println(ex.getMessage()); }
/* 116 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(TipoUnidade tipoUnidade)
/*     */   {
/*     */     try {
/* 122 */       Conexao conexao = new Conexao();
/* 123 */       Connection conn = Conexao.getConnection();
/* 124 */       String sql = "DELETE FROM TIPO_UNIDADE WHERE SEQ_TIPO_UNIDADE =  ? ";
/*     */       
/* 126 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 128 */       ps.setString(1, tipoUnidade.getSeqTipoUnidade());
/*     */       
/* 130 */       ps.execute();
/* 131 */       ps.close();
/*     */       
/* 133 */       return true;
/*     */     } catch (SQLException ex) {
/* 135 */       System.out.println(ex.getMessage()); }
/* 136 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoUnidade/TipoUnidadeDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */