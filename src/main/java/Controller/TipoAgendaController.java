package Controller;

import Empresa.Empresa;
import TipoAgenda.TipoAgenda;
import TipoAgenda.TipoAgendaService;
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








@ManagedBean(name="tipoAgendaController")
@ViewScoped
public class TipoAgendaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoAgendaService tipoAgendaService = new TipoAgendaService();
  TipoAgenda tipoAgenda = new TipoAgenda();
  List<TipoAgenda> listaTipoAgenda = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  public void salvar(int pTela) {
    this.tipoAgenda.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoAgenda.setDataCadastro(new Date());
    this.tipoAgenda = this.tipoAgendaService.salvar(this.tipoAgenda);
    

    int idx = 0;
    idx = this.listaTipoAgenda.indexOf(this.tipoAgenda);
    if (idx == -1) {
      this.listaTipoAgenda.add(this.tipoAgenda);
    } else if (this.listaTipoAgenda.size() > 0) {
      this.listaTipoAgenda.remove(this.tipoAgenda);
      this.listaTipoAgenda.add(idx, this.tipoAgenda);
    } else {
      this.listaTipoAgenda.add(idx, this.tipoAgenda);
    }
    



    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tipoAgenda = new TipoAgenda();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoAgenda = this.tipoAgendaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.tipoAgendaService.deletar(this.tipoAgenda)) {
      listar();
      this.tipoAgenda = new TipoAgenda();
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
  
  public void selecionar(TipoAgenda pTipoAgenda) {
    this.tipoAgenda = pTipoAgenda;
    this.tela = Integer.valueOf(1);
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  
  public LoginController getLoginController() {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public TipoAgendaService getTipoAgendaService() {
    return this.tipoAgendaService;
  }
  
  public void setTipoAgendaService(TipoAgendaService tipoAgendaService) {
    this.tipoAgendaService = tipoAgendaService;
  }
  
  public TipoAgenda getTipoAgenda() {
    return this.tipoAgenda;
  }
  
  public void setTipoAgenda(TipoAgenda tipoAgenda) {
    this.tipoAgenda = tipoAgenda;
  }
  
  public List<TipoAgenda> getListaTipoAgenda() {
    return this.listaTipoAgenda;
  }
  
  public void setListaTipoAgenda(List<TipoAgenda> listaTipoAgenda) {
    this.listaTipoAgenda = listaTipoAgenda;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoAgendaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */