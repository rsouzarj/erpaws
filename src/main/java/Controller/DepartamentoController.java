package Controller;

import Departamento.Departamento;
import Departamento.DepartamentoService;
import Empresa.Empresa;
import Usuario.Usuario;
import Util.Situacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;







@ManagedBean(name="departamentoController")
@ViewScoped
public class DepartamentoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  DepartamentoService departamentoService = new DepartamentoService();
  Departamento departamento = new Departamento();
  List<Departamento> listaDepartamento = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  public void iniciar() {
    if ((this.loginController.usuario.getAcOrgDepartamento() == null) || (this.loginController.usuario.getAcOrgDepartamento().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela)
  {
    this.departamento.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.departamento.setDataCadastro(new Date());
    this.departamento = this.departamentoService.salvar(this.departamento);
    listar();
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.departamento = new Departamento();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaDepartamento = this.departamentoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.departamentoService.deletar(this.departamento)) {
      listar();
      this.departamento = new Departamento();
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
  
  public void selecionar(Departamento pDepartamento) {
    this.departamento = pDepartamento;
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
  
  public DepartamentoService getDepartamentoService() {
    return this.departamentoService;
  }
  
  public void setDepartamentoService(DepartamentoService departamentoService) {
    this.departamentoService = departamentoService;
  }
  
  public Departamento getDepartamento() {
    return this.departamento;
  }
  
  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }
  
  public List<Departamento> getListaDepartamento() {
    return this.listaDepartamento;
  }
  
  public void setListaDepartamento(List<Departamento> listaDepartamento) {
    this.listaDepartamento = listaDepartamento;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\DepartamentoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */