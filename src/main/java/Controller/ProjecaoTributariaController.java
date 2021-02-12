package Controller;

import Empresa.Empresa;
import ProjecaoTributaria.ProjecaoTributaria;
import ProjecaoTributaria.ProjecaoTributariaService;
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







@ManagedBean(name="projecaoTributariaController")
@ViewScoped
public class ProjecaoTributariaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  ProjecaoTributariaService projecaoTributariaService = new ProjecaoTributariaService();
  ProjecaoTributaria projecaoTributaria = new ProjecaoTributaria();
  List<ProjecaoTributaria> listaProjecaoTributaria = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcFinAliquotaRetencaoFederal() == null) || (this.loginController.usuario.getAcFinAliquotaRetencaoFederal().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela)
  {
    this.projecaoTributaria.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.projecaoTributaria = this.projecaoTributariaService.salvar(this.projecaoTributaria);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.projecaoTributaria = new ProjecaoTributaria();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaProjecaoTributaria = this.projecaoTributariaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.projecaoTributariaService.deletar(this.projecaoTributaria)) {
      listar();
      this.projecaoTributaria = new ProjecaoTributaria();
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
  
  public void selecionar(ProjecaoTributaria pProjecaoTributaria) {
    this.projecaoTributaria = pProjecaoTributaria;
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
  
  public ProjecaoTributariaService getProjecaoTributariaService() {
    return this.projecaoTributariaService;
  }
  
  public void setProjecaoTributariaService(ProjecaoTributariaService projecaoTributariaService) {
    this.projecaoTributariaService = projecaoTributariaService;
  }
  
  public ProjecaoTributaria getProjecaoTributaria() {
    return this.projecaoTributaria;
  }
  
  public void setProjecaoTributaria(ProjecaoTributaria projecaoTributaria) {
    this.projecaoTributaria = projecaoTributaria;
  }
  
  public List<ProjecaoTributaria> getListaProjecaoTributaria() {
    return this.listaProjecaoTributaria;
  }
  
  public void setListaProjecaoTributaria(List<ProjecaoTributaria> listaProjecaoTributaria) {
    this.listaProjecaoTributaria = listaProjecaoTributaria;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\ProjecaoTributariaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */