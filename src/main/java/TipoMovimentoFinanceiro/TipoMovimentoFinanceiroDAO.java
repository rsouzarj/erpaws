/*     */ package TipoMovimentoFinanceiro;
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
/*     */ public class TipoMovimentoFinanceiroDAO
/*     */ {
/*     */   public TipoMovimentoFinanceiro inserir(TipoMovimentoFinanceiro tipoMovimentoFinanceiro)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_TIPO_MOVIMENTO_FINANCEIRO");
/*  28 */       tipoMovimentoFinanceiro.setSeqTipoMovimentoFinanceiro(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into TIPO_MOVIMENTO_FINANCEIRO (SEQ_TIPO_MOVIMENTO_FINANCEIRO,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,NOME,OPERACAO,seq_financeiro_categoria) values  (?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, tipoMovimentoFinanceiro.getSeqTipoMovimentoFinanceiro());
/*  38 */       ps.setString(2, tipoMovimentoFinanceiro.getSeqEmpresa());
/*  39 */       ps.setDate(3, new java.sql.Date(tipoMovimentoFinanceiro.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, tipoMovimentoFinanceiro.getSituacao());
/*  41 */       ps.setString(5, tipoMovimentoFinanceiro.getNome());
/*  42 */       ps.setString(6, tipoMovimentoFinanceiro.getOperacao());
/*  43 */       ps.setString(7, tipoMovimentoFinanceiro.getSeqFinanceiroCategoria());
/*     */       
/*  45 */       ps.execute();
/*  46 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  49 */       Logger.getLogger(TipoMovimentoFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  50 */       System.out.println(ex.getMessage());
/*     */     }
/*  52 */     return tipoMovimentoFinanceiro;
/*     */   }
/*     */   
/*     */   public TipoMovimentoFinanceiro alterar(TipoMovimentoFinanceiro tipoMovimentoFinanceiro) {
/*     */     try {
/*  57 */       Conexao conexao = new Conexao();
/*  58 */       Connection conn = Conexao.getConnection();
/*  59 */       String sql = "update TIPO_MOVIMENTO_FINANCEIRO set SEQ_EMPRESA = ?,DATA_CADASTRO = ?,SITUACAO = ?,NOME = ?,OPERACAO = ?, seq_financeiro_categoria = ? where SEQ_TIPO_MOVIMENTO_FINANCEIRO = ?";
/*     */       
/*  61 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  63 */       ps.setString(1, tipoMovimentoFinanceiro.getSeqEmpresa());
/*  64 */       ps.setDate(2, new java.sql.Date(tipoMovimentoFinanceiro.getDataCadastro().getTime()));
/*  65 */       ps.setString(3, tipoMovimentoFinanceiro.getSituacao());
/*  66 */       ps.setString(4, tipoMovimentoFinanceiro.getNome());
/*  67 */       ps.setString(5, tipoMovimentoFinanceiro.getOperacao());
/*  68 */       ps.setString(6, tipoMovimentoFinanceiro.getSeqFinanceiroCategoria());
/*  69 */       ps.setString(7, tipoMovimentoFinanceiro.getSeqTipoMovimentoFinanceiro());
/*  70 */       ps.execute();
/*  71 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  74 */       Logger.getLogger(TipoMovimentoFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  75 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  78 */     return tipoMovimentoFinanceiro;
/*     */   }
/*     */   
/*     */   public List<TipoMovimentoFinanceiro> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  83 */       Conexao conexao = new Conexao();
/*  84 */       Connection conn = Conexao.getConnection();
/*  85 */       String sql = "SELECT TIPO_MOVIMENTO_FINANCEIRO.*, FINANCEIRO_CATEGORIA.NOME nomeFinanceiroCategoria  FROM TIPO_MOVIMENTO_FINANCEIRO INNER JOIN FINANCEIRO_CATEGORIA ON FINANCEIRO_CATEGORIA.SEQ_FINANCEIRO_CATEGORIA = TIPO_MOVIMENTO_FINANCEIRO.SEQ_FINANCEIRO_CATEGORIA " + sClausula.montarsClausula() + " order by TIPO_MOVIMENTO_FINANCEIRO.nome asc";

/*  94 */       List<TipoMovimentoFinanceiro> listaTipoMovimentoFinanceiro = new ArrayList();
/*  95 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  96 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  98 */       while (rs.next()) {
/*  99 */         TipoMovimentoFinanceiro tipoMovimentoFinanceiro = new TipoMovimentoFinanceiro();
/* 100 */         tipoMovimentoFinanceiro.setSeqTipoMovimentoFinanceiro(rs.getString("SEQ_TIPO_MOVIMENTO_FINANCEIRO"));
/* 101 */         tipoMovimentoFinanceiro.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         tipoMovimentoFinanceiro.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 103 */         tipoMovimentoFinanceiro.setSituacao(rs.getString("SITUACAO"));
/* 104 */         tipoMovimentoFinanceiro.setNome(rs.getString("NOME"));
/* 105 */         tipoMovimentoFinanceiro.setOperacao(rs.getString("OPERACAO"));
/* 106 */         tipoMovimentoFinanceiro.setSeqFinanceiroCategoria(rs.getString("seq_financeiro_categoria"));
/* 107 */         tipoMovimentoFinanceiro.setNomeFinanceiroCategoria(rs.getString("nomeFinanceiroCategoria"));
/* 108 */         listaTipoMovimentoFinanceiro.add(tipoMovimentoFinanceiro);
/*     */       }
/*     */       
/* 111 */       ps.execute();
/* 112 */       ps.close();
/*     */       
/* 114 */       return listaTipoMovimentoFinanceiro;
/*     */     } catch (SQLException ex) {
/* 116 */       Logger.getLogger(TipoMovimentoFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 117 */       System.out.println(ex.getMessage()); }
/* 118 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(TipoMovimentoFinanceiro tipoMovimentoFinanceiro)
/*     */   {
/*     */     try {
/* 124 */       Conexao conexao = new Conexao();
/* 125 */       Connection conn = Conexao.getConnection();
/* 126 */       String sql = "DELETE FROM TIPO_MOVIMENTO_FINANCEIRO WHERE SEQ_TIPO_MOVIMENTO_FINANCEIRO =  ? ";
/*     */       
/* 128 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 130 */       ps.setString(1, tipoMovimentoFinanceiro.getSeqTipoMovimentoFinanceiro());
/*     */       
/* 132 */       ps.execute();
/* 133 */       ps.close();
/*     */       
/* 135 */       return true;
/*     */     } catch (SQLException ex) {
/* 137 */       System.out.println(ex.getMessage()); }
/* 138 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoMovimentoFinanceiro/TipoMovimentoFinanceiroDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */