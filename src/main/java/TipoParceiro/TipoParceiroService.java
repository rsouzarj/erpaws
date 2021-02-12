/*     */ package TipoParceiro;
/*     */ 
/*     */ import ClausulaSQL.ClausulaWhere;
/*     */ import ClausulaSQL.GeneroCondicaoWhere;
/*     */ import ClausulaSQL.OperacaoCondicaoWhere;
/*     */ import ClausulaSQL.TipoCondicaoWhere;
/*     */ import Empresa.Empresa;
/*     */ import Empresa.EmpresaService;
/*     */ import Util.Situacao;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TipoParceiroService
/*     */ {
/*     */   public TipoParceiro salvar(TipoParceiro tipoParceiro)
/*     */   {
/*  25 */     TipoParceiroDAO dao = new TipoParceiroDAO();
/*  26 */     if (tipoParceiro.getSeqTipoParceiro() == null) {
/*  27 */       dao.inserir(tipoParceiro);
/*  28 */       return tipoParceiro;
/*     */     }
/*  30 */     dao.alterar(tipoParceiro);
/*  31 */     return tipoParceiro;
/*     */   }
/*     */   
/*     */   public List<TipoParceiro> listar(String pSeqEmpresa, Situacao pSituacao)
/*     */   {
/*  36 */     List<TipoParceiro> retorno = new ArrayList();
/*     */     
/*  38 */     EmpresaService empresaService = new EmpresaService();
/*  39 */     Empresa empresa = empresaService.buscarEmpresaPorID(pSeqEmpresa);
/*     */     
/*  41 */     if (empresa.getIntegracao().equals("CROSS"))
/*     */     {
/*  43 */       TipoParceiroDAO dao = new TipoParceiroDAO();
/*     */       
/*  45 */       ClausulaWhere condicao = new ClausulaWhere();
/*  46 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*     */       
/*  48 */       if (pSituacao.equals(Situacao.ATIVO)) {
/*  49 */         condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/*  50 */       } else if (pSituacao.equals(Situacao.INATIVO)) {
/*  51 */         condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*     */       }
/*  53 */       condicao.AdicionarCondicaoManual(" order by ordem");
/*     */       
/*  55 */       retorno = dao.listar(condicao);
/*  56 */     } else if (empresa.getIntegracao().equals("SAP")) {
/*  57 */       TipoParceiro tipoParceiro = new TipoParceiro();
/*     */       
/*  59 */       tipoParceiro.setNome("Cliente");
/*  60 */       tipoParceiro.setSeqTipoParceiro("C");
/*  61 */       retorno.add(tipoParceiro);
/*     */       
/*  63 */       tipoParceiro = new TipoParceiro();
/*  64 */       tipoParceiro.setNome("Lead");
/*  65 */       tipoParceiro.setSeqTipoParceiro("L");
/*     */     }
/*     */     
/*  68 */     return retorno;
/*     */   }
/*     */   
/*     */ 
/*     */   public TipoParceiro buscarPorId(String pSeqTipoParceiro, String pSeqEmpresa)
/*     */   {
/*  74 */     TipoParceiroDAO dao = new TipoParceiroDAO();
/*  75 */     ClausulaWhere condicao = new ClausulaWhere();
/*  76 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_tipo_parceiro", GeneroCondicaoWhere.igual, String.valueOf(pSeqTipoParceiro), TipoCondicaoWhere.Numero);
/*  77 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*  78 */     return (TipoParceiro)dao.listar(condicao).get(0);
/*     */   }
/*     */   
/*     */   public List<TipoParceiro> listarPorNome(String pTipoParceiroNome, String pSeqEmpresa) {
/*  82 */     TipoParceiroDAO dao = new TipoParceiroDAO();
/*  83 */     ClausulaWhere condicao = new ClausulaWhere();
/*  84 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "nome", GeneroCondicaoWhere.contem, pTipoParceiroNome, TipoCondicaoWhere.Texto);
/*  85 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*  86 */     return dao.listar(condicao);
/*     */   }
/*     */   
/*     */   public boolean deletar(TipoParceiro tipoParceiro) {
/*  90 */     TipoParceiroDAO dao = new TipoParceiroDAO();
/*  91 */     return dao.deletar(tipoParceiro);
/*     */   }
/*     */   
/*     */   public HashMap<String, String> listarContador(String pSeqEmpresa) {
/*  95 */     TipoParceiroDAO dao = new TipoParceiroDAO();
/*  96 */     return dao.listarContador(pSeqEmpresa);
/*     */   }
/*     */   
/*     */   public HashMap<String, String> listarContadorComercial(String pSeqEmpresa, String pSeqParceiroVendedor) {
/* 100 */     TipoParceiroDAO dao = new TipoParceiroDAO();
/* 101 */     return dao.listarContadorVendedor(pSeqEmpresa, pSeqParceiroVendedor);
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/TipoParceiro/TipoParceiroService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */