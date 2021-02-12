package Controller;

import Empresa.Empresa;
import TipoEndereco.TipoEndereco;
import TipoEndereco.TipoEnderecoService;
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







@ManagedBean(name="tipoEnderecoController")
@ViewScoped
public class TipoEnderecoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoEnderecoService tipoEnderecoService = new TipoEnderecoService();
  TipoEndereco tipoEndereco = new TipoEndereco();
  List<TipoEndereco> listaTipoEndereco = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  

  public void iniciar()
  {
    if ((this.loginController.usuario.getAcCadTendereco() == null) || (this.loginController.usuario.getAcCadTendereco().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    listar();
  }
  
  public void salvar(int pTela) {
    this.tipoEndereco.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoEndereco = this.tipoEnderecoService.salvar(this.tipoEndereco);
    
    listar();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tipoEndereco = new TipoEndereco();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoEndereco = this.tipoEnderecoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.tipoEnderecoService.deletar(this.tipoEndereco)) {
      listar();
      this.tipoEndereco = new TipoEndereco();
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
  
  public void selecionar(TipoEndereco pTipoEndereco) {
    this.tipoEndereco = pTipoEndereco;
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
  
  public TipoEnderecoService getTipoEnderecoService() {
    return this.tipoEnderecoService;
  }
  
  public void setTipoEnderecoService(TipoEnderecoService tipoEnderecoService) {
    this.tipoEnderecoService = tipoEnderecoService;
  }
  
  public TipoEndereco getTipoEndereco() {
    return this.tipoEndereco;
  }
  
  public void setTipoEndereco(TipoEndereco tipoEndereco) {
    this.tipoEndereco = tipoEndereco;
  }
  
  public List<TipoEndereco> getListaTipoEndereco() {
    return this.listaTipoEndereco;
  }
  
  public void setListaTipoEndereco(List<TipoEndereco> listaTipoEndereco) {
    this.listaTipoEndereco = listaTipoEndereco;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoEnderecoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */