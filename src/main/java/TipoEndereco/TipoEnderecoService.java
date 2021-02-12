/*    */ package TipoEndereco;
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
/*    */ public class TipoEnderecoService
/*    */ {
/*    */   public TipoEndereco salvar(TipoEndereco tipoEndereco)
/*    */   {
/* 23 */     TipoEnderecoDAO dao = new TipoEnderecoDAO();
/* 24 */     if (tipoEndereco.getSeqTipoEndereco() == null) {
/* 25 */       tipoEndereco.setDataCadastro(new Date());
/* 26 */       return dao.inserir(tipoEndereco);
/*    */     }
/* 28 */     return dao.alterar(tipoEndereco);
/*    */   }
/*    */   
/*    */   public List<TipoEndereco> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     TipoEnderecoDAO dao = new TipoEnderecoDAO();
/* 34 */     List<TipoEndereco> listaTipoEndereco = new ArrayList();
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
/* 46 */     listaTipoEndereco = dao.listar(condicao);
/* 47 */     return listaTipoEndereco;
/*    */   }
/*    */   
/*    */   public boolean deletar(TipoEndereco tipoEndereco) {
/* 51 */     TipoEnderecoDAO dao = new TipoEnderecoDAO();
/* 52 */     return dao.deletar(tipoEndereco);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoEndereco/TipoEnderecoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */