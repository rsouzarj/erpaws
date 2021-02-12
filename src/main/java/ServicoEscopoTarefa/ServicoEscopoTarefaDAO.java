/*     */ package ServicoEscopoTarefa;
/*     */ 
/*     */ import ClausulaSQL.ClausulaWhere;
/*     */ import Util.Conexao;
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
/*     */ public class ServicoEscopoTarefaDAO
/*     */ {
/*     */   public ServicoEscopoTarefa inserir(ServicoEscopoTarefa servicoEscopoTarefa)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       Conexao conexao = new Conexao();
/*  28 */       Connection conn = Conexao.getConnection();
/*  29 */       String sql = "insert into SERVICO_ESCOPO_TAREFA (SEQ_TIPO_TAREFA,SEQ_SERVICO_ESCOPO) values  (?,?)";
/*     */       
/*     */ 
/*     */ 
/*  33 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  35 */       ps.setString(1, servicoEscopoTarefa.getSeqTipoTarefa());
/*  36 */       ps.setString(2, servicoEscopoTarefa.getSeqServicoEscopo());
/*     */       
/*  38 */       ps.execute();
/*  39 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  42 */       Logger.getLogger(ServicoEscopoTarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  43 */       System.out.println(ex.getMessage());
/*     */     }
/*  45 */     return servicoEscopoTarefa;
/*     */   }
/*     */   
/*     */   public ServicoEscopoTarefa alterar(ServicoEscopoTarefa servicoEscopoTarefa) {
/*     */     try {
/*  50 */       Conexao conexao = new Conexao();
/*  51 */       Connection conn = Conexao.getConnection();
/*  52 */       String sql = "update SERVICO_ESCOPO_TAREFA set SEQ_SERVICO_ESCOPO = ? where SEQ_TIPO_TAREFA = ?";
/*     */       
/*  54 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  56 */       ps.setString(1, servicoEscopoTarefa.getSeqServicoEscopo());
/*  57 */       ps.setString(2, servicoEscopoTarefa.getSeqTipoTarefa());
/*  58 */       ps.execute();
/*  59 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  62 */       Logger.getLogger(ServicoEscopoTarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  63 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  66 */     return servicoEscopoTarefa;
/*     */   }
/*     */   
/*     */   public List<ServicoEscopoTarefa> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  71 */       Conexao conexao = new Conexao();
/*  72 */       Connection conn = Conexao.getConnection();
/*  73 */       String sql = "select servico_escopo_tarefa.* ,\ntipo_tarefa.nome tarefa,\ntipo_tarefa.horas horas,\ntipo_tarefa.seq_usuario,\ntipo_tarefa.seq_departamento\nFrom \nservico_escopo_tarefa\ninner join tipo_tarefa on tipo_tarefa.seq_tipo_tarefa = servico_escopo_tarefa.seq_tipo_tarefa " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  81 */       System.out.println(sql);
/*     */       
/*  83 */       List<ServicoEscopoTarefa> listaServicoEscopoTarefa = new ArrayList();
/*  84 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  85 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  87 */       while (rs.next()) {
/*  88 */         ServicoEscopoTarefa servicoEscopoTarefa = new ServicoEscopoTarefa();
/*  89 */         servicoEscopoTarefa.setSeqTipoTarefa(rs.getString("SEQ_TIPO_TAREFA"));
/*  90 */         servicoEscopoTarefa.setSeqServicoEscopo(rs.getString("SEQ_SERVICO_ESCOPO"));
/*  91 */         servicoEscopoTarefa.setTarefa(rs.getString("TAREFA"));
/*  92 */         servicoEscopoTarefa.setHora(rs.getString("HORAS"));
/*  93 */         servicoEscopoTarefa.setSeqUsuario(rs.getString("SEQ_USUARIO"));
/*  94 */         servicoEscopoTarefa.setSeqDepartamento(rs.getString("SEQ_DEPARTAMENTO"));
/*  95 */         listaServicoEscopoTarefa.add(servicoEscopoTarefa);
/*     */       }
/*     */       
/*  98 */       ps.execute();
/*  99 */       ps.close();
/*     */       
/* 101 */       return listaServicoEscopoTarefa;
/*     */     } catch (SQLException ex) {
/* 103 */       Logger.getLogger(ServicoEscopoTarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 104 */       System.out.println(ex.getMessage()); }
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(ServicoEscopoTarefa servicoEscopoTarefa)
/*     */   {
/*     */     try {
/* 111 */       Conexao conexao = new Conexao();
/* 112 */       Connection conn = Conexao.getConnection();
/* 113 */       String sql = "DELETE FROM SERVICO_ESCOPO_TAREFA WHERE SEQ_TIPO_TAREFA =  ? and seq_servico_escopo = ? ";
/*     */       
/* 115 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 117 */       ps.setString(1, servicoEscopoTarefa.getSeqTipoTarefa());
/* 118 */       ps.setString(2, servicoEscopoTarefa.getSeqServicoEscopo());
/*     */       
/* 120 */       ps.execute();
/* 121 */       ps.close();
/*     */       
/* 123 */       return true;
/*     */     } catch (SQLException ex) {
/* 125 */       System.out.println(ex.getMessage()); }
/* 126 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ServicoEscopoTarefa/ServicoEscopoTarefaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */