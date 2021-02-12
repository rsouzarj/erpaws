package Controller;

import Empresa.Empresa;
import Tarefa.Tarefa;
import Tarefa.TarefaService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
















@ManagedBean(name="painelTarefaController")
@ViewScoped
public class PainelTarefaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TarefaService tarefaService = new TarefaService();
  List<Tarefa> listaTarefa = new ArrayList();
  
  public void iniciar()
  {
    this.listaTarefa = this.tarefaService.listar(this.loginController.getEmpresa().getSeqEmpresa());
  }
  



  public void filtrar() {}
  


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
  
  public List<Tarefa> getListaTarefa() {
    return this.listaTarefa;
  }
  
  public void setListaTarefa(List<Tarefa> listaTarefa) {
    this.listaTarefa = listaTarefa;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\PainelTarefaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */