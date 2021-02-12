/*     */ package TipoParceiro;
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
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TipoParceiroDAO
/*     */ {
/*     */   public TipoParceiro inserir(TipoParceiro tipoParceiro)
/*     */   {
/*     */     try
/*     */     {
/*  28 */       String seq = Sequence.buscarNumeroSequence("SEQ_TIPO_PARCEIRO");
/*  29 */       tipoParceiro.setSeqTipoParceiro(seq);
/*  30 */       Conexao conexao = new Conexao();
/*  31 */       Connection conn = Conexao.getConnection();
/*  32 */       String sql = "insert into TIPO_PARCEIRO (SEQ_TIPO_PARCEIRO,NOME,DATA_CADASTRO,SITUACAO,ORDEM,SEQ_EMPRESA,chave_origem,portal_comercial, cpf_cnpj_obrigatorio) values  (?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  36 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  38 */       ps.setString(1, tipoParceiro.getSeqTipoParceiro());
/*  39 */       ps.setString(2, tipoParceiro.getNome());
/*  40 */       ps.setDate(3, new java.sql.Date(tipoParceiro.getDataCadastro().getTime()));
/*  41 */       ps.setString(4, tipoParceiro.getSituacao());
/*  42 */       ps.setString(5, tipoParceiro.getOrdem());
/*  43 */       ps.setString(6, tipoParceiro.getSeqEmpresa());
/*  44 */       ps.setString(7, tipoParceiro.getChaveOrigem());
/*  45 */       ps.setString(8, tipoParceiro.getPortalComercial());
/*  46 */       ps.setString(9, tipoParceiro.getCpfCnpjObrigatorio());
/*     */       
/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(TipoParceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return tipoParceiro;
/*     */   }
/*     */   
/*     */   public TipoParceiro alterar(TipoParceiro tipoParceiro) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update TIPO_PARCEIRO set NOME = ?,DATA_CADASTRO = ?,SITUACAO = ?,ORDEM = ?,SEQ_EMPRESA = ?, chave_origem = ?, portal_comercial = ? , cpf_cnpj_obrigatorio = ? where SEQ_TIPO_PARCEIRO = ? ";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, tipoParceiro.getNome());
/*  67 */       ps.setDate(2, new java.sql.Date(tipoParceiro.getDataCadastro().getTime()));
/*  68 */       ps.setString(3, tipoParceiro.getSituacao());
/*  69 */       ps.setString(4, tipoParceiro.getOrdem());
/*  70 */       ps.setString(5, tipoParceiro.getSeqEmpresa());
/*  71 */       ps.setString(6, tipoParceiro.getChaveOrigem());
/*  72 */       ps.setString(7, tipoParceiro.getPortalComercial());
/*  73 */       ps.setString(8, tipoParceiro.getCpfCnpjObrigatorio());
/*  74 */       ps.setString(9, tipoParceiro.getSeqTipoParceiro());
/*  75 */       ps.execute();
/*  76 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  79 */       Logger.getLogger(TipoParceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  80 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  83 */     return tipoParceiro;
/*     */   }
/*     */   
/*     */   public List<TipoParceiro> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  88 */       Conexao conexao = new Conexao();
/*  89 */       Connection conn = Conexao.getConnection();
/*  90 */       String sql = "SELECT * FROM TIPO_PARCEIRO " + sClausula.montarsClausula();
/*     */       
/*  92 */       List<TipoParceiro> listaTipoParceiro = new ArrayList();
/*  93 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  94 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  96 */       while (rs.next()) {
/*  97 */         TipoParceiro tipoParceiro = new TipoParceiro();
/*  98 */         tipoParceiro.setSeqTipoParceiro(rs.getString("SEQ_TIPO_PARCEIRO"));
/*  99 */         tipoParceiro.setNome(rs.getString("NOME"));
/* 100 */         tipoParceiro.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 101 */         tipoParceiro.setSituacao(rs.getString("SITUACAO"));
/* 102 */         tipoParceiro.setOrdem(rs.getString("ORDEM"));
/* 103 */         tipoParceiro.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 104 */         tipoParceiro.setChaveOrigem(rs.getString("chave_origem"));
/* 105 */         tipoParceiro.setPortalComercial(rs.getString("portal_comercial"));
/* 106 */         tipoParceiro.setCpfCnpjObrigatorio(rs.getString("cpf_cnpj_obrigatorio"));
/* 107 */         listaTipoParceiro.add(tipoParceiro);
/*     */       }
/*     */       
/* 110 */       ps.execute();
/* 111 */       ps.close();
/*     */       
/* 113 */       return listaTipoParceiro;
/*     */     } catch (SQLException ex) {
/* 115 */       Logger.getLogger(TipoParceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 116 */       System.out.println(ex.getMessage()); }
/* 117 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(TipoParceiro tipoParceiro)
/*     */   {
/*     */     try {
/* 123 */       Conexao conexao = new Conexao();
/* 124 */       Connection conn = Conexao.getConnection();
/* 125 */       String sql = "DELETE FROM TIPO_PARCEIRO WHERE SEQ_TIPO_PARCEIRO =  ? ";
/*     */       
/* 127 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 129 */       ps.setString(1, tipoParceiro.getSeqTipoParceiro());
/*     */       
/* 131 */       ps.execute();
/* 132 */       ps.close();
/*     */       
/* 134 */       return true;
/*     */     } catch (SQLException ex) {
/* 136 */       System.out.println(ex.getMessage()); }
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   public HashMap<String, String> listarContador(String pSeqEmpresa)
/*     */   {
/* 142 */     HashMap<String, String> retorno = new HashMap();
/*     */     try {
/* 144 */       Conexao conexao = new Conexao();
/* 145 */       Connection conn = Conexao.getConnection();
/* 146 */       String sql = "select \n                    tipo_parceiro.seq_tipo_parceiro,\n                    tipo_parceiro.nome,\n                    count(parceiro.SEQ_parceiro) total\n                    From \n                    tipo_parceiro\n                    inner join parceiro  on parceiro.seq_tipo_parceiro = tipo_parceiro.seq_tipo_parceiro and tipo_parceiro.seq_empresa = parceiro.seq_empresa \n                    where \n                    tipo_parceiro.seq_empresa = " + String.valueOf(pSeqEmpresa) + "                    group by \n" + "                    tipo_parceiro.nome,\n" + "                    tipo_parceiro.seq_tipo_parceiro";
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */       System.out.println("SQL: ==>  " + sql);
/*     */       
/* 161 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 162 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 164 */       while (rs.next()) {
/* 165 */         retorno.put(rs.getString("SEQ_TIPO_PARCEIRO"), rs.getString("NOME") + " (" + rs.getString("TOTAL") + ")");
/*     */       }
/*     */       
/* 168 */       ps.execute();
/* 169 */       ps.close();
/*     */       
/* 171 */       return retorno;
/*     */     } catch (SQLException ex) {
/* 173 */       Logger.getLogger(TipoParceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 174 */       System.out.println(ex.getMessage()); }
/* 175 */     return null;
/*     */   }
/*     */   
/*     */   public HashMap<String, String> listarContadorVendedor(String pSeqEmpresa, String pSeqParceiroVendedor)
/*     */   {
/* 180 */     HashMap<String, String> retorno = new HashMap();
/*     */     try {
/* 182 */       Conexao conexao = new Conexao();
/* 183 */       Connection conn = Conexao.getConnection();
/* 184 */       String sql = "select \n                    tipo_parceiro.seq_tipo_parceiro,\n                    tipo_parceiro.nome,\n                    count(distinct parceiro.SEQ_parceiro) total\n                    From \n                    tipo_parceiro\n                    inner join empresa on empresa.seq_empresa = tipo_parceiro.seq_empresa\n                    left join parceiro_vinculo on parceiro_vinculo.SEQ_TIPO_VINCULO = empresa.SEQ_TIPO_VINCULO_VENDEDOR \n                    left join parceiro on parceiro.seq_parceiro = parceiro_vinculo.seq_parceiro and parceiro.seq_tipo_parceiro = tipo_parceiro.seq_tipo_parceiro\n                    and parceiro_vinculo.seq_parceiro_vinculado = " + String.valueOf(pSeqParceiroVendedor) + "                    where \n" + "                    tipo_parceiro.seq_empresa = " + String.valueOf(pSeqEmpresa) + "                    and tipo_parceiro.PORTAL_COMERCIAL = 'Sim'" + "                    group by \n" + "                    tipo_parceiro.nome,\n" + "                    tipo_parceiro.seq_tipo_parceiro";
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 201 */       System.out.println("SQL: ==>  " + sql);
/*     */       
/* 203 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 204 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 206 */       while (rs.next()) {
/* 207 */         retorno.put(rs.getString("SEQ_TIPO_PARCEIRO"), rs.getString("NOME") + " (" + rs.getString("TOTAL") + ")");
/*     */       }
/*     */       
/* 210 */       ps.execute();
/* 211 */       ps.close();
/*     */       
/* 213 */       return retorno;
/*     */     } catch (SQLException ex) {
/* 215 */       Logger.getLogger(TipoParceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 216 */       System.out.println(ex.getMessage()); }
/* 217 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoParceiro/TipoParceiroDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */