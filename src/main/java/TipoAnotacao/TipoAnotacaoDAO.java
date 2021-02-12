/*     */ package TipoAnotacao;
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
/*     */ public class TipoAnotacaoDAO
/*     */ {
/*     */   public TipoAnotacao inserir(TipoAnotacao tipoAnotacao)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_TIPO_ANOTACAO");
/*  28 */       tipoAnotacao.setSeqTipoAnotacao(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into TIPO_ANOTACAO (SEQ_TIPO_ANOTACAO,NOME,DATA_CADASTRO,SITUACAO,SEQ_EMPRESA) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, tipoAnotacao.getSeqTipoAnotacao());
/*  38 */       ps.setString(2, tipoAnotacao.getNome());
/*  39 */       ps.setDate(3, new java.sql.Date(tipoAnotacao.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, tipoAnotacao.getSituacao());
/*  41 */       ps.setString(5, tipoAnotacao.getSeqEmpresa());
/*     */       
/*  43 */       ps.execute();
/*  44 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  47 */       Logger.getLogger(TipoAnotacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  48 */       System.out.println(ex.getMessage());
/*     */     }
/*  50 */     return tipoAnotacao;
/*     */   }
/*     */   
/*     */   public TipoAnotacao alterar(TipoAnotacao tipoAnotacao) {
/*     */     try {
/*  55 */       Conexao conexao = new Conexao();
/*  56 */       Connection conn = Conexao.getConnection();
/*  57 */       String sql = "update TIPO_ANOTACAO set NOME = ?,DATA_CADASTRO = ?,SITUACAO = ?,SEQ_EMPRESA = ? where SEQ_TIPO_ANOTACAO = ?";
/*     */       
/*  59 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  61 */       ps.setString(1, tipoAnotacao.getNome());
/*  62 */       ps.setDate(2, new java.sql.Date(tipoAnotacao.getDataCadastro().getTime()));
/*  63 */       ps.setString(3, tipoAnotacao.getSituacao());
/*  64 */       ps.setString(4, tipoAnotacao.getSeqEmpresa());
/*  65 */       ps.setString(5, tipoAnotacao.getSeqTipoAnotacao());
/*  66 */       ps.execute();
/*  67 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  70 */       Logger.getLogger(TipoAnotacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  71 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  74 */     return tipoAnotacao;
/*     */   }
/*     */   
/*     */   public List<TipoAnotacao> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  79 */       Conexao conexao = new Conexao();
/*  80 */       Connection conn = Conexao.getConnection();
/*  81 */       String sql = "SELECT * FROM TIPO_ANOTACAO" + sClausula.montarsClausula();
/*  82 */       System.out.println(sql);
/*     */       
/*  84 */       List<TipoAnotacao> listaTipoAnotacao = new ArrayList();
/*  85 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  86 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  88 */       while (rs.next()) {
/*  89 */         TipoAnotacao tipoAnotacao = new TipoAnotacao();
/*  90 */         tipoAnotacao.setSeqTipoAnotacao(rs.getString("SEQ_TIPO_ANOTACAO"));
/*  91 */         tipoAnotacao.setNome(rs.getString("NOME"));
/*  92 */         tipoAnotacao.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  93 */         tipoAnotacao.setSituacao(rs.getString("SITUACAO"));
/*  94 */         tipoAnotacao.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/*  95 */         listaTipoAnotacao.add(tipoAnotacao);
/*     */       }
/*     */       
/*  98 */       ps.execute();
/*  99 */       ps.close();
/*     */       
/* 101 */       return listaTipoAnotacao;
/*     */     } catch (SQLException ex) {
/* 103 */       Logger.getLogger(TipoAnotacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 104 */       System.out.println(ex.getMessage()); }
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(TipoAnotacao tipoAnotacao)
/*     */   {
/*     */     try {
/* 111 */       Conexao conexao = new Conexao();
/* 112 */       Connection conn = Conexao.getConnection();
/* 113 */       String sql = "DELETE FROM TIPO_ANOTACAO WHERE SEQ_TIPO_ANOTACAO =  ? ";
/*     */       
/* 115 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 117 */       ps.setString(1, tipoAnotacao.getSeqTipoAnotacao());
/*     */       
/* 119 */       ps.execute();
/* 120 */       ps.close();
/*     */       
/* 122 */       return true;
/*     */     } catch (SQLException ex) {
/* 124 */       System.out.println(ex.getMessage()); }
/* 125 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoAnotacao/TipoAnotacaoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */