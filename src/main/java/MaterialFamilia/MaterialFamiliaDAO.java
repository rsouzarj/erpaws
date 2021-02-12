/*     */ package MaterialFamilia;
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
/*     */ public class MaterialFamiliaDAO
/*     */ {
/*     */   public MaterialFamilia inserir(MaterialFamilia materialFamilia)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_MATERIAL_FAMILIA");
/*  28 */       materialFamilia.setSeqMaterialFamilia(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into MATERIAL_FAMILIA (SEQ_MATERIAL_FAMILIA,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,NOME) values  (?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, materialFamilia.getSeqMaterialFamilia());
/*  38 */       ps.setString(2, materialFamilia.getSeqEmpresa());
/*  39 */       ps.setDate(3, new java.sql.Date(materialFamilia.getDataCadastro().getTime()));
/*  40 */       ps.setString(4, materialFamilia.getSituacao());
/*  41 */       ps.setString(5, materialFamilia.getNome());
/*     */       
/*  43 */       ps.execute();
/*  44 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  47 */       Logger.getLogger(MaterialFamiliaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  48 */       System.out.println(ex.getMessage());
/*     */     }
/*  50 */     return materialFamilia;
/*     */   }
/*     */   
/*     */   public MaterialFamilia alterar(MaterialFamilia materialFamilia) {
/*     */     try {
/*  55 */       Conexao conexao = new Conexao();
/*  56 */       Connection conn = Conexao.getConnection();
/*  57 */       String sql = "update MATERIAL_FAMILIA set SEQ_EMPRESA = ?,DATA_CADASTRO = ?,SITUACAO = ?,NOME = ? where SEQ_MATERIAL_FAMILIA = ?";
/*     */       
/*  59 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  61 */       ps.setString(1, materialFamilia.getSeqEmpresa());
/*  62 */       ps.setDate(2, new java.sql.Date(materialFamilia.getDataCadastro().getTime()));
/*  63 */       ps.setString(3, materialFamilia.getSituacao());
/*  64 */       ps.setString(4, materialFamilia.getNome());
/*  65 */       ps.setString(5, materialFamilia.getSeqMaterialFamilia());
/*  66 */       ps.execute();
/*  67 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  70 */       Logger.getLogger(MaterialFamiliaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  71 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  74 */     return materialFamilia;
/*     */   }
/*     */   
/*     */   public List<MaterialFamilia> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  79 */       Conexao conexao = new Conexao();
/*  80 */       Connection conn = Conexao.getConnection();
/*  81 */       String sql = "SELECT * FROM MATERIAL_FAMILIA" + sClausula.montarsClausula();
/*  82 */       System.out.println(sql);
/*     */       
/*  84 */       List<MaterialFamilia> listaMaterialFamilia = new ArrayList();
/*  85 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  86 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  88 */       while (rs.next()) {
/*  89 */         MaterialFamilia materialFamilia = new MaterialFamilia();
/*  90 */         materialFamilia.setSeqMaterialFamilia(rs.getString("SEQ_MATERIAL_FAMILIA"));
/*  91 */         materialFamilia.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/*  92 */         materialFamilia.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/*  93 */         materialFamilia.setSituacao(rs.getString("SITUACAO"));
/*  94 */         materialFamilia.setNome(rs.getString("NOME"));
/*  95 */         listaMaterialFamilia.add(materialFamilia);
/*     */       }
/*     */       
/*  98 */       ps.execute();
/*  99 */       ps.close();
/*     */       
/* 101 */       return listaMaterialFamilia;
/*     */     } catch (SQLException ex) {
/* 103 */       Logger.getLogger(MaterialFamiliaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 104 */       System.out.println(ex.getMessage()); }
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(MaterialFamilia materialFamilia)
/*     */   {
/*     */     try {
/* 111 */       Conexao conexao = new Conexao();
/* 112 */       Connection conn = Conexao.getConnection();
/* 113 */       String sql = "DELETE FROM MATERIAL_FAMILIA WHERE SEQ_MATERIAL_FAMILIA =  ? ";
/*     */       
/* 115 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 117 */       ps.setString(1, materialFamilia.getSeqMaterialFamilia());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/MaterialFamilia/MaterialFamiliaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */