/*    */ package PesquisaSatisfacao;
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
/*    */ public class PesquisaSatisfacaoService
/*    */ {
/*    */   public PesquisaSatisfacao salvar(PesquisaSatisfacao pesquisaSatisfacao)
/*    */   {
/* 23 */     PesquisaSatisfacaoDAO dao = new PesquisaSatisfacaoDAO();
/* 24 */     if (pesquisaSatisfacao.getSeqPesquisaSatisfacao() == null) {
/* 25 */       pesquisaSatisfacao.setDataCadastro(new Date());
/* 26 */       return dao.inserir(pesquisaSatisfacao);
/*    */     }
/* 28 */     return dao.alterar(pesquisaSatisfacao);
/*    */   }
/*    */   
/*    */   public List<PesquisaSatisfacao> listar(int pSeqEmpresa)
/*    */   {
/* 33 */     PesquisaSatisfacaoDAO dao = new PesquisaSatisfacaoDAO();
/* 34 */     List<PesquisaSatisfacao> listaPesquisaSatisfacao = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 37 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "PESQUISA_SATISFACAO.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 39 */     listaPesquisaSatisfacao = dao.listar(condicao);
/* 40 */     return listaPesquisaSatisfacao;
/*    */   }
/*    */   
/* 43 */   public List<PesquisaSatisfacao> listarFiltro(ClausulaWhere condicao) { PesquisaSatisfacaoDAO dao = new PesquisaSatisfacaoDAO();
/* 44 */     List<PesquisaSatisfacao> listaPesquisaSatisfacao = new ArrayList();
/*    */     
/* 46 */     listaPesquisaSatisfacao = dao.listar(condicao);
/* 47 */     return listaPesquisaSatisfacao;
/*    */   }
/*    */   
/*    */   public List<PesquisaSatisfacao> listarSeqPesquisa(int pSeqPesquisa) {
/* 51 */     PesquisaSatisfacaoDAO dao = new PesquisaSatisfacaoDAO();
/* 52 */     List<PesquisaSatisfacao> listaPesquisaSatisfacao = new ArrayList();
/* 53 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 55 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "PESQUISA_SATISFACAO.seq_PESQUISA_SATISFACAO", GeneroCondicaoWhere.igual, String.valueOf(pSeqPesquisa), TipoCondicaoWhere.Numero);
/*    */     
/* 57 */     listaPesquisaSatisfacao = dao.listar(condicao);
/* 58 */     return listaPesquisaSatisfacao;
/*    */   }
/*    */   
/*    */   public boolean deletar(PesquisaSatisfacao pesquisaSatisfacao) {
/* 62 */     PesquisaSatisfacaoDAO dao = new PesquisaSatisfacaoDAO();
/* 63 */     return dao.deletar(pesquisaSatisfacao);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/PesquisaSatisfacao/PesquisaSatisfacaoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */