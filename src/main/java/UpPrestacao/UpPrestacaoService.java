/*    */ package UpPrestacao;
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
/*    */ public class UpPrestacaoService
/*    */ {
/*    */   public UpPrestacao salvar(UpPrestacao upPrestacao)
/*    */   {
/* 23 */     UpPrestacaoDAO dao = new UpPrestacaoDAO();
/* 24 */     if (upPrestacao.getSeqUpload() == null) {
/* 25 */       upPrestacao.setDataCadastro(new Date());
/* 26 */       return dao.inserir(upPrestacao);
/*    */     }
/* 28 */     return dao.alterar(upPrestacao);
/*    */   }
/*    */   
/*    */   public List<UpPrestacao> listar(String pSeqEmpresa, String pSeq)
/*    */   {
/* 33 */     UpPrestacaoDAO dao = new UpPrestacaoDAO();
/* 34 */     List<UpPrestacao> listaUpload = new ArrayList();
/* 35 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     

/* 38 */     /*condicao.AdicionarCondicao(OperacaoCondicaoWhere.or, "upload.seq_documento", GeneroCondicaoWhere.igual, pSeq, TipoCondicaoWhere.Texto);*/
             condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "upPrestacao.seq_financeiro", GeneroCondicaoWhere.igual, pSeq, TipoCondicaoWhere.Texto);
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "upPrestacao.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 41 */     listaUpload = dao.listar(condicao);
/* 42 */     return listaUpload;
/*    */   }
/*    */   
/*    */   public List<UpPrestacao> listarFiltro(ClausulaWhere condicao) {
/* 46 */     UpPrestacaoDAO dao = new UpPrestacaoDAO();
/* 47 */     List<UpPrestacao> listaUpload = new ArrayList();
/* 48 */     listaUpload = dao.listar(condicao);
/* 49 */     return listaUpload;
/*    */   }
/*    */   
/*    */   public boolean deletar(UpPrestacao upPrestacao) {
/* 53 */     UpPrestacaoDAO dao = new UpPrestacaoDAO();
/* 54 */     return dao.deletar(upPrestacao);
/*    */   }
/*    */ }
