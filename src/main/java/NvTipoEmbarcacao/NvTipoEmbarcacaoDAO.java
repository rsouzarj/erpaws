/*     */ package NvTipoEmbarcacao;
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
/*     */ public class NvTipoEmbarcacaoDAO
/*     */ {
/*     */   public NvTipoEmbarcacao inserir(NvTipoEmbarcacao nvTipoEmbarcacao)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_NV_TIPO_EMBARCACAO");
/*  28 */       nvTipoEmbarcacao.setSeqNvTipoEmbarcacao(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into NV_TIPO_EMBARCACAO (SEQ_NV_TIPO_EMBARCACAO,CODIGO,NOME,SITUACAO,DATA_CADASTRO) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, nvTipoEmbarcacao.getSeqNvTipoEmbarcacao());
/*  38 */       ps.setString(2, nvTipoEmbarcacao.getCodigo());
/*  39 */       ps.setString(3, nvTipoEmbarcacao.getNome());
/*  40 */       ps.setString(4, nvTipoEmbarcacao.getSituacao());
/*  41 */       ps.setDate(5, new java.sql.Date(nvTipoEmbarcacao.getDataCadastro().getTime()));
/*     */       
/*  43 */       ps.execute();
/*  44 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  47 */       Logger.getLogger(NvTipoEmbarcacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  48 */       System.out.println(ex.getMessage());
/*     */     }
/*  50 */     return nvTipoEmbarcacao;
/*     */   }
/*     */   
/*     */   public NvTipoEmbarcacao alterar(NvTipoEmbarcacao nvTipoEmbarcacao) {
/*     */     try {
/*  55 */       Conexao conexao = new Conexao();
/*  56 */       Connection conn = Conexao.getConnection();
/*  57 */       String sql = "update NV_TIPO_EMBARCACAO set CODIGO = ?,NOME = ?,SITUACAO = ?,DATA_CADASTRO = ? where SEQ_NV_TIPO_EMBARCACAO = ?";
/*     */       
/*  59 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  61 */       ps.setString(1, nvTipoEmbarcacao.getCodigo());
/*  62 */       ps.setString(2, nvTipoEmbarcacao.getNome());
/*  63 */       ps.setString(3, nvTipoEmbarcacao.getSituacao());
/*  64 */       ps.setDate(4, new java.sql.Date(nvTipoEmbarcacao.getDataCadastro().getTime()));
/*  65 */       ps.setString(5, nvTipoEmbarcacao.getSeqNvTipoEmbarcacao());
/*  66 */       ps.execute();
/*  67 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  70 */       Logger.getLogger(NvTipoEmbarcacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  71 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  74 */     return nvTipoEmbarcacao;
/*     */   }
/*     */   
/*     */   public List<NvTipoEmbarcacao> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  79 */       Conexao conexao = new Conexao();
/*  80 */       Connection conn = Conexao.getConnection();
/*  81 */       String sql = "SELECT * FROM NV_TIPO_EMBARCACAO" + sClausula.montarsClausula();
/*  82 */       System.out.println(sql);
/*     */       
/*  84 */       List<NvTipoEmbarcacao> listaNvTipoEmbarcacao = new ArrayList();
/*  85 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  86 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  88 */       while (rs.next()) {
/*  89 */         NvTipoEmbarcacao nvTipoEmbarcacao = new NvTipoEmbarcacao();
/*  90 */         nvTipoEmbarcacao.setSeqNvTipoEmbarcacao(rs.getString("SEQ_NV_TIPO_EMBARCACAO"));
/*  91 */         nvTipoEmbarcacao.setCodigo(rs.getString("CODIGO"));
/*  92 */         nvTipoEmbarcacao.setNome(rs.getString("NOME"));
/*  93 */         nvTipoEmbarcacao.setSituacao(rs.getString("SITUACAO"));
/*  94 */         nvTipoEmbarcacao.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  95 */         listaNvTipoEmbarcacao.add(nvTipoEmbarcacao);
/*     */       }
/*     */       
/*  98 */       ps.execute();
/*  99 */       ps.close();
/*     */       
/* 101 */       return listaNvTipoEmbarcacao;
/*     */     } catch (SQLException ex) {
/* 103 */       Logger.getLogger(NvTipoEmbarcacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 104 */       System.out.println(ex.getMessage()); }
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(NvTipoEmbarcacao nvTipoEmbarcacao)
/*     */   {
/*     */     try {
/* 111 */       Conexao conexao = new Conexao();
/* 112 */       Connection conn = Conexao.getConnection();
/* 113 */       String sql = "DELETE FROM NV_TIPO_EMBARCACAO WHERE SEQ_NV_TIPO_EMBARCACAO =  ? ";
/*     */       
/* 115 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 117 */       ps.setString(1, nvTipoEmbarcacao.getSeqNvTipoEmbarcacao());
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


