/*     */ package MovimentoFinanceiro;
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
/*     */ public class MovimentoFinanceiroDAO
/*     */ {
/*     */   public MovimentoFinanceiro inserir(MovimentoFinanceiro movimentoFinanceiro)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_MOVIMENTO_FINANCEIRO");
/*  28 */       movimentoFinanceiro.setSeqMovimentoFinanceiro(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into MOVIMENTO_FINANCEIRO (SEQ_MOVIMENTO_FINANCEIRO,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,SEQ_TIPO_MOVIMENTO_FINANCEIRO,OPERACAO,DATA,VALOR) values  (?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, movimentoFinanceiro.getSeqMovimentoFinanceiro());
/*  38 */       ps.setString(2, movimentoFinanceiro.getSeqEmpresa());
/*  39 */       ps.setDate(3, new java.sql.Date(movimentoFinanceiro.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, movimentoFinanceiro.getSituacao());
/*  41 */       ps.setString(5, movimentoFinanceiro.getSeqTipoMovimentoFinanceiro());
/*  42 */       ps.setString(6, movimentoFinanceiro.getOperacao());
/*  43 */       ps.setDate(7, new java.sql.Date(movimentoFinanceiro.getData().getTime()));
/*  44 */       ps.setBigDecimal(8, movimentoFinanceiro.getValor());
/*     */       
/*  46 */       ps.execute();
/*  47 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  50 */       Logger.getLogger(MovimentoFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  51 */       System.out.println(ex.getMessage());
/*     */     }
/*  53 */     return movimentoFinanceiro;
/*     */   }
/*     */   
/*     */   public MovimentoFinanceiro alterar(MovimentoFinanceiro movimentoFinanceiro) {
/*     */     try {
/*  58 */       Conexao conexao = new Conexao();
/*  59 */       Connection conn = Conexao.getConnection();
/*  60 */       String sql = "update MOVIMENTO_FINANCEIRO set SEQ_EMPRESA = ?,DATA_CADASTRO = ?,SITUACAO = ?,SEQ_TIPO_MOVIMENTO_FINANCEIRO = ?,OPERACAO = ?,DATA = ?,VALOR = ? where SEQ_MOVIMENTO_FINANCEIRO = ?";
/*     */       
/*  62 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  64 */       ps.setString(1, movimentoFinanceiro.getSeqEmpresa());
/*  65 */       ps.setDate(2, new java.sql.Date(movimentoFinanceiro.getDataCadastro().getTime()));
/*  66 */       ps.setString(3, movimentoFinanceiro.getSituacao());
/*  67 */       ps.setString(4, movimentoFinanceiro.getSeqTipoMovimentoFinanceiro());
/*  68 */       ps.setString(5, movimentoFinanceiro.getOperacao());
/*  69 */       ps.setDate(6, new java.sql.Date(movimentoFinanceiro.getData().getTime()));
/*  70 */       ps.setBigDecimal(7, movimentoFinanceiro.getValor());
/*  71 */       ps.setString(8, movimentoFinanceiro.getSeqMovimentoFinanceiro());
/*  72 */       ps.execute();
/*  73 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  76 */       Logger.getLogger(MovimentoFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  77 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  80 */     return movimentoFinanceiro;
/*     */   }
/*     */   
/*     */   public List<MovimentoFinanceiro> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  85 */       Conexao conexao = new Conexao();
/*  86 */       Connection conn = Conexao.getConnection();
/*  87 */       String sql = "SELECT * FROM MOVIMENTO_FINANCEIRO" + sClausula.montarsClausula();
/*  88 */       System.out.println(sql);
/*     */       
/*  90 */       List<MovimentoFinanceiro> listaMovimentoFinanceiro = new ArrayList();
/*  91 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  92 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  94 */       while (rs.next()) {
/*  95 */         MovimentoFinanceiro movimentoFinanceiro = new MovimentoFinanceiro();
/*  96 */         movimentoFinanceiro.setSeqMovimentoFinanceiro(rs.getString("SEQ_MOVIMENTO_FINANCEIRO"));
/*  97 */         movimentoFinanceiro.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/*  98 */         movimentoFinanceiro.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  99 */         movimentoFinanceiro.setSituacao(rs.getString("SITUACAO"));
/* 100 */         movimentoFinanceiro.setSeqTipoMovimentoFinanceiro(rs.getString("SEQ_TIPO_MOVIMENTO_FINANCEIRO"));
/* 101 */         movimentoFinanceiro.setOperacao(rs.getString("OPERACAO"));
/* 102 */         movimentoFinanceiro.setData(rs.getDate("DATA"));
/* 103 */         movimentoFinanceiro.setValor(rs.getBigDecimal("VALOR"));
/* 104 */         listaMovimentoFinanceiro.add(movimentoFinanceiro);
/*     */       }
/*     */       
/* 107 */       ps.execute();
/* 108 */       ps.close();
/*     */       
/* 110 */       return listaMovimentoFinanceiro;
/*     */     } catch (SQLException ex) {
/* 112 */       Logger.getLogger(MovimentoFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 113 */       System.out.println(ex.getMessage()); }
/* 114 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(MovimentoFinanceiro movimentoFinanceiro)
/*     */   {
/*     */     try {
/* 120 */       Conexao conexao = new Conexao();
/* 121 */       Connection conn = Conexao.getConnection();
/* 122 */       String sql = "DELETE FROM MOVIMENTO_FINANCEIRO WHERE SEQ_MOVIMENTO_FINANCEIRO =  ? ";
/*     */       
/* 124 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 126 */       ps.setString(1, movimentoFinanceiro.getSeqMovimentoFinanceiro());
/*     */       
/* 128 */       ps.execute();
/* 129 */       ps.close();
/*     */       
/* 131 */       return true;
/*     */     } catch (SQLException ex) {
/* 133 */       System.out.println(ex.getMessage()); }
/* 134 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/MovimentoFinanceiro/MovimentoFinanceiroDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */