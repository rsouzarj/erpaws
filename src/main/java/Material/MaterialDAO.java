/*     */ package Material;
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
/*     */ 
/*     */ 
/*     */ public class MaterialDAO
/*     */ {
/*     */   public Material inserir(Material material)
/*     */   {
/*     */     try
/*     */     {
/*  29 */       String seq = Sequence.buscarNumeroSequence("SEQ_MATERIAL");
/*  30 */       material.setSeqMaterial(seq);
/*  31 */       Conexao conexao = new Conexao();
/*  32 */       Connection conn = Conexao.getConnection();
/*  33 */       String sql = "insert into MATERIAL (SEQ_MATERIAL,SEQ_EMPRESA,CODIGO,REFERENCIA,NOME,DESCRICAO,DATA_CADASTRO,SITUACAO,QTDE_ESTOQUE,seq_material_familia) values  (?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  37 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  39 */       ps.setString(1, material.getSeqMaterial());
/*  40 */       ps.setString(2, material.getSeqEmpresa());
/*  41 */       ps.setString(3, material.getCodigo());
/*  42 */       ps.setString(4, material.getReferencia());
/*  43 */       ps.setString(5, material.getNome());
/*  44 */       ps.setString(6, material.getDescricao());
/*  45 */       ps.setDate(7, new java.sql.Date(material.getDataCadastro().getTime()));
/*  46 */       ps.setString(8, material.getSituacao());
/*  47 */       ps.setBigDecimal(9, material.getQtdeEstoque());
/*  48 */       ps.setObject(10, material.getSeqMaterialFamilia());
/*     */       
/*  50 */       ps.execute();
/*  51 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  54 */       Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  55 */       System.out.println(ex.getMessage());
/*     */     }
/*  57 */     return material;
/*     */   }
/*     */   
/*     */   public Material alterar(Material material) {
/*     */     try {
/*  62 */       Conexao conexao = new Conexao();
/*  63 */       Connection conn = Conexao.getConnection();
/*  64 */       String sql = "update MATERIAL set SEQ_EMPRESA = ?,CODIGO = ?,REFERENCIA = ?,NOME = ?,DESCRICAO = ?,DATA_CADASTRO = ?,SITUACAO = ?,QTDE_ESTOQUE = ?, seq_material_familia = ? where SEQ_MATERIAL = ?";
/*     */       
/*  66 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  68 */       ps.setString(1, material.getSeqEmpresa());
/*  69 */       ps.setString(2, material.getCodigo());
/*  70 */       ps.setString(3, material.getReferencia());
/*  71 */       ps.setString(4, material.getNome());
/*  72 */       ps.setString(5, material.getDescricao());
/*  73 */       ps.setDate(6, new java.sql.Date(material.getDataCadastro().getTime()));
/*  74 */       ps.setString(7, material.getSituacao());
/*  75 */       ps.setBigDecimal(8, material.getQtdeEstoque());
/*  76 */       ps.setObject(9, material.getSeqMaterialFamilia());
/*  77 */       ps.setString(10, material.getSeqMaterial());
/*  78 */       ps.execute();
/*  79 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  82 */       Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  83 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  86 */     return material;
/*     */   }
/*     */   
/*     */   public List<Material> listar(ClausulaWhere sClausula)
/*     */   {
/*     */     try {
/*  92 */       Conexao conexao = new Conexao();
/*  93 */       Connection conn = Conexao.getConnection();
/*  94 */       String sql = "SELECT * FROM MATERIAL" + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*  98 */       List<Material> listaMaterial = new ArrayList();
/*  99 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 101 */       System.out.println(sql);
/*     */       
/* 103 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 105 */       while (rs.next()) {
/* 106 */         Material material = new Material();
/* 107 */         material.setSeqMaterial(rs.getString("SEQ_MATERIAL"));
/* 108 */         material.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 109 */         material.setCodigo(rs.getString("CODIGO"));
/* 110 */         material.setReferencia(rs.getString("REFERENCIA"));
/* 111 */         material.setNome(rs.getString("NOME"));
/* 112 */         material.setDescricao(rs.getString("DESCRICAO"));
/* 113 */         material.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 114 */         material.setSituacao(rs.getString("SITUACAO"));
/* 115 */         material.setQtdeEstoque(rs.getBigDecimal("QTDE_ESTOQUE"));
/* 116 */         material.setSeqMaterialFamilia(rs.getString("seq_material_familia"));
/* 117 */         listaMaterial.add(material);
/*     */       }
/*     */       
/* 120 */       ps.execute();
/* 121 */       ps.close();
/*     */       
/* 123 */       return listaMaterial;
/*     */     } catch (SQLException ex) {
/* 125 */       Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 126 */       System.out.println(ex.getMessage()); }
/* 127 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(Material material)
/*     */   {
/*     */     try {
/* 133 */       Conexao conexao = new Conexao();
/* 134 */       Connection conn = Conexao.getConnection();
/* 135 */       String sql = "DELETE FROM MATERIAL WHERE SEQ_MATERIAL =  ? ";
/*     */       
/* 137 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 139 */       ps.setString(1, material.getSeqMaterial());
/*     */       
/* 141 */       ps.execute();
/* 142 */       ps.close();
/*     */       
/* 144 */       return true;
/*     */     } catch (SQLException ex) {
/* 146 */       System.out.println(ex.getMessage()); }
/* 147 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Material/MaterialDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */