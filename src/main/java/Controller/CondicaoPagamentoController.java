package Controller;

import CondicaoPagamento.CondicaoPagamento;
import CondicaoPagamento.CondicaoPagamentoService;
import CondicaoPagamentoItem.CondicaoPagamentoItem;
import CondicaoPagamentoItem.CondicaoPagamentoItemService;
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







@ManagedBean(name="condicaoPagamentoController")
@ViewScoped
public class CondicaoPagamentoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  CondicaoPagamentoService condicaoPagamentoService = new CondicaoPagamentoService();
  CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
  List<CondicaoPagamento> listaCondicaoPagamento = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  List<CondicaoPagamentoItem> listaCondicaoPagamentoItem = new ArrayList();
  CondicaoPagamentoItem condicaoPagamentoItem = new CondicaoPagamentoItem();
  CondicaoPagamentoItemService condicaoPagamentoItemService = new CondicaoPagamentoItemService();
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcFinCpagamento() == null) || (this.loginController.usuario.getAcFinCpagamento().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela) {
    this.condicaoPagamento.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.condicaoPagamento.setDataCadastro(new Date());
    this.condicaoPagamento = this.condicaoPagamentoService.salvar(this.condicaoPagamento);
    int idx = 0;
    idx = this.listaCondicaoPagamento.indexOf(this.condicaoPagamento);
    if (idx == -1) {
      this.listaCondicaoPagamento.add(this.condicaoPagamento);
    } else if (this.listaCondicaoPagamento.size() > 0) {
      this.listaCondicaoPagamento.remove(this.condicaoPagamento);
      this.listaCondicaoPagamento.add(idx, this.condicaoPagamento);
    } else {
      this.listaCondicaoPagamento.add(idx, this.condicaoPagamento);
    }
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.condicaoPagamento = new CondicaoPagamento();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaCondicaoPagamento = this.condicaoPagamentoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.condicaoPagamentoService.deletar(this.condicaoPagamento)) {
      listar();
      this.condicaoPagamento = new CondicaoPagamento();
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
  
  public void selecionar(CondicaoPagamento pCondicaoPagamento) {
    this.condicaoPagamento = pCondicaoPagamento;
    this.tela = Integer.valueOf(1);
    listarItem();
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  

  public void novoItem()
  {
    this.condicaoPagamentoItem = new CondicaoPagamentoItem();
  }
  
  public void listarItem() {
    this.listaCondicaoPagamentoItem = this.condicaoPagamentoItemService.listarPorCondicaoDePagamento(this.condicaoPagamento.getSeqCondicaoPagamento());
  }
  
  public void selecionarItem(CondicaoPagamentoItem pCondicaoPagamentoItem) {
    this.condicaoPagamentoItem = pCondicaoPagamentoItem;
  }
  
  public void salvarItem() {
    this.condicaoPagamentoItem.setSeqCondicaoPagamento(this.condicaoPagamento.getSeqCondicaoPagamento());
    this.condicaoPagamentoItem.setSituacao("ATIVO");
    this.condicaoPagamentoItemService.salvar(this.condicaoPagamentoItem);
    novoItem();
    listarItem();
  }
  
  public void removerItem(CondicaoPagamentoItem pCondicaoPagamentoItem) {
    this.condicaoPagamentoItemService.deletar(pCondicaoPagamentoItem);
    listar();
  }
  


  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public CondicaoPagamentoService getCondicaoPagamentoService() {
    return this.condicaoPagamentoService;
  }
  
  public void setCondicaoPagamentoService(CondicaoPagamentoService condicaoPagamentoService) {
    this.condicaoPagamentoService = condicaoPagamentoService;
  }
  
  public CondicaoPagamento getCondicaoPagamento() {
    return this.condicaoPagamento;
  }
  
  public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
    this.condicaoPagamento = condicaoPagamento;
  }
  
  public List<CondicaoPagamento> getListaCondicaoPagamento() {
    return this.listaCondicaoPagamento;
  }
  
  public void setListaCondicaoPagamento(List<CondicaoPagamento> listaCondicaoPagamento) {
    this.listaCondicaoPagamento = listaCondicaoPagamento;
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
  
  public List<CondicaoPagamentoItem> getListaCondicaoPagamentoItem() {
    return this.listaCondicaoPagamentoItem;
  }
  
  public void setListaCondicaoPagamentoItem(List<CondicaoPagamentoItem> listaCondicaoPagamentoItem) {
    this.listaCondicaoPagamentoItem = listaCondicaoPagamentoItem;
  }
  
  public CondicaoPagamentoItem getCondicaoPagamentoItem() {
    return this.condicaoPagamentoItem;
  }
  
  public void setCondicaoPagamentoItem(CondicaoPagamentoItem condicaoPagamentoItem) {
    this.condicaoPagamentoItem = condicaoPagamentoItem;
  }
  
  public CondicaoPagamentoItemService getCondicaoPagamentoItemService() {
    return this.condicaoPagamentoItemService;
  }
  
  public void setCondicaoPagamentoItemService(CondicaoPagamentoItemService condicaoPagamentoItemService) {
    this.condicaoPagamentoItemService = condicaoPagamentoItemService;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\CondicaoPagamentoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */