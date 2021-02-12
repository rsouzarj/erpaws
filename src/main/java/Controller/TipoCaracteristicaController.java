package Controller;

import Empresa.Empresa;
import TipoCaracteristica.TipoCaracteristica;
import TipoCaracteristica.TipoCaracteristicaService;
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







@ManagedBean(name="tipoCaracteristicaController")
@ViewScoped
public class TipoCaracteristicaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoCaracteristicaService tipoCaracteristicaService = new TipoCaracteristicaService();
  TipoCaracteristica tipoCaracteristica = new TipoCaracteristica();
  List<TipoCaracteristica> listaTipoCaracteristica = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  

  public void iniciar()
  {
    if ((this.loginController.usuario.getAcCadTcaracteristica() == null) || (this.loginController.usuario.getAcCadTcaracteristica().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela) {
    this.tipoCaracteristica.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoCaracteristica = this.tipoCaracteristicaService.salvar(this.tipoCaracteristica);
    listar();
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tipoCaracteristica = new TipoCaracteristica();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoCaracteristica = this.tipoCaracteristicaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.tipoCaracteristicaService.deletar(this.tipoCaracteristica)) {
      listar();
      this.tipoCaracteristica = new TipoCaracteristica();
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
  
  public void selecionar(TipoCaracteristica pTipoCaracteristica) {
    this.tipoCaracteristica = pTipoCaracteristica;
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
  
  public TipoCaracteristicaService getTipoCaracteristicaService() {
    return this.tipoCaracteristicaService;
  }
  
  public void setTipoCaracteristicaService(TipoCaracteristicaService tipoCaracteristicaService) {
    this.tipoCaracteristicaService = tipoCaracteristicaService;
  }
  
  public TipoCaracteristica getTipoCaracteristica() {
    return this.tipoCaracteristica;
  }
  
  public void setTipoCaracteristica(TipoCaracteristica tipoCaracteristica) {
    this.tipoCaracteristica = tipoCaracteristica;
  }
  
  public List<TipoCaracteristica> getListaTipoCaracteristica() {
    return this.listaTipoCaracteristica;
  }
  
  public void setListaTipoCaracteristica(List<TipoCaracteristica> listaTipoCaracteristica) {
    this.listaTipoCaracteristica = listaTipoCaracteristica;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoCaracteristicaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */