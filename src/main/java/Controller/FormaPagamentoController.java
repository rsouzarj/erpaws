package Controller;

import Empresa.Empresa;
import FormaPagamento.FormaPagamento;
import FormaPagamento.FormaPagamentoService;
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







@ManagedBean(name="formaPagamentoController")
@ViewScoped
public class FormaPagamentoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  FormaPagamentoService formaPagamentoService = new FormaPagamentoService();
  FormaPagamento formaPagamento = new FormaPagamento();
  List<FormaPagamento> listaFormaPagamento = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcFinFpagamento() == null) || (this.loginController.usuario.getAcFinFpagamento().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela)
  {
    this.formaPagamento.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.formaPagamento.setDataCadastro(new Date());
    this.formaPagamento = this.formaPagamentoService.salvar(this.formaPagamento);
    int idx = 0;
    idx = this.listaFormaPagamento.indexOf(this.formaPagamento);
    if (idx == -1) {
      this.listaFormaPagamento.add(this.formaPagamento);
    } else if (this.listaFormaPagamento.size() > 0) {
      this.listaFormaPagamento.remove(this.formaPagamento);
      this.listaFormaPagamento.add(idx, this.formaPagamento);
    } else {
      this.listaFormaPagamento.add(idx, this.formaPagamento);
    }
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.formaPagamento = new FormaPagamento();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaFormaPagamento = this.formaPagamentoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.formaPagamentoService.deletar(this.formaPagamento)) {
      listar();
      this.formaPagamento = new FormaPagamento();
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
  
  public void selecionar(FormaPagamento pFormaPagamento) {
    this.formaPagamento = pFormaPagamento;
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
  
  public FormaPagamentoService getFormaPagamentoService() {
    return this.formaPagamentoService;
  }
  
  public void setFormaPagamentoService(FormaPagamentoService formaPagamentoService) {
    this.formaPagamentoService = formaPagamentoService;
  }
  
  public FormaPagamento getFormaPagamento() {
    return this.formaPagamento;
  }
  
  public void setFormaPagamento(FormaPagamento formaPagamento) {
    this.formaPagamento = formaPagamento;
  }
  
  public List<FormaPagamento> getListaFormaPagamento() {
    return this.listaFormaPagamento;
  }
  
  public void setListaFormaPagamento(List<FormaPagamento> listaFormaPagamento) {
    this.listaFormaPagamento = listaFormaPagamento;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\FormaPagamentoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */