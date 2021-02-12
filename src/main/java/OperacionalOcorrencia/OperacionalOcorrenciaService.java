/*    */ package OperacionalOcorrencia;
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
/*    */ 
/*    */ 
/*    */ public class OperacionalOcorrenciaService
/*    */ {
/*    */   public OperacionalOcorrencia salvar(OperacionalOcorrencia operacionalOcorrencia)
/*    */   {
/* 25 */     OperacionalOcorrenciaDAO dao = new OperacionalOcorrenciaDAO();
/* 26 */     if (operacionalOcorrencia.getSeqOperacionalOcorrencia() == null) {
/* 27 */       operacionalOcorrencia.setDataCadastro(new Date());
/* 28 */       operacionalOcorrencia.setData(new Date());
/* 29 */       dao.inserir(operacionalOcorrencia);
/* 30 */       return operacionalOcorrencia;
/*    */     }
/* 32 */     dao.alterar(operacionalOcorrencia);
/* 33 */     return operacionalOcorrencia;
/*    */   }
/*    */   
/*    */   public List<OperacionalOcorrencia> listarPorOperacional(String pSeqOperacional)
/*    */   {
/* 38 */     OperacionalOcorrenciaDAO dao = new OperacionalOcorrenciaDAO();
/* 39 */     List<OperacionalOcorrencia> listaOperacionalOcorrencia = new ArrayList();
/* 40 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 42 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "operacional_ocorrencia.seq_operacional", GeneroCondicaoWhere.igual, String.valueOf(pSeqOperacional), TipoCondicaoWhere.Numero);
/*    */     
/* 44 */     listaOperacionalOcorrencia = dao.listar(condicao);
/* 45 */     return listaOperacionalOcorrencia;
/*    */   }
/*    */   
/*    */   public boolean deletar(OperacionalOcorrencia operacionalOcorrencia) {
/* 49 */     OperacionalOcorrenciaDAO dao = new OperacionalOcorrenciaDAO();
/* 50 */     return dao.deletar(operacionalOcorrencia);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/OperacionalOcorrencia/OperacionalOcorrenciaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */