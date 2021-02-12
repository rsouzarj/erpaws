/*    */ package FormaPagamento;
/*    */ 
/*    */ import ClausulaSQL.ClausulaWhere;
/*    */ import ClausulaSQL.GeneroCondicaoWhere;
/*    */ import ClausulaSQL.OperacaoCondicaoWhere;
/*    */ import ClausulaSQL.TipoCondicaoWhere;
/*    */ import Empresa.Empresa;
/*    */ import Empresa.EmpresaService;
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
/*    */ 
/*    */ public class FormaPagamentoService
/*    */ {
/*    */   public FormaPagamento salvar(FormaPagamento formaPagamento)
/*    */   {
/* 27 */     FormaPagamentoDAO dao = new FormaPagamentoDAO();
/* 28 */     if (formaPagamento.getSeqFormaPagamento() == null) {
/* 29 */       formaPagamento.setDataCadastro(new Date());
/* 30 */       dao.inserir(formaPagamento);
/* 31 */       return formaPagamento;
/*    */     }
/* 33 */     dao.alterar(formaPagamento);
/* 34 */     return formaPagamento;
/*    */   }
/*    */   
/*    */   public List<FormaPagamento> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 39 */     List<FormaPagamento> retorno = new ArrayList();
/* 40 */     EmpresaService empresaService = new EmpresaService();
/* 41 */     Empresa empresa = empresaService.buscarEmpresaPorID(pSeqEmpresa);
/*    */     
/* 43 */     if (empresa.getIntegracao().equals("CROSS")) {
/* 44 */       FormaPagamentoDAO dao = new FormaPagamentoDAO();
/* 45 */       ClausulaWhere condicao = new ClausulaWhere();
/*    */       
/* 47 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
/* 48 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*    */       
/* 50 */       if (pSituacao == Situacao.ATIVO) {
/* 51 */         condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 52 */       } else if (pSituacao == Situacao.INATIVO) {
/* 53 */         condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*    */       }
/*    */       
/* 56 */       retorno = dao.listar(condicao);
/* 57 */     } 
/*    */     
/* 62 */     return retorno;
/*    */   }
/*    */   
/*    */   public boolean deletar(FormaPagamento formaPagamento) {
/* 66 */     FormaPagamentoDAO dao = new FormaPagamentoDAO();
/* 67 */     return dao.deletar(formaPagamento);
/*    */   }
/*    */ }
