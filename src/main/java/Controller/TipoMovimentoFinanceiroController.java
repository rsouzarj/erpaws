package Controller;

import Empresa.Empresa;
import FinanceiroCategoria.FinanceiroCategoria;
import FinanceiroCategoria.FinanceiroCategoriaService;
import TipoMovimentoFinanceiro.TipoMovimentoFinanceiro;
import TipoMovimentoFinanceiro.TipoMovimentoFinanceiroService;
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








@ManagedBean(name="tipoMovimentoFinanceiroController")
@ViewScoped
public class TipoMovimentoFinanceiroController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoMovimentoFinanceiroService tipoMovimentoFinanceiroService = new TipoMovimentoFinanceiroService();
  TipoMovimentoFinanceiro tipoMovimentoFinanceiro = new TipoMovimentoFinanceiro();
  List<TipoMovimentoFinanceiro> listaTipoMovimentoFinanceiro = new ArrayList();
  
  FinanceiroCategoria financeiroCategoria = new FinanceiroCategoria();
  FinanceiroCategoriaService financeiroCategoriaService = new FinanceiroCategoriaService();
  List<FinanceiroCategoria> listaFinanceiroCategoria = new ArrayList();
  
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcFinTLancamento() == null) || (this.loginController.usuario.getAcFinTLancamento().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    
    this.listaTipoMovimentoFinanceiro = this.tipoMovimentoFinanceiroService.listar(this.loginController.getUsuario().getSeqEmpresa(), "", Situacao.ATIVO);
    this.listaFinanceiroCategoria = this.financeiroCategoriaService.listar(this.loginController.getUsuario().getSeqEmpresa(), "", Situacao.ATIVO);
  }
  
  public void salvar(int pTela) {
    this.tipoMovimentoFinanceiro.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoMovimentoFinanceiro.setDataCadastro(new Date());
    this.tipoMovimentoFinanceiro = this.tipoMovimentoFinanceiroService.salvar(this.tipoMovimentoFinanceiro);
    int idx = 0;
    idx = this.listaTipoMovimentoFinanceiro.indexOf(this.tipoMovimentoFinanceiro);
    if (idx == -1) {
      this.listaTipoMovimentoFinanceiro.add(this.tipoMovimentoFinanceiro);
    } else if (this.listaTipoMovimentoFinanceiro.size() > 0) {
      this.listaTipoMovimentoFinanceiro.remove(this.tipoMovimentoFinanceiro);
      this.listaTipoMovimentoFinanceiro.add(idx, this.tipoMovimentoFinanceiro);
    } else {
      this.listaTipoMovimentoFinanceiro.add(idx, this.tipoMovimentoFinanceiro);
    }
    this.listaTipoMovimentoFinanceiro = this.tipoMovimentoFinanceiroService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.tipoMovimentoFinanceiro = new TipoMovimentoFinanceiro();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoMovimentoFinanceiro = this.tipoMovimentoFinanceiroService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
    public void listaCategoria() {
    this.listaFinanceiroCategoria= this.financeiroCategoriaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
    
  
  public void deletar() {
    if (this.tipoMovimentoFinanceiroService.deletar(this.tipoMovimentoFinanceiro)) {
      listar();
      this.tipoMovimentoFinanceiro = new TipoMovimentoFinanceiro();
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
  
  public void selecionar(TipoMovimentoFinanceiro pTipoMovimentoFinanceiro) {
    this.tipoMovimentoFinanceiro = pTipoMovimentoFinanceiro;
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
  
  public TipoMovimentoFinanceiroService getTipoMovimentoFinanceiroService() {
    return this.tipoMovimentoFinanceiroService;
  }
  
  public void setTipoMovimentoFinanceiroService(TipoMovimentoFinanceiroService tipoMovimentoFinanceiroService) {
    this.tipoMovimentoFinanceiroService = tipoMovimentoFinanceiroService;
  }
  
  public TipoMovimentoFinanceiro getTipoMovimentoFinanceiro() {
    return this.tipoMovimentoFinanceiro;
  }
  
  public void setTipoMovimentoFinanceiro(TipoMovimentoFinanceiro tipoMovimentoFinanceiro) {
    this.tipoMovimentoFinanceiro = tipoMovimentoFinanceiro;
  }
  
  public List<TipoMovimentoFinanceiro> getListaTipoMovimentoFinanceiro() {
    return this.listaTipoMovimentoFinanceiro;
  }
  
  public void setListaTipoMovimentoFinanceiro(List<TipoMovimentoFinanceiro> listaTipoMovimentoFinanceiro) {
    this.listaTipoMovimentoFinanceiro = listaTipoMovimentoFinanceiro;
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
  
  public FinanceiroCategoriaService getFinanceiroCategoriaService() {
    return this.financeiroCategoriaService;
  }
  
  public void setFinanceiroCategoriaService(FinanceiroCategoriaService financeiroCategoriaService) {
    this.financeiroCategoriaService = financeiroCategoriaService;
  }
  
  public List<FinanceiroCategoria> getListaFinanceiroCategoria() {
    return this.listaFinanceiroCategoria;
  }
  
  public void setListaFinanceiroCategoria(List<FinanceiroCategoria> listaFinanceiroCategoria) {
    this.listaFinanceiroCategoria = listaFinanceiroCategoria;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoMovimentoFinanceiroController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */