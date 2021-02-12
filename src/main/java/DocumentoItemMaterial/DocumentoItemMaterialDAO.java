/*     */ package DocumentoItemMaterial;
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
/*     */ public class DocumentoItemMaterialDAO
/*     */ {
/*     */   public DocumentoItemMaterial inserir(DocumentoItemMaterial documentoItemMaterial)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_DOCUMENTO_ITEM_MATERIAL");
/*  28 */       documentoItemMaterial.setSeqDocumentoItemMaterial(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into DOCUMENTO_ITEM_MATERIAL (SEQ_DOCUMENTO_ITEM_MATERIAL,SEQ_EMPRESA,SEQ_DOCUMENTO,DATA_CADASTRO,SITUACAO,SEQ_MATERIAL,VL_UNITARIO,QTDE, preco_tabela, preco_total, vl_desconto, tipo_desconto, unidade,qtde_anterior,qtde_periodo,qtde_acumulado,vl_periodo,vl_acumulado,descricao,chk_cambio) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, documentoItemMaterial.getSeqDocumentoItemMaterial());
/*  38 */       ps.setString(2, documentoItemMaterial.getSeqEmpresa());
/*  39 */       ps.setString(3, documentoItemMaterial.getSeqDocumento());
/*  40 */       ps.setDate(4, new java.sql.Date(documentoItemMaterial.getDataCadastro().getTime()));
/*  41 */       ps.setString(5, documentoItemMaterial.getSituacao());
/*  42 */       ps.setString(6, documentoItemMaterial.getSeqMaterial());
/*  43 */       ps.setBigDecimal(7, documentoItemMaterial.getVlUnitario());
/*  44 */       ps.setBigDecimal(8, documentoItemMaterial.getQtde());
/*  45 */       ps.setBigDecimal(9, documentoItemMaterial.getPrecoTabela());
/*  46 */       ps.setBigDecimal(10, documentoItemMaterial.getPrecoTotal());
/*  47 */       ps.setBigDecimal(11, documentoItemMaterial.getVlDesconto());
/*  48 */       ps.setString(12, documentoItemMaterial.getTipoDesconto());
/*  49 */       ps.setBigDecimal(13, documentoItemMaterial.getSeqUnidade());
/*  50 */       ps.setBigDecimal(14, documentoItemMaterial.getQtdeAnterior());
/*  51 */       ps.setBigDecimal(15, documentoItemMaterial.getQtdePeriodo());
/*  52 */       ps.setBigDecimal(16, documentoItemMaterial.getQtdeAcumulado());
/*  53 */       ps.setBigDecimal(17, documentoItemMaterial.getVlPeriodo());
/*  54 */       ps.setBigDecimal(18, documentoItemMaterial.getVlAcumulado());
/*  55 */       ps.setString(19, documentoItemMaterial.getDescricao());
/*  56 */       ps.setBoolean(20, documentoItemMaterial.isChkTaxaCambio());
/*     */       
/*  58 */       ps.execute();
/*  59 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  62 */       Logger.getLogger(DocumentoItemMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  63 */       System.out.println(ex.getMessage());
/*     */     }
/*  65 */     return documentoItemMaterial;
/*     */   }
/*     */   
/*     */   public DocumentoItemMaterial alterar(DocumentoItemMaterial documentoItemMaterial) {
/*     */     try {
/*  70 */       Conexao conexao = new Conexao();
/*  71 */       Connection conn = Conexao.getConnection();
/*  72 */       String sql = "update DOCUMENTO_ITEM_MATERIAL set SEQ_EMPRESA = ?,SITUACAO = ?,SEQ_MATERIAL = ?,VL_UNITARIO = ?,QTDE = ?, preco_tabela = ?, preco_total = ?, vl_desconto = ?, tipo_desconto = ?, unidade = ?, qtde_anterior = ?,qtde_periodo = ?,qtde_acumulado = ?,vl_periodo = ?,vl_acumulado = ?, descricao = ?, chk_cambio = ?  where SEQ_DOCUMENTO_ITEM_MATERIAL = ?";
/*     */       
/*     */ 
/*  75 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  77 */       ps.setString(1, documentoItemMaterial.getSeqEmpresa());
/*  78 */       ps.setString(2, documentoItemMaterial.getSituacao());
/*  79 */       ps.setString(3, documentoItemMaterial.getSeqMaterial());
/*  80 */       ps.setBigDecimal(4, documentoItemMaterial.getVlUnitario());
/*  81 */       ps.setBigDecimal(5, documentoItemMaterial.getQtde());
/*  82 */       ps.setBigDecimal(6, documentoItemMaterial.getPrecoTabela());
/*  83 */       ps.setBigDecimal(7, documentoItemMaterial.getPrecoTotal());
/*  84 */       ps.setBigDecimal(8, documentoItemMaterial.getVlDesconto());
/*  85 */       ps.setString(9, documentoItemMaterial.getTipoDesconto());
/*  86 */       ps.setBigDecimal(10, documentoItemMaterial.getSeqUnidade());
/*  87 */       ps.setBigDecimal(11, documentoItemMaterial.getQtdeAnterior());
/*  88 */       ps.setBigDecimal(12, documentoItemMaterial.getQtdePeriodo());
/*  89 */       ps.setBigDecimal(13, documentoItemMaterial.getQtdeAcumulado());
/*  90 */       ps.setBigDecimal(14, documentoItemMaterial.getVlPeriodo());
/*  91 */       ps.setBigDecimal(15, documentoItemMaterial.getVlAcumulado());
/*  92 */       ps.setString(16, documentoItemMaterial.getDescricao());
/*  93 */       ps.setBoolean(17, documentoItemMaterial.isChkTaxaCambio());
/*  94 */       ps.setString(18, documentoItemMaterial.getSeqDocumentoItemMaterial());
/*  95 */       ps.execute();
/*  96 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  99 */       Logger.getLogger(DocumentoItemMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 100 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/* 103 */     return documentoItemMaterial;
/*     */   }
/*     */   
/*     */   public List<DocumentoItemMaterial> listar(ClausulaWhere sClausula) {
/*     */     try {
/* 108 */       Conexao conexao = new Conexao();
/* 109 */       Connection conn = Conexao.getConnection();
/* 110 */       String sql = "SELECT DOCUMENTO_ITEM_MATERIAL.*, material.nome material_nome,material.codigo material_codigo, material.referencia material_referencia FROM DOCUMENTO_ITEM_MATERIAL inner join material on material.seq_material = DOCUMENTO_ITEM_MATERIAL.seq_material " + sClausula.montarsClausula() + "order by DOCUMENTO_ITEM_MATERIAL.SEQ_DOCUMENTO_ITEM_MATERIAL ";
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 118 */       List<DocumentoItemMaterial> listaDocumentoItemMaterial = new ArrayList();
/* 119 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 120 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 122 */       while (rs.next()) {
/* 123 */         DocumentoItemMaterial documentoItemMaterial = new DocumentoItemMaterial();
/* 124 */         documentoItemMaterial.setSeqDocumentoItemMaterial(rs.getString("SEQ_DOCUMENTO_ITEM_MATERIAL"));
/* 125 */         documentoItemMaterial.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 126 */         documentoItemMaterial.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/* 127 */         documentoItemMaterial.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 128 */         documentoItemMaterial.setSituacao(rs.getString("SITUACAO"));
/* 129 */         documentoItemMaterial.setSeqMaterial(rs.getString("SEQ_MATERIAL"));
/* 130 */         documentoItemMaterial.setVlUnitario(rs.getBigDecimal("VL_UNITARIO"));
/* 131 */         documentoItemMaterial.setVlDesconto(rs.getBigDecimal("vl_desconto"));
/* 132 */         documentoItemMaterial.setTipoDesconto(rs.getString("tipo_desconto"));
/* 133 */         documentoItemMaterial.setQtde(rs.getBigDecimal("QTDE"));
/* 134 */         documentoItemMaterial.setPrecoTabela(rs.getBigDecimal("preco_tabela"));
/* 135 */         documentoItemMaterial.setPrecoTotal(rs.getBigDecimal("preco_total"));
/* 136 */         documentoItemMaterial.setMaterialCodigo(rs.getString("material_codigo"));
/* 137 */         documentoItemMaterial.setMaterialNome(rs.getString("material_nome"));
/* 138 */         documentoItemMaterial.setDescricao(rs.getString("descricao"));
/* 139 */         documentoItemMaterial.setMaterialReferencia(rs.getString("material_referencia"));
/* 140 */         documentoItemMaterial.setSeqUnidade(rs.getBigDecimal("unidade"));
/* 141 */         documentoItemMaterial.setQtdeAnterior(rs.getBigDecimal("qtde_anterior"));
/* 142 */         documentoItemMaterial.setQtdePeriodo(rs.getBigDecimal("qtde_periodo"));
/* 143 */         documentoItemMaterial.setQtdeAcumulado(rs.getBigDecimal("qtde_acumulado"));
/* 144 */         documentoItemMaterial.setVlPeriodo(rs.getBigDecimal("vl_periodo"));
/* 145 */         documentoItemMaterial.setVlAcumulado(rs.getBigDecimal("vl_acumulado"));
/* 146 */         documentoItemMaterial.setChkTaxaCambio(rs.getBoolean("chk_cambio"));
/* 147 */         listaDocumentoItemMaterial.add(documentoItemMaterial);
/*     */       }
/*     */       
/* 150 */       ps.execute();
/* 151 */       ps.close();
/*     */       
/* 153 */       return listaDocumentoItemMaterial;
/*     */     } catch (SQLException ex) {
/* 155 */       Logger.getLogger(DocumentoItemMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 156 */       System.out.println(ex.getMessage()); }
/* 157 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(DocumentoItemMaterial documentoItemMaterial)
/*     */   {
/*     */     try {
/* 163 */       Conexao conexao = new Conexao();
/* 164 */       Connection conn = Conexao.getConnection();
/* 165 */       String sql = "DELETE FROM DOCUMENTO_ITEM_MATERIAL WHERE SEQ_DOCUMENTO_ITEM_MATERIAL =  ? ";
/*     */       
/* 167 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 169 */       ps.setString(1, documentoItemMaterial.getSeqDocumentoItemMaterial());
/*     */       
/* 171 */       ps.execute();
/* 172 */       ps.close();
/*     */       
/* 174 */       return true;
/*     */     } catch (SQLException ex) {
/* 176 */       System.out.println(ex.getMessage()); }
/* 177 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemMaterial/DocumentoItemMaterialDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */