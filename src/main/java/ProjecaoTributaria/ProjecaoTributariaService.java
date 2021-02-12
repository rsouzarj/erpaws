/*    */ package ProjecaoTributaria;
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
/*    */ public class ProjecaoTributariaService
/*    */ {
/*    */   public ProjecaoTributaria salvar(ProjecaoTributaria projecaoTributaria)
/*    */   {
/* 23 */     ProjecaoTributariaDAO dao = new ProjecaoTributariaDAO();
/* 24 */     if (projecaoTributaria.getSeqProjecaoTributaria() == null) {
/* 25 */       projecaoTributaria.setDataCadastro(new Date());
/* 26 */       return dao.inserir(projecaoTributaria);
/*    */     }
/* 28 */     return dao.alterar(projecaoTributaria);
/*    */   }
/*    */   
/*    */   public List<ProjecaoTributaria> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     ProjecaoTributariaDAO dao = new ProjecaoTributariaDAO();
/* 34 */     List<ProjecaoTributaria> listaProjecaoTributaria = new ArrayList();
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
/* 46 */     listaProjecaoTributaria = dao.listar(condicao);
/* 47 */     return listaProjecaoTributaria;
/*    */   }
/*    */   
/*    */   public List<ProjecaoTributaria> listarPorSeq(String pSeqEmpresa, String pString, Situacao pSituacao) {
/* 51 */     ProjecaoTributariaDAO dao = new ProjecaoTributariaDAO();
/* 52 */     List<ProjecaoTributaria> listaProjecaoTributaria = new ArrayList();
/* 53 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 55 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_projecao_tributaria", GeneroCondicaoWhere.igual, pString, TipoCondicaoWhere.Texto);
/* 56 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 58 */     if (pSituacao == Situacao.ATIVO) {
/* 59 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 60 */     } else if (pSituacao == Situacao.INATIVO) {
/* 61 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 64 */     listaProjecaoTributaria = dao.listar(condicao);
/* 65 */     return listaProjecaoTributaria;
/*    */   }
/*    */   
/*    */   public boolean deletar(ProjecaoTributaria projecaoTributaria) {
/* 69 */     ProjecaoTributariaDAO dao = new ProjecaoTributariaDAO();
/* 70 */     return dao.deletar(projecaoTributaria);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ProjecaoTributaria/ProjecaoTributariaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */