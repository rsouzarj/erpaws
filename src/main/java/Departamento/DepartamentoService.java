/*    */ package Departamento;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import Util.Situacao;
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
/*    */ public class DepartamentoService
/*    */ {
/*    */   public Departamento salvar(Departamento departamento)
/*    */   {
/* 23 */     DepartamentoDAO dao = new DepartamentoDAO();
/* 24 */     if (departamento.getSeqDepartamento() == null) {
/* 25 */       departamento.setDataCadastro(new Date());
/* 26 */       dao.inserir(departamento);
/* 27 */       return departamento;
/*    */     }
/* 29 */     dao.alterar(departamento);
/* 30 */     return departamento;
/*    */   }
/*    */   
/*    */   public List<Departamento> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 35 */     DepartamentoDAO dao = new DepartamentoDAO();
/* 36 */     List<Departamento> listaDepartamento = new ArrayList();
/* 37 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 40 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 42 */     if (pSituacao == Situacao.ATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 44 */     } else if (pSituacao == Situacao.INATIVO) {
/* 45 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 48 */     listaDepartamento = dao.listar(condicao);
/* 49 */     return listaDepartamento;
/*    */   }
/*    */   
/*    */   public boolean deletar(Departamento departamento) {
/* 53 */     DepartamentoDAO dao = new DepartamentoDAO();
/* 54 */     return dao.deletar(departamento);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Departamento/DepartamentoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */