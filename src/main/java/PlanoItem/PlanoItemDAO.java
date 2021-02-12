/*     */ package PlanoItem;
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
/*     */ public class PlanoItemDAO
/*     */ {
/*     */   public PlanoItem inserir(PlanoItem planoItem)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_PLANO_ITEM");
/*  28 */       planoItem.setSeqPlanoItem(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into PLANO_ITEM (SEQ_PLANO_ITEM,NOME_PLANO,DATA_CADASTRO,IDENTIFICACAO_LISTA,situacao,seq_empresa) values  (?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, planoItem.getSeqPlanoItem());
/*  38 */       ps.setString(2, planoItem.getNomePlano());
/*     */       try {
/*  40 */         ps.setDate(3, new java.sql.Date(planoItem.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  42 */         ps.setDate(3, null);
/*     */       }
/*  44 */       ps.setString(4, planoItem.getIdentificacaoLista());
/*  45 */       ps.setString(5, planoItem.getSituacao());
/*  46 */       ps.setString(6, planoItem.getSeqEmpresa());
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(PlanoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return planoItem;
/*     */   }
/*     */   
/*     */   public PlanoItem alterar(PlanoItem planoItem) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update PLANO_ITEM set NOME_PLANO = ?,DATA_CADASTRO = ?,seq_empresa = ?,IDENTIFICACAO_LISTA = ?, situacao = ? where SEQ_PLANO_ITEM = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, planoItem.getNomePlano());
/*     */       try {
/*  68 */         ps.setDate(2, new java.sql.Date(planoItem.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  70 */         ps.setDate(2, null);
/*     */       }
/*  72 */       ps.setString(3, planoItem.getSeqEmpresa());
/*  73 */       ps.setString(4, planoItem.getIdentificacaoLista());
/*  74 */       ps.setString(5, planoItem.getSituacao());
/*  75 */       ps.setString(6, planoItem.getSeqPlanoItem());
/*  76 */       ps.execute();
/*  77 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  80 */       Logger.getLogger(PlanoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  81 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  84 */     return planoItem;
/*     */   }
/*     */   
/*     */   public List<PlanoItem> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  89 */       Conexao conexao = new Conexao();
/*  90 */       Connection conn = Conexao.getConnection();
/*  91 */       String sql = "SELECT * FROM PLANO_ITEM" + sClausula.montarsClausula();
/*  92 */       System.out.println(sql);
/*     */       
/*  94 */       List<PlanoItem> listaPlanoItem = new ArrayList();
/*  95 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  96 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  98 */       while (rs.next()) {
/*  99 */         PlanoItem planoItem = new PlanoItem();
/* 100 */         planoItem.setSeqPlanoItem(rs.getString("SEQ_PLANO_ITEM"));
/* 101 */         planoItem.setNomePlano(rs.getString("NOME_PLANO"));
/* 102 */         planoItem.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 103 */         planoItem.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 104 */         planoItem.setSituacao(rs.getString("situacao"));
/* 105 */         planoItem.setIdentificacaoLista(rs.getString("IDENTIFICACAO_LISTA"));
/* 106 */         listaPlanoItem.add(planoItem);
/*     */       }
/*     */       
/* 109 */       ps.execute();
/* 110 */       ps.close();
/*     */       
/* 112 */       return listaPlanoItem;
/*     */     } catch (SQLException ex) {
/* 114 */       Logger.getLogger(PlanoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 115 */       System.out.println(ex.getMessage()); }
/* 116 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(PlanoItem planoItem)
/*     */   {
/*     */     try {
/* 122 */       Conexao conexao = new Conexao();
/* 123 */       Connection conn = Conexao.getConnection();
/* 124 */       String sql = "DELETE FROM PLANO_ITEM WHERE SEQ_PLANO_ITEM =  ? ";
/*     */       
/* 126 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 128 */       ps.setString(1, planoItem.getSeqPlanoItem());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/PlanoItem/PlanoItemDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */