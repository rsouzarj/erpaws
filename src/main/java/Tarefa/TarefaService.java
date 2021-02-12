/*    */ package Tarefa;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TarefaService
/*    */ {
/*    */   public Tarefa salvar(Tarefa tarefa)
/*    */   {
/* 23 */     TarefaDAO dao = new TarefaDAO();
/* 24 */     if (tarefa.getSeqTarefa() == null) {
/* 25 */       tarefa.setDataCadastro(new Date());
/* 26 */       return dao.inserir(tarefa);
/*    */     }
/* 28 */     return dao.alterar(tarefa);
/*    */   }
/*    */   
/*    */   public List<Tarefa> listar(String pSeqEmpresa)
/*    */   {
/* 33 */     TarefaDAO dao = new TarefaDAO();
/* 34 */     List<Tarefa> listaTarefa = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "tarefa.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 39 */     listaTarefa = dao.listar(condicao);
/* 40 */     return listaTarefa;
/*    */   }
/*    */   
/*    */   public boolean deletar(Tarefa tarefa) {
/* 44 */     TarefaDAO dao = new TarefaDAO();
/* 45 */     return dao.deletar(tarefa);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Tarefa/TarefaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */