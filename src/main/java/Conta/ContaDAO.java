/*     */ package Conta;
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
/*     */ public class ContaDAO
/*     */ {
/*     */   public Conta inserir(Conta conta)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_CONTA");
/*  28 */       conta.setSeqConta(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into CONTA (SEQ_CONTA,CONTA_CORRENTE_DV,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,DV_CEDENTE,BANCO,AGENCIA,CONTA_CORRENTE,CARTEIRA,CODIGO_CEDENTE,AGENCIA_DV,NOME,vl_tarifa,saldo_inicial) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, conta.getSeqConta());
/*  38 */       ps.setString(2, conta.getContaCorrenteDv());
/*  39 */       ps.setString(3, conta.getSeqEmpresa());
/*     */       try {
/*  41 */         ps.setDate(4, new java.sql.Date(conta.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  43 */         ps.setDate(4, null);
/*     */       }
/*  45 */       ps.setString(5, conta.getSituacao());
/*  46 */       ps.setString(6, conta.getDvCedente());
/*  47 */       ps.setString(7, conta.getBanco());
/*  48 */       ps.setString(8, conta.getAgencia());
/*  49 */       ps.setString(9, conta.getContaCorrente());
/*  50 */       ps.setString(10, conta.getCarteira());
/*  51 */       ps.setString(11, conta.getCodigoCedente());
/*  52 */       ps.setString(12, conta.getAgenciaDv());
/*  53 */       ps.setString(13, conta.getNome());
/*  54 */       ps.setBigDecimal(14, conta.getVlTarifa());
/*  55 */       ps.setBigDecimal(15, conta.getSaldoInicial());
/*     */       
/*  57 */       ps.execute();
/*  58 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  61 */       Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  62 */       System.out.println(ex.getMessage());
/*     */     }
/*  64 */     return conta;
/*     */   }
/*     */   
/*     */   public Conta alterar(Conta conta) {
/*     */     try {
/*  69 */       Conexao conexao = new Conexao();
/*  70 */       Connection conn = Conexao.getConnection();
/*  71 */       String sql = "update CONTA set CONTA_CORRENTE_DV = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ?,SITUACAO = ?,DV_CEDENTE = ?,BANCO = ?,AGENCIA = ?,CONTA_CORRENTE = ?,CARTEIRA = ?,CODIGO_CEDENTE = ?,AGENCIA_DV = ?,NOME = ?, vl_tarifa = ?,saldo_inicial = ? where SEQ_CONTA = ?";
/*     */       
/*  73 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  75 */       ps.setString(1, conta.getContaCorrenteDv());
/*  76 */       ps.setString(2, conta.getSeqEmpresa());
/*     */       try {
/*  78 */         ps.setDate(3, new java.sql.Date(conta.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  80 */         ps.setDate(3, null);
/*     */       }
/*  82 */       ps.setString(4, conta.getSituacao());
/*  83 */       ps.setString(5, conta.getDvCedente());
/*  84 */       ps.setString(6, conta.getBanco());
/*  85 */       ps.setString(7, conta.getAgencia());
/*  86 */       ps.setString(8, conta.getContaCorrente());
/*  87 */       ps.setString(9, conta.getCarteira());
/*  88 */       ps.setString(10, conta.getCodigoCedente());
/*  89 */       ps.setString(11, conta.getAgenciaDv());
/*  90 */       ps.setString(12, conta.getNome());
/*  91 */       ps.setBigDecimal(13, conta.getVlTarifa());
/*  92 */       ps.setBigDecimal(14, conta.getSaldoInicial());
/*  93 */       ps.setString(15, conta.getSeqConta());
/*  94 */       ps.execute();
/*  95 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  98 */       Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  99 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/* 102 */     return conta;
/*     */   }
/*     */   
/*     */   public List<Conta> listar(ClausulaWhere sClausula) {
/*     */     try {
/* 107 */       Conexao conexao = new Conexao();
/* 108 */       Connection conn = Conexao.getConnection();
/* 109 */       String sql = "SELECT * FROM CONTA" + sClausula.montarsClausula() + " order by banco";
/*     */       
/*     */ 
/* 112 */       List<Conta> listaConta = new ArrayList();
/* 113 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 114 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 116 */       while (rs.next()) {
/* 117 */         Conta conta = new Conta();
/* 118 */         conta.setSeqConta(rs.getString("SEQ_CONTA"));
/* 119 */         conta.setContaCorrenteDv(rs.getString("CONTA_CORRENTE_DV"));
/* 120 */         conta.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 121 */         conta.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 122 */         conta.setSituacao(rs.getString("SITUACAO"));
/* 123 */         conta.setDvCedente(rs.getString("DV_CEDENTE"));
/* 124 */         conta.setBanco(rs.getString("BANCO"));
/* 125 */         conta.setAgencia(rs.getString("AGENCIA"));
/* 126 */         conta.setContaCorrente(rs.getString("CONTA_CORRENTE"));
/* 127 */         conta.setCarteira(rs.getString("CARTEIRA"));
/* 128 */         conta.setCodigoCedente(rs.getString("CODIGO_CEDENTE"));
/* 129 */         conta.setAgenciaDv(rs.getString("AGENCIA_DV"));
/* 130 */         conta.setNome(rs.getString("NOME"));
/* 131 */         conta.setVlTarifa(rs.getBigDecimal("vl_tarifa"));
/* 132 */         conta.setSaldoInicial(rs.getBigDecimal("saldo_inicial"));
/* 133 */         listaConta.add(conta);
/*     */       }
/*     */       
/* 136 */       ps.execute();
/* 137 */       ps.close();
/*     */       
/* 139 */       return listaConta;
/*     */     } catch (SQLException ex) {
/* 141 */       Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 142 */       System.out.println(ex.getMessage()); }
/* 143 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(Conta conta)
/*     */   {
/*     */     try {
/* 149 */       Conexao conexao = new Conexao();
/* 150 */       Connection conn = Conexao.getConnection();
/* 151 */       String sql = "DELETE FROM CONTA WHERE SEQ_CONTA =  ? ";
/*     */       
/* 153 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 155 */       ps.setString(1, conta.getSeqConta());
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


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Conta/ContaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */