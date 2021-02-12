package Controller;

import Empresa.Empresa;
import Lugar.Lugar;
import Lugar.LugarService;
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








@ManagedBean(name="lugarController")
@ViewScoped
public class LugarController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  LugarService lugarService = new LugarService();
  Lugar lugar = new Lugar();
  List<Lugar> listaLugar = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcComPservico() == null) || (this.loginController.usuario.getAcComPservico().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela) {
    this.lugar.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.lugar.setSituacao("ATIVO");
    this.lugar = this.lugarService.salvar(this.lugar);
    listar();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.lugar = new Lugar();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaLugar = this.lugarService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.lugarService.deletar(this.lugar)) {
      listar();
      this.lugar = new Lugar();
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
  
  public void selecionar(Lugar pLugar) {
    this.lugar = pLugar;
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
  
  public LugarService getLugarService() {
    return this.lugarService;
  }
  
  public void setLugarService(LugarService lugarService) {
    this.lugarService = lugarService;
  }
  
  public Lugar getLugar() {
    return this.lugar;
  }
  
  public void setLugar(Lugar lugar) {
    this.lugar = lugar;
  }
  
  public List<Lugar> getListaLugar() {
    return this.listaLugar;
  }
  
  public void setListaLugar(List<Lugar> listaLugar) {
    this.listaLugar = listaLugar;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\LugarController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */