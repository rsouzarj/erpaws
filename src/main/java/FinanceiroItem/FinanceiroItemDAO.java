/*     */ package FinanceiroItem;
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
/*     */ public class FinanceiroItemDAO
/*     */ {
/*     */   public FinanceiroItem inserir(FinanceiroItem financeiroItem)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_FINANCEIRO_ITEM");
/*  28 */       financeiroItem.setSeqFinanceiroItem(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into FINANCEIRO_ITEM (SEQ_FINANCEIRO_ITEM,DATA_CADASTRO,SEQ_FINANCEIRO,QUANTIDADE,DESCRICAO,VALOR_UNITARIO,VALOR_TOTAL,SEQ_EMPRESA,SEQ_UNIDADE,SEQ_DOCUMENTO) values  (?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, financeiroItem.getSeqFinanceiroItem());
/*     */       try {
/*  39 */         ps.setDate(2, new java.sql.Date(financeiroItem.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  41 */         ps.setDate(2, null);
/*     */       }
/*  43 */       ps.setString(3, financeiroItem.getSeqFinanceiro());
/*  44 */       ps.setBigDecimal(4, financeiroItem.getQuantidade());
/*  45 */       ps.setString(5, financeiroItem.getDescricao());
/*  46 */       ps.setBigDecimal(6, financeiroItem.getValorUnitario());
/*  47 */       ps.setBigDecimal(7, financeiroItem.getValorTotal());
/*  48 */       ps.setString(8, financeiroItem.getSeqEmpresa());
/*  49 */       ps.setString(9, financeiroItem.getSeqUnidade());
/*     */       ps.setString(10, financeiroItem.getSeqDocumento());

/*  51 */       ps.execute();
/*  52 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  55 */       Logger.getLogger(FinanceiroItemDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  56 */       System.out.println(ex.getMessage());
/*     */     }
/*  58 */     return financeiroItem;
/*     */   }
/*     */   
/*     */   public FinanceiroItem alterar(FinanceiroItem financeiroItem) {
/*     */     try {
/*  63 */       Conexao conexao = new Conexao();
/*  64 */       Connection conn = Conexao.getConnection();
/*  65 */       String sql = "update FINANCEIRO_ITEM set DATA_CADASTRO = ?,SEQ_FINANCEIRO = ?,QUANTIDADE = ?,DESCRICAO = ?,VALOR_UNITARIO = ?,VALOR_TOTAL = ?,SEQ_EMPRESA = ?,SEQ_UNIDADE = ?, SEQ_DOCUMENTO = ? where SEQ_FINANCEIRO_ITEM = ?";
/*     */       
/*  67 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       try
/*     */       {
/*  70 */         ps.setDate(1, new java.sql.Date(financeiroItem.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  72 */         ps.setDate(1, null);
/*     */       }
/*  74 */       ps.setString(2, financeiroItem.getSeqFinanceiro());
/*  75 */       ps.setBigDecimal(3, financeiroItem.getQuantidade());
/*  76 */       ps.setString(4, financeiroItem.getDescricao());
/*  77 */       ps.setBigDecimal(5, financeiroItem.getValorUnitario());
/*  78 */       ps.setBigDecimal(6, financeiroItem.getValorTotal());
/*  79 */       ps.setString(7, financeiroItem.getSeqEmpresa());
/*  80 */       ps.setString(8, financeiroItem.getSeqUnidade());
/*  81 */       ps.setString(9, financeiroItem.getSeqDocumento());
                ps.setString(10, financeiroItem.getSeqFinanceiroItem());
/*  82 */       ps.execute();
/*  83 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  86 */       Logger.getLogger(FinanceiroItemDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  87 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  90 */     return financeiroItem;
/*     */   }
/*     */   
/*     */   public List<FinanceiroItem> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  95 */       Conexao conexao = new Conexao();
/*  96 */       Connection conn = Conexao.getConnection();
/*  97 */       String sql = "SELECT * FROM FINANCEIRO_ITEM" + sClausula.montarsClausula();
/*  98 */       System.out.println(sql);
/*     */       
/* 100 */       List<FinanceiroItem> listaFinanceiroItem = new ArrayList();
/* 101 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 102 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 104 */       while (rs.next()) {
/* 105 */         FinanceiroItem financeiroItem = new FinanceiroItem();
/* 106 */         financeiroItem.setSeqFinanceiroItem(rs.getString("SEQ_FINANCEIRO_ITEM"));
/* 107 */         financeiroItem.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 108 */         financeiroItem.setSeqFinanceiro(rs.getString("SEQ_FINANCEIRO"));
/* 109 */         financeiroItem.setQuantidade(rs.getBigDecimal("QUANTIDADE"));
/* 110 */         financeiroItem.setDescricao(rs.getString("DESCRICAO"));
/* 111 */         financeiroItem.setValorUnitario(rs.getBigDecimal("VALOR_UNITARIO"));
/* 112 */         financeiroItem.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
/* 113 */         financeiroItem.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 114 */         financeiroItem.setSeqUnidade(rs.getString("SEQ_UNIDADE"));
                  financeiroItem.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/* 115 */         listaFinanceiroItem.add(financeiroItem);
/*     */       }
/*     */       
/* 118 */       ps.execute();
/* 119 */       ps.close();
/*     */       
/* 121 */       return listaFinanceiroItem;
/*     */     } catch (SQLException ex) {
/* 123 */       Logger.getLogger(FinanceiroItemDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 124 */       System.out.println(ex.getMessage()); }
/* 125 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(FinanceiroItem financeiroItem)
/*     */   {
/*     */     try {
/* 131 */       Conexao conexao = new Conexao();
/* 132 */       Connection conn = Conexao.getConnection();
/* 133 */       String sql = "DELETE FROM FINANCEIRO_ITEM WHERE SEQ_FINANCEIRO_ITEM =  ? ";
/*     */       
/* 135 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 137 */       ps.setString(1, financeiroItem.getSeqFinanceiroItem());
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
