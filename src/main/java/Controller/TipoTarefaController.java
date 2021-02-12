package Controller;

import Departamento.Departamento;
import Departamento.DepartamentoService;
import Empresa.Empresa;
import TipoTarefa.TipoTarefa;
import TipoTarefa.TipoTarefaService;
import Usuario.Usuario;
import Usuario.UsuarioService;
import Util.Situacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;








@ManagedBean(name="tipoTarefaController")
@ViewScoped
public class TipoTarefaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoTarefaService tipoTarefaService = new TipoTarefaService();
  TipoTarefa tipoTarefa = new TipoTarefa();
  List<TipoTarefa> listaTipoTarefa = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  UsuarioService usuarioService = new UsuarioService();
  List<Usuario> listaUsuario = new ArrayList();
  DepartamentoService departamentoService = new DepartamentoService();
  List<Departamento> listaDepartamento = new ArrayList();
  
  public void iniciar() {
    this.listaUsuario = this.usuarioService.listarTodosOsUsuarios(this.loginController.getEmpresa().getSeqEmpresa(), Situacao.ATIVO);
    this.listaDepartamento = this.departamentoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.ATIVO);
  }
  
  public void salvar(int pTela) {
    this.tipoTarefa.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoTarefa = this.tipoTarefaService.salvar(this.tipoTarefa);
    listar();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tipoTarefa = new TipoTarefa();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoTarefa = this.tipoTarefaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    this.tipoTarefaService.deletar(this.tipoTarefa);
    listar();
    this.tela = Integer.valueOf(0);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso!.", ""));
  }
  
  public void fecharTela() throws IOException {
    this.loginController.mudarPagina("/principal/ principal.jsf");
  }
  
  public void selecionar(TipoTarefa pTipoTarefa) {
    this.tipoTarefa = pTipoTarefa;
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
  
  public TipoTarefaService getTipoTarefaService() {
    return this.tipoTarefaService;
  }
  
  public void setTipoTarefaService(TipoTarefaService tipoTarefaService) {
    this.tipoTarefaService = tipoTarefaService;
  }
  
  public TipoTarefa getTipoTarefa() {
    return this.tipoTarefa;
  }
  
  public void setTipoTarefa(TipoTarefa tipoTarefa) {
    this.tipoTarefa = tipoTarefa;
  }
  
  public List<TipoTarefa> getListaTipoTarefa() {
    return this.listaTipoTarefa;
  }
  
  public void setListaTipoTarefa(List<TipoTarefa> listaTipoTarefa) {
    this.listaTipoTarefa = listaTipoTarefa;
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
  
  public UsuarioService getUsuarioService() {
    return this.usuarioService;
  }
  
  public void setUsuarioService(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }
  
  public List<Usuario> getListaUsuario() {
    return this.listaUsuario;
  }
  
  public void setListaUsuario(List<Usuario> listaUsuario) {
    this.listaUsuario = listaUsuario;
  }
  
  public DepartamentoService getDepartamentoService() {
    return this.departamentoService;
  }
  
  public void setDepartamentoService(DepartamentoService departamentoService) {
    this.departamentoService = departamentoService;
  }
  
  public List<Departamento> getListaDepartamento() {
    return this.listaDepartamento;
  }
  
  public void setListaDepartamento(List<Departamento> listaDepartamento) {
    this.listaDepartamento = listaDepartamento;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoTarefaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */