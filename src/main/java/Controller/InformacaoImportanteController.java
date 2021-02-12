package Controller;

import Empresa.Empresa;
import InformacaoImportante.InformacaoImportante;
import InformacaoImportante.InformacaoImportanteService;
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







@ManagedBean(name="informacaoImportanteController")
@ViewScoped
public class InformacaoImportanteController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  InformacaoImportanteService informacaoImportanteService = new InformacaoImportanteService();
  InformacaoImportante informacaoImportante = new InformacaoImportante();
  List<InformacaoImportante> listaInformacaoImportante = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcFinInformacaoImportante() == null) || (this.loginController.usuario.getAcFinInformacaoImportante().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela)
  {
    this.informacaoImportante.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.informacaoImportante = this.informacaoImportanteService.salvar(this.informacaoImportante);
    
    if (this.informacaoImportante.getSeqInformacaoImportante() != null) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
      listar();
      this.tela = Integer.valueOf(pTela);
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao armazenar registro.", ""));
    }
  }
  
  public void novo() {
    this.informacaoImportante = new InformacaoImportante();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaInformacaoImportante = this.informacaoImportanteService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.informacaoImportanteService.deletar(this.informacaoImportante)) {
      listar();
      this.informacaoImportante = new InformacaoImportante();
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
  
  public void selecionar(InformacaoImportante pInformacaoImportante) {
    this.informacaoImportante = pInformacaoImportante;
    this.tela = Integer.valueOf(1);
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
    listar();
  }
  

  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public InformacaoImportanteService getInformacaoImportanteService() {
    return this.informacaoImportanteService;
  }
  
  public void setInformacaoImportanteService(InformacaoImportanteService informacaoImportanteService) {
    this.informacaoImportanteService = informacaoImportanteService;
  }
  
  public InformacaoImportante getInformacaoImportante() {
    return this.informacaoImportante;
  }
  
  public void setInformacaoImportante(InformacaoImportante informacaoImportante) {
    this.informacaoImportante = informacaoImportante;
  }
  
  public List<InformacaoImportante> getListaInformacaoImportante() {
    return this.listaInformacaoImportante;
  }
  
  public void setListaInformacaoImportante(List<InformacaoImportante> listaInformacaoImportante) {
    this.listaInformacaoImportante = listaInformacaoImportante;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\InformacaoImportanteController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */