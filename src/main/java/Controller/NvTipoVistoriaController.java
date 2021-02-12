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
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;







@ManagedBean(name="nvTipoVistoriaController")
@ViewScoped
public class NvTipoVistoriaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  NvTipoVistoriaService nvTipoVistoriaService = new NvTipoVistoriaService();
  NvTipoVistoria nvTipoVistoria = new NvTipoVistoria();
  List<NvTipoVistoria> listaNvTipoVistoria = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  NvTpVistoriaTpCertificadoService nvTpVistoriaTpCertificadoService = new NvTpVistoriaTpCertificadoService();
  List<NvTpVistoriaTpCertificado> listaNvTpVistoriaTpCertificado = new ArrayList();
  NvTpVistoriaTpCertificado nvTpVistoriaTpCertificado = new NvTpVistoriaTpCertificado();
  
  NvTipoCertificadoService nvTipoCertificadoService = new NvTipoCertificadoService();
  List<NvTipoCertificado> listaNvTipoCertificado = new ArrayList();
  List<String> tipoCertificadoSelecionada = new ArrayList();
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOpTvistoria() == null) || (this.loginController.usuario.getAcOpTvistoria().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    

    this.listaNvTipoCertificado = this.nvTipoCertificadoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.ATIVO);
  }
  
  public void salvar(int pTela) {
    this.nvTipoVistoria.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.nvTipoVistoria = this.nvTipoVistoriaService.salvar(this.nvTipoVistoria);
    

    for (String s : this.tipoCertificadoSelecionada) {
      this.nvTpVistoriaTpCertificado.setSeqNvTipoCertificado(s);
      this.nvTpVistoriaTpCertificado.setSeqNvTipoVistoria(this.nvTipoVistoria.getSeqNvTipoVistoria());
      this.nvTpVistoriaTpCertificadoService.deletar(this.nvTpVistoriaTpCertificado);
    }
    

    for (String s : this.tipoCertificadoSelecionada) {
      this.nvTpVistoriaTpCertificado.setSeqNvTipoCertificado(s);
      this.nvTpVistoriaTpCertificado.setSeqNvTipoVistoria(this.nvTipoVistoria.getSeqNvTipoVistoria());
      
      this.nvTpVistoriaTpCertificadoService.salvar(this.nvTpVistoriaTpCertificado);
    }
    
    listar();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.nvTipoVistoria = new NvTipoVistoria();
    this.tipoCertificadoSelecionada = new ArrayList();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaNvTipoVistoria = this.nvTipoVistoriaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.nvTipoVistoriaService.deletar(this.nvTipoVistoria)) {
      listar();
      this.nvTipoVistoria = new NvTipoVistoria();
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
  
  public void selecionar(NvTipoVistoria pNvTipoVistoria) {
    this.nvTipoVistoria = pNvTipoVistoria;
    
    this.listaNvTpVistoriaTpCertificado = this.nvTpVistoriaTpCertificadoService.listarPorTipoVistoria(this.nvTipoVistoria.getSeqNvTipoVistoria());
    this.tipoCertificadoSelecionada = new ArrayList();
    for (NvTpVistoriaTpCertificado s : this.listaNvTpVistoriaTpCertificado) {
      this.tipoCertificadoSelecionada.add(String.valueOf(s.getSeqNvTipoCertificado()));
    }
    
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
  
  public NvTipoVistoriaService getNvTipoVistoriaService() {
    return this.nvTipoVistoriaService;
  }
  
  public void setNvTipoVistoriaService(NvTipoVistoriaService nvTipoVistoriaService) {
    this.nvTipoVistoriaService = nvTipoVistoriaService;
  }
  
  public NvTipoVistoria getNvTipoVistoria() {
    return this.nvTipoVistoria;
  }
  
  public void setNvTipoVistoria(NvTipoVistoria nvTipoVistoria) {
    this.nvTipoVistoria = nvTipoVistoria;
  }
  
  public List<NvTipoVistoria> getListaNvTipoVistoria() {
    return this.listaNvTipoVistoria;
  }
  
  public void setListaNvTipoVistoria(List<NvTipoVistoria> listaNvTipoVistoria) {
    this.listaNvTipoVistoria = listaNvTipoVistoria;
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
  
  public NvTipoCertificadoService getNvTipoCertificadoService() {
    return this.nvTipoCertificadoService;
  }
  
  public void setNvTipoCertificadoService(NvTipoCertificadoService nvTipoCertificadoService) {
    this.nvTipoCertificadoService = nvTipoCertificadoService;
  }
  
  public List<NvTipoCertificado> getListaNvTipoCertificado() {
    return this.listaNvTipoCertificado;
  }
  
  public void setListaNvTipoCertificado(List<NvTipoCertificado> listaNvTipoCertificado) {
    this.listaNvTipoCertificado = listaNvTipoCertificado;
  }
  
  public List<String> getTipoCertificadoSelecionada() {
    return this.tipoCertificadoSelecionada;
  }
  
  public void setTipoCertificadoSelecionada(List<String> tipoCertificadoSelecionada) {
    this.tipoCertificadoSelecionada = tipoCertificadoSelecionada;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\NvTipoVistoriaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */