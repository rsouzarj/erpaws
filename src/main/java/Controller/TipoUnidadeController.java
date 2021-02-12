package Controller;

import Empresa.Empresa;
import TipoUnidade.TipoUnidade;
import TipoUnidade.TipoUnidadeService;
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







@ManagedBean(name="tipoUnidadeController")
@ViewScoped
public class TipoUnidadeController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoUnidadeService tipoUnidadeService = new TipoUnidadeService();
  TipoUnidade tipoUnidade = new TipoUnidade();
  List<TipoUnidade> listaTipoUnidade = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcFinTunidade() == null) || (this.loginController.usuario.getAcFinTunidade().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela)
  {
    this.tipoUnidade.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoUnidade = this.tipoUnidadeService.salvar(this.tipoUnidade);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tipoUnidade = new TipoUnidade();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoUnidade = this.tipoUnidadeService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.tipoUnidadeService.deletar(this.tipoUnidade)) {
      listar();
      this.tipoUnidade = new TipoUnidade();
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
  
  public void selecionar(TipoUnidade pTipoUnidade) {
    this.tipoUnidade = pTipoUnidade;
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
  
  public TipoUnidadeService getTipoUnidadeService() {
    return this.tipoUnidadeService;
  }
  
  public void setTipoUnidadeService(TipoUnidadeService tipoUnidadeService) {
    this.tipoUnidadeService = tipoUnidadeService;
  }
  
  public TipoUnidade getTipoUnidade() {
    return this.tipoUnidade;
  }
  
  public void setTipoUnidade(TipoUnidade tipoUnidade) {
    this.tipoUnidade = tipoUnidade;
  }
  
  public List<TipoUnidade> getListaTipoUnidade() {
    return this.listaTipoUnidade;
  }
  
  public void setListaTipoUnidade(List<TipoUnidade> listaTipoUnidade) {
    this.listaTipoUnidade = listaTipoUnidade;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoUnidadeController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */