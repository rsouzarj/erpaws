/*    */ package Conta;
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
/*    */ public class ContaService
/*    */ {
/*    */   public Conta salvar(Conta conta)
/*    */   {
/* 23 */     ContaDAO dao = new ContaDAO();
/* 24 */     if (conta.getSeqConta() == null) {
/* 25 */       conta.setDataCadastro(new Date());
/* 26 */       return dao.inserir(conta);
/*    */     }
/* 28 */     return dao.alterar(conta);
/*    */   }
/*    */   
/*    */   public List<Conta> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     ContaDAO dao = new ContaDAO();
/* 34 */     List<Conta> listaConta = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 40 */     if (pSituacao == Situacao.ATIVO) {
/* 41 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 42 */     } else if (pSituacao == Situacao.INATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 46 */     listaConta = dao.listar(condicao);
/* 47 */     return listaConta;
/*    */   }
/*    */   
/*    */   public Conta buscar(String pSeqConta) {
/* 51 */     ContaDAO dao = new ContaDAO();
/* 52 */     List<Conta> listaConta = new ArrayList();
/* 53 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 55 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_conta", GeneroCondicaoWhere.igual, String.valueOf(pSeqConta), TipoCondicaoWhere.Numero);
/*    */     
/* 57 */     listaConta = dao.listar(condicao);
/* 58 */     return (Conta)listaConta.get(0);
/*    */   }
/*    */   
/*    */   public boolean deletar(Conta conta) {
/* 62 */     ContaDAO dao = new ContaDAO();
/* 63 */     return dao.deletar(conta);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Conta/ContaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */