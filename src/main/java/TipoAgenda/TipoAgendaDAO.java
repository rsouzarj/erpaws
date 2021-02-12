/*     */ package TipoAgenda;
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
/*     */ public class TipoAgendaDAO
/*     */ {
/*     */   public TipoAgenda inserir(TipoAgenda tipoAgenda)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_TIPO_AGENDA");
/*  28 */       tipoAgenda.setSeqTipoAgenda(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into TIPO_AGENDA (SEQ_TIPO_AGENDA,NOME,DATA_CADASTRO,SITUACAO,SEQ_EMPRESA) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, tipoAgenda.getSeqTipoAgenda());
/*  38 */       ps.setString(2, tipoAgenda.getNome());
/*  39 */       ps.setDate(3, new java.sql.Date(tipoAgenda.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, tipoAgenda.getSituacao());
/*  41 */       ps.setString(5, tipoAgenda.getSeqEmpresa());
/*     */       
/*  43 */       ps.execute();
/*  44 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  47 */       Logger.getLogger(TipoAgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  48 */       System.out.println(ex.getMessage());
/*     */     }
/*  50 */     return tipoAgenda;
/*     */   }
/*     */   
/*     */   public TipoAgenda alterar(TipoAgenda tipoAgenda) {
/*     */     try {
/*  55 */       Conexao conexao = new Conexao();
/*  56 */       Connection conn = Conexao.getConnection();
/*  57 */       String sql = "update TIPO_AGENDA set NOME = ?,DATA_CADASTRO = ?,SITUACAO = ?,SEQ_EMPRESA = ? where SEQ_TIPO_AGENDA = ?";
/*     */       
/*  59 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  61 */       ps.setString(1, tipoAgenda.getNome());
/*  62 */       ps.setDate(2, new java.sql.Date(tipoAgenda.getDataCadastro().getTime()));
/*  63 */       ps.setString(3, tipoAgenda.getSituacao());
/*  64 */       ps.setString(4, tipoAgenda.getSeqEmpresa());
/*  65 */       ps.setString(5, tipoAgenda.getSeqTipoAgenda());
/*  66 */       ps.execute();
/*  67 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  70 */       Logger.getLogger(TipoAgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  71 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  74 */     return tipoAgenda;
/*     */   }
/*     */   
/*     */   public List<TipoAgenda> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  79 */       Conexao conexao = new Conexao();
/*  80 */       Connection conn = Conexao.getConnection();
/*  81 */       String sql = "SELECT * FROM TIPO_AGENDA" + sClausula.montarsClausula();
/*  82 */       System.out.println(sql);
/*     */       
/*  84 */       List<TipoAgenda> listaTipoAgenda = new ArrayList();
/*  85 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  86 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  88 */       while (rs.next()) {
/*  89 */         TipoAgenda tipoAgenda = new TipoAgenda();
/*  90 */         tipoAgenda.setSeqTipoAgenda(rs.getString("SEQ_TIPO_AGENDA"));
/*  91 */         tipoAgenda.setNome(rs.getString("NOME"));
/*  92 */         tipoAgenda.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  93 */         tipoAgenda.setSituacao(rs.getString("SITUACAO"));
/*  94 */         tipoAgenda.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/*  95 */         listaTipoAgenda.add(tipoAgenda);
/*     */       }
/*     */       
/*  98 */       ps.execute();
/*  99 */       ps.close();
/*     */       
/* 101 */       return listaTipoAgenda;
/*     */     } catch (SQLException ex) {
/* 103 */       Logger.getLogger(TipoAgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 104 */       System.out.println(ex.getMessage()); }
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(TipoAgenda tipoAgenda)
/*     */   {
/*     */     try {
/* 111 */       Conexao conexao = new Conexao();
/* 112 */       Connection conn = Conexao.getConnection();
/* 113 */       String sql = "DELETE FROM TIPO_AGENDA WHERE SEQ_TIPO_AGENDA =  ? ";
/*     */       
/* 115 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 117 */       ps.setString(1, tipoAgenda.getSeqTipoAgenda());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoAgenda/TipoAgendaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */