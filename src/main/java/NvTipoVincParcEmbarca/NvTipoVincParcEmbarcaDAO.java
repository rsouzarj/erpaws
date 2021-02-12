/*     */ package NvTipoVincParcEmbarca;
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
/*     */ public class NvTipoVincParcEmbarcaDAO
/*     */ {
/*     */   public NvTipoVincParcEmbarca inserir(NvTipoVincParcEmbarca nvTipoVincParcEmbarca)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_NV_TIPO_VINC_PARC_EMBARCA");
/*  28 */       nvTipoVincParcEmbarca.setSeqNvTipoVincParcEmbarca(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into NV_TIPO_VINC_PARC_EMBARCA (SEQ_NV_TIPO_VINC_PARC_EMBARCA,NOME,DATA_CADASTRO,SEQ_EMPRESA,SITUACAO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, nvTipoVincParcEmbarca.getSeqNvTipoVincParcEmbarca());
/*  38 */       ps.setString(2, nvTipoVincParcEmbarca.getNome());
/*     */       try {
/*  40 */         ps.setDate(3, new java.sql.Date(nvTipoVincParcEmbarca.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  42 */         ps.setDate(3, null);
/*     */       }
/*  44 */       ps.setString(4, nvTipoVincParcEmbarca.getSeqEmpresa());
/*  45 */       ps.setString(5, nvTipoVincParcEmbarca.getSituacao());
/*     */       
/*  47 */       ps.execute();
/*  48 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  51 */       Logger.getLogger(NvTipoVincParcEmbarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  52 */       System.out.println(ex.getMessage());
/*     */     }
/*  54 */     return nvTipoVincParcEmbarca;
/*     */   }
/*     */   
/*     */   public NvTipoVincParcEmbarca alterar(NvTipoVincParcEmbarca nvTipoVincParcEmbarca) {
/*     */     try {
/*  59 */       Conexao conexao = new Conexao();
/*  60 */       Connection conn = Conexao.getConnection();
/*  61 */       String sql = "update NV_TIPO_VINC_PARC_EMBARCA set NOME = ?,DATA_CADASTRO = ?,SEQ_EMPRESA = ?,SITUACAO = ? where SEQ_NV_TIPO_VINC_PARC_EMBARCA = ?";
/*     */       
/*  63 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  65 */       ps.setString(1, nvTipoVincParcEmbarca.getNome());
/*     */       try {
/*  67 */         ps.setDate(2, new java.sql.Date(nvTipoVincParcEmbarca.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  69 */         ps.setDate(2, null);
/*     */       }
/*  71 */       ps.setString(3, nvTipoVincParcEmbarca.getSeqEmpresa());
/*  72 */       ps.setString(4, nvTipoVincParcEmbarca.getSituacao());
/*  73 */       ps.setString(5, nvTipoVincParcEmbarca.getSeqNvTipoVincParcEmbarca());
/*  74 */       ps.execute();
/*  75 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  78 */       Logger.getLogger(NvTipoVincParcEmbarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  79 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  82 */     return nvTipoVincParcEmbarca;
/*     */   }
/*     */   
/*     */   public List<NvTipoVincParcEmbarca> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  87 */       Conexao conexao = new Conexao();
/*  88 */       Connection conn = Conexao.getConnection();
/*  89 */       String sql = "SELECT * FROM NV_TIPO_VINC_PARC_EMBARCA" + sClausula.montarsClausula();
/*  90 */       System.out.println(sql);
/*     */       
/*  92 */       List<NvTipoVincParcEmbarca> listaNvTipoVincParcEmbarca = new ArrayList();
/*  93 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  94 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  96 */       while (rs.next()) {
/*  97 */         NvTipoVincParcEmbarca nvTipoVincParcEmbarca = new NvTipoVincParcEmbarca();
/*  98 */         nvTipoVincParcEmbarca.setSeqNvTipoVincParcEmbarca(rs.getString("SEQ_NV_TIPO_VINC_PARC_EMBARCA"));
/*  99 */         nvTipoVincParcEmbarca.setNome(rs.getString("NOME"));
/* 100 */         nvTipoVincParcEmbarca.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 101 */         nvTipoVincParcEmbarca.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 102 */         nvTipoVincParcEmbarca.setSituacao(rs.getString("SITUACAO"));
/* 103 */         listaNvTipoVincParcEmbarca.add(nvTipoVincParcEmbarca);
/*     */       }
/*     */       
/* 106 */       ps.execute();
/* 107 */       ps.close();
/*     */       
/* 109 */       return listaNvTipoVincParcEmbarca;
/*     */     } catch (SQLException ex) {
/* 111 */       Logger.getLogger(NvTipoVincParcEmbarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 112 */       System.out.println(ex.getMessage()); }
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(NvTipoVincParcEmbarca nvTipoVincParcEmbarca)
/*     */   {
/*     */     try {
/* 119 */       Conexao conexao = new Conexao();
/* 120 */       Connection conn = Conexao.getConnection();
/* 121 */       String sql = "DELETE FROM NV_TIPO_VINC_PARC_EMBARCA WHERE SEQ_NV_TIPO_VINC_PARC_EMBARCA =  ? ";
/*     */       
/* 123 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 125 */       ps.setString(1, nvTipoVincParcEmbarca.getSeqNvTipoVincParcEmbarca());
/*     */       
/* 127 */       ps.execute();
/* 128 */       ps.close();
/*     */       
/* 130 */       return true;
/*     */     } catch (SQLException ex) {
/* 132 */       System.out.println(ex.getMessage()); }
/* 133 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvTipoVincParcEmbarca/NvTipoVincParcEmbarcaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */