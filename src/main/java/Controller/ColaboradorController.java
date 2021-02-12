package Controller;

import Colaborador.Colaborador;
import Colaborador.ColaboradorService;
import Empresa.Empresa;
import TipoColaborador.TipoColaborador;
import TipoColaborador.TipoColaboradorService;
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







@ManagedBean(name="colaboradorController")
@ViewScoped
public class ColaboradorController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  ColaboradorService colaboradorService = new ColaboradorService();
  Colaborador colaborador = new Colaborador();
  List<Colaborador> listaColaborador = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  List<TipoColaborador> listaTipoColaborador = new ArrayList();
  TipoColaboradorService tipoColaboradorService = new TipoColaboradorService();
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOrgColaborador() == null) || (this.loginController.usuario.getAcOrgColaborador().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    this.listaTipoColaborador = this.tipoColaboradorService.listar(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.ATIVO);
  }
  
  public void salvar(int pTela) {
    this.colaborador.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.colaborador = this.colaboradorService.salvar(this.colaborador);
    listar();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.colaborador = new Colaborador();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaColaborador = this.colaboradorService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.colaboradorService.deletar(this.colaborador)) {
      listar();
      this.colaborador = new Colaborador();
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
  
  public void selecionar(Colaborador pColaborador) {
    this.colaborador = pColaborador;
    this.tela = Integer.valueOf(1);
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  
  public void nomeAssinatura() {
    int count = this.listaTipoColaborador.size();
    for (int i = 0; i < count; i++) {
      if (((TipoColaborador)this.listaTipoColaborador.get(i)).getSeqTipoColaborador().equals(this.colaborador.getSeqTipoColaborador())) {
        this.colaborador.setNomeAssinatura(((TipoColaborador)this.listaTipoColaborador.get(i)).getNome());
      }
    }
  }
  
  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public ColaboradorService getColaboradorService() {
    return this.colaboradorService;
  }
  
  public void setColaboradorService(ColaboradorService colaboradorService) {
    this.colaboradorService = colaboradorService;
  }
  
  public Colaborador getColaborador() {
    return this.colaborador;
  }
  
  public void setColaborador(Colaborador colaborador) {
    this.colaborador = colaborador;
  }
  
  public List<Colaborador> getListaColaborador() {
    return this.listaColaborador;
  }
  
  public void setListaColaborador(List<Colaborador> listaColaborador) {
    this.listaColaborador = listaColaborador;
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
  
  public List<TipoColaborador> getListaTipoColaborador() {
    return this.listaTipoColaborador;
  }
  
  public void setListaTipoColaborador(List<TipoColaborador> listaTipoColaborador) {
    this.listaTipoColaborador = listaTipoColaborador;
  }
  
  public TipoColaboradorService getTipoColaboradorService() {
    return this.tipoColaboradorService;
  }
  
  public void setTipoColaboradorService(TipoColaboradorService tipoColaboradorService) {
    this.tipoColaboradorService = tipoColaboradorService;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\ColaboradorController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */