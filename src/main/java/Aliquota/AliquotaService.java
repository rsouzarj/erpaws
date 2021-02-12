/*     */ package Aliquota;
/*     */ 
/*     */ import ClausulaSQL.ClausulaWhere;
/*     */ import ClausulaSQL.GeneroCondicaoWhere;
/*     */ import ClausulaSQL.OperacaoCondicaoWhere;
/*     */ import ClausulaSQL.TipoCondicaoWhere;
/*     */ import Util.Situacao;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AliquotaService
/*     */ {
/*     */   public Aliquota salvar(Aliquota aliquota)
/*     */   {
/*  23 */     AliquotaDAO dao = new AliquotaDAO();
/*  24 */     if (aliquota.getSeqAliquota() == null) {
/*  25 */       aliquota.setDataCadastro(new Date());
/*  26 */       return dao.inserir(aliquota);
/*     */     }
/*  28 */     return dao.alterar(aliquota);
/*     */   }
/*     */   
/*     */   public List<Aliquota> listar(String pSeqEmpresa, String pString, Situacao pSituacao)
/*     */   {
/*  33 */     AliquotaDAO dao = new AliquotaDAO();
/*  34 */     List<Aliquota> listaAliquota = new ArrayList();
/*  35 */     ClausulaWhere condicao = new ClausulaWhere();
/*     */     
/*     */ 
/*     */ 
/*  39 */     condicao.AdicionarCondicaoManual("where seq_empresa = " + pSeqEmpresa.toUpperCase() + " and (upper(nome) like('%" + pString.toUpperCase() + "%') or upper(tipo_aliquota) like('%" + pString.toUpperCase() + "%'))");
/*     */     
/*  41 */     if (pSituacao == Situacao.ATIVO) {
/*  42 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/*  43 */     } else if (pSituacao == Situacao.INATIVO) {
/*  44 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*     */     }
/*     */     
/*  47 */     listaAliquota = dao.listar(condicao);
/*  48 */     return listaAliquota;
/*     */   }
/*     */   
/*     */   public List<Aliquota> listarFiltro(ClausulaWhere condicao) {
/*  52 */     AliquotaDAO dao = new AliquotaDAO();
/*  53 */     List<Aliquota> listaAliquota = new ArrayList();
/*     */     
/*  55 */     listaAliquota = dao.listar(condicao);
/*  56 */     return listaAliquota;
/*     */   }
/*     */   
/*     */   public List<Aliquota> listarPorSeq(String pSeqEmpresa, String pSeqAliquota, Situacao pSituacao)
/*     */   {
/*  61 */     AliquotaDAO dao = new AliquotaDAO();
/*  62 */     List<Aliquota> listaAliquota = new ArrayList();
/*  63 */     ClausulaWhere condicao = new ClausulaWhere();
/*     */     
/*  65 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "seq_ALIQUOTA", GeneroCondicaoWhere.igual, pSeqAliquota, TipoCondicaoWhere.Texto);
/*  66 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*     */     
/*  68 */     if (pSituacao == Situacao.ATIVO) {
/*  69 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/*  70 */     } else if (pSituacao == Situacao.INATIVO) {
/*  71 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*     */     }
/*     */     
/*  74 */     listaAliquota = dao.listar(condicao);
/*  75 */     return listaAliquota;
/*     */   }
/*     */   
/*     */   public List<Aliquota> listarPorDescricao(String pSeqEmpresa, String pDescricao, Situacao pSituacao) {
/*  79 */     AliquotaDAO dao = new AliquotaDAO();
/*  80 */     List<Aliquota> listaAliquota = new ArrayList();
/*  81 */     ClausulaWhere condicao = new ClausulaWhere();
/*     */     
/*  83 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "descricao", GeneroCondicaoWhere.igual, pDescricao, TipoCondicaoWhere.Texto);
/*  84 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*     */     
/*  86 */     if (pSituacao == Situacao.ATIVO) {
/*  87 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/*  88 */     } else if (pSituacao == Situacao.INATIVO) {
/*  89 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*     */     }
/*     */     
/*  92 */     listaAliquota = dao.listar(condicao);
/*  93 */     return listaAliquota;
/*     */   }
/*     */   
/*     */   public List<Aliquota> listarPorTipo(String pSeqEmpresa, String pString, Situacao pSituacao) {
/*  97 */     AliquotaDAO dao = new AliquotaDAO();
/*  98 */     List<Aliquota> listaAliquotaRetencaoFederal = new ArrayList();
/*  99 */     ClausulaWhere condicao = new ClausulaWhere();
/*     */     
/* 101 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "TIPO_ALIQUOTA", GeneroCondicaoWhere.igual, pString, TipoCondicaoWhere.Texto);
/* 102 */     condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
/*     */     
/* 104 */     if (pSituacao == Situacao.ATIVO) {
/* 105 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
/* 106 */     } else if (pSituacao == Situacao.INATIVO) {
/* 107 */       condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
/*     */     }
/*     */     
/* 110 */     listaAliquotaRetencaoFederal = dao.listar(condicao);
/* 111 */     return listaAliquotaRetencaoFederal;
/*     */   }
/*     */   
/*     */   public boolean deletar(Aliquota aliquota) {
/* 115 */     AliquotaDAO dao = new AliquotaDAO();
/* 116 */     return dao.deletar(aliquota);
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Aliquota/AliquotaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */