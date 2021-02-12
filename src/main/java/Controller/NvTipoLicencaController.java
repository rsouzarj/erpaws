package Controller;

import Empresa.Empresa;
import NvTipoLicenca.NvTipoLicenca;
import NvTipoLicenca.NvTipoLicencaService;
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







@ManagedBean(name="nvTipoLicencaController")
@ViewScoped
public class NvTipoLicencaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  NvTipoLicencaService nvTipoLicencaService = new NvTipoLicencaService();
  NvTipoLicenca nvTipoLicenca = new NvTipoLicenca();
  List<NvTipoLicenca> listaNvTipoLicenca = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOpTlicenca() == null) || (this.loginController.usuario.getAcOpTlicenca().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela)
  {
    this.nvTipoLicenca.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.nvTipoLicenca = this.nvTipoLicencaService.salvar(this.nvTipoLicenca);
    listar();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.nvTipoLicenca = new NvTipoLicenca();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaNvTipoLicenca = this.nvTipoLicencaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.nvTipoLicencaService.deletar(this.nvTipoLicenca)) {
      listar();
      this.nvTipoLicenca = new NvTipoLicenca();
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
  
  public void selecionar(NvTipoLicenca pNvTipoLicenca) {
    this.nvTipoLicenca = pNvTipoLicenca;
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
  
  public NvTipoLicencaService getNvTipoLicencaService() {
    return this.nvTipoLicencaService;
  }
  
  public void setNvTipoLicencaService(NvTipoLicencaService nvTipoLicencaService) {
    this.nvTipoLicencaService = nvTipoLicencaService;
  }
  
  public NvTipoLicenca getNvTipoLicenca() {
    return this.nvTipoLicenca;
  }
  
  public void setNvTipoLicenca(NvTipoLicenca nvTipoLicenca) {
    this.nvTipoLicenca = nvTipoLicenca;
  }
  
  public List<NvTipoLicenca> getListaNvTipoLicenca() {
    return this.listaNvTipoLicenca;
  }
  
  public void setListaNvTipoLicenca(List<NvTipoLicenca> listaNvTipoLicenca) {
    this.listaNvTipoLicenca = listaNvTipoLicenca;
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
