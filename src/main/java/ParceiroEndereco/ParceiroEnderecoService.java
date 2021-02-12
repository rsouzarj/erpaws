/*    */ package ParceiroEndereco;
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
/*    */ public class ParceiroEnderecoService
/*    */ {
/*    */   public ParceiroEndereco salvar(ParceiroEndereco parceiroEndereco)
/*    */   {
/* 23 */     ParceiroEnderecoDAO dao = new ParceiroEnderecoDAO();
/* 24 */     if (parceiroEndereco.getSeqParceiroEndereco() == null) {
/* 25 */       parceiroEndereco.setSituacao("ATIVO");
/* 26 */       parceiroEndereco.setDataCadastro(new Date());
/* 27 */       return dao.inserir(parceiroEndereco);
/*    */     }
/* 29 */     return dao.alterar(parceiroEndereco);
/*    */   }
/*    */   
/*    */   public List<ParceiroEndereco> listar(String pSeqParceiro, Situacao pSituacao)
/*    */   {
/* 34 */     ParceiroEnderecoDAO dao = new ParceiroEnderecoDAO();
/* 35 */     List<ParceiroEndereco> listaParceiroEndereco = new ArrayList();
/* 36 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "parceiro_endereco.seq_parceiro", GeneroCondicaoWhere.igual, String.valueOf(pSeqParceiro), TipoCondicaoWhere.Numero);
/*    */     
/* 40 */     if (pSituacao == Situacao.ATIVO) {
/* 41 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "parceiro_endereco.situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 42 */     } else if (pSituacao == Situacao.INATIVO) {
/* 43 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "parceiro_endereco.situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 46 */     listaParceiroEndereco = dao.listar(condicao);
/* 47 */     return listaParceiroEndereco;
/*    */   }
/*    */   
/*    */   public boolean deletar(ParceiroEndereco parceiroEndereco) {
/* 51 */     ParceiroEnderecoDAO dao = new ParceiroEnderecoDAO();
/* 52 */     return dao.deletar(parceiroEndereco);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/ParceiroEndereco/ParceiroEnderecoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */