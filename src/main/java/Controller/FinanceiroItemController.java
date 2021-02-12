package Controller;

import Empresa.Empresa;
import FinanceiroItem.FinanceiroItem;
import FinanceiroItem.FinanceiroItemService;
import Util.Situacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;








@ManagedBean(name="financeiroItemController")
@ViewScoped
public class FinanceiroItemController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  FinanceiroItemService financeiroItemService = new FinanceiroItemService();
  FinanceiroItem financeiroItem = new FinanceiroItem();
  List<FinanceiroItem> listaFinanceiroItem = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar() {}
  
  public void salvar(int pTela)
  {
    this.financeiroItem.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.financeiroItem = this.financeiroItemService.salvar(this.financeiroItem);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.financeiroItem = new FinanceiroItem();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaFinanceiroItem = this.financeiroItemService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.financeiroItemService.deletar(this.financeiroItem)) {
      listar();
      this.financeiroItem = new FinanceiroItem();
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
  
  public void selecionar(FinanceiroItem pFinanceiroItem) {
    this.financeiroItem = pFinanceiroItem;
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
  
  public FinanceiroItemService getFinanceiroItemService() {
    return this.financeiroItemService;
  }
  
  public void setFinanceiroItemService(FinanceiroItemService financeiroItemService) {
    this.financeiroItemService = financeiroItemService;
  }
  
  public FinanceiroItem getFinanceiroItem() {
    return this.financeiroItem;
  }
  
  public void setFinanceiroItem(FinanceiroItem financeiroItem) {
    this.financeiroItem = financeiroItem;
  }
  
  public List<FinanceiroItem> getListaFinanceiroItem() {
    return this.listaFinanceiroItem;
  }
  
  public void setListaFinanceiroItem(List<FinanceiroItem> listaFinanceiroItem) {
    this.listaFinanceiroItem = listaFinanceiroItem;
  }
  
  public String getPesquisa()
  {
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\FinanceiroItemController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */