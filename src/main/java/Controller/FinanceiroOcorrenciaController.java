package Controller;

import Empresa.Empresa;
import FinanceiroOcorrencia.FinanceiroOcorrencia;
import FinanceiroOcorrencia.FinanceiroOcorrenciaService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;









@ManagedBean(name="financeiroOcorrenciaController")
@ViewScoped
public class FinanceiroOcorrenciaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  FinanceiroOcorrenciaService financeiroOcorrenciaService = new FinanceiroOcorrenciaService();
  FinanceiroOcorrencia financeiroOcorrencia = new FinanceiroOcorrencia();
  List<FinanceiroOcorrencia> listaFinanceiroOcorrencia = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar() {}
  
  public void salvar(int pTela)
  {
    this.financeiroOcorrencia.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.financeiroOcorrencia = this.financeiroOcorrenciaService.salvar(this.financeiroOcorrencia);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.financeiroOcorrencia = new FinanceiroOcorrencia();
    this.tela = Integer.valueOf(1);
  }
  

  public void listar() {}
  
  public void deletar()
  {
    if (this.financeiroOcorrenciaService.deletar(this.financeiroOcorrencia)) {
      listar();
      this.financeiroOcorrencia = new FinanceiroOcorrencia();
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
  
  public void selecionar(FinanceiroOcorrencia pFinanceiroOcorrencia) {
    this.financeiroOcorrencia = pFinanceiroOcorrencia;
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
  
  public FinanceiroOcorrenciaService getFinanceiroOcorrenciaService() {
    return this.financeiroOcorrenciaService;
  }
  
  public void setFinanceiroOcorrenciaService(FinanceiroOcorrenciaService financeiroOcorrenciaService) {
    this.financeiroOcorrenciaService = financeiroOcorrenciaService;
  }
  
  public FinanceiroOcorrencia getFinanceiroOcorrencia() {
    return this.financeiroOcorrencia;
  }
  
  public void setFinanceiroOcorrencia(FinanceiroOcorrencia financeiroOcorrencia) {
    this.financeiroOcorrencia = financeiroOcorrencia;
  }
  
  public List<FinanceiroOcorrencia> getListaFinanceiroOcorrencia() {
    return this.listaFinanceiroOcorrencia;
  }
  
  public void setListaFinanceiroOcorrencia(List<FinanceiroOcorrencia> listaFinanceiroOcorrencia) {
    this.listaFinanceiroOcorrencia = listaFinanceiroOcorrencia;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\FinanceiroOcorrenciaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */