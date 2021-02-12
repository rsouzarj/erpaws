/*     */ package Departamento;
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
/*     */ public class DepartamentoDAO
/*     */ {
/*     */   public Departamento inserir(Departamento departamento)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_DEPARTAMENTO");
/*  28 */       departamento.setSeqDepartamento(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into DEPARTAMENTO (SEQ_DEPARTAMENTO,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,NOME) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, departamento.getSeqDepartamento());
/*  38 */       ps.setString(2, departamento.getSeqEmpresa());
/*  39 */       ps.setDate(3, new java.sql.Date(departamento.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, departamento.getSituacao());
/*  41 */       ps.setString(5, departamento.getNome());
/*     */       
/*  43 */       ps.execute();
/*  44 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  47 */       Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  48 */       System.out.println(ex.getMessage());
/*     */     }
/*  50 */     return departamento;
/*     */   }
/*     */   
/*     */   public Departamento alterar(Departamento departamento) {
/*     */     try {
/*  55 */       Conexao conexao = new Conexao();
/*  56 */       Connection conn = Conexao.getConnection();
/*  57 */       String sql = "update DEPARTAMENTO set SEQ_EMPRESA = ?,DATA_CADASTRO = ?,SITUACAO = ?,NOME = ? where SEQ_DEPARTAMENTO = ?";
/*     */       
/*  59 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  61 */       ps.setString(1, departamento.getSeqEmpresa());
/*  62 */       ps.setDate(2, new java.sql.Date(departamento.getDataCadastro().getTime()));
/*  63 */       ps.setString(3, departamento.getSituacao());
/*  64 */       ps.setString(4, departamento.getNome());
/*  65 */       ps.setString(5, departamento.getSeqDepartamento());
/*  66 */       ps.execute();
/*  67 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  70 */       Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  71 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  74 */     return departamento;
/*     */   }
/*     */   
/*     */   public List<Departamento> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  79 */       Conexao conexao = new Conexao();
/*  80 */       Connection conn = Conexao.getConnection();
/*  81 */       String sql = "SELECT * FROM DEPARTAMENTO" + sClausula.montarsClausula();
/*  82 */       System.out.println(sql);
/*     */       
/*  84 */       List<Departamento> listaDepartamento = new ArrayList();
/*  85 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  86 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  88 */       while (rs.next()) {
/*  89 */         Departamento departamento = new Departamento();
/*  90 */         departamento.setSeqDepartamento(rs.getString("SEQ_DEPARTAMENTO"));
/*  91 */         departamento.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/*  92 */         departamento.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  93 */         departamento.setSituacao(rs.getString("SITUACAO"));
/*  94 */         departamento.setNome(rs.getString("NOME"));
/*  95 */         listaDepartamento.add(departamento);
/*     */       }
/*     */       
/*  98 */       ps.execute();
/*  99 */       ps.close();
/*     */       
/* 101 */       return listaDepartamento;
/*     */     } catch (SQLException ex) {
/* 103 */       Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 104 */       System.out.println(ex.getMessage()); }
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(Departamento departamento)
/*     */   {
/*     */     try {
/* 111 */       Conexao conexao = new Conexao();
/* 112 */       Connection conn = Conexao.getConnection();
/* 113 */       String sql = "DELETE FROM DEPARTAMENTO WHERE SEQ_DEPARTAMENTO =  ? ";
/*     */       
/* 115 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 117 */       ps.setString(1, departamento.getSeqDepartamento());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Departamento/DepartamentoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */