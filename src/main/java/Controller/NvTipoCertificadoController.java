package Controller;

import Empresa.Empresa;
import NvTipoCertificado.NvTipoCertificado;
import NvTipoCertificado.NvTipoCertificadoService;
import NvTipoVistoria.NvTipoVistoria;
import NvTipoVistoria.NvTipoVistoriaService;
import NvTpVistoriaTpCertificado.NvTpVistoriaTpCertificado;
import NvTpVistoriaTpCertificado.NvTpVistoriaTpCertificadoService;
import Usuario.Usuario;
import Util.Situacao;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;






@ManagedBean(name="nvTipoCertificadoController")
@ViewScoped
public class NvTipoCertificadoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  NvTipoCertificadoService nvTipoCertificadoService = new NvTipoCertificadoService();
  NvTipoCertificado nvTipoCertificado = new NvTipoCertificado();
  List<NvTipoCertificado> listaNvTipoCertificado = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  NvTpVistoriaTpCertificadoService nvTpVistoriaTpCertificadoService = new NvTpVistoriaTpCertificadoService();
  List<NvTpVistoriaTpCertificado> listaNvTpVistoriaTpCertificado = new ArrayList();
  NvTpVistoriaTpCertificado nvTpVistoriaTpCertificado = new NvTpVistoriaTpCertificado();
  
  NvTipoVistoriaService nvTipoVistoriaService = new NvTipoVistoriaService();
  List<NvTipoVistoria> listaNvTipoVistoria = new ArrayList();
  List<String> tipoVistoriaSelecionada = new ArrayList();
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOpTcertificado() == null) || (this.loginController.usuario.getAcOpTcertificado().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    
    this.listaNvTipoVistoria = this.nvTipoVistoriaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.ATIVO);
  }
  
  public void salvar(int pTela) {
    this.nvTipoCertificado.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.nvTipoCertificado = this.nvTipoCertificadoService.salvar(this.nvTipoCertificado);

    for (String s : this.tipoVistoriaSelecionada) {
      this.nvTpVistoriaTpCertificado.setSeqNvTipoCertificado(this.nvTipoCertificado.getSeqNvTipoCertificado());
      this.nvTpVistoriaTpCertificado.setSeqNvTipoVistoria(s);
      
      this.nvTpVistoriaTpCertificadoService.salvar(this.nvTpVistoriaTpCertificado);
    }
    
    listar();
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.nvTipoCertificado = new NvTipoCertificado();
    this.tipoVistoriaSelecionada = new ArrayList();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaNvTipoCertificado = this.nvTipoCertificadoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.nvTipoCertificadoService.deletar(this.nvTipoCertificado)) {
      listar();
      this.nvTipoCertificado = new NvTipoCertificado();
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
  
  public void selecionar(NvTipoCertificado pNvTipoCertificado) {
    this.tela = Integer.valueOf(1);
    System.out.println("entrou");
    System.out.println(this.tela);
    this.nvTipoCertificado = pNvTipoCertificado;
    
    this.listaNvTpVistoriaTpCertificado = this.nvTpVistoriaTpCertificadoService.listarPorTipoCertificado(this.nvTipoCertificado.getSeqNvTipoCertificado());
    this.tipoVistoriaSelecionada = new ArrayList();
    for (NvTpVistoriaTpCertificado s : this.listaNvTpVistoriaTpCertificado) {
      this.tipoVistoriaSelecionada.add(String.valueOf(s.getSeqNvTipoVistoria()));
    }
    System.out.println("saiu");
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
  
  public NvTipoCertificadoService getNvTipoCertificadoService() {
    return this.nvTipoCertificadoService;
  }
  
  public void setNvTipoCertificadoService(NvTipoCertificadoService nvTipoCertificadoService) {
    this.nvTipoCertificadoService = nvTipoCertificadoService;
  }
  
  public NvTipoCertificado getNvTipoCertificado() {
    return this.nvTipoCertificado;
  }
  
  public void setNvTipoCertificado(NvTipoCertificado nvTipoCertificado) {
    this.nvTipoCertificado = nvTipoCertificado;
  }
  
  public List<NvTipoCertificado> getListaNvTipoCertificado() {
    return this.listaNvTipoCertificado;
  }
  
  public void setListaNvTipoCertificado(List<NvTipoCertificado> listaNvTipoCertificado) {
    this.listaNvTipoCertificado = listaNvTipoCertificado;
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
  
  public NvTpVistoriaTpCertificadoService getNvTpVistoriaTpCertificadoService() {
    return this.nvTpVistoriaTpCertificadoService;
  }
  
  public void setNvTpVistoriaTpCertificadoService(NvTpVistoriaTpCertificadoService nvTpVistoriaTpCertificadoService) {
    this.nvTpVistoriaTpCertificadoService = nvTpVistoriaTpCertificadoService;
  }
  
  public List<NvTpVistoriaTpCertificado> getListaNvTpVistoriaTpCertificado() {
    return this.listaNvTpVistoriaTpCertificado;
  }
  
  public void setListaNvTpVistoriaTpCertificado(List<NvTpVistoriaTpCertificado> listaNvTpVistoriaTpCertificado) {
    this.listaNvTpVistoriaTpCertificado = listaNvTpVistoriaTpCertificado;
  }
  
  public NvTpVistoriaTpCertificado getNvTpVistoriaTpCertificado() {
    return this.nvTpVistoriaTpCertificado;
  }
  
  public void setNvTpVistoriaTpCertificado(NvTpVistoriaTpCertificado nvTpVistoriaTpCertificado) {
    this.nvTpVistoriaTpCertificado = nvTpVistoriaTpCertificado;
  }
  
  public List<String> getTipoVistoriaSelecionada() {
    return this.tipoVistoriaSelecionada;
  }
  
  public void setTipoVistoriaSelecionada(List<String> tipoVistoriaSelecionada) {
    this.tipoVistoriaSelecionada = tipoVistoriaSelecionada;
  }
  
  public NvTipoVistoriaService getNvTipoVistoriaService() {
    return this.nvTipoVistoriaService;
  }
  
  public void setNvTipoVistoriaService(NvTipoVistoriaService nvTipoVistoriaService) {
    this.nvTipoVistoriaService = nvTipoVistoriaService;
  }
  
  public List<NvTipoVistoria> getListaNvTipoVistoria() {
    return this.listaNvTipoVistoria;
  }
  
  public void setListaNvTipoVistoria(List<NvTipoVistoria> listaNvTipoVistoria) {
    this.listaNvTipoVistoria = listaNvTipoVistoria;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\NvTipoCertificadoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */