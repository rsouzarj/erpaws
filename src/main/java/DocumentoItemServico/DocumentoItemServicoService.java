/*    */ package DocumentoItemServico;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import ServicoEscopoTarefa.ServicoEscopoTarefa;
/*    */ import ServicoEscopoTarefa.ServicoEscopoTarefaService;
/*    */ import Tarefa.Tarefa;
/*    */ import Tarefa.TarefaService;
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
/*    */ public class DocumentoItemServicoService
/*    */ {
/*    */   public DocumentoItemServico salvar(DocumentoItemServico documentoItemServico)
/*    */   {
/* 26 */     DocumentoItemServicoDAO dao = new DocumentoItemServicoDAO();
/* 27 */     if (documentoItemServico.getSeqDocumentoItemServico() == null)
/*    */     {
/*    */ 
/*    */ 
/* 31 */       ServicoEscopoTarefaService servicoEscopoTarefaService = new ServicoEscopoTarefaService();
/* 32 */       List<ServicoEscopoTarefa> listaTarefa = servicoEscopoTarefaService.listarPorEscopo(documentoItemServico.getSeqServicoEscopo());
/*    */       
/* 34 */       TarefaService tarefaService = new TarefaService();
/*    */       
/* 36 */       for (ServicoEscopoTarefa t : listaTarefa) {
/* 37 */         Tarefa tarefa = new Tarefa();
/* 38 */         tarefa.setSeqTipoTarefa(t.getSeqTipoTarefa());
/* 39 */         tarefa.setSeqDocumento(documentoItemServico.getSeqDocumento());
/* 40 */         tarefa.setSeqEmpresa(documentoItemServico.getSeqEmpresa());
/* 41 */         tarefa.setSeqDepartamento(t.getSeqDepartamento());
/* 42 */         tarefa.setSeqUsuario(t.getSeqUsuario());
/* 43 */         tarefa.setSeqServicoEscopo(t.getSeqServicoEscopo());
/* 44 */         tarefa.setSituacao("ATIVO");
/* 45 */         tarefa.setStatus("A");
/* 46 */         tarefaService.salvar(tarefa);
/*    */       }
/*    */       
/*    */ 
/* 50 */       documentoItemServico.setDataCadastro(new Date());
/* 51 */       return dao.inserir(documentoItemServico);
/*    */     }
/* 53 */     return dao.alterar(documentoItemServico);
/*    */   }
/*    */   
/*    */   public List<DocumentoItemServico> listarPorDocumento(String pSeqDocumento)
/*    */   {
/* 58 */     List<DocumentoItemServico> retorno = new ArrayList();
/* 59 */     DocumentoItemServicoDAO dao = new DocumentoItemServicoDAO();
/* 60 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 62 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_documento", GeneroCondicaoWhere.igual, String.valueOf(pSeqDocumento), TipoCondicaoWhere.Numero);
/*    */     
/* 64 */     retorno = dao.listar(condicao);
/* 65 */     return retorno;
/*    */   }
/*    */   
/*    */   public boolean deletar(DocumentoItemServico documentoItemServico) {
/* 69 */     DocumentoItemServicoDAO dao = new DocumentoItemServicoDAO();
/* 70 */     return dao.deletar(documentoItemServico);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemServico/DocumentoItemServicoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */