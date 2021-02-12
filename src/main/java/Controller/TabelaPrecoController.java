package Controller;

import Empresa.Empresa;
import MaterialPreco.MaterialPreco;
import MaterialPreco.MaterialPrecoService;
import TabelaPreco.TabelaPreco;
import TabelaPreco.TabelaPrecoService;
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







@ManagedBean(name="tabelaPrecoController")
@ViewScoped
public class TabelaPrecoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TabelaPrecoService tabelaPrecoService = new TabelaPrecoService();
  TabelaPreco tabelaPreco = new TabelaPreco();
  List<TabelaPreco> listaTabelaPreco = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  MaterialPrecoService materialPrecoService = new MaterialPrecoService();
  MaterialPreco materialPreco = new MaterialPreco();
  List<MaterialPreco> listaMaterialPreco = new ArrayList();
  
  public void salvar(int pTela) {
    this.tabelaPreco.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tabelaPreco.setDataCadastro(new Date());
    this.tabelaPreco = this.tabelaPrecoService.salvar(this.tabelaPreco);
    
    this.materialPrecoService.salvar(this.listaMaterialPreco);
    
    int idx = 0;
    idx = this.listaTabelaPreco.indexOf(this.tabelaPreco);
    if (idx == -1) {
      this.listaTabelaPreco.add(this.tabelaPreco);
    } else if (this.listaTabelaPreco.size() > 0) {
      this.listaTabelaPreco.remove(this.tabelaPreco);
      this.listaTabelaPreco.add(idx, this.tabelaPreco);
    } else {
      this.listaTabelaPreco.add(idx, this.tabelaPreco);
    }
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tabelaPreco = new TabelaPreco();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTabelaPreco = this.tabelaPrecoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.tabelaPrecoService.deletar(this.tabelaPreco)) {
      listar();
      this.tabelaPreco = new TabelaPreco();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
      this.tela = Integer.valueOf(0);
      listar();
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
    }
  }
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcComTpreco() == null) || (this.loginController.usuario.getAcComTpreco().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void fecharTela() throws IOException
  {
    this.loginController.mudarPagina("/principal/ principal.jsf");
  }
  
  public void selecionar(TabelaPreco pTabelaPreco) {
    this.tabelaPreco = pTabelaPreco;
    this.listaMaterialPreco = this.materialPrecoService.listarPorTabela(pTabelaPreco, Situacao.TODOS);
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
  
  public TabelaPrecoService getTabelaPrecoService() {
    return this.tabelaPrecoService;
  }
  
  public void setTabelaPrecoService(TabelaPrecoService tabelaPrecoService) {
    this.tabelaPrecoService = tabelaPrecoService;
  }
  
  public TabelaPreco getTabelaPreco() {
    return this.tabelaPreco;
  }
  
  public void setTabelaPreco(TabelaPreco tabelaPreco) {
    this.tabelaPreco = tabelaPreco;
  }
  
  public List<TabelaPreco> getListaTabelaPreco() {
    return this.listaTabelaPreco;
  }
  
  public void setListaTabelaPreco(List<TabelaPreco> listaTabelaPreco) {
    this.listaTabelaPreco = listaTabelaPreco;
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
  
  public MaterialPreco getMaterialPreco() {
    return this.materialPreco;
  }
  
  public void setMaterialPreco(MaterialPreco materialPreco) {
    this.materialPreco = materialPreco;
  }
  
  public List<MaterialPreco> getListaMaterialPreco() {
    return this.listaMaterialPreco;
  }
  
  public void setListaMaterialPreco(List<MaterialPreco> listaMaterialPreco) {
    this.listaMaterialPreco = listaMaterialPreco;
  }
  
  public MaterialPrecoService getMaterialPrecoService() {
    return this.materialPrecoService;
  }
  
  public void setMaterialPrecoService(MaterialPrecoService materialPrecoService) {
    this.materialPrecoService = materialPrecoService;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TabelaPrecoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */