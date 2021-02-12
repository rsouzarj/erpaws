/*     */ package ParceiroVinculoEmbarcacao;
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
/*     */ public class ParceiroVinculoEmbarcacaoDAO
/*     */ {
/*     */   public ParceiroVinculoEmbarcacao inserir(ParceiroVinculoEmbarcacao parceiroVinculoEmbarcacao)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_PARCEIRO_V_EMBARCACAO");
/*  28 */       parceiroVinculoEmbarcacao.setSeqParceiroVEmbarcacao(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into PARCEIRO_VINCULO_EMBARCACAO (SEQ_PARCEIRO_V_EMBARCACAO,SEQ_NV_EMBARCACAO,DATA_CADASTRO,SEQ_TIPO_VINCULO,SEQ_PARCEIRO_VINCULADO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, parceiroVinculoEmbarcacao.getSeqParceiroVEmbarcacao());
/*  38 */       ps.setString(2, parceiroVinculoEmbarcacao.getSeqNvEmbarcacao());
/*     */       try {
/*  40 */         ps.setDate(3, new java.sql.Date(parceiroVinculoEmbarcacao.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  42 */         ps.setDate(3, null);
/*     */       }
/*  44 */       ps.setString(4, parceiroVinculoEmbarcacao.getSeqTipoVinculo());
/*  45 */       ps.setString(5, parceiroVinculoEmbarcacao.getSeqParceiroVinculado());
/*     */       
/*  47 */       ps.execute();
/*  48 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  51 */       Logger.getLogger(ParceiroVinculoEmbarcacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  52 */       System.out.println(ex.getMessage());
/*     */     }
/*  54 */     return parceiroVinculoEmbarcacao;
/*     */   }
/*     */   
/*     */   public ParceiroVinculoEmbarcacao alterar(ParceiroVinculoEmbarcacao parceiroVinculoEmbarcacao) {
/*     */     try {
/*  59 */       Conexao conexao = new Conexao();
/*  60 */       Connection conn = Conexao.getConnection();
/*  61 */       String sql = "update PARCEIRO_VINCULO_EMBARCACAO set SEQ_NV_EMBARCACAO = ?,DATA_CADASTRO = ?,SEQ_TIPO_VINCULO = ?,SEQ_PARCEIRO_VINCULADO = ? where SEQ_PARCEIRO_V_EMBARCACAO = ?";
/*     */       
/*  63 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  65 */       ps.setString(1, parceiroVinculoEmbarcacao.getSeqNvEmbarcacao());
/*     */       try {
/*  67 */         ps.setDate(2, new java.sql.Date(parceiroVinculoEmbarcacao.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  69 */         ps.setDate(2, null);
/*     */       }
/*  71 */       ps.setString(3, parceiroVinculoEmbarcacao.getSeqTipoVinculo());
/*  72 */       ps.setString(4, parceiroVinculoEmbarcacao.getSeqParceiroVinculado());
/*  73 */       ps.setString(5, parceiroVinculoEmbarcacao.getSeqParceiroVEmbarcacao());
/*  74 */       ps.execute();
/*  75 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  78 */       Logger.getLogger(ParceiroVinculoEmbarcacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  79 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  82 */     return parceiroVinculoEmbarcacao;
/*     */   }
/*     */   
/*     */   public List<ParceiroVinculoEmbarcacao> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  87 */       Conexao conexao = new Conexao();
/*  88 */       Connection conn = Conexao.getConnection();
/*  89 */       String sql = "SELECT PARCEIRO_VINCULO_EMBARCACAO.*,NV_EMBARCACAO.nome embarcacao_nome,\ntipo_vinculo.nome tipo_vinculo_nome,\nvinculado.nome vinculado\n FROM PARCEIRO_VINCULO_EMBARCACAO inner join NV_EMBARCACAO on NV_EMBARCACAO.seq_NV_EMBARCACAO = PARCEIRO_VINCULO_EMBARCACAO.seq_NV_EMBARCACAO\ninner join parceiro vinculado on vinculado.seq_parceiro = PARCEIRO_VINCULO_EMBARCACAO.seq_parceiro_vinculado\ninner join tipo_vinculo on tipo_vinculo.seq_tipo_vinculo = PARCEIRO_VINCULO_EMBARCACAO.seq_tipo_vinculo " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */       System.out.println(sql);
/*     */       
/* 100 */       List<ParceiroVinculoEmbarcacao> listaParceiroVinculoEmbarcacao = new ArrayList();
/* 101 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 102 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 104 */       while (rs.next()) {
/* 105 */         ParceiroVinculoEmbarcacao parceiroVinculoEmbarcacao = new ParceiroVinculoEmbarcacao();
/* 106 */         parceiroVinculoEmbarcacao.setSeqParceiroVEmbarcacao(rs.getString("SEQ_PARCEIRO_V_EMBARCACAO"));
/* 107 */         parceiroVinculoEmbarcacao.setSeqNvEmbarcacao(rs.getString("SEQ_NV_EMBARCACAO"));
/* 108 */         parceiroVinculoEmbarcacao.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 109 */         parceiroVinculoEmbarcacao.setSeqTipoVinculo(rs.getString("SEQ_TIPO_VINCULO"));
/* 110 */         parceiroVinculoEmbarcacao.setSeqParceiroVinculado(rs.getString("SEQ_PARCEIRO_VINCULADO"));
/*     */         
/* 112 */         parceiroVinculoEmbarcacao.setEmbarcacaoNome(rs.getString("embarcacao_nome"));
/* 113 */         parceiroVinculoEmbarcacao.setTipoVinculoNome(rs.getString("TIPO_VINCULO_NOME"));
/* 114 */         parceiroVinculoEmbarcacao.setVinculadoNome(rs.getString("vinculado"));
/* 115 */         listaParceiroVinculoEmbarcacao.add(parceiroVinculoEmbarcacao);
/*     */       }
/*     */       
/* 118 */       ps.execute();
/* 119 */       ps.close();
/*     */       
/* 121 */       return listaParceiroVinculoEmbarcacao;
/*     */     } catch (SQLException ex) {
/* 123 */       Logger.getLogger(ParceiroVinculoEmbarcacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 124 */       System.out.println(ex.getMessage()); }
/* 125 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(ParceiroVinculoEmbarcacao parceiroVinculoEmbarcacao)
/*     */   {
/*     */     try {
/* 131 */       Conexao conexao = new Conexao();
/* 132 */       Connection conn = Conexao.getConnection();
/* 133 */       String sql = "DELETE FROM PARCEIRO_VINCULO_EMBARCACAO WHERE SEQ_PARCEIRO_V_EMBARCACAO =  ? ";
/*     */       
/* 135 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 137 */       ps.setString(1, parceiroVinculoEmbarcacao.getSeqParceiroVEmbarcacao());
/*     */       
/* 139 */       ps.execute();
/* 140 */       ps.close();
/*     */       
/* 142 */       return true;
/*     */     } catch (SQLException ex) {
/* 144 */       System.out.println(ex.getMessage()); }
/* 145 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ParceiroVinculoEmbarcacao/ParceiroVinculoEmbarcacaoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */