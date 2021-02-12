/*    */ package ServicoEscopoTarefa;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ServicoEscopoTarefaService
/*    */ {
/*    */   public ServicoEscopoTarefa salvar(ServicoEscopoTarefa servicoEscopoTarefa)
/*    */   {
/* 21 */     ServicoEscopoTarefaDAO dao = new ServicoEscopoTarefaDAO();
/* 22 */     return dao.inserir(servicoEscopoTarefa);
/*    */   }
/*    */   
/*    */   public List<ServicoEscopoTarefa> listarPorEscopo(String pSeqServicoEscopo) {
/* 26 */     ServicoEscopoTarefaDAO dao = new ServicoEscopoTarefaDAO();
/* 27 */     List<ServicoEscopoTarefa> listaServicoEscopoTarefa = new ArrayList();
/* 28 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 30 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "servico_escopo_tarefa.seq_servico_escopo", GeneroCondicaoWhere.igual, String.valueOf(pSeqServicoEscopo), TipoCondicaoWhere.Numero);
/*    */     
/* 32 */     listaServicoEscopoTarefa = dao.listar(condicao);
/* 33 */     return listaServicoEscopoTarefa;
/*    */   }
/*    */   
/*    */   public boolean deletar(ServicoEscopoTarefa servicoEscopoTarefa) {
/* 37 */     ServicoEscopoTarefaDAO dao = new ServicoEscopoTarefaDAO();
/* 38 */     return dao.deletar(servicoEscopoTarefa);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ServicoEscopoTarefa/ServicoEscopoTarefaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */