/*    */ package TabelaPreco;
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
/*    */ public class TabelaPrecoService
/*    */ {
/*    */   public TabelaPreco salvar(TabelaPreco tabelaPreco)
/*    */   {
/* 23 */     TabelaPrecoDAO dao = new TabelaPrecoDAO();
/* 24 */     if (tabelaPreco.getSeqTabelaPreco() == null) {
/* 25 */       tabelaPreco.setDataCadastro(new Date());
/* 26 */       dao.inserir(tabelaPreco);
/* 27 */       return tabelaPreco;
/*    */     }
/* 29 */     dao.alterar(tabelaPreco);
/* 30 */     return tabelaPreco;
/*    */   }
/*    */   
/*    */   public List<TabelaPreco> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 35 */     TabelaPrecoDAO dao = new TabelaPrecoDAO();
/* 36 */     List<TabelaPreco> listaTabelaPreco = new ArrayList();
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
/* 48 */     listaTabelaPreco = dao.listar(condicao);
/* 49 */     return listaTabelaPreco;
/*    */   }
/*    */   
/*    */   public List<TabelaPreco> listarPorSeq(String pSeqEmpresa, String pString, Situacao pSituacao) {
/* 53 */     TabelaPrecoDAO dao = new TabelaPrecoDAO();
/* 54 */     List<TabelaPreco> listaTabelaPreco = new ArrayList();
/* 55 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 57 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "SEQ_TABELA_PRECO", GeneroCondicaoWhere.igual, pString, TipoCondicaoWhere.Texto);
/* 58 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 60 */     if (pSituacao == Situacao.ATIVO) {
/* 61 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 62 */     } else if (pSituacao == Situacao.INATIVO) {
/* 63 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 66 */     listaTabelaPreco = dao.listar(condicao);
/* 67 */     return listaTabelaPreco;
/*    */   }
/*    */   
/*    */   public boolean deletar(TabelaPreco tabelaPreco)
/*    */   {
/* 72 */     TabelaPrecoDAO dao = new TabelaPrecoDAO();
/* 73 */     return dao.deletar(tabelaPreco);
/*    */   }
/*    */   
/*    */   public TabelaPreco buscarTabelaPrincipal() {
/* 77 */     TabelaPrecoDAO dao = new TabelaPrecoDAO();
/*    */     
/*    */ 
/* 80 */     List<TabelaPreco> listaTabelaPreco = new ArrayList();
/* 81 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 83 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "Tabela_preco.principal", GeneroCondicaoWhere.igual, "SIM", TipoCondicaoWhere.Texto);
/*    */     
/* 85 */     listaTabelaPreco = dao.listar(condicao);
/*    */     
/* 87 */     return (TabelaPreco)listaTabelaPreco.get(0);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TabelaPreco/TabelaPrecoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */