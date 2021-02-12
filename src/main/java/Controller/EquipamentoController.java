package Controller;

import Empresa.Empresa;
import Equipamento.Equipamento;
import Equipamento.EquipamentoService;
import EquipamentoParceiro.EquipamentoParceiro;
import EquipamentoParceiro.EquipamentoParceiroService;
import Parceiro.Parceiro;
import Parceiro.ParceiroService;
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








@ManagedBean(name="equipamentoController")
@ViewScoped
public class EquipamentoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  EquipamentoService equipamentoService = new EquipamentoService();
  Equipamento equipamento = new Equipamento();
  List<Equipamento> listaEquipamento = new ArrayList();
  
  EquipamentoParceiroService equipamentoParceiroService = new EquipamentoParceiroService();
  EquipamentoParceiro equipamentoParceiro = new EquipamentoParceiro();
  List<EquipamentoParceiro> listaEquipamentoParceiro = new ArrayList();
  
  List<Parceiro> listaParceiro = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOpEquipamento() == null) || (this.loginController.usuario.getAcOpEquipamento().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    
    ParceiroService parceiroService = new ParceiroService();
    this.listaParceiro = parceiroService.listarParceiro(this.loginController.getUsuario().getSeqUsuario(), "");
  }
  
  public void salvar(int pTela) {
    this.equipamento.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.equipamento.setSituacao("ATIVO");
    this.equipamento = this.equipamentoService.salvar(this.equipamento);
    listar();
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.equipamento = new Equipamento();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaEquipamento = this.equipamentoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.equipamentoService.deletar(this.equipamento)) {
      listar();
      this.equipamento = new Equipamento();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
      this.tela = Integer.valueOf(0);
      listar();
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
    }
  }
  
  public void adicionarVinculo() {
    if (this.equipamento.getSeqEquipamento() == null) {
      salvar(1);
    }
    this.equipamentoParceiro.setSeqEquipamento(this.equipamento.getSeqEquipamento());
    this.equipamentoParceiroService.salvar(this.equipamentoParceiro);
    this.listaEquipamentoParceiro = this.equipamentoParceiroService.listarParceiro(this.equipamento.getSeqEquipamento());
    this.equipamentoParceiro = new EquipamentoParceiro();
  }
  
  public void removerVinculo(EquipamentoParceiro pEquipamentoParceiro) {
    this.equipamentoParceiroService.deletar(pEquipamentoParceiro);
    this.listaEquipamentoParceiro = this.equipamentoParceiroService.listarParceiro(this.equipamento.getSeqEquipamento());
  }
  
  public void fecharTela() throws IOException {
    this.loginController.mudarPagina("/principal/ principal.jsf");
  }
  
  public void selecionar(Equipamento pEquipamento) {
    this.equipamento = pEquipamento;
    this.listaEquipamentoParceiro = this.equipamentoParceiroService.listarParceiro(this.equipamento.getSeqEquipamento());
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
  
  public EquipamentoService getEquipamentoService() {
    return this.equipamentoService;
  }
  
  public void setEquipamentoService(EquipamentoService equipamentoService) {
    this.equipamentoService = equipamentoService;
  }
  
  public Equipamento getEquipamento() {
    return this.equipamento;
  }
  
  public void setEquipamento(Equipamento equipamento) {
    this.equipamento = equipamento;
  }
  
  public List<Equipamento> getListaEquipamento() {
    return this.listaEquipamento;
  }
  
  public void setListaEquipamento(List<Equipamento> listaEquipamento) {
    this.listaEquipamento = listaEquipamento;
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
  
  public List<Parceiro> getListaParceiro() {
    return this.listaParceiro;
  }
  
  public void setListaParceiro(List<Parceiro> listaParceiro) {
    this.listaParceiro = listaParceiro;
  }
  
  public EquipamentoParceiroService getEquipamentoParceiroService() {
    return this.equipamentoParceiroService;
  }
  
  public void setEquipamentoParceiroService(EquipamentoParceiroService equipamentoParceiroService) {
    this.equipamentoParceiroService = equipamentoParceiroService;
  }
  
  public EquipamentoParceiro getEquipamentoParceiro() {
    return this.equipamentoParceiro;
  }
  
  public void setEquipamentoParceiro(EquipamentoParceiro equipamentoParceiro) {
    this.equipamentoParceiro = equipamentoParceiro;
  }
  
  public List<EquipamentoParceiro> getListaEquipamentoParceiro() {
    return this.listaEquipamentoParceiro;
  }
  
  public void setListaEquipamentoParceiro(List<EquipamentoParceiro> listaEquipamentoParceiro) {
    this.listaEquipamentoParceiro = listaEquipamentoParceiro;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\EquipamentoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */