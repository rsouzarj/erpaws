/*     */ package InformacaoImportante;
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
/*     */ public class InformacaoImportanteDAO
/*     */ {
/*     */   public InformacaoImportante inserir(InformacaoImportante informacaoImportante)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_INFORMACAO_IMPORTANTE");
/*  28 */       informacaoImportante.setSeqInformacaoImportante(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into INFORMACAO_IMPORTANTE (SEQ_INFORMACAO_IMPORTANTE,DESCRICAO,SITUACAO,SEQ_EMPRESA,DATA_CADASTRO,tipo_documento_destino) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, informacaoImportante.getSeqInformacaoImportante());
/*  38 */       ps.setString(2, informacaoImportante.getDescricao());
/*  39 */       ps.setString(3, informacaoImportante.getSituacao());
/*  40 */       ps.setString(4, informacaoImportante.getSeqEmpresa());
/*     */       try {
/*  42 */         ps.setDate(5, new java.sql.Date(informacaoImportante.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  44 */         ps.setDate(5, null);
/*     */       }
/*  46 */       ps.setString(6, informacaoImportante.getTipoDocumentoDestino());
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(InformacaoImportanteDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return informacaoImportante;
/*     */   }
/*     */   
/*     */   public InformacaoImportante alterar(InformacaoImportante informacaoImportante) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update INFORMACAO_IMPORTANTE set DESCRICAO = ?,SITUACAO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ?, tipo_documento_destino = ? where SEQ_INFORMACAO_IMPORTANTE = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, informacaoImportante.getDescricao());
/*  67 */       ps.setString(2, informacaoImportante.getSituacao());
/*  68 */       ps.setString(3, informacaoImportante.getSeqEmpresa());
/*     */       try {
/*  70 */         ps.setDate(4, new java.sql.Date(informacaoImportante.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  72 */         ps.setDate(4, null);
/*     */       }
/*  74 */       ps.setString(5, informacaoImportante.getTipoDocumentoDestino());
/*  75 */       ps.setString(6, informacaoImportante.getSeqInformacaoImportante());
/*  76 */       ps.execute();
/*  77 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  80 */       Logger.getLogger(InformacaoImportanteDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  81 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  84 */     return informacaoImportante;
/*     */   }
/*     */   
/*     */   public List<InformacaoImportante> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  89 */       Conexao conexao = new Conexao();
/*  90 */       Connection conn = Conexao.getConnection();
/*  91 */       String sql = "SELECT * FROM INFORMACAO_IMPORTANTE" + sClausula.montarsClausula();
/*  92 */       System.out.println(sql);
/*     */       
/*  94 */       List<InformacaoImportante> listaInformacaoImportante = new ArrayList();
/*  95 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  96 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  98 */       while (rs.next()) {
/*  99 */         InformacaoImportante informacaoImportante = new InformacaoImportante();
/* 100 */         informacaoImportante.setSeqInformacaoImportante(rs.getString("SEQ_INFORMACAO_IMPORTANTE"));
/* 101 */         informacaoImportante.setDescricao(rs.getString("DESCRICAO"));
/* 102 */         informacaoImportante.setSituacao(rs.getString("SITUACAO"));
/* 103 */         informacaoImportante.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 104 */         informacaoImportante.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 105 */         informacaoImportante.setTipoDocumentoDestino(rs.getString("tipo_documento_destino"));
/* 106 */         listaInformacaoImportante.add(informacaoImportante);
/*     */       }
/*     */       
/* 109 */       ps.execute();
/* 110 */       ps.close();
/*     */       
/* 112 */       return listaInformacaoImportante;
/*     */     } catch (SQLException ex) {
/* 114 */       Logger.getLogger(InformacaoImportanteDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 115 */       System.out.println(ex.getMessage()); }
/* 116 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(InformacaoImportante informacaoImportante)
/*     */   {
/*     */     try {
/* 122 */       Conexao conexao = new Conexao();
/* 123 */       Connection conn = Conexao.getConnection();
/* 124 */       String sql = "DELETE FROM INFORMACAO_IMPORTANTE WHERE SEQ_INFORMACAO_IMPORTANTE =  ? ";
/*     */       
/* 126 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 128 */       ps.setString(1, informacaoImportante.getSeqInformacaoImportante());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/InformacaoImportante/InformacaoImportanteDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */