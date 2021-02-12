/*    */ package CondicaoPagamento;
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
/*    */ public class CondicaoPagamentoService
/*    */ {
/*    */   public CondicaoPagamento salvar(CondicaoPagamento condicaoPagamento)
/*    */   {
/* 26 */     CondicaoPagamentoDAO dao = new CondicaoPagamentoDAO();
/* 27 */     if (condicaoPagamento.getSeqCondicaoPagamento() == null) {
/* 28 */       condicaoPagamento.setDataCadastro(new Date());
/* 29 */       dao.inserir(condicaoPagamento);
/* 30 */       return condicaoPagamento;
/*    */     }
/* 32 */     dao.alterar(condicaoPagamento);
/* 33 */     return condicaoPagamento;
/*    */   }
/*    */   
/*    */   public List<CondicaoPagamento> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*    */   {
/* 38 */     List<CondicaoPagamento> retorno = new ArrayList();
/*    */     
/* 40 */     EmpresaService empresaService = new EmpresaService();
/* 41 */     Empresa empresa = empresaService.buscarEmpresaPorID(pSeqEmpresa);
/*    */     
/* 43 */     if (empresa.getIntegracao().equals("CROSS")) {
/* 44 */       CondicaoPagamentoDAO dao = new CondicaoPagamentoDAO();
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
/*    */   public boolean deletar(CondicaoPagamento condicaoPagamento) {
/* 66 */     CondicaoPagamentoDAO dao = new CondicaoPagamentoDAO();
/* 67 */     return dao.deletar(condicaoPagamento);
/*    */   }
/*    */ }
