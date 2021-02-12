/*     */ package PesquisaSatisfacao;
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
/*     */ public class PesquisaSatisfacaoDAO
/*     */ {
/*     */   public PesquisaSatisfacao inserir(PesquisaSatisfacao pesquisaSatisfacao)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_PESQUISA_SATISFACAO");
/*  28 */       pesquisaSatisfacao.setSeqPesquisaSatisfacao(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into PESQUISA_SATISFACAO (SEQ_PESQUISA_SATISFACAO,DATA_CADASTRO,SEQ_DOCUMENTO,PERGUNTA_UM,PERGUNTA_DOIS,PERGUNTA_TRES,PERGUNTA_QUATRO,PERGUNTA_CINCO,PERGUNTA_SEIS,PERGUNTA_SETE,PERGUNTA_OITO,PERGUNTA_NOVE,PERGUNTA_DEZ,PERGUNTA_ONZE,COMENTARIO_OBSERVACAO,EMPRESA_VALIDADOR,LOCAL_VALIDADOR,FUNCIONARIO_VALIDADOR,AREA_VALIDADOR,CARGO_VALIDADOR,SEQ_EMPRESA) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, pesquisaSatisfacao.getSeqPesquisaSatisfacao());
/*     */       try {
/*  39 */         ps.setDate(2, new java.sql.Date(pesquisaSatisfacao.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  41 */         ps.setDate(2, null);
/*     */       }
/*  43 */       ps.setInt(3, pesquisaSatisfacao.getSeqDocumento().intValue());
/*  44 */       ps.setInt(4, pesquisaSatisfacao.getPerguntaUm().intValue());
/*  45 */       ps.setInt(5, pesquisaSatisfacao.getPerguntaDois().intValue());
/*  46 */       ps.setInt(6, pesquisaSatisfacao.getPerguntaTres().intValue());
/*  47 */       ps.setInt(7, pesquisaSatisfacao.getPerguntaQuatro().intValue());
/*  48 */       ps.setInt(8, pesquisaSatisfacao.getPerguntaCinco().intValue());
/*  49 */       ps.setInt(9, pesquisaSatisfacao.getPerguntaSeis().intValue());
/*  50 */       ps.setInt(10, pesquisaSatisfacao.getPerguntaSete().intValue());
/*  51 */       ps.setInt(11, pesquisaSatisfacao.getPerguntaOito().intValue());
/*  52 */       ps.setInt(12, pesquisaSatisfacao.getPerguntaNove().intValue());
/*  53 */       ps.setInt(13, pesquisaSatisfacao.getPerguntaDez().intValue());
/*  54 */       ps.setInt(14, pesquisaSatisfacao.getPerguntaOnze().intValue());
/*  55 */       ps.setString(15, pesquisaSatisfacao.getComentarioObservacao());
/*  56 */       ps.setString(16, pesquisaSatisfacao.getEmpresaValidador());
/*  57 */       ps.setString(17, pesquisaSatisfacao.getLocalValidador());
/*  58 */       ps.setString(18, pesquisaSatisfacao.getFuncionarioValidador());
/*  59 */       ps.setString(19, pesquisaSatisfacao.getAreaValidador());
/*  60 */       ps.setString(20, pesquisaSatisfacao.getCargoValidador());
/*  61 */       ps.setInt(21, pesquisaSatisfacao.getSeqEmpresa().intValue());
/*     */       
/*  63 */       ps.execute();
/*  64 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  67 */       Logger.getLogger(PesquisaSatisfacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  68 */       System.out.println(ex.getMessage());
/*     */     }
/*  70 */     return pesquisaSatisfacao;
/*     */   }
/*     */   
/*     */   public PesquisaSatisfacao alterar(PesquisaSatisfacao pesquisaSatisfacao) {
/*     */     try {
/*  75 */       Conexao conexao = new Conexao();
/*  76 */       Connection conn = Conexao.getConnection();
/*  77 */       String sql = "update PESQUISA_SATISFACAO set DATA_CADASTRO = ?,SEQ_DOCUMENTO = ?,PERGUNTA_UM = ?,PERGUNTA_DOIS = ?,PERGUNTA_TRES = ?,PERGUNTA_QUATRO = ?,PERGUNTA_CINCO = ?,PERGUNTA_SEIS = ?,PERGUNTA_SETE = ?,PERGUNTA_OITO = ?,PERGUNTA_NOVE = ?,PERGUNTA_DEZ = ?,PERGUNTA_ONZE = ?,COMENTARIO_OBSERVACAO = ?,EMPRESA_VALIDADOR = ?,LOCAL_VALIDADOR = ?,FUNCIONARIO_VALIDADOR = ?,AREA_VALIDADOR = ?,CARGO_VALIDADOR = ?,SEQ_EMPRESA = ? where SEQ_PESQUISA_SATISFACAO = ?";
/*     */       
/*  79 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       try
/*     */       {
/*  82 */         ps.setDate(1, new java.sql.Date(pesquisaSatisfacao.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  84 */         ps.setDate(1, null);
/*     */       }
/*  86 */       ps.setInt(2, pesquisaSatisfacao.getSeqDocumento().intValue());
/*  87 */       ps.setInt(3, pesquisaSatisfacao.getPerguntaUm().intValue());
/*  88 */       ps.setInt(4, pesquisaSatisfacao.getPerguntaDois().intValue());
/*  89 */       ps.setInt(5, pesquisaSatisfacao.getPerguntaTres().intValue());
/*  90 */       ps.setInt(6, pesquisaSatisfacao.getPerguntaQuatro().intValue());
/*  91 */       ps.setInt(7, pesquisaSatisfacao.getPerguntaCinco().intValue());
/*  92 */       ps.setInt(8, pesquisaSatisfacao.getPerguntaSeis().intValue());
/*  93 */       ps.setInt(9, pesquisaSatisfacao.getPerguntaSete().intValue());
/*  94 */       ps.setInt(10, pesquisaSatisfacao.getPerguntaOito().intValue());
/*  95 */       ps.setInt(11, pesquisaSatisfacao.getPerguntaNove().intValue());
/*  96 */       ps.setInt(12, pesquisaSatisfacao.getPerguntaDez().intValue());
/*  97 */       ps.setInt(13, pesquisaSatisfacao.getPerguntaOnze().intValue());
/*  98 */       ps.setString(14, pesquisaSatisfacao.getComentarioObservacao());
/*  99 */       ps.setString(15, pesquisaSatisfacao.getEmpresaValidador());
/* 100 */       ps.setString(16, pesquisaSatisfacao.getLocalValidador());
/* 101 */       ps.setString(17, pesquisaSatisfacao.getFuncionarioValidador());
/* 102 */       ps.setString(18, pesquisaSatisfacao.getAreaValidador());
/* 103 */       ps.setString(19, pesquisaSatisfacao.getCargoValidador());
/* 104 */       ps.setInt(20, pesquisaSatisfacao.getSeqEmpresa().intValue());
/* 105 */       ps.setString(21, pesquisaSatisfacao.getSeqPesquisaSatisfacao());
/* 106 */       ps.execute();
/* 107 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/* 110 */       Logger.getLogger(PesquisaSatisfacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 111 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/* 114 */     return pesquisaSatisfacao;
/*     */   }
/*     */   
/*     */   public List<PesquisaSatisfacao> listar(ClausulaWhere sClausula) {
/*     */     try {
/* 119 */       Conexao conexao = new Conexao();
/* 120 */       Connection conn = Conexao.getConnection();
/* 121 */       String sql = "SELECT PESQUISA_SATISFACAO.*,documento.codigo codigoDocumento,documento.seq_parceiro,tipo_documento.nome tipoDocumento \n FROM PESQUISA_SATISFACAO  inner join documento on documento.seq_documento = PESQUISA_SATISFACAO.seq_documento \n inner join tipo_documento on tipo_documento.seq_tipo_documento = documento.seq_tipo_documento \n" + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 126 */       System.out.println(sql);
/*     */       
/* 128 */       List<PesquisaSatisfacao> listaPesquisaSatisfacao = new ArrayList();
/* 129 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 130 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 132 */       while (rs.next()) {
/* 133 */         PesquisaSatisfacao pesquisaSatisfacao = new PesquisaSatisfacao();
/* 134 */         pesquisaSatisfacao.setSeqPesquisaSatisfacao(rs.getString("SEQ_PESQUISA_SATISFACAO"));
/* 135 */         pesquisaSatisfacao.setSeqParceiro(rs.getString("seq_parceiro"));
/* 136 */         pesquisaSatisfacao.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 137 */         pesquisaSatisfacao.setSeqDocumento(Integer.valueOf(rs.getInt("SEQ_DOCUMENTO")));
/* 138 */         pesquisaSatisfacao.setPerguntaUm(Integer.valueOf(rs.getInt("PERGUNTA_UM")));
/* 139 */         pesquisaSatisfacao.setPerguntaDois(Integer.valueOf(rs.getInt("PERGUNTA_DOIS")));
/* 140 */         pesquisaSatisfacao.setPerguntaTres(Integer.valueOf(rs.getInt("PERGUNTA_TRES")));
/* 141 */         pesquisaSatisfacao.setPerguntaQuatro(Integer.valueOf(rs.getInt("PERGUNTA_QUATRO")));
/* 142 */         pesquisaSatisfacao.setPerguntaCinco(Integer.valueOf(rs.getInt("PERGUNTA_CINCO")));
/* 143 */         pesquisaSatisfacao.setPerguntaSeis(Integer.valueOf(rs.getInt("PERGUNTA_SEIS")));
/* 144 */         pesquisaSatisfacao.setPerguntaSete(Integer.valueOf(rs.getInt("PERGUNTA_SETE")));
/* 145 */         pesquisaSatisfacao.setPerguntaOito(Integer.valueOf(rs.getInt("PERGUNTA_OITO")));
/* 146 */         pesquisaSatisfacao.setPerguntaNove(Integer.valueOf(rs.getInt("PERGUNTA_NOVE")));
/* 147 */         pesquisaSatisfacao.setPerguntaDez(Integer.valueOf(rs.getInt("PERGUNTA_DEZ")));
/* 148 */         pesquisaSatisfacao.setPerguntaOnze(Integer.valueOf(rs.getInt("PERGUNTA_ONZE")));
/* 149 */         pesquisaSatisfacao.setComentarioObservacao(rs.getString("COMENTARIO_OBSERVACAO"));
/* 150 */         pesquisaSatisfacao.setEmpresaValidador(rs.getString("EMPRESA_VALIDADOR"));
/* 151 */         pesquisaSatisfacao.setLocalValidador(rs.getString("LOCAL_VALIDADOR"));
/* 152 */         pesquisaSatisfacao.setFuncionarioValidador(rs.getString("FUNCIONARIO_VALIDADOR"));
/* 153 */         pesquisaSatisfacao.setAreaValidador(rs.getString("AREA_VALIDADOR"));
/* 154 */         pesquisaSatisfacao.setCargoValidador(rs.getString("CARGO_VALIDADOR"));
/* 155 */         pesquisaSatisfacao.setSeqEmpresa(Integer.valueOf(rs.getInt("SEQ_EMPRESA")));
/* 156 */         pesquisaSatisfacao.setCodigoDocumento(rs.getString("codigoDocumento"));
/* 157 */         pesquisaSatisfacao.setTipoDocumento(rs.getString("tipoDocumento"));
/* 158 */         listaPesquisaSatisfacao.add(pesquisaSatisfacao);
/*     */       }
/*     */       
/* 161 */       ps.execute();
/* 162 */       ps.close();
/*     */       
/* 164 */       return listaPesquisaSatisfacao;
/*     */     } catch (SQLException ex) {
/* 166 */       Logger.getLogger(PesquisaSatisfacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 167 */       System.out.println(ex.getMessage()); }
/* 168 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(PesquisaSatisfacao pesquisaSatisfacao)
/*     */   {
/*     */     try {
/* 174 */       Conexao conexao = new Conexao();
/* 175 */       Connection conn = Conexao.getConnection();
/* 176 */       String sql = "DELETE FROM PESQUISA_SATISFACAO WHERE SEQ_PESQUISA_SATISFACAO =  ? ";
/*     */       
/* 178 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 180 */       ps.setString(1, pesquisaSatisfacao.getSeqPesquisaSatisfacao());
/*     */       
/* 182 */       ps.execute();
/* 183 */       ps.close();
/*     */       
/* 185 */       return true;
/*     */     } catch (SQLException ex) {
/* 187 */       System.out.println(ex.getMessage()); }
/* 188 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/PesquisaSatisfacao/PesquisaSatisfacaoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */