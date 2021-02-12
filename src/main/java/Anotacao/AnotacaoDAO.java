/*     */ package Anotacao;
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
/*     */ public class AnotacaoDAO
/*     */ {
/*     */   public Anotacao inserir(Anotacao anotacao)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_ANOTACAO");
/*  28 */       anotacao.setSeqAnotacao(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into ANOTACAO (SEQ_ANOTACAO,SEQ_PARCEIRO,SEQ_TIPO_ANOTACAO,DESCRICAO,SEQ_EMPRESA,DATA_CADASTRO) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, anotacao.getSeqAnotacao());
/*  38 */       ps.setString(2, anotacao.getSeqParceiro());
/*  39 */       ps.setString(3, anotacao.getSeqTipoAnotacao());
/*  40 */       ps.setString(4, anotacao.getDescricao());
/*  41 */       ps.setString(5, anotacao.getSeqEmpresa());
/*  42 */       ps.setDate(6, new java.sql.Date(anotacao.getDataCadastro().getTime()));
/*     */       
/*  44 */       ps.execute();
/*  45 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  48 */       Logger.getLogger(AnotacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  49 */       System.out.println(ex.getMessage());
/*     */     }
/*  51 */     return anotacao;
/*     */   }
/*     */   
/*     */   public Anotacao alterar(Anotacao anotacao) {
/*     */     try {
/*  56 */       Conexao conexao = new Conexao();
/*  57 */       Connection conn = Conexao.getConnection();
/*  58 */       String sql = "update ANOTACAO set SEQ_PARCEIRO = ?,SEQ_TIPO_ANOTACAO = ?,DESCRICAO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ? where SEQ_ANOTACAO = ?";
/*     */       
/*  60 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  62 */       ps.setString(1, anotacao.getSeqParceiro());
/*  63 */       ps.setString(2, anotacao.getSeqTipoAnotacao());
/*  64 */       ps.setString(3, anotacao.getDescricao());
/*  65 */       ps.setString(4, anotacao.getSeqEmpresa());
/*  66 */       ps.setDate(5, new java.sql.Date(anotacao.getDataCadastro().getTime()));
/*  67 */       ps.setString(6, anotacao.getSeqAnotacao());
/*  68 */       ps.execute();
/*  69 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  72 */       Logger.getLogger(AnotacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  73 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  76 */     return anotacao;
/*     */   }
/*     */   
/*     */   public List<Anotacao> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  81 */       Conexao conexao = new Conexao();
/*  82 */       Connection conn = Conexao.getConnection();
/*  83 */       String sql = "SELECT ANOTACAO.* , tipo_anotacao.nome tipo_nome\nFROM \nANOTACAO\ninner join tipo_anotacao on tipo_anotacao.seq_tipo_anotacao = anotacao.seq_tipo_anotacao\n" + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  88 */       System.out.println(sql);
/*     */       
/*  90 */       List<Anotacao> listaAnotacao = new ArrayList();
/*  91 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  92 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  94 */       while (rs.next()) {
/*  95 */         Anotacao anotacao = new Anotacao();
/*  96 */         anotacao.setSeqAnotacao(rs.getString("SEQ_ANOTACAO"));
/*  97 */         anotacao.setSeqParceiro(rs.getString("SEQ_PARCEIRO"));
/*  98 */         anotacao.setSeqTipoAnotacao(rs.getString("SEQ_TIPO_ANOTACAO"));
/*  99 */         anotacao.setDescricao(rs.getString("DESCRICAO"));
/* 100 */         anotacao.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 101 */         anotacao.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*     */         
/* 103 */         anotacao.setTipoNome(rs.getString("tipo_nome"));
/*     */         
/* 105 */         listaAnotacao.add(anotacao);
/*     */       }
/*     */       
/* 108 */       ps.execute();
/* 109 */       ps.close();
/*     */       
/* 111 */       return listaAnotacao;
/*     */     } catch (SQLException ex) {
/* 113 */       Logger.getLogger(AnotacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 114 */       System.out.println(ex.getMessage()); }
/* 115 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(Anotacao anotacao)
/*     */   {
/*     */     try {
/* 121 */       Conexao conexao = new Conexao();
/* 122 */       Connection conn = Conexao.getConnection();
/* 123 */       String sql = "DELETE FROM ANOTACAO WHERE SEQ_ANOTACAO =  ? ";
/*     */       
/* 125 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 127 */       ps.setString(1, anotacao.getSeqAnotacao());
/*     */       
/* 129 */       ps.execute();
/* 130 */       ps.close();
/*     */       
/* 132 */       return true;
/*     */     } catch (SQLException ex) {
/* 134 */       System.out.println(ex.getMessage()); }
/* 135 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Anotacao/AnotacaoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */