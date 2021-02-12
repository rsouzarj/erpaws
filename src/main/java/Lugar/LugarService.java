/*    */ package Lugar;
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
/*    */ public class LugarService
/*    */ {
/*    */   public Lugar salvar(Lugar lugar)
/*    */   {
/* 23 */     LugarDAO dao = new LugarDAO();
/* 24 */     if (lugar.getSeqLugar() == null) {
/* 25 */       lugar.setDataCadastro(new Date());
/* 26 */       return dao.inserir(lugar);
/*    */     }
/* 28 */     return dao.alterar(lugar);
/*    */   }
/*    */   
/*    */   public List<Lugar> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 33 */     LugarDAO dao = new LugarDAO();
/* 34 */     List<Lugar> listaLugar = new ArrayList();
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
/* 46 */     listaLugar = dao.listar(condicao);
/* 47 */     return listaLugar;
/*    */   }
/*    */   
/*    */   public boolean deletar(Lugar lugar) {
/* 51 */     LugarDAO dao = new LugarDAO();
/* 52 */     return dao.deletar(lugar);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Lugar/LugarService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */