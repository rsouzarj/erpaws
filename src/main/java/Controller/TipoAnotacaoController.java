package Controller;

import Empresa.Empresa;
import TipoAnotacao.TipoAnotacao;
import TipoAnotacao.TipoAnotacaoService;
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








@ManagedBean(name="tipoAnotacaoController")
@ViewScoped
public class TipoAnotacaoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoAnotacaoService tipoAnotacaoService = new TipoAnotacaoService();
  TipoAnotacao tipoAnotacao = new TipoAnotacao();
  List<TipoAnotacao> listaTipoAnotacao = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  public void salvar(int pTela) {
    this.tipoAnotacao.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoAnotacao.setDataCadastro(new Date());
    this.tipoAnotacao = this.tipoAnotacaoService.salvar(this.tipoAnotacao);
    
    int idx = 0;
    idx = this.listaTipoAnotacao.indexOf(this.tipoAnotacao);
    if (idx == -1) {
      this.listaTipoAnotacao.add(this.tipoAnotacao);
    } else if (this.listaTipoAnotacao.size() > 0) {
      this.listaTipoAnotacao.remove(this.tipoAnotacao);
      this.listaTipoAnotacao.add(idx, this.tipoAnotacao);
    } else {
      this.listaTipoAnotacao.add(idx, this.tipoAnotacao);
    }
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tipoAnotacao = new TipoAnotacao();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoAnotacao = this.tipoAnotacaoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.tipoAnotacaoService.deletar(this.tipoAnotacao)) {
      listar();
      this.tipoAnotacao = new TipoAnotacao();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
      this.tela = Integer.valueOf(0);
      listar();
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
    }
  }
  
  public void iniciar() {}
  
  public void fecharTela()
    throws IOException
  {
    this.loginController.mudarPagina("/principal/ principal.jsf");
  }
  
  public void selecionar(TipoAnotacao pTipoAnotacao) {
    this.tipoAnotacao = pTipoAnotacao;
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
  
  public TipoAnotacaoService getTipoAnotacaoService() {
    return this.tipoAnotacaoService;
  }
  
  public void setTipoAnotacaoService(TipoAnotacaoService tipoAnotacaoService) {
    this.tipoAnotacaoService = tipoAnotacaoService;
  }
  
  public TipoAnotacao getTipoAnotacao() {
    return this.tipoAnotacao;
  }
  
  public void setTipoAnotacao(TipoAnotacao tipoAnotacao) {
    this.tipoAnotacao = tipoAnotacao;
  }
  
  public List<TipoAnotacao> getListaTipoAnotacao() {
    return this.listaTipoAnotacao;
  }
  
  public void setListaTipoAnotacao(List<TipoAnotacao> listaTipoAnotacao) {
    this.listaTipoAnotacao = listaTipoAnotacao;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoAnotacaoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */