package Controller;

import Empresa.Empresa;
import NvTipoEmbarcacao.NvTipoEmbarcacao;
import NvTipoEmbarcacao.NvTipoEmbarcacaoService;
import Usuario.Usuario;
import Util.Situacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="nvTipoEmbarcacaoController")
@ViewScoped
public class NvTipoEmbarcacaoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  NvTipoEmbarcacaoService nvTipoEmbarcacaoService = new NvTipoEmbarcacaoService();
  NvTipoEmbarcacao nvTipoEmbarcacao = new NvTipoEmbarcacao();
  List<NvTipoEmbarcacao> listaNvTipoEmbarcacao = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOpEmbarcacao() == null) || (this.loginController.usuario.getAcOpEmbarcacao().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela)
  {
    this.nvTipoEmbarcacao = this.nvTipoEmbarcacaoService.salvar(this.nvTipoEmbarcacao);
    listar();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.nvTipoEmbarcacao = new NvTipoEmbarcacao();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaNvTipoEmbarcacao = this.nvTipoEmbarcacaoService.listar(this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.nvTipoEmbarcacaoService.deletar(this.nvTipoEmbarcacao)) {
      listar();
      this.nvTipoEmbarcacao = new NvTipoEmbarcacao();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
      this.tela = Integer.valueOf(0);
      listar();
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
    }
  }
  
  public void fecharTela() throws IOException {
    this.loginController.mudarPagina("/principal/ principal.jsf");
  }
  
  public void selecionar(NvTipoEmbarcacao pNvTipoEmbarcacao) {
    this.nvTipoEmbarcacao = pNvTipoEmbarcacao;
    this.tela = Integer.valueOf(1);
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  

  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public NvTipoEmbarcacaoService getNvTipoEmbarcacaoService() {
    return this.nvTipoEmbarcacaoService;
  }
  
  public void setNvTipoEmbarcacaoService(NvTipoEmbarcacaoService nvTipoEmbarcacaoService) {
    this.nvTipoEmbarcacaoService = nvTipoEmbarcacaoService;
  }
  
  public NvTipoEmbarcacao getNvTipoEmbarcacao() {
    return this.nvTipoEmbarcacao;
  }
  
  public void setNvTipoEmbarcacao(NvTipoEmbarcacao nvTipoEmbarcacao) {
    this.nvTipoEmbarcacao = nvTipoEmbarcacao;
  }
  
  public List<NvTipoEmbarcacao> getListaNvTipoEmbarcacao() {
    return this.listaNvTipoEmbarcacao;
  }
  
  public void setListaNvTipoEmbarcacao(List<NvTipoEmbarcacao> listaNvTipoEmbarcacao) {
    this.listaNvTipoEmbarcacao = listaNvTipoEmbarcacao;
  }
  
  public String getPesquisa() {
    return this.pesquisa;
  }
  
  public void setPesquisa(String pesquisa) {
    this.pesquisa = pesquisa;
  }
  
  public Integer getTela() {
    return this.tela;
  }
  
  public void setTela(Integer tela) {
    this.tela = tela;
  }
}
