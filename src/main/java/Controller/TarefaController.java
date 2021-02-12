package Controller;

import Empresa.Empresa;
import Tarefa.Tarefa;
import Tarefa.TarefaService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;









@ManagedBean(name="tarefaController")
@ViewScoped
public class TarefaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TarefaService tarefaService = new TarefaService();
  Tarefa tarefa = new Tarefa();
  List<Tarefa> listaTarefa = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar() {}
  
  public void salvar(int pTela)
  {
    this.tarefa.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tarefa = this.tarefaService.salvar(this.tarefa);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tarefa = new Tarefa();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTarefa = this.tarefaService.listar(this.loginController.getEmpresa().getSeqEmpresa());
  }
  
  public void deletar() {
    if (this.tarefaService.deletar(this.tarefa)) {
      listar();
      this.tarefa = new Tarefa();
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
  
  public void selecionar(Tarefa pTarefa) {
    this.tarefa = pTarefa;
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
  
  public TarefaService getTarefaService() {
    return this.tarefaService;
  }
  
  public void setTarefaService(TarefaService tarefaService) {
    this.tarefaService = tarefaService;
  }
  
  public Tarefa getTarefa() {
    return this.tarefa;
  }
  
  public void setTarefa(Tarefa tarefa) {
    this.tarefa = tarefa;
  }
  
  public List<Tarefa> getListaTarefa() {
    return this.listaTarefa;
  }
  
  public void setListaTarefa(List<Tarefa> listaTarefa) {
    this.listaTarefa = listaTarefa;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TarefaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */