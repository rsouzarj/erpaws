/*     */ package ParceiroVinculo;
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
/*     */ public class ParceiroVinculoDAO
/*     */ {
/*     */   public ParceiroVinculo inserir(ParceiroVinculo parceiroVinculo)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_PARCEIRO_VINCULO");
/*  28 */       parceiroVinculo.setSeqParceiroVinculo(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into PARCEIRO_VINCULO (SEQ_PARCEIRO_VINCULO,SEQ_PARCEIRO,SEQ_PARCEIRO_VINCULADO,SEQ_TIPO_VINCULO,DATA_CADASTRO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, parceiroVinculo.getSeqParceiroVinculo());
/*  38 */       ps.setString(2, parceiroVinculo.getSeqParceiro());
/*  39 */       ps.setString(3, parceiroVinculo.getSeqParceiroVinculado());
/*  40 */       ps.setString(4, parceiroVinculo.getSeqTipoVinculo());
/*  41 */       ps.setDate(5, new java.sql.Date(parceiroVinculo.getDataCadastro().getTime()));
/*     */       
/*  43 */       ps.execute();
/*  44 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  47 */       Logger.getLogger(ParceiroVinculoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  48 */       System.out.println(ex.getMessage());
/*     */     }
/*  50 */     return parceiroVinculo;
/*     */   }
/*     */   
/*     */   public ParceiroVinculo alterar(ParceiroVinculo parceiroVinculo) {
/*     */     try {
/*  55 */       Conexao conexao = new Conexao();
/*  56 */       Connection conn = Conexao.getConnection();
/*  57 */       String sql = "UPDATE PARCEIRO_VINCULO set SEQ_PARCEIRO = ?,SEQ_TIPO_VINCULO = ?,DATA_CADASTRO = ? where SEQ_PARCEIRO_VINCULO = ?";
/*     */       
/*  59 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  61 */       ps.setString(1, parceiroVinculo.getSeqParceiro());
/*  62 */       ps.setString(2, parceiroVinculo.getSeqTipoVinculo());
/*  63 */       ps.setDate(3, new java.sql.Date(parceiroVinculo.getDataCadastro().getTime()));
/*  64 */       ps.setString(4, parceiroVinculo.getSeqParceiroVinculo());
/*  65 */       ps.execute();
/*  66 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  69 */       Logger.getLogger(ParceiroVinculoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  70 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  73 */     return parceiroVinculo;
/*     */   }
/*     */   
/*     */   public List<ParceiroVinculo> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  78 */       Conexao conexao = new Conexao();
/*  79 */       Connection conn = Conexao.getConnection();
/*  80 */       String sql = "select parceiro_vinculo.*,\nparceiro.nome parceiro_nome,\ntipo_vinculo.nome tipo_vinculo_nome,\nvinculado.nome vinculado\nfrom \nparceiro_vinculo \ninner join parceiro on parceiro.seq_parceiro = parceiro_vinculo.seq_parceiro\ninner join parceiro vinculado on vinculado.seq_parceiro = parceiro_vinculo.seq_parceiro_vinculado\ninner join tipo_vinculo on tipo_vinculo.seq_tipo_vinculo = parceiro_vinculo.seq_tipo_vinculo " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */       System.out.println(sql);
/*     */       
/*  91 */       List<ParceiroVinculo> listaParceiroVinculo = new ArrayList();
/*  92 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  93 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  95 */       while (rs.next()) {
/*  96 */         ParceiroVinculo parceiroVinculo = new ParceiroVinculo();
/*  97 */         parceiroVinculo.setSeqParceiroVinculo(rs.getString("SEQ_PARCEIRO_VINCULO"));
/*  98 */         parceiroVinculo.setSeqParceiro(rs.getString("SEQ_PARCEIRO"));
/*  99 */         parceiroVinculo.setSeqParceiroVinculado(rs.getString("SEQ_PARCEIRO_VINCULADO"));
/* 100 */         parceiroVinculo.setSeqTipoVinculo(rs.getString("SEQ_TIPO_VINCULO"));
/* 101 */         parceiroVinculo.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*     */         
/* 103 */         parceiroVinculo.setParceiroNome(rs.getString("PARCEIRO_NOME"));
/* 104 */         parceiroVinculo.setTipoVinculoNome(rs.getString("TIPO_VINCULO_NOME"));
/* 105 */         parceiroVinculo.setVinculadoNome(rs.getString("vinculado"));
/* 106 */         listaParceiroVinculo.add(parceiroVinculo);
/*     */       }
/*     */       
/* 109 */       ps.execute();
/* 110 */       ps.close();
/*     */       
/* 112 */       return listaParceiroVinculo;
/*     */     } catch (SQLException ex) {
/* 114 */       Logger.getLogger(ParceiroVinculoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 115 */       System.out.println(ex.getMessage()); }
/* 116 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(ParceiroVinculo parceiroVinculo)
/*     */   {
/*     */     try {
/* 122 */       Conexao conexao = new Conexao();
/* 123 */       Connection conn = Conexao.getConnection();
/* 124 */       String sql = "DELETE FROM PARCEIRO_VINCULO WHERE SEQ_PARCEIRO_VINCULO =  ? ";
/*     */       
/* 126 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 128 */       ps.setString(1, parceiroVinculo.getSeqParceiroVinculo());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ParceiroVinculo/ParceiroVinculoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */