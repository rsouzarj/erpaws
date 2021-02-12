/*     */ package Tarefa;
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
/*     */ public class TarefaDAO
/*     */ {
/*     */   public Tarefa inserir(Tarefa tarefa)
/*     */   {
/*     */     try
/*     */     {
/*  28 */       String seq = Sequence.buscarNumeroSequence("SEQ_TAREFA");
/*  29 */       tarefa.setSeqTarefa(seq);
/*  30 */       Conexao conexao = new Conexao();
/*  31 */       Connection conn = Conexao.getConnection();
/*  32 */       String sql = "insert into TAREFA (SEQ_TAREFA,SEQ_USUARIO,DATA_CADASTRO,SEQ_DEPARTAMENTO,SEQ_DOCUMENTO,STATUS,SEQ_TIPO_TAREFA,SEQ_EMPRESA,SITUACAO, seq_servico_escopo) values  (?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  36 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  38 */       ps.setString(1, tarefa.getSeqTarefa());
/*  39 */       ps.setObject(2, tarefa.getSeqUsuario(), 1);
/*     */       try {
/*  41 */         ps.setDate(3, new java.sql.Date(tarefa.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  43 */         ps.setDate(3, null);
/*     */       }
/*  45 */       ps.setObject(4, tarefa.getSeqDepartamento(), 1);
/*  46 */       ps.setObject(5, tarefa.getSeqDocumento(), 1);
/*  47 */       ps.setString(6, tarefa.getStatus());
/*  48 */       ps.setString(7, tarefa.getSeqTipoTarefa());
/*  49 */       ps.setString(8, tarefa.getSeqEmpresa());
/*  50 */       ps.setString(9, tarefa.getSituacao());
/*  51 */       ps.setObject(10, tarefa.getSeqServicoEscopo(), 1);
/*     */       
/*  53 */       ps.execute();
/*  54 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  57 */       Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  58 */       System.out.println(ex.getMessage());
/*     */     }
/*  60 */     return tarefa;
/*     */   }
/*     */   
/*     */   public Tarefa alterar(Tarefa tarefa) {
/*     */     try {
/*  65 */       Conexao conexao = new Conexao();
/*  66 */       Connection conn = Conexao.getConnection();
/*  67 */       String sql = "update TAREFA set SEQ_USUARIO = ?,DATA_CADASTRO = ?,SEQ_DEPARTAMENTO = ?,SEQ_DOCUMENTO = ?,STATUS = ?,SEQ_TIPO_TAREFA = ?,SEQ_EMPRESA = ?,SITUACAO = ?, seq_servico_escopo = ? where SEQ_TAREFA = ?";
/*     */       
/*  69 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  71 */       ps.setString(1, tarefa.getSeqUsuario());
/*     */       try {
/*  73 */         ps.setDate(2, new java.sql.Date(tarefa.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  75 */         ps.setDate(2, null);
/*     */       }
/*  77 */       ps.setString(3, tarefa.getSeqDepartamento());
/*  78 */       ps.setString(4, tarefa.getSeqDocumento());
/*  79 */       ps.setString(5, tarefa.getStatus());
/*  80 */       ps.setString(6, tarefa.getSeqTipoTarefa());
/*  81 */       ps.setString(7, tarefa.getSeqEmpresa());
/*  82 */       ps.setString(8, tarefa.getSituacao());
/*  83 */       ps.setObject(9, tarefa.getSeqServicoEscopo());
/*  84 */       ps.setString(10, tarefa.getSeqTarefa());
/*  85 */       ps.execute();
/*  86 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  89 */       Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  90 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  93 */     return tarefa;
/*     */   }
/*     */   
/*     */   public List<Tarefa> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  98 */       Conexao conexao = new Conexao();
/*  99 */       Connection conn = Conexao.getConnection();
/* 100 */       String sql = "select \ntarefa.* ,\ntipo_tarefa.nome tarefa,\ntipo_tarefa.horas,\nparceiro_usuario.nome usuario,\ndepartamento.nome departamento\n,tipo_documento.nome tipo_documento,\nparceiro.nome parceiro,\nservico_escopo.nome escopo\nfrom \ntarefa\ninner join tipo_tarefa on tipo_tarefa.seq_tipo_tarefa = tarefa.seq_tipo_tarefa\nleft join usuario on usuario.seq_usuario = tarefa.seq_usuario\nleft join parceiro parceiro_usuario on parceiro_usuario.seq_parceiro = usuario.seq_parceiro\nleft join departamento on departamento.seq_departamento = tarefa.seq_departamento\nleft join servico_escopo on servico_escopo.seq_servico_escopo = tarefa.seq_servico_escopo\nleft join documento on documento.seq_documento = tarefa.seq_documento\nleft join tipo_documento on tipo_documento.seq_tipo_documento = documento.seq_tipo_documento\nleft join parceiro on parceiro.seq_parceiro = documento.seq_parceiro " + sClausula.montarsClausula();
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
/*     */ 
/*     */ 
/* 119 */       System.out.println(sql);
/*     */       
/* 121 */       List<Tarefa> listaTarefa = new ArrayList();
/* 122 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 123 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 125 */       while (rs.next()) {
/* 126 */         Tarefa tarefa = new Tarefa();
/* 127 */         tarefa.setSeqTarefa(rs.getString("SEQ_TAREFA"));
/* 128 */         tarefa.setSeqUsuario(rs.getString("SEQ_USUARIO"));
/* 129 */         tarefa.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 130 */         tarefa.setSeqDepartamento(rs.getString("SEQ_DEPARTAMENTO"));
/* 131 */         tarefa.setSeqDocumento(rs.getString("SEQ_DOCUMENTO"));
/* 132 */         tarefa.setStatus(rs.getString("STATUS"));
/* 133 */         tarefa.setSeqTipoTarefa(rs.getString("SEQ_TIPO_TAREFA"));
/* 134 */         tarefa.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 135 */         tarefa.setSituacao(rs.getString("SITUACAO"));
/*     */         
/* 137 */         tarefa.setTarefa(rs.getString("TAREFA"));
/* 138 */         tarefa.setHoras(rs.getString("HORAS"));
/* 139 */         tarefa.setUsuario(rs.getString("USUARIO"));
/* 140 */         tarefa.setDepartamento(rs.getString("DEPARTAMENTO"));
/* 141 */         tarefa.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));
/* 142 */         tarefa.setParceiro(rs.getString("PARCEIRO"));
/* 143 */         tarefa.setEscopo(rs.getString("ESCOPO"));
/* 144 */         listaTarefa.add(tarefa);
/*     */       }
/*     */       
/* 147 */       ps.execute();
/* 148 */       ps.close();
/*     */       
/* 150 */       return listaTarefa;
/*     */     } catch (SQLException ex) {
/* 152 */       Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 153 */       System.out.println(ex.getMessage()); }
/* 154 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(Tarefa tarefa)
/*     */   {
/*     */     try {
/* 160 */       Conexao conexao = new Conexao();
/* 161 */       Connection conn = Conexao.getConnection();
/* 162 */       String sql = "DELETE FROM TAREFA WHERE SEQ_TAREFA =  ? ";
/*     */       
/* 164 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 166 */       ps.setString(1, tarefa.getSeqTarefa());
/*     */       
/* 168 */       ps.execute();
/* 169 */       ps.close();
/*     */       
/* 171 */       return true;
/*     */     } catch (SQLException ex) {
/* 173 */       System.out.println(ex.getMessage()); }
/* 174 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Tarefa/TarefaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */