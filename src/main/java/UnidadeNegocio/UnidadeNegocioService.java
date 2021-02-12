/*    */ package UnidadeNegocio;
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
/*    */ public class UnidadeNegocioService
/*    */ {
/*    */   public UnidadeNegocio salvar(UnidadeNegocio unidadeNegocio)
/*    */   {
/* 23 */     UnidadeNegocioDAO dao = new UnidadeNegocioDAO();
/* 24 */     if (unidadeNegocio.getSeqUnidadeNegocio() == null) {
/* 25 */       unidadeNegocio.setDataCadastro(new Date());
/* 26 */       dao.inserir(unidadeNegocio);
/* 27 */       return unidadeNegocio;
/*    */     }
/* 29 */     dao.alterar(unidadeNegocio);
/* 30 */     return unidadeNegocio;
/*    */   }
/*    */   
/*    */   public List<UnidadeNegocio> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 35 */     UnidadeNegocioDAO dao = new UnidadeNegocioDAO();
/* 36 */     List<UnidadeNegocio> listaUnidadeNegocio = new ArrayList();
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
/* 48 */     listaUnidadeNegocio = dao.listar(condicao);
/* 49 */     return listaUnidadeNegocio;
/*    */   }
/*    */   
/*    */   public List<UnidadeNegocio> listarPorCnpj(String pSeqEmpresa, String pString, Situacao pSituacao) {
/* 53 */     UnidadeNegocioDAO dao = new UnidadeNegocioDAO();
/* 54 */     List<UnidadeNegocio> listaUnidadeNegocio = new ArrayList();
/* 55 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 57 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "cnpj", GeneroCondicaoWhere.igual, pString, TipoCondicaoWhere.Texto);
/* 58 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 60 */     if (pSituacao == Situacao.ATIVO) {
/* 61 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 62 */     } else if (pSituacao == Situacao.INATIVO) {
/* 63 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 66 */     listaUnidadeNegocio = dao.listar(condicao);
/* 67 */     return listaUnidadeNegocio;
/*    */   }
/*    */   
/*    */   public List<UnidadeNegocio> listarPorSeq(String pSeqEmpresa, String pString, Situacao pSituacao) {
/* 71 */     UnidadeNegocioDAO dao = new UnidadeNegocioDAO();
/* 72 */     List<UnidadeNegocio> listaUnidadeNegocio = new ArrayList();
/* 73 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 75 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_unidade_negocio", GeneroCondicaoWhere.igual, pString, TipoCondicaoWhere.Numero);
/* 76 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 78 */     if (pSituacao == Situacao.ATIVO) {
/* 79 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 80 */     } else if (pSituacao == Situacao.INATIVO) {
/* 81 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 84 */     listaUnidadeNegocio = dao.listar(condicao);
/* 85 */     return listaUnidadeNegocio;
/*    */   }
/*    */   
/*    */   public boolean deletar(UnidadeNegocio unidadeNegocio) {
/* 89 */     UnidadeNegocioDAO dao = new UnidadeNegocioDAO();
/* 90 */     return dao.deletar(unidadeNegocio);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/UnidadeNegocio/UnidadeNegocioService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */