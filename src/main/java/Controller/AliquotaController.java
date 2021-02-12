package Controller;

import Aliquota.Aliquota;
import Aliquota.AliquotaService;
import ClausulaSQL.ClausulaWhere;
import Empresa.Empresa;
import Usuario.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;











@ManagedBean(name="aliquotaController")
@ViewScoped
public class AliquotaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  AliquotaService aliquotaService = new AliquotaService();
  Aliquota aliquota = new Aliquota();
  List<Aliquota> listaAliquota = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcFinAliquotaRetencaoFederal() == null) || (this.loginController.usuario.getAcFinAliquotaRetencaoFederal().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela) {
    this.aliquota.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.aliquota = this.aliquotaService.salvar(this.aliquota);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.aliquota = new Aliquota();
    this.tela = Integer.valueOf(1);
  }
  
  public void listarFederais() {
    ClausulaWhere condicao = new ClausulaWhere();
    
    condicao.AdicionarCondicaoManual("where seq_empresa = " + this.loginController.getEmpresa().getSeqEmpresa().toUpperCase() + " and (upper(nome) like('%" + this.pesquisa.toUpperCase() + "%') or upper(tipo_aliquota) like('%" + this.pesquisa.toUpperCase() + "%')) and tipo_aliquota <> 'ISSQN RETIDO'");
    
    this.listaAliquota = this.aliquotaService.listarFiltro(condicao);
  }
  
  public void deletarFederais() {
    if (this.aliquotaService.deletar(this.aliquota)) {
      listarFederais();
      this.aliquota = new Aliquota();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
      this.tela = Integer.valueOf(0);
      listarFederais();
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
    }
  }
  
  public void fecharTela() throws IOException {
    this.loginController.mudarPagina("/principal/ principal.jsf");
  }
  
  public void selecionar(Aliquota pAliquotaRetencaoFederal) {
    this.aliquota = pAliquotaRetencaoFederal;
    this.tela = Integer.valueOf(1);
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  
  public void listarISSQN()
  {
    ClausulaWhere condicao = new ClausulaWhere();
    
    condicao.AdicionarCondicaoManual("where seq_empresa = " + this.loginController.getEmpresa().getSeqEmpresa().toUpperCase() + " and (upper(nome) like('%" + this.pesquisa.toUpperCase() + "%') or upper(tipo_aliquota) like('%" + this.pesquisa.toUpperCase() + "%')) and tipo_aliquota = 'ISSQN RETIDO'");
    
    this.listaAliquota = this.aliquotaService.listarFiltro(condicao);
  }
  
  public void deletarISSQN() {
    if (this.aliquotaService.deletar(this.aliquota)) {
      listarISSQN();
      this.aliquota = new Aliquota();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
      this.tela = Integer.valueOf(0);
      listarISSQN();
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
    }
  }
  
  public void novoISSQN() {
    this.aliquota = new Aliquota();
    this.aliquota.setTipoAliquota("ISSQN RETIDO");
    this.tela = Integer.valueOf(1);
  }
  
  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public AliquotaService getAliquotaService() {
    return this.aliquotaService;
  }
  
  public void setAliquotaService(AliquotaService aliquotaService) {
    this.aliquotaService = aliquotaService;
  }
  
  public Aliquota getAliquota() {
    return this.aliquota;
  }
  
  public void setAliquota(Aliquota aliquota) {
    this.aliquota = aliquota;
  }
  
  public List<Aliquota> getListaAliquota() {
    return this.listaAliquota;
  }
  
  public void setListaAliquota(List<Aliquota> listaAliquota) {
    this.listaAliquota = listaAliquota;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\AliquotaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */