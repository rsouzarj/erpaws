/*    */ package NvCertificadoCalculo;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import Util.Situacao;
/*    */ import java.io.PrintStream;
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
/*    */ public class NvCertificadoCalculoService
/*    */ {
/*    */   public NvCertificadoCalculo salvar(NvCertificadoCalculo nvCertificadoCalculo)
/*    */   {
/* 24 */     NvCertificadoCalculoDAO dao = new NvCertificadoCalculoDAO();
/* 25 */     if (nvCertificadoCalculo.getSeqNvCertificadoCalculo() == null) {
/* 26 */       nvCertificadoCalculo.setDataCadastro(new Date());
/* 27 */       return dao.inserir(nvCertificadoCalculo);
/*    */     }
/* 29 */     return dao.alterar(nvCertificadoCalculo);
/*    */   }
/*    */   
/*    */   public List<NvCertificadoCalculo> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 34 */     NvCertificadoCalculoDAO dao = new NvCertificadoCalculoDAO();
/* 35 */     List<NvCertificadoCalculo> listaNvCertificadoCalculo = new ArrayList();
/* 36 */     ClausulaWhere condicao = new ClausulaWhere();
/*    */     
/* 38 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 39 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */     
/* 41 */     if (pSituacao == Situacao.ATIVO) {
/* 42 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 43 */     } else if (pSituacao == Situacao.INATIVO) {
/* 44 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */     }
/*    */     
/* 47 */     listaNvCertificadoCalculo = dao.listar(condicao);
/* 48 */     return listaNvCertificadoCalculo;
/*    */   }
/*    */   
/*    */   public NvCertificadoCalculo buscar(String pSeqNvCertificadoCalculo) {
/* 52 */     NvCertificadoCalculoDAO dao = new NvCertificadoCalculoDAO();
/* 53 */     List<NvCertificadoCalculo> listaNvCertificadoCalculo = new ArrayList();
/* 54 */     ClausulaWhere condicao = new ClausulaWhere();
/* 55 */     System.out.println("AQUI" + pSeqNvCertificadoCalculo);
/*    */     
/* 57 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_Nv_Certificado_Calculo", GeneroCondicaoWhere.igual, String.valueOf(pSeqNvCertificadoCalculo), TipoCondicaoWhere.Numero);
/*    */     
/* 59 */     listaNvCertificadoCalculo = dao.listar(condicao);
/*    */     
/*    */ 
/* 62 */     return (NvCertificadoCalculo)listaNvCertificadoCalculo.get(0);
/*    */   }
/*    */   
/*    */   public boolean deletar(NvCertificadoCalculo nvCertificadoCalculo) {
/* 66 */     NvCertificadoCalculoDAO dao = new NvCertificadoCalculoDAO();
/* 67 */     return dao.deletar(nvCertificadoCalculo);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/NvCertificadoCalculo/NvCertificadoCalculoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */