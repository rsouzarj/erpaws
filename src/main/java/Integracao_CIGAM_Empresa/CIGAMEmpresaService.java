/*     */ package Integracao_CIGAM_Empresa;
/*     */ 
/*     */ import Empresa.Empresa;
/*     */ import Empresa.EmpresaService;
/*     */ import Integracao_CIGAM.ParceiroCigamDAO;
/*     */ import Integracao_CIGAM.TipoParceiroCigamDAO;
/*     */ import Integracao_CIGAM.UsuarioCigamDAO;
/*     */ import Parceiro.Parceiro;
/*     */ import Parceiro.ParceiroService;
/*     */ import TipoParceiro.TipoParceiro;
/*     */ import TipoParceiro.TipoParceiroService;
/*     */ import TipoVinculo.TipoVinculo;
/*     */ import TipoVinculo.TipoVinculoService;
/*     */ import Usuario.Usuario;
/*     */ import Usuario.UsuarioService;
/*     */ import Util.Retorno;
/*     */ import Util.Situacao;
/*     */ import Util.Util;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CIGAMEmpresaService
/*     */ {
/*     */   public static void main(String[] args)
/*     */   {
/*  36 */     CIGAMEmpresaService integracaoCIGAMService = new CIGAMEmpresaService();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CIGAMEmpresa buscarPorCodigo(String pCodigoI, String pCodigo)
/*     */   {
/*  45 */     CIGAMEmpresaDAO dao = new CIGAMEmpresaDAO();
/*  46 */     CIGAMEmpresa cigamEmpresa = dao.listarEmpresaPorCodigo(pCodigo);
/*  47 */     return cigamEmpresa;
/*     */   }
/*     */   
/*     */   public List<Parceiro> listarPorDivisao(String pDivisao) {
/*  51 */     CIGAMEmpresaDAO dao = new CIGAMEmpresaDAO();
/*  52 */     return dao.listarEmpresaPorDivisao(pDivisao);
/*     */   }
/*     */   
/*     */   public List<CIGAMEmpresa> listarPorNome(String pNome) {
/*  56 */     CIGAMEmpresaDAO dao = new CIGAMEmpresaDAO();
/*  57 */     return dao.listarEmpresaPorNome(pNome);
/*     */   }
/*     */   
/*     */   public Retorno salvar(Parceiro pParceiro, Empresa pEmpresa)
/*     */   {
/*  62 */     CIGAMEmpresaDAO dao = new CIGAMEmpresaDAO();
/*  63 */     return dao.salvarEmpresa(pParceiro);
/*     */   }
/*     */   
/*     */   public void popularUsuarioERP(String pChave) {
/*  67 */     UsuarioCigamDAO usuarioCigamDAO = new UsuarioCigamDAO();
/*  68 */     List<Usuario> listaUsuarioCIGAM = usuarioCigamDAO.listar(pChave);
/*     */     
/*  70 */     UsuarioService usuarioService = new UsuarioService();
/*  71 */     for (Usuario u : listaUsuarioCIGAM) {
/*  72 */       usuarioService.salvarUsuario(u);
/*     */     }
/*     */   }
/*     */   
/*     */   public void popularParceiroERP(String pChave)
/*     */   {
/*  78 */     ParceiroCigamDAO parceiroCIGAMDAO = new ParceiroCigamDAO();
/*     */     
/*  80 */     List<Parceiro> listaParceiroCIGAM = parceiroCIGAMDAO.listar(pChave);
/*     */     
/*  82 */     String seqEmpresa = ((Parceiro)listaParceiroCIGAM.get(0)).getSeqEmpresa();
/*  83 */     TipoParceiroService tipoParceiroService = new TipoParceiroService();
/*  84 */     List<TipoParceiro> listaTipoParceiro = new ArrayList();
/*  85 */     listaTipoParceiro = tipoParceiroService.listar(seqEmpresa, Situacao.TODOS);
/*     */     
/*  87 */     ParceiroService parceiroService = new ParceiroService();
/*  88 */     for (Parceiro p : listaParceiroCIGAM) {
/*  89 */       p.setSeqTipoParceiro("0");
/*  90 */       p.setSeqParceiroInclusao("86");
/*  91 */       parceiroService.salvar(p);
/*     */     }
/*     */     
/*  94 */     TipoVinculoService tipoVinculoService = new TipoVinculoService();
/*  95 */     TipoVinculo tipoVinculo = new TipoVinculo();
/*  96 */     tipoVinculo.setSeqEmpresa(seqEmpresa);
/*  97 */     tipoVinculo.setCodigo("001");
/*  98 */     tipoVinculo.setNome("Vendedor");
/*  99 */     tipoVinculo = tipoVinculoService.salvar(tipoVinculo);
/*     */     
/* 101 */     EmpresaService EmpresaService = new EmpresaService();
/* 102 */     Empresa empresa = new Empresa();
/* 103 */     empresa = EmpresaService.buscarEmpresaPorID(seqEmpresa);
/* 104 */     empresa.setSeqTipoVinculoVendedor(tipoVinculo.getSeqTipoVinculo());
/* 105 */     EmpresaService.salvar(empresa);
/*     */     
/* 107 */     Util.executarSql("update parceiro set SEQ_tipo_parceiro = (select p.seq_tipo_parceiro from tipo_parceiro p where p.chave_origem  = parceiro.tag2) where seq_empresa = " + String.valueOf(seqEmpresa));
/*     */     
/* 109 */     String sVincularParceiroVendedor = "insert into PARCEIRO_VINCULO (seq_parceiro_vinculo, seq_parceiro, seq_parceiro_vinculado, seq_tipo_vinculo, data_cadastro)\n\nselect\nseq_parceiro_vinculo.nextval,\nparceiro.seq_parceiro,\nvendedor.seq_parceiro,\n" + tipoVinculo.getSeqTipoVinculo() + ",\n" + "sysdate\n" + "from\n" + "parceiro\n" + "inner join parceiro vendedor on vendedor.chave_origem = parceiro.tag1\n" + "where\n" + "trim(parceiro.tag1) != ' '\n" + "and trim(parceiro.chave_origem) != ' '\n" + "and parceiro.seq_empresa = " + String.valueOf(seqEmpresa);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */     Util.executarSql(sVincularParceiroVendedor);
/*     */   }
/*     */   
/*     */   public void popularTipoParceiroERP(String pChave) {
/* 129 */     TipoParceiroCigamDAO tipoParceiroCigamDAO = new TipoParceiroCigamDAO();
/* 130 */     List<TipoParceiro> listaTipoParceiroCIGAM = tipoParceiroCigamDAO.listar(pChave);
/*     */     
/* 132 */     TipoParceiroService tipoParceiroService = new TipoParceiroService();
/* 133 */     for (TipoParceiro tp : listaTipoParceiroCIGAM) {
/* 134 */       tipoParceiroService.salvar(tp);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM_Empresa/CIGAMEmpresaService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */