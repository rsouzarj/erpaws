package Controller;

import Empresa.Empresa;
import TipoColaborador.TipoColaborador;
import TipoColaborador.TipoColaboradorService;
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







@ManagedBean(name="tipoColaboradorController")
@ViewScoped
public class TipoColaboradorController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoColaboradorService tipoColaboradorService = new TipoColaboradorService();
  TipoColaborador tipoColaborador = new TipoColaborador();
  List<TipoColaborador> listaTipoColaborador = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOrgFuncao() == null) || (this.loginController.usuario.getAcOrgFuncao().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela) {
    this.tipoColaborador.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoColaborador = this.tipoColaboradorService.salvar(this.tipoColaborador);
    
    listar();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tipoColaborador = new TipoColaborador();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoColaborador = this.tipoColaboradorService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.tipoColaboradorService.deletar(this.tipoColaborador)) {
      listar();
      this.tipoColaborador = new TipoColaborador();
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
  
  public void selecionar(TipoColaborador pTipoColaborador) {
    this.tipoColaborador = pTipoColaborador;
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
  
  public TipoColaboradorService getTipoColaboradorService() {
    return this.tipoColaboradorService;
  }
  
  public void setTipoColaboradorService(TipoColaboradorService tipoColaboradorService) {
    this.tipoColaboradorService = tipoColaboradorService;
  }
  
  public TipoColaborador getTipoColaborador() {
    return this.tipoColaborador;
  }
  
  public void setTipoColaborador(TipoColaborador tipoColaborador) {
    this.tipoColaborador = tipoColaborador;
  }
  
  public List<TipoColaborador> getListaTipoColaborador() {
    return this.listaTipoColaborador;
  }
  
  public void setListaTipoColaborador(List<TipoColaborador> listaTipoColaborador) {
    this.listaTipoColaborador = listaTipoColaborador;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoColaboradorController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */