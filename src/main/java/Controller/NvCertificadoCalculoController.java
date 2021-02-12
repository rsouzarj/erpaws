package Controller;

import Empresa.Empresa;
import NvCertificadoCalculo.NvCertificadoCalculo;
import NvCertificadoCalculo.NvCertificadoCalculoService;
import NvCertificadoCalculoD.NvCertificadoCalculoD;
import NvCertificadoCalculoD.NvCertificadoCalculoDService;
import NvTipoCertificado.NvTipoCertificado;
import NvTipoCertificado.NvTipoCertificadoService;
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







@ManagedBean(name="nvCertificadoCalculoController")
@ViewScoped
public class NvCertificadoCalculoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  NvCertificadoCalculoService nvCertificadoCalculoService = new NvCertificadoCalculoService();
  NvCertificadoCalculo nvCertificadoCalculo = new NvCertificadoCalculo();
  List<NvCertificadoCalculo> listaNvCertificadoCalculo = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  NvCertificadoCalculoDService nvCertificadoCalculoDService = new NvCertificadoCalculoDService();
  NvCertificadoCalculoD nvCertificadoCalculoD = new NvCertificadoCalculoD();
  List<NvCertificadoCalculoD> listaNvCertificadoCalculoD = new ArrayList();
  
  NvTipoCertificadoService nvTipoCertificadoService = new NvTipoCertificadoService();
  List<NvTipoCertificado> listaNvTipoCertificado = new ArrayList();
  
  public void iniciar() {
    if ((this.loginController.usuario.getAcOpCalculoData() == null) || (this.loginController.usuario.getAcOpCalculoData().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    this.listaNvTipoCertificado = this.nvTipoCertificadoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.ATIVO);
  }
  
  public void salvar(int pTela)
  {
    this.nvCertificadoCalculo.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.nvCertificadoCalculo.setDataCadastro(new Date());
    this.nvCertificadoCalculo = this.nvCertificadoCalculoService.salvar(this.nvCertificadoCalculo);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.nvCertificadoCalculo = new NvCertificadoCalculo();
    this.listaNvCertificadoCalculoD = new ArrayList();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaNvCertificadoCalculo = this.nvCertificadoCalculoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.nvCertificadoCalculoService.deletar(this.nvCertificadoCalculo)) {
      listar();
      this.nvCertificadoCalculo = new NvCertificadoCalculo();
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
  
  public void selecionar(NvCertificadoCalculo pNvCertificadoCalculo) {
    this.nvCertificadoCalculo = pNvCertificadoCalculo;
    this.listaNvCertificadoCalculoD = new ArrayList();
    
    listarDetalhe();
    
    this.tela = Integer.valueOf(1);
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  

  public void listarDetalhe()
  {
    this.listaNvCertificadoCalculoD = this.nvCertificadoCalculoDService.listar(this.nvCertificadoCalculo.getSeqNvCertificadoCalculo());
  }
  
  public void selecionarDetalhe(NvCertificadoCalculoD pNvCertificadoCalculoD) {
    this.nvCertificadoCalculoD = pNvCertificadoCalculoD;
  }
  
  public void novoDetalhe() {
    this.nvCertificadoCalculoD = new NvCertificadoCalculoD();
  }
  
  public void salvarDetalhe() {
    this.nvCertificadoCalculoD.setSeqNvCertificadoCalculo(this.nvCertificadoCalculo.getSeqNvCertificadoCalculo());
    this.nvCertificadoCalculoDService.salvar(this.nvCertificadoCalculoD);
    listarDetalhe();
    novoDetalhe();
  }
  
  public void deletarDetalhe() {
    this.nvCertificadoCalculoDService.deletar(this.nvCertificadoCalculoD);
    listarDetalhe();
    novoDetalhe();
  }
  
  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public NvCertificadoCalculoService getNvCertificadoCalculoService() {
    return this.nvCertificadoCalculoService;
  }
  
  public void setNvCertificadoCalculoService(NvCertificadoCalculoService nvCertificadoCalculoService) {
    this.nvCertificadoCalculoService = nvCertificadoCalculoService;
  }
  
  public NvCertificadoCalculo getNvCertificadoCalculo() {
    return this.nvCertificadoCalculo;
  }
  
  public void setNvCertificadoCalculo(NvCertificadoCalculo nvCertificadoCalculo) {
    this.nvCertificadoCalculo = nvCertificadoCalculo;
  }
  
  public List<NvCertificadoCalculo> getListaNvCertificadoCalculo() {
    return this.listaNvCertificadoCalculo;
  }
  
  public void setListaNvCertificadoCalculo(List<NvCertificadoCalculo> listaNvCertificadoCalculo) {
    this.listaNvCertificadoCalculo = listaNvCertificadoCalculo;
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
  
  public NvCertificadoCalculoDService getNvCertificadoCalculoDService() {
    return this.nvCertificadoCalculoDService;
  }
  
  public void setNvCertificadoCalculoDService(NvCertificadoCalculoDService nvCertificadoCalculoDService) {
    this.nvCertificadoCalculoDService = nvCertificadoCalculoDService;
  }
  
  public NvCertificadoCalculoD getNvCertificadoCalculoD() {
    return this.nvCertificadoCalculoD;
  }
  
  public void setNvCertificadoCalculoD(NvCertificadoCalculoD nvCertificadoCalculoD) {
    this.nvCertificadoCalculoD = nvCertificadoCalculoD;
  }
  
  public List<NvCertificadoCalculoD> getListaNvCertificadoCalculoD() {
    return this.listaNvCertificadoCalculoD;
  }
  
  public void setListaNvCertificadoCalculoD(List<NvCertificadoCalculoD> listaNvCertificadoCalculoD) {
    this.listaNvCertificadoCalculoD = listaNvCertificadoCalculoD;
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
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\NvCertificadoCalculoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */