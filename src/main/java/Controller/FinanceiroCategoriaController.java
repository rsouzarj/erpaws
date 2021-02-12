package Controller;

import Empresa.Empresa;
import FinanceiroCategoria.FinanceiroCategoria;
import FinanceiroCategoria.FinanceiroCategoriaService;
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









@ManagedBean(name="financeiroCategoriaController")
@ViewScoped
public class FinanceiroCategoriaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  FinanceiroCategoriaService financeiroCategoriaService = new FinanceiroCategoriaService();
  FinanceiroCategoria financeiroCategoria = new FinanceiroCategoria();
  List<FinanceiroCategoria> listaFinanceiroCategoria = new ArrayList();
  


  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar() {
    if ((this.loginController.usuario.getAcFinCategoria() == null) || (this.loginController.usuario.getAcFinCategoria().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    this.listaFinanceiroCategoria = this.financeiroCategoriaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void salvar(int pTela) {
    this.financeiroCategoria.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.financeiroCategoria = this.financeiroCategoriaService.salvar(this.financeiroCategoria);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.financeiroCategoria = new FinanceiroCategoria();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaFinanceiroCategoria = this.financeiroCategoriaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.financeiroCategoriaService.deletar(this.financeiroCategoria)) {
      listar();
      this.financeiroCategoria = new FinanceiroCategoria();
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
  
  public void selecionar(FinanceiroCategoria pFinanceiroCategoria) {
    this.financeiroCategoria = pFinanceiroCategoria;
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
  
  public FinanceiroCategoriaService getFinanceiroCategoriaService() {
    return this.financeiroCategoriaService;
  }
  
  public void setFinanceiroCategoriaService(FinanceiroCategoriaService financeiroCategoriaService) {
    this.financeiroCategoriaService = financeiroCategoriaService;
  }
  
  public FinanceiroCategoria getFinanceiroCategoria() {
    return this.financeiroCategoria;
  }
  
  public void setFinanceiroCategoria(FinanceiroCategoria financeiroCategoria) {
    this.financeiroCategoria = financeiroCategoria;
  }
  
  public List<FinanceiroCategoria> getListaFinanceiroCategoria() {
    return this.listaFinanceiroCategoria;
  }
  
  public void setListaFinanceiroCategoria(List<FinanceiroCategoria> listaFinanceiroCategoria) {
    this.listaFinanceiroCategoria = listaFinanceiroCategoria;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\FinanceiroCategoriaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */