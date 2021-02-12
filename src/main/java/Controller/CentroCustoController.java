package Controller;

import CentroCusto.CentroCusto;
import CentroCusto.CentroCustoService;
import Empresa.Empresa;
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







@ManagedBean(name="centroCustoController")
@ViewScoped
public class CentroCustoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  CentroCustoService centroCustoService = new CentroCustoService();
  CentroCusto centroCusto = new CentroCusto();
  List<CentroCusto> listaCentroCusto = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar() {
    if ((this.loginController.usuario.getAcFinCentroCusto() == null) || (this.loginController.usuario.getAcFinCentroCusto().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela) {
    this.centroCusto.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.centroCusto = this.centroCustoService.salvar(this.centroCusto);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.centroCusto = new CentroCusto();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaCentroCusto = this.centroCustoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.centroCustoService.deletar(this.centroCusto)) {
      listar();
      this.centroCusto = new CentroCusto();
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
  
  public void selecionar(CentroCusto pCentroCusto) {
    this.centroCusto = pCentroCusto;
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
  
  public CentroCustoService getCentroCustoService() {
    return this.centroCustoService;
  }
  
  public void setCentroCustoService(CentroCustoService centroCustoService) {
    this.centroCustoService = centroCustoService;
  }
  
  public CentroCusto getCentroCusto() {
    return this.centroCusto;
  }
  
  public void setCentroCusto(CentroCusto centroCusto) {
    this.centroCusto = centroCusto;
  }
  
  public List<CentroCusto> getListaCentroCusto() {
    return this.listaCentroCusto;
  }
  
  public void setListaCentroCusto(List<CentroCusto> listaCentroCusto) {
    this.listaCentroCusto = listaCentroCusto;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\CentroCustoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */