/*     */ package Aliquota;
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
/*     */ public class AliquotaDAO
/*     */ {
/*     */   public Aliquota inserir(Aliquota aliquota)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_ALIQUOTA");
/*  28 */       aliquota.setSeqAliquota(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into ALIQUOTA (SEQ_ALIQUOTA,SEQ_EMPRESA,TIPO_ALIQUOTA,SITUACAO,NOME,DESCRICAO,PERCENTUAL,DATA_CADASTRO,codigo) values  (?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, aliquota.getSeqAliquota());
/*  38 */       ps.setString(2, aliquota.getSeqEmpresa());
/*  39 */       ps.setString(3, aliquota.getTipoAliquota());
/*  40 */       ps.setString(4, aliquota.getSituacao());
/*  41 */       ps.setString(5, aliquota.getNome());
/*  42 */       ps.setString(6, aliquota.getDescricao());
/*  43 */       ps.setBigDecimal(7, aliquota.getPercentual());
/*     */       try {
/*  45 */         ps.setDate(8, new java.sql.Date(aliquota.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  47 */         ps.setDate(8, null);
/*     */       }
/*  49 */       ps.setString(9, aliquota.getCodigo());
/*     */       
/*  51 */       ps.execute();
/*  52 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  55 */       Logger.getLogger(AliquotaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  56 */       System.out.println(ex.getMessage());
/*     */     }
/*  58 */     return aliquota;
/*     */   }
/*     */   
/*     */   public Aliquota alterar(Aliquota aliquota) {
/*     */     try {
/*  63 */       Conexao conexao = new Conexao();
/*  64 */       Connection conn = Conexao.getConnection();
/*  65 */       String sql = "update ALIQUOTA set SEQ_EMPRESA = ?,TIPO_ALIQUOTA = ?,SITUACAO = ?,NOME = ?,DESCRICAO = ?,PERCENTUAL = ?,DATA_CADASTRO = ?,CODIGO = ? where SEQ_ALIQUOTA = ?";
/*     */       
/*  67 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  69 */       ps.setString(1, aliquota.getSeqEmpresa());
/*  70 */       ps.setString(2, aliquota.getTipoAliquota());
/*  71 */       ps.setString(3, aliquota.getSituacao());
/*  72 */       ps.setString(4, aliquota.getNome());
/*  73 */       ps.setString(5, aliquota.getDescricao());
/*  74 */       ps.setBigDecimal(6, aliquota.getPercentual());
/*     */       try {
/*  76 */         ps.setDate(7, new java.sql.Date(aliquota.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  78 */         ps.setDate(7, null);
/*     */       }
/*  80 */       ps.setString(8, aliquota.getCodigo());
/*  81 */       ps.setString(9, aliquota.getSeqAliquota());
/*  82 */       ps.execute();
/*  83 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  86 */       Logger.getLogger(AliquotaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  87 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  90 */     return aliquota;
/*     */   }
/*     */   
/*     */   public List<Aliquota> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  95 */       Conexao conexao = new Conexao();
/*  96 */       Connection conn = Conexao.getConnection();
/*  97 */       String sql = "SELECT * FROM ALIQUOTA" + sClausula.montarsClausula();
/*     */       
/*     */ 
/* 100 */       List<Aliquota> listaAliquota = new ArrayList();
/* 101 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 102 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 104 */       while (rs.next()) {
/* 105 */         Aliquota aliquota = new Aliquota();
/* 106 */         aliquota.setSeqAliquota(rs.getString("SEQ_ALIQUOTA"));
/* 107 */         aliquota.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 108 */         aliquota.setTipoAliquota(rs.getString("TIPO_ALIQUOTA"));
/* 109 */         aliquota.setSituacao(rs.getString("SITUACAO"));
/* 110 */         aliquota.setNome(rs.getString("NOME"));
/* 111 */         aliquota.setDescricao(rs.getString("DESCRICAO"));
/* 112 */         aliquota.setPercentual(rs.getBigDecimal("PERCENTUAL"));
/* 113 */         aliquota.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 114 */         aliquota.setCodigo(rs.getString("CODIGO"));
/* 115 */         listaAliquota.add(aliquota);
/*     */       }
/*     */       
/* 118 */       ps.execute();
/* 119 */       ps.close();
/*     */       
/* 121 */       return listaAliquota;
/*     */     } catch (SQLException ex) {
/* 123 */       Logger.getLogger(AliquotaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 124 */       System.out.println(ex.getMessage()); }
/* 125 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(Aliquota aliquota)
/*     */   {
/*     */     try {
/* 131 */       Conexao conexao = new Conexao();
/* 132 */       Connection conn = Conexao.getConnection();
/* 133 */       String sql = "DELETE FROM ALIQUOTA WHERE SEQ_ALIQUOTA =  ? ";
/*     */       
/* 135 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 137 */       ps.setString(1, aliquota.getSeqAliquota());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Aliquota/AliquotaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */