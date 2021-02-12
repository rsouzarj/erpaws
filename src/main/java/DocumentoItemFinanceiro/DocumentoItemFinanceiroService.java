/*    */ package DocumentoItemFinanceiro;
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
/*    */ public class DocumentoItemFinanceiroService
/*    */ {
/*    */   public DocumentoItemFinanceiro salvar(DocumentoItemFinanceiro documentoItemFinanceiro)
/*    */   {
/* 23 */     DocumentoItemFinanceiroDAO dao = new DocumentoItemFinanceiroDAO();
/* 24 */     if (documentoItemFinanceiro.getSeqDocumentoItemFinanceiro() == null) {
/* 25 */       documentoItemFinanceiro.setDataCadastro(new Date());
/* 26 */       return dao.inserir(documentoItemFinanceiro);
/*    */     }
/* 28 */     return dao.alterar(documentoItemFinanceiro);
/*    */   }
/*    */   
/*    */   public List<DocumentoItemFinanceiro> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     DocumentoItemFinanceiroDAO dao = new DocumentoItemFinanceiroDAO();
/* 34 */     List<DocumentoItemFinanceiro> listaDocumentoItemFinanceiro = new ArrayList();
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
/* 46 */     listaDocumentoItemFinanceiro = dao.listar(condicao);
/* 47 */     return listaDocumentoItemFinanceiro;
/*    */   }
/*    */   
/*    */   public DocumentoItemFinanceiro buscar(String pSeqDocumento) {
/* 51 */     if (pSeqDocumento.isEmpty()) {
/* 52 */       return new DocumentoItemFinanceiro();
/*    */     }
/*    */     
/* 55 */     DocumentoItemFinanceiroDAO dao = new DocumentoItemFinanceiroDAO();
/* 56 */     List<DocumentoItemFinanceiro> listaDocumentoItemFinanceiro = new ArrayList();
/* 57 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 59 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_documento", GeneroCondicaoWhere.igual, String.valueOf(pSeqDocumento), TipoCondicaoWhere.Numero);
/*    */     
/* 61 */     listaDocumentoItemFinanceiro = dao.listar(condicao);
/*    */     
/* 63 */     if (listaDocumentoItemFinanceiro.size() > 0) {
/* 64 */       return (DocumentoItemFinanceiro)listaDocumentoItemFinanceiro.get(0);
/*    */     }
/* 66 */     return new DocumentoItemFinanceiro();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean deletar(DocumentoItemFinanceiro documentoItemFinanceiro)
/*    */   {
/* 72 */     DocumentoItemFinanceiroDAO dao = new DocumentoItemFinanceiroDAO();
/* 73 */     return dao.deletar(documentoItemFinanceiro);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoItemFinanceiro/DocumentoItemFinanceiroService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */