package Controller;

import ClausulaSQL.ClausulaWhere;
import ClausulaSQL.GeneroCondicaoWhere;
import ClausulaSQL.OperacaoCondicaoWhere;
import ClausulaSQL.TipoCondicaoWhere;
import Empresa.Empresa;
import Empresa.EmpresaService;
import Parceiro.Parceiro;
import Parceiro.ParceiroService;
import PesquisaSatisfacao.PesquisaSatisfacao;
import PesquisaSatisfacao.PesquisaSatisfacaoService;
import TipoDocumento.TipoDocumento;
import TipoDocumento.TipoDocumentoService;
import Usuario.Usuario;
import Util.Situacao;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.StreamedContent;






@ManagedBean(name="pesquisaSatisfacaoController")
@ViewScoped
public class PesquisaSatisfacaoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  PesquisaSatisfacaoService pesquisaSatisfacaoService = new PesquisaSatisfacaoService();
  PesquisaSatisfacao pesquisaSatisfacao = new PesquisaSatisfacao();
  List<PesquisaSatisfacao> listaPesquisaSatisfacao = new ArrayList();
  
  TipoDocumentoService tipoDocumentoService = new TipoDocumentoService();
  List<TipoDocumento> listaTipoDocumento = new ArrayList();
  
  ParceiroService parceiroService = new ParceiroService();
  List<Parceiro> listaParceiro = new ArrayList();
  Parceiro parceiro = new Parceiro();
  
  boolean porDataCadastro;
  
  String dataCadastroInicial;
  String dataCadastroFinal;
  EmpresaService empresaService = new EmpresaService();
  
  String pesquisa = "";
  Integer seqDocumento;
  Integer seqEmpresa;
  Integer seqPesquisa;
  Integer seqParceiro;
  Integer tela = Integer.valueOf(0);
  
  BigDecimal mediaP1 = new BigDecimal(0);
  BigDecimal mediaP2 = new BigDecimal(0);
  BigDecimal mediaP3 = new BigDecimal(0);
  BigDecimal mediaP4 = new BigDecimal(0);
  BigDecimal mediaP5 = new BigDecimal(0);
  BigDecimal mediaP6 = new BigDecimal(0);
  BigDecimal mediaP7 = new BigDecimal(0);
  BigDecimal mediaP8 = new BigDecimal(0);
  BigDecimal mediaP9 = new BigDecimal(0);
  BigDecimal mediaP10 = new BigDecimal(0);
  BigDecimal mediaP11 = new BigDecimal(0);
  
  private StreamedContent logo;
  
  String seqParceiroSelecionado;
  String codigoSelecionado;
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcRelPesqSatisfacao() == null) || (this.loginController.usuario.getAcRelPesqSatisfacao().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    ClausulaWhere condicao = new ClausulaWhere();
    
    condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "parceiro.seq_parceiro", GeneroCondicaoWhere.igual, String.valueOf(this.seqParceiro), TipoCondicaoWhere.Numero);
    










    if (this.loginController.usuario.getSeqUsuario() != null) {
      System.out.println(this.loginController.empresa.getSeqEmpresa());
      this.listaPesquisaSatisfacao = this.pesquisaSatisfacaoService.listar(Integer.parseInt(this.loginController.empresa.getSeqEmpresa()));
      this.listaTipoDocumento = this.tipoDocumentoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.TODOS, this.loginController.getUsuario().getSeqUsuario());
      this.listaParceiro = this.parceiroService.listarParceiro(this.loginController.getUsuario().getSeqUsuario(), "");
      calcularMedias();
    }
    
    if ((this.seqPesquisa != null) && (this.loginController.usuario.getSeqUsuario() != null)) {
      this.pesquisaSatisfacao = ((PesquisaSatisfacao)this.pesquisaSatisfacaoService.listarSeqPesquisa(this.seqPesquisa.intValue()).get(0));
      this.loginController.setEmpresa(this.empresaService.buscarEmpresaPorID(this.pesquisaSatisfacao.getSeqEmpresa().toString()));
    }
    if (this.seqEmpresa != null) {
      this.loginController.setEmpresa(this.empresaService.buscarEmpresaPorID(this.seqEmpresa.toString()));
    }
    
    if (this.seqParceiro != null) {
      this.parceiro = ((Parceiro)this.parceiroService.listarParceiroFiltro(condicao).get(0));
      this.pesquisaSatisfacao.setEmpresaValidador(this.parceiro.getNome());
    }
  }
  

  public void salvar()
  {
    if (this.seqEmpresa == null) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Referência à Proposta não foi encontrada.", ""));
      return;
    }
    if (this.seqDocumento == null) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Referência à Proposta não foi encontrada..", ""));
      return;
    }
    this.pesquisaSatisfacao.setSeqEmpresa(this.seqEmpresa);
    this.pesquisaSatisfacao.setSeqDocumento(this.seqDocumento);
    this.pesquisaSatisfacao = this.pesquisaSatisfacaoService.salvar(this.pesquisaSatisfacao);
    this.pesquisaSatisfacao = new PesquisaSatisfacao();
    
    RequestContext.getCurrentInstance().execute("PF('statusDialog').show();");
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
  }
  
  public void novo() {
    this.pesquisaSatisfacao = new PesquisaSatisfacao();
  }
  
  public void listar() {
    ClausulaWhere condicao = new ClausulaWhere();
    
    condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "PESQUISA_SATISFACAO.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(this.loginController.getEmpresa().getSeqEmpresa()), TipoCondicaoWhere.Numero);
    










    if (this.seqParceiroSelecionado != null) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "documento.seq_parceiro", GeneroCondicaoWhere.igual, String.valueOf(this.seqParceiroSelecionado), TipoCondicaoWhere.Numero);
    }
    if ((this.codigoSelecionado != null) && (!this.codigoSelecionado.isEmpty())) {
      condicao.AdicionarCondicaoManual(" and (documento.codigo = '" + this.codigoSelecionado + "' or documento.codigo = ' " + this.codigoSelecionado + "')");
    }
    
    this.listaPesquisaSatisfacao = this.pesquisaSatisfacaoService.listarFiltro(condicao);
  }
  
  public void deletar() {
    if (this.pesquisaSatisfacaoService.deletar(this.pesquisaSatisfacao)) {
      listar();
      this.pesquisaSatisfacao = new PesquisaSatisfacao();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
      listar();
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
    }
  }
  
  public void fecharTela() throws IOException {
    this.loginController.mudarPagina("/painel/pesquisa_satisfacao.jsf");
  }
  
  public void limpar() {
    this.pesquisaSatisfacao = new PesquisaSatisfacao();
  }
  
  public void selecionar(PesquisaSatisfacao pPesquisaSatisfacao)
  {
    this.pesquisaSatisfacao = pPesquisaSatisfacao;
    this.loginController.mudarPagina("/pesquisa.jsf?sp=" + pPesquisaSatisfacao.getSeqPesquisaSatisfacao());
  }
  

  public void mudarTela(Integer pTela) {}
  
  public void limparMedias()
  {
    this.mediaP1 = new BigDecimal(0);
    this.mediaP2 = new BigDecimal(0);
    this.mediaP3 = new BigDecimal(0);
    this.mediaP4 = new BigDecimal(0);
    this.mediaP5 = new BigDecimal(0);
    this.mediaP6 = new BigDecimal(0);
    this.mediaP7 = new BigDecimal(0);
    this.mediaP8 = new BigDecimal(0);
    this.mediaP9 = new BigDecimal(0);
    this.mediaP10 = new BigDecimal(0);
    this.mediaP11 = new BigDecimal(0);
  }
  
  public void calcularMedias() {
    if (this.listaPesquisaSatisfacao.isEmpty()) {
      limparMedias();
      return;
    }
    int size = this.listaPesquisaSatisfacao.size();
    
    BigDecimal tam = new BigDecimal(size);
    limparMedias();
    for (PesquisaSatisfacao l : this.listaPesquisaSatisfacao) {
      this.mediaP1 = this.mediaP1.add(new BigDecimal(l.getPerguntaUm().intValue()));
      this.mediaP2 = this.mediaP2.add(new BigDecimal(l.getPerguntaDois().intValue()));
      this.mediaP3 = this.mediaP3.add(new BigDecimal(l.getPerguntaTres().intValue()));
      this.mediaP4 = this.mediaP4.add(new BigDecimal(l.getPerguntaQuatro().intValue()));
      this.mediaP5 = this.mediaP5.add(new BigDecimal(l.getPerguntaCinco().intValue()));
      this.mediaP6 = this.mediaP6.add(new BigDecimal(l.getPerguntaSeis().intValue()));
      this.mediaP7 = this.mediaP7.add(new BigDecimal(l.getPerguntaSete().intValue()));
      this.mediaP8 = this.mediaP8.add(new BigDecimal(l.getPerguntaOito().intValue()));
      this.mediaP9 = this.mediaP9.add(new BigDecimal(l.getPerguntaNove().intValue()));
      this.mediaP10 = this.mediaP10.add(new BigDecimal(l.getPerguntaDez().intValue()));
      this.mediaP11 = this.mediaP11.add(new BigDecimal(l.getPerguntaOnze().intValue()));
    }
    

    this.mediaP1 = this.mediaP1.divide(tam, 2, 0);
    this.mediaP2 = this.mediaP2.divide(tam, 2, 0);
    this.mediaP3 = this.mediaP3.divide(tam, 2, 0);
    this.mediaP4 = this.mediaP4.divide(tam, 2, 0);
    this.mediaP5 = this.mediaP5.divide(tam, 2, 0);
    this.mediaP6 = this.mediaP6.divide(tam, 2, 0);
    this.mediaP7 = this.mediaP7.divide(tam, 2, 0);
    this.mediaP8 = this.mediaP8.divide(tam, 2, 0);
    this.mediaP9 = this.mediaP9.divide(tam, 2, 0);
    this.mediaP10 = this.mediaP10.divide(tam, 2, 0);
    this.mediaP11 = this.mediaP11.divide(tam, 2, 0);
  }
  

  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public PesquisaSatisfacaoService getPesquisaSatisfacaoService() {
    return this.pesquisaSatisfacaoService;
  }
  
  public void setPesquisaSatisfacaoService(PesquisaSatisfacaoService pesquisaSatisfacaoService) {
    this.pesquisaSatisfacaoService = pesquisaSatisfacaoService;
  }
  
  public PesquisaSatisfacao getPesquisaSatisfacao() {
    return this.pesquisaSatisfacao;
  }
  
  public void setPesquisaSatisfacao(PesquisaSatisfacao pesquisaSatisfacao) {
    this.pesquisaSatisfacao = pesquisaSatisfacao;
  }
  
  public List<PesquisaSatisfacao> getListaPesquisaSatisfacao() {
    return this.listaPesquisaSatisfacao;
  }
  
  public void setListaPesquisaSatisfacao(List<PesquisaSatisfacao> listaPesquisaSatisfacao) {
    this.listaPesquisaSatisfacao = listaPesquisaSatisfacao;
  }
  
  public String getPesquisa() {
    return this.pesquisa;
  }
  
  public void setPesquisa(String pesquisa) {
    this.pesquisa = pesquisa;
  }
  
  public Integer getSeqDocumento() {
    return this.seqDocumento;
  }
  
  public void setSeqDocumento(Integer seqDocumento) {
    this.seqDocumento = seqDocumento;
  }
  
  public Integer getSeqEmpresa() {
    return this.seqEmpresa;
  }
  
  public void setSeqEmpresa(Integer seqEmpresa) {
    this.seqEmpresa = seqEmpresa;
  }
  
  public Integer getTela() {
    return this.tela;
  }
  
  public void setTela(Integer tela) {
    this.tela = tela;
  }
  
  public StreamedContent getLogo() {
    return this.logo;
  }
  
  public void setLogo(StreamedContent logo) {
    this.logo = logo;
  }
  
  public BigDecimal getMediaP1() {
    return this.mediaP1;
  }
  
  public void setMediaP1(BigDecimal mediaP1) {
    this.mediaP1 = mediaP1;
  }
  
  public BigDecimal getMediaP2() {
    return this.mediaP2;
  }
  
  public void setMediaP2(BigDecimal mediaP2) {
    this.mediaP2 = mediaP2;
  }
  
  public BigDecimal getMediaP3() {
    return this.mediaP3;
  }
  
  public void setMediaP3(BigDecimal mediaP3) {
    this.mediaP3 = mediaP3;
  }
  
  public BigDecimal getMediaP4() {
    return this.mediaP4;
  }
  
  public void setMediaP4(BigDecimal mediaP4) {
    this.mediaP4 = mediaP4;
  }
  
  public BigDecimal getMediaP5() {
    return this.mediaP5;
  }
  
  public void setMediaP5(BigDecimal mediaP5) {
    this.mediaP5 = mediaP5;
  }
  
  public BigDecimal getMediaP6() {
    return this.mediaP6;
  }
  
  public void setMediaP6(BigDecimal mediaP6) {
    this.mediaP6 = mediaP6;
  }
  
  public BigDecimal getMediaP7() {
    return this.mediaP7;
  }
  
  public void setMediaP7(BigDecimal mediaP7) {
    this.mediaP7 = mediaP7;
  }
  
  public BigDecimal getMediaP8() {
    return this.mediaP8;
  }
  
  public void setMediaP8(BigDecimal mediaP8) {
    this.mediaP8 = mediaP8;
  }
  
  public BigDecimal getMediaP9() {
    return this.mediaP9;
  }
  
  public void setMediaP9(BigDecimal mediaP9) {
    this.mediaP9 = mediaP9;
  }
  
  public BigDecimal getMediaP10() {
    return this.mediaP10;
  }
  
  public void setMediaP10(BigDecimal mediaP10) {
    this.mediaP10 = mediaP10;
  }
  
  public BigDecimal getMediaP11() {
    return this.mediaP11;
  }
  
  public void setMediaP11(BigDecimal mediaP11) {
    this.mediaP11 = mediaP11;
  }
  
  public Integer getSeqPesquisa() {
    return this.seqPesquisa;
  }
  
  public void setSeqPesquisa(Integer seqPesquisa) {
    this.seqPesquisa = seqPesquisa;
  }
  
  public EmpresaService getEmpresaService() {
    return this.empresaService;
  }
  
  public void setEmpresaService(EmpresaService empresaService) {
    this.empresaService = empresaService;
  }
  
  public String getCodigoSelecionado() {
    return this.codigoSelecionado;
  }
  
  public void setCodigoSelecionado(String codigoSelecionado) {
    this.codigoSelecionado = codigoSelecionado;
  }
  
  public String getSeqParceiroSelecionado() {
    return this.seqParceiroSelecionado;
  }
  
  public void setSeqParceiroSelecionado(String seqParceiroSelecionado) {
    this.seqParceiroSelecionado = seqParceiroSelecionado;
  }
  
  public TipoDocumentoService getTipoDocumentoService() {
    return this.tipoDocumentoService;
  }
  
  public void setTipoDocumentoService(TipoDocumentoService tipoDocumentoService) {
    this.tipoDocumentoService = tipoDocumentoService;
  }
  
  public List<TipoDocumento> getListaTipoDocumento() {
    return this.listaTipoDocumento;
  }
  
  public void setListaTipoDocumento(List<TipoDocumento> listaTipoDocumento) {
    this.listaTipoDocumento = listaTipoDocumento;
  }
  
  public ParceiroService getParceiroService() {
    return this.parceiroService;
  }
  
  public void setParceiroService(ParceiroService parceiroService) {
    this.parceiroService = parceiroService;
  }
  
  public List<Parceiro> getListaParceiro() {
    return this.listaParceiro;
  }
  
  public void setListaParceiro(List<Parceiro> listaParceiro) {
    this.listaParceiro = listaParceiro;
  }
  
  public Parceiro getParceiro() {
    return this.parceiro;
  }
  
  public void setParceiro(Parceiro parceiro) {
    this.parceiro = parceiro;
  }
  
  public Integer getSeqParceiro() {
    return this.seqParceiro;
  }
  
  public void setSeqParceiro(Integer seqParceiro) {
    this.seqParceiro = seqParceiro;
  }
  
  public boolean isPorDataCadastro() {
    return this.porDataCadastro;
  }
  
  public void setPorDataCadastro(boolean porDataCadastro) {
    this.porDataCadastro = porDataCadastro;
  }
  
  public String getDataCadastroInicial() {
    return this.dataCadastroInicial;
  }
  
  public void setDataCadastroInicial(String dataCadastroInicial) {
    this.dataCadastroInicial = dataCadastroInicial;
  }
  
  public String getDataCadastroFinal() {
    return this.dataCadastroFinal;
  }
  
  public void setDataCadastroFinal(String dataCadastroFinal) {
    this.dataCadastroFinal = dataCadastroFinal;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\PesquisaSatisfacaoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */