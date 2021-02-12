/*    */ package ServicoEscopo;
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
/*    */ public class ServicoEscopoService
/*    */ {
/*    */   public ServicoEscopo salvar(ServicoEscopo servicoEscopo)
/*    */   {
/* 19 */     ServicoEscopoDAO dao = new ServicoEscopoDAO();
/* 20 */     if (servicoEscopo.getSeqServicoEscopo() == null) {
/* 21 */       servicoEscopo.setDataCadastro(new Date());
/* 22 */       return dao.inserir(servicoEscopo);
/*    */     }
/* 24 */     return dao.alterar(servicoEscopo);
/*    */   }
/*    */   
/*    */   public List<ServicoEscopo> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 29 */     ServicoEscopoDAO dao = new ServicoEscopoDAO();
/* 30 */     List<ServicoEscopo> listaServicoEscopo = new ArrayList();
/* 31 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 33 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 34 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 36 */     if (pSituacao == Situacao.ATIVO) {
/* 37 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 38 */     } else if (pSituacao == Situacao.INATIVO) {
/* 39 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 42 */     listaServicoEscopo = dao.listar(condicao);
/* 43 */     return listaServicoEscopo;
/*    */   }
/*    */   
/*    */   public boolean deletar(ServicoEscopo servicoEscopo) {
/* 47 */     ServicoEscopoDAO dao = new ServicoEscopoDAO();
/* 48 */     return dao.deletar(servicoEscopo);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ServicoEscopo/ServicoEscopoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */