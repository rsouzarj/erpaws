/*     */ package CondicaoPagamentoItem;
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
/*     */ public class CondicaoPagamentoItemDAO
/*     */ {
/*     */   public CondicaoPagamentoItem inserir(CondicaoPagamentoItem condicaoPagamentoItem)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_CONDICAO_PAGAMENTO_ITEM");
/*  28 */       condicaoPagamentoItem.setSeqCondicaoPagamentoItem(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into CONDICAO_PAGAMENTO_ITEM (SEQ_CONDICAO_PAGAMENTO_ITEM,SEQ_CONDICAO_PAGAMENTO,NOME,DIAS,RATEIO_PERC,ACRESCIMO,DATA_CADASTRO,SITUACAO) values  (?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, condicaoPagamentoItem.getSeqCondicaoPagamentoItem());
/*  38 */       ps.setString(2, condicaoPagamentoItem.getSeqCondicaoPagamento());
/*  39 */       ps.setString(3, condicaoPagamentoItem.getNome());
/*  40 */       ps.setString(4, condicaoPagamentoItem.getDias());
/*  41 */       ps.setBigDecimal(5, condicaoPagamentoItem.getRateioPerc());
/*  42 */       ps.setBigDecimal(6, condicaoPagamentoItem.getAcrescimo());
/*  43 */       ps.setDate(7, new java.sql.Date(condicaoPagamentoItem.getDataCadastro().getTime()));
/*  44 */       ps.setString(8, condicaoPagamentoItem.getSituacao());
/*     */       
/*  46 */       ps.execute();
/*  47 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  50 */       Logger.getLogger(CondicaoPagamentoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  51 */       System.out.println(ex.getMessage());
/*     */     }
/*  53 */     return condicaoPagamentoItem;
/*     */   }
/*     */   
/*     */   public CondicaoPagamentoItem alterar(CondicaoPagamentoItem condicaoPagamentoItem) {
/*     */     try {
/*  58 */       Conexao conexao = new Conexao();
/*  59 */       Connection conn = Conexao.getConnection();
/*  60 */       String sql = "update CONDICAO_PAGAMENTO_ITEM set SEQ_CONDICAO_PAGAMENTO = ?,NOME = ?,DIAS = ?,RATEIO_PERC = ?,ACRESCIMO = ?,DATA_CADASTRO = ?,SITUACAO = ? where SEQ_CONDICAO_PAGAMENTO_ITEM = ?";
/*     */       
/*  62 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  64 */       ps.setString(1, condicaoPagamentoItem.getSeqCondicaoPagamento());
/*  65 */       ps.setString(2, condicaoPagamentoItem.getNome());
/*  66 */       ps.setString(3, condicaoPagamentoItem.getDias());
/*  67 */       ps.setBigDecimal(4, condicaoPagamentoItem.getRateioPerc());
/*  68 */       ps.setBigDecimal(5, condicaoPagamentoItem.getAcrescimo());
/*  69 */       ps.setDate(6, new java.sql.Date(condicaoPagamentoItem.getDataCadastro().getTime()));
/*  70 */       ps.setString(7, condicaoPagamentoItem.getSituacao());
/*  71 */       ps.setString(8, condicaoPagamentoItem.getSeqCondicaoPagamentoItem());
/*  72 */       ps.execute();
/*  73 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  76 */       Logger.getLogger(CondicaoPagamentoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  77 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  80 */     return condicaoPagamentoItem;
/*     */   }
/*     */   
/*     */   public List<CondicaoPagamentoItem> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  85 */       Conexao conexao = new Conexao();
/*  86 */       Connection conn = Conexao.getConnection();
/*  87 */       String sql = "SELECT * FROM CONDICAO_PAGAMENTO_ITEM" + sClausula.montarsClausula();
/*  88 */       System.out.println(sql);
/*     */       
/*  90 */       List<CondicaoPagamentoItem> listaCondicaoPagamentoItem = new ArrayList();
/*  91 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  92 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  94 */       while (rs.next()) {
/*  95 */         CondicaoPagamentoItem condicaoPagamentoItem = new CondicaoPagamentoItem();
/*  96 */         condicaoPagamentoItem.setSeqCondicaoPagamentoItem(rs.getString("SEQ_CONDICAO_PAGAMENTO_ITEM"));
/*  97 */         condicaoPagamentoItem.setSeqCondicaoPagamento(rs.getString("SEQ_CONDICAO_PAGAMENTO"));
/*  98 */         condicaoPagamentoItem.setNome(rs.getString("NOME"));
/*  99 */         condicaoPagamentoItem.setDias(rs.getString("DIAS"));
/* 100 */         condicaoPagamentoItem.setRateioPerc(rs.getBigDecimal("RATEIO_PERC"));
/* 101 */         condicaoPagamentoItem.setAcrescimo(rs.getBigDecimal("ACRESCIMO"));
/* 102 */         condicaoPagamentoItem.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 103 */         condicaoPagamentoItem.setSituacao(rs.getString("SITUACAO"));
/* 104 */         listaCondicaoPagamentoItem.add(condicaoPagamentoItem);
/*     */       }
/*     */       
/* 107 */       ps.execute();
/* 108 */       ps.close();
/*     */       
/* 110 */       return listaCondicaoPagamentoItem;
/*     */     } catch (SQLException ex) {
/* 112 */       Logger.getLogger(CondicaoPagamentoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 113 */       System.out.println(ex.getMessage()); }
/* 114 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(CondicaoPagamentoItem condicaoPagamentoItem)
/*     */   {
/*     */     try {
/* 120 */       Conexao conexao = new Conexao();
/* 121 */       Connection conn = Conexao.getConnection();
/* 122 */       String sql = "DELETE FROM CONDICAO_PAGAMENTO_ITEM WHERE SEQ_CONDICAO_PAGAMENTO_ITEM =  ? ";
/*     */       
/* 124 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 126 */       ps.setString(1, condicaoPagamentoItem.getSeqCondicaoPagamentoItem());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/CondicaoPagamentoItem/CondicaoPagamentoItemDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */