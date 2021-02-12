/*     */ package FinanceiroItemPc;
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
/*     */ public class FinanceiroItemPcDAO
/*     */ {
/*     */   public FinanceiroItemPc inserir(FinanceiroItemPc financeiroItemPc)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_FINANCEIRO_ITEM_PC");
/*  28 */       financeiroItemPc.setSeqFinanceiroItemPc(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into FINANCEIRO_ITEM_PC (SEQ_FINANCEIRO_ITEM_PC,DATA_CADASTRO,SEQ_FINANCEIRO,DATA,DESCRICAO,NUMERO_DOCUMENTO,VALOR,CNPJ_CPF,RAZAO_SOCIAL,SEQ_EMPRESA,SEQ_DOCUMENTO_FISCAL) values  (?,?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, financeiroItemPc.getSeqFinanceiroItemPc());
/*     */       try {
/*  39 */         ps.setDate(2, new java.sql.Date(financeiroItemPc.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  41 */         ps.setDate(2, null);
/*     */       }
/*  43 */       ps.setString(3, financeiroItemPc.getSeqFinanceiro());
/*     */       try {
/*  45 */         ps.setDate(4, new java.sql.Date(financeiroItemPc.getData().getTime()));
/*     */       } catch (NullPointerException e) {
/*  47 */         ps.setDate(4, null);
/*     */       }
/*  49 */       ps.setString(5, financeiroItemPc.getDescricao());
/*  50 */       ps.setString(6, financeiroItemPc.getNumeroDocumento());
/*  51 */       ps.setBigDecimal(7, financeiroItemPc.getValor());
/*  52 */       ps.setString(8, financeiroItemPc.getCnpjCpf());
/*  53 */       ps.setString(9, financeiroItemPc.getRazaoSocial());
/*  54 */       ps.setString(10, financeiroItemPc.getSeqEmpresa());
/*  55 */       ps.setString(11, financeiroItemPc.getSeqDocumentoFiscal());
/*     */       
/*  57 */       ps.execute();
/*  58 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  61 */       Logger.getLogger(FinanceiroItemPcDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  62 */       System.out.println(ex.getMessage());
/*     */     }
/*  64 */     return financeiroItemPc;
/*     */   }
/*     */   
/*     */   public FinanceiroItemPc alterar(FinanceiroItemPc financeiroItemPc) {
/*     */     try {
/*  69 */       Conexao conexao = new Conexao();
/*  70 */       Connection conn = Conexao.getConnection();
/*  71 */       String sql = "update FINANCEIRO_ITEM_PC set DATA_CADASTRO = ?,SEQ_FINANCEIRO = ?,DATA = ?,DESCRICAO = ?,NUMERO_DOCUMENTO = ?,VALOR = ?,CNPJ_CPF = ?,RAZAO_SOCIAL = ?,SEQ_EMPRESA = ?,SEQ_DOCUMENTO_FISCAL = ? where SEQ_FINANCEIRO_ITEM_PC = ?";
/*     */       
/*  73 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       try
/*     */       {
/*  76 */         ps.setDate(1, new java.sql.Date(financeiroItemPc.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  78 */         ps.setDate(1, null);
/*     */       }
/*  80 */       ps.setString(2, financeiroItemPc.getSeqFinanceiro());
/*     */       try {
/*  82 */         ps.setDate(3, new java.sql.Date(financeiroItemPc.getData().getTime()));
/*     */       } catch (NullPointerException e) {
/*  84 */         ps.setDate(3, null);
/*     */       }
/*  86 */       ps.setString(4, financeiroItemPc.getDescricao());
/*  87 */       ps.setString(5, financeiroItemPc.getNumeroDocumento());
/*  88 */       ps.setBigDecimal(6, financeiroItemPc.getValor());
/*  89 */       ps.setString(7, financeiroItemPc.getCnpjCpf());
/*  90 */       ps.setString(8, financeiroItemPc.getRazaoSocial());
/*  91 */       ps.setString(9, financeiroItemPc.getSeqEmpresa());
/*  92 */       ps.setString(10, financeiroItemPc.getSeqDocumentoFiscal());
/*  93 */       ps.setString(11, financeiroItemPc.getSeqFinanceiroItemPc());
/*  94 */       ps.execute();
/*  95 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  98 */       Logger.getLogger(FinanceiroItemPcDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  99 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/* 102 */     return financeiroItemPc;
/*     */   }
/*     */   
/*     */   public List<FinanceiroItemPc> listar(ClausulaWhere sClausula) {
/*     */     try {
/* 107 */       Conexao conexao = new Conexao();
/* 108 */       Connection conn = Conexao.getConnection();
/* 109 */       String sql = "SELECT FINANCEIRO_ITEM_PC.*, documento_fiscal.nome nomeDocumentoFiscal  FROM FINANCEIRO_ITEM_PC  left join documento_fiscal on documento_fiscal.seq_documento_fiscal = FINANCEIRO_ITEM_PC.seq_documento_fiscal " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/* 113 */       System.out.println(sql);
/*     */       
/* 115 */       List<FinanceiroItemPc> listaFinanceiroItemPc = new ArrayList();
/* 116 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 117 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 119 */       while (rs.next()) {
/* 120 */         FinanceiroItemPc financeiroItemPc = new FinanceiroItemPc();
/* 121 */         financeiroItemPc.setSeqFinanceiroItemPc(rs.getString("SEQ_FINANCEIRO_ITEM_PC"));
/* 122 */         financeiroItemPc.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 123 */         financeiroItemPc.setSeqFinanceiro(rs.getString("SEQ_FINANCEIRO"));
/* 124 */         financeiroItemPc.setData(rs.getDate("DATA"));
/* 125 */         financeiroItemPc.setDescricao(rs.getString("DESCRICAO"));
/* 126 */         financeiroItemPc.setNumeroDocumento(rs.getString("NUMERO_DOCUMENTO"));
/* 127 */         financeiroItemPc.setValor(rs.getBigDecimal("VALOR"));
/* 128 */         financeiroItemPc.setCnpjCpf(rs.getString("CNPJ_CPF"));
/* 129 */         financeiroItemPc.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
/* 130 */         financeiroItemPc.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 131 */         financeiroItemPc.setSeqDocumentoFiscal(rs.getString("SEQ_DOCUMENTO_FISCAL"));
/* 132 */         financeiroItemPc.setNomeDocumentoFiscal(rs.getString("nomeDocumentoFiscal"));
/* 133 */         listaFinanceiroItemPc.add(financeiroItemPc);
/*     */       }
/*     */       
/* 136 */       ps.execute();
/* 137 */       ps.close();
/*     */       
/* 139 */       return listaFinanceiroItemPc;
/*     */     } catch (SQLException ex) {
/* 141 */       Logger.getLogger(FinanceiroItemPcDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 142 */       System.out.println(ex.getMessage()); }
/* 143 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(FinanceiroItemPc financeiroItemPc)
/*     */   {
/*     */     try {
/* 149 */       Conexao conexao = new Conexao();
/* 150 */       Connection conn = Conexao.getConnection();
/* 151 */       String sql = "DELETE FROM FINANCEIRO_ITEM_PC WHERE SEQ_FINANCEIRO_ITEM_PC =  ? ";
/*     */       
/* 153 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 155 */       ps.setString(1, financeiroItemPc.getSeqFinanceiroItemPc());
/*     */       
/* 157 */       ps.execute();
/* 158 */       ps.close();
/*     */       
/* 160 */       return true;
/*     */     } catch (SQLException ex) {
/* 162 */       System.out.println(ex.getMessage()); }
/* 163 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FinanceiroItemPc/FinanceiroItemPcDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */