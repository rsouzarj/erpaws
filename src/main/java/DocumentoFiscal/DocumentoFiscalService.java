/*    */ package DocumentoFiscal;
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
/*    */ public class DocumentoFiscalService
/*    */ {
/*    */   public DocumentoFiscal salvar(DocumentoFiscal documentoFiscal)
/*    */   {
/* 23 */     DocumentoFiscalDAO dao = new DocumentoFiscalDAO();
/* 24 */     if (documentoFiscal.getSeqDocumentoFiscal() == null) {
/* 25 */       documentoFiscal.setDataCadastro(new Date());
/* 26 */       return dao.inserir(documentoFiscal);
/*    */     }
/* 28 */     return dao.alterar(documentoFiscal);
/*    */   }
/*    */   
/*    */   public List<DocumentoFiscal> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     DocumentoFiscalDAO dao = new DocumentoFiscalDAO();
/* 34 */     List<DocumentoFiscal> listaDocumentoFiscal = new ArrayList();
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
/* 46 */     listaDocumentoFiscal = dao.listar(condicao);
/* 47 */     return listaDocumentoFiscal;
/*    */   }
/*    */   
/*    */   public boolean deletar(DocumentoFiscal documentoFiscal) {
/* 51 */     DocumentoFiscalDAO dao = new DocumentoFiscalDAO();
/* 52 */     return dao.deletar(documentoFiscal);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/DocumentoFiscal/DocumentoFiscalService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */