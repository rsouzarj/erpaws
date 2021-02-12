package Controller;

import Empresa.Empresa;
import NvTipoVincParcEmbarca.NvTipoVincParcEmbarca;
import NvTipoVincParcEmbarca.NvTipoVincParcEmbarcaService;
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







@ManagedBean(name="nvTipoVincParcEmbarcaController")
@ViewScoped
public class NvTipoVincParcEmbarcaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  NvTipoVincParcEmbarcaService nvTipoVincParcEmbarcaService = new NvTipoVincParcEmbarcaService();
  NvTipoVincParcEmbarca nvTipoVincParcEmbarca = new NvTipoVincParcEmbarca();
  List<NvTipoVincParcEmbarca> listaNvTipoVincParcEmbarca = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOpTvinculo() == null) || (this.loginController.usuario.getAcOpTvinculo().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    
    listar();
  }
  
  public void salvar(int pTela) {
    this.nvTipoVincParcEmbarca.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.nvTipoVincParcEmbarca = this.nvTipoVincParcEmbarcaService.salvar(this.nvTipoVincParcEmbarca);
    
    listar();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.nvTipoVincParcEmbarca = new NvTipoVincParcEmbarca();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaNvTipoVincParcEmbarca = this.nvTipoVincParcEmbarcaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.nvTipoVincParcEmbarcaService.deletar(this.nvTipoVincParcEmbarca)) {
      listar();
      this.nvTipoVincParcEmbarca = new NvTipoVincParcEmbarca();
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
  
  public void selecionar(NvTipoVincParcEmbarca pNvTipoVincParcEmbarca) {
    this.nvTipoVincParcEmbarca = pNvTipoVincParcEmbarca;
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
  
  public NvTipoVincParcEmbarcaService getNvTipoVincParcEmbarcaService() {
    return this.nvTipoVincParcEmbarcaService;
  }
  
  public void setNvTipoVincParcEmbarcaService(NvTipoVincParcEmbarcaService nvTipoVincParcEmbarcaService) {
    this.nvTipoVincParcEmbarcaService = nvTipoVincParcEmbarcaService;
  }
  
  public NvTipoVincParcEmbarca getNvTipoVincParcEmbarca() {
    return this.nvTipoVincParcEmbarca;
  }
  
  public void setNvTipoVincParcEmbarca(NvTipoVincParcEmbarca nvTipoVincParcEmbarca) {
    this.nvTipoVincParcEmbarca = nvTipoVincParcEmbarca;
  }
  
  public List<NvTipoVincParcEmbarca> getListaNvTipoVincParcEmbarca() {
    return this.listaNvTipoVincParcEmbarca;
  }
  
  public void setListaNvTipoVincParcEmbarca(List<NvTipoVincParcEmbarca> listaNvTipoVincParcEmbarca) {
    this.listaNvTipoVincParcEmbarca = listaNvTipoVincParcEmbarca;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\NvTipoVincParcEmbarcaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */