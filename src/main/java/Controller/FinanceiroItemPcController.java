package Controller;

import Empresa.Empresa;
import FinanceiroItemPc.FinanceiroItemPc;
import FinanceiroItemPc.FinanceiroItemPcService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;









@ManagedBean(name="financeiroItemPcController")
@ViewScoped
public class FinanceiroItemPcController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  FinanceiroItemPcService financeiroItemPcService = new FinanceiroItemPcService();
  FinanceiroItemPc financeiroItemPc = new FinanceiroItemPc();
  List<FinanceiroItemPc> listaFinanceiroItemPc = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar() {}
  
  public void salvar(int pTela)
  {
    this.financeiroItemPc.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.financeiroItemPc = this.financeiroItemPcService.salvar(this.financeiroItemPc);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.financeiroItemPc = new FinanceiroItemPc();
    this.tela = Integer.valueOf(1);
  }
  

  public void listar() {}
  
  public void deletar()
  {
    if (this.financeiroItemPcService.deletar(this.financeiroItemPc)) {
      listar();
      this.financeiroItemPc = new FinanceiroItemPc();
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
  
  public void selecionar(FinanceiroItemPc pFinanceiroItemPc) {
    this.financeiroItemPc = pFinanceiroItemPc;
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
  
  public FinanceiroItemPcService getFinanceiroItemPcService() {
    return this.financeiroItemPcService;
  }
  
  public void setFinanceiroItemPcService(FinanceiroItemPcService financeiroItemPcService) {
    this.financeiroItemPcService = financeiroItemPcService;
  }
  
  public FinanceiroItemPc getFinanceiroItemPc() {
    return this.financeiroItemPc;
  }
  
  public void setFinanceiroItemPc(FinanceiroItemPc financeiroItemPc) {
    this.financeiroItemPc = financeiroItemPc;
  }
  
  public List<FinanceiroItemPc> getListaFinanceiroItemPc() {
    return this.listaFinanceiroItemPc;
  }
  
  public void setListaFinanceiroItemPc(List<FinanceiroItemPc> listaFinanceiroItemPc) {
    this.listaFinanceiroItemPc = listaFinanceiroItemPc;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\FinanceiroItemPcController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */