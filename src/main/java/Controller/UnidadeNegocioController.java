package Controller;

import Empresa.Empresa;
import Uf.Uf;
import Uf.UfService;
import UnidadeNegocio.UnidadeNegocio;
import UnidadeNegocio.UnidadeNegocioService;
import Usuario.Usuario;
import Util.Cep;
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







@ManagedBean(name="unidadeNegocioController")
@ViewScoped
public class UnidadeNegocioController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  UnidadeNegocioService unidadeNegocioService = new UnidadeNegocioService();
  UnidadeNegocio unidadeNegocio = new UnidadeNegocio();
  List<UnidadeNegocio> listaUnidadeNegocio = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  List<Uf> listaUf = new ArrayList();
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOrgUnegocio() == null) || (this.loginController.usuario.getAcOrgUnegocio().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    
    UfService ufService = new UfService();
    this.listaUf = ufService.listar();
  }
  
  public void salvar(int pTela) {
    this.unidadeNegocio.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.unidadeNegocio.setDataCadastro(new Date());
    this.unidadeNegocio = this.unidadeNegocioService.salvar(this.unidadeNegocio);
    int idx = 0;
    idx = this.listaUnidadeNegocio.indexOf(this.unidadeNegocio);
    if (idx == -1) {
      this.listaUnidadeNegocio.add(this.unidadeNegocio);
    } else if (this.listaUnidadeNegocio.size() > 0) {
      this.listaUnidadeNegocio.remove(this.unidadeNegocio);
      this.listaUnidadeNegocio.add(idx, this.unidadeNegocio);
    } else {
      this.listaUnidadeNegocio.add(idx, this.unidadeNegocio);
    }
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.unidadeNegocio = new UnidadeNegocio();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaUnidadeNegocio = this.unidadeNegocioService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.unidadeNegocioService.deletar(this.unidadeNegocio)) {
      listar();
      this.unidadeNegocio = new UnidadeNegocio();
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
  
  public void selecionar(UnidadeNegocio pUnidadeNegocio) {
    this.unidadeNegocio = pUnidadeNegocio;
    this.tela = Integer.valueOf(1);
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  
  public void buscarCep() {
    Cep cep = Cep.buscarCep(this.unidadeNegocio.getCep().replace("-", ""));
    this.unidadeNegocio.setLogradouro(cep.getLogradouroFull());
    this.unidadeNegocio.setBairro(cep.getBairro());
    this.unidadeNegocio.setCidade(cep.getCidade());
    this.unidadeNegocio.setUf(cep.getUf());
  }
  
  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public UnidadeNegocioService getUnidadeNegocioService() {
    return this.unidadeNegocioService;
  }
  
  public void setUnidadeNegocioService(UnidadeNegocioService unidadeNegocioService) {
    this.unidadeNegocioService = unidadeNegocioService;
  }
  
  public UnidadeNegocio getUnidadeNegocio() {
    return this.unidadeNegocio;
  }
  
  public void setUnidadeNegocio(UnidadeNegocio unidadeNegocio) {
    this.unidadeNegocio = unidadeNegocio;
  }
  
  public List<UnidadeNegocio> getListaUnidadeNegocio() {
    return this.listaUnidadeNegocio;
  }
  
  public void setListaUnidadeNegocio(List<UnidadeNegocio> listaUnidadeNegocio) {
    this.listaUnidadeNegocio = listaUnidadeNegocio;
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
  
  public List<Uf> getListaUf() {
    return this.listaUf;
  }
  
  public void setListaUf(List<Uf> listaUf) {
    this.listaUf = listaUf;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\UnidadeNegocioController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */