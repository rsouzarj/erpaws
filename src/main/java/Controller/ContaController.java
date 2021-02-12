package Controller;

import Conta.Conta;
import Conta.ContaService;
import Empresa.Empresa;
import Usuario.Usuario;
import Util.Situacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;







@ManagedBean(name="contaController")
@ViewScoped
public class ContaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  ContaService contaService = new ContaService();
  Conta conta = new Conta();
  List<Conta> listaConta = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcFinContas() == null) || (this.loginController.usuario.getAcFinContas().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela) {
    this.conta.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.conta.setDataCadastro(new Date());
    this.conta = this.contaService.salvar(this.conta);
    int idx = 0;
    idx = this.listaConta.indexOf(this.conta);
    if (idx == -1) {
      this.listaConta.add(this.conta);
    } else if (this.listaConta.size() > 0) {
      this.listaConta.remove(this.conta);
      this.listaConta.add(idx, this.conta);
    } else {
      this.listaConta.add(idx, this.conta);
    }
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.conta = new Conta();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaConta = this.contaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.contaService.deletar(this.conta)) {
      listar();
      this.conta = new Conta();
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
  
  public void selecionar(Conta pConta) {
    this.conta = pConta;
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
  
  public ContaService getContaService() {
    return this.contaService;
  }
  
  public void setContaService(ContaService contaService) {
    this.contaService = contaService;
  }
  
  public Conta getConta() {
    return this.conta;
  }
  
  public void setConta(Conta conta) {
    this.conta = conta;
  }
  
  public List<Conta> getListaConta() {
    return this.listaConta;
  }
  
  public void setListaConta(List<Conta> listaConta) {
    this.listaConta = listaConta;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\ContaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */