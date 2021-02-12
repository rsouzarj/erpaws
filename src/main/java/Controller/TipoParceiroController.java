package Controller;

import Empresa.Empresa;
import TipoParceiro.TipoParceiro;
import TipoParceiro.TipoParceiroService;
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







@ManagedBean(name="tipoParceiroController")
@ViewScoped
public class TipoParceiroController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoParceiroService tipoParceiroService = new TipoParceiroService();
  TipoParceiro tipoParceiro = new TipoParceiro();
  List<TipoParceiro> listaTipoParceiro = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  

  public void iniciar()
  {
    if ((this.loginController.usuario.getAcCadTparceiro() == null) || (this.loginController.usuario.getAcCadTparceiro().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela) {
    this.tipoParceiro.setDataCadastro(new Date());
    this.tipoParceiro.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoParceiro = this.tipoParceiroService.salvar(this.tipoParceiro);
    
    int idx = 0;
    idx = this.listaTipoParceiro.indexOf(this.tipoParceiro);
    if (idx == -1) {
      this.listaTipoParceiro.add(this.tipoParceiro);
    } else if (this.listaTipoParceiro.size() > 0) {
      this.listaTipoParceiro.remove(this.tipoParceiro);
      this.listaTipoParceiro.add(idx, this.tipoParceiro);
    } else {
      this.listaTipoParceiro.add(idx, this.tipoParceiro);
    }
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tipoParceiro = new TipoParceiro();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoParceiro = this.tipoParceiroService.listar(this.loginController.getEmpresa().getSeqEmpresa(), Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.tipoParceiroService.deletar(this.tipoParceiro)) {
      listar();
      this.tipoParceiro = new TipoParceiro();
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
  
  public void selecionar(TipoParceiro pTipoParceiro) {
    this.tipoParceiro = pTipoParceiro;
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
  
  public TipoParceiroService getTipoParceiroService() {
    return this.tipoParceiroService;
  }
  
  public void setTipoParceiroService(TipoParceiroService tipoParceiroService) {
    this.tipoParceiroService = tipoParceiroService;
  }
  
  public TipoParceiro getTipoParceiro() {
    return this.tipoParceiro;
  }
  
  public void setTipoParceiro(TipoParceiro tipoParceiro) {
    this.tipoParceiro = tipoParceiro;
  }
  
  public List<TipoParceiro> getListaTipoParceiro() {
    return this.listaTipoParceiro;
  }
  
  public void setListaTipoParceiro(List<TipoParceiro> listaTipoParceiro) {
    this.listaTipoParceiro = listaTipoParceiro;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoParceiroController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */