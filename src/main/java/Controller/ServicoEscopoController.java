package Controller;

import DocumentoEscopo.DocumentoEscopo;
import DocumentoEscopo.DocumentoEscopoService;
import Empresa.Empresa;
import ServicoEscopo.ServicoEscopo;
import ServicoEscopo.ServicoEscopoService;
import ServicoEscopoTarefa.ServicoEscopoTarefa;
import ServicoEscopoTarefa.ServicoEscopoTarefaService;
import TipoDocumento.TipoDocumento;
import TipoDocumento.TipoDocumentoService;
import TipoTarefa.TipoTarefa;
import TipoTarefa.TipoTarefaService;
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







@ManagedBean(name="servicoEscopoController")
@ViewScoped
public class ServicoEscopoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  ServicoEscopoService servicoEscopoService = new ServicoEscopoService();
  ServicoEscopo servicoEscopo = new ServicoEscopo();
  List<ServicoEscopo> listaServicoEscopo = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  ServicoEscopoTarefaService servicoEscopoTarefaService = new ServicoEscopoTarefaService();
  ServicoEscopoTarefa servicoEscopoTarefa = new ServicoEscopoTarefa();
  List<ServicoEscopoTarefa> listaServicoEscopoTarefa = new ArrayList();
  TipoTarefaService tipoTarefaService = new TipoTarefaService();
  List<TipoTarefa> listaTipoTarefa = new ArrayList();
  
  List<TipoDocumento> listaTipoDocumento = new ArrayList();
  TipoDocumentoService tipoDocumentoService = new TipoDocumentoService();
  
  DocumentoEscopoService documentoEscopoService = new DocumentoEscopoService();
  DocumentoEscopo documentoEscopo = new DocumentoEscopo();
  List<DocumentoEscopo> listaDocumentoEscopo = new ArrayList();
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcComEscopo() == null) || (this.loginController.usuario.getAcComEscopo().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    this.listaTipoTarefa = this.tipoTarefaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.ATIVO);
    this.listaTipoDocumento = this.tipoDocumentoService.listarEscopo(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.ATIVO, this.loginController.getUsuario().getSeqUsuario());
    this.listaDocumentoEscopo = this.documentoEscopoService.listar("", this.servicoEscopo.getSeqServicoEscopo());
  }
  
  public void salvar(int pTela) {
    this.servicoEscopo.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.servicoEscopo = this.servicoEscopoService.salvar(this.servicoEscopo);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.servicoEscopo = new ServicoEscopo();
    this.documentoEscopo = new DocumentoEscopo();
    this.listaDocumentoEscopo.clear();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaServicoEscopo = this.servicoEscopoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.servicoEscopoService.deletar(this.servicoEscopo)) {
      listar();
      this.servicoEscopo = new ServicoEscopo();
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
  
  public void selecionar(ServicoEscopo pServicoEscopo) {
    this.servicoEscopo = pServicoEscopo;
    this.documentoEscopo = new DocumentoEscopo();
    listarTarefa();
    listarDocumento();
    
    this.tela = Integer.valueOf(1);
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  

  public void salvarTarefa()
  {
    this.servicoEscopoTarefa.setSeqServicoEscopo(this.servicoEscopo.getSeqServicoEscopo());
    this.servicoEscopoTarefaService.salvar(this.servicoEscopoTarefa);
    listarTarefa();
  }
  
  public void deletarTarefa(ServicoEscopoTarefa pServicoEscopoTarefa) {
    this.servicoEscopoTarefaService.deletar(pServicoEscopoTarefa);
    listarTarefa();
  }
  
  public void deletarTarefa() {
    this.servicoEscopoTarefaService.deletar(this.servicoEscopoTarefa);
  }
  
  public void listarTarefa() {
    this.listaDocumentoEscopo = this.documentoEscopoService.listar("", this.servicoEscopo.getSeqServicoEscopo());
  }
  
  public void adicionarVinculo()
  {
    if (this.servicoEscopo.getSeqServicoEscopo() == null) {
      salvar(1);
    }
    this.documentoEscopo.setSeqServicoEscopo(this.servicoEscopo.getSeqServicoEscopo());
    this.documentoEscopoService.salvar(this.documentoEscopo);
    this.documentoEscopo = new DocumentoEscopo();
    this.listaDocumentoEscopo = this.documentoEscopoService.listar("", this.servicoEscopo.getSeqServicoEscopo());
  }
  
  public void removerVinculo(DocumentoEscopo pDocumentoEscopo) {
    this.documentoEscopoService.deletar(pDocumentoEscopo);
    this.listaDocumentoEscopo = this.documentoEscopoService.listar("", this.servicoEscopo.getSeqServicoEscopo());
  }
  
  public void listarDocumento() {
    this.listaDocumentoEscopo = this.documentoEscopoService.listar("", this.servicoEscopo.getSeqServicoEscopo());
  }
  
  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public ServicoEscopoService getServicoEscopoService() {
    return this.servicoEscopoService;
  }
  
  public void setServicoEscopoService(ServicoEscopoService servicoEscopoService) {
    this.servicoEscopoService = servicoEscopoService;
  }
  
  public ServicoEscopo getServicoEscopo() {
    return this.servicoEscopo;
  }
  
  public void setServicoEscopo(ServicoEscopo servicoEscopo) {
    this.servicoEscopo = servicoEscopo;
  }
  
  public List<ServicoEscopo> getListaServicoEscopo() {
    return this.listaServicoEscopo;
  }
  
  public void setListaServicoEscopo(List<ServicoEscopo> listaServicoEscopo) {
    this.listaServicoEscopo = listaServicoEscopo;
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
  
  public ServicoEscopoTarefaService getServicoEscopoTarefaService() {
    return this.servicoEscopoTarefaService;
  }
  
  public void setServicoEscopoTarefaService(ServicoEscopoTarefaService servicoEscopoTarefaService) {
    this.servicoEscopoTarefaService = servicoEscopoTarefaService;
  }
  
  public ServicoEscopoTarefa getServicoEscopoTarefa() {
    return this.servicoEscopoTarefa;
  }
  
  public void setServicoEscopoTarefa(ServicoEscopoTarefa servicoEscopoTarefa) {
    this.servicoEscopoTarefa = servicoEscopoTarefa;
  }
  
  public List<ServicoEscopoTarefa> getListaServicoEscopoTarefa() {
    return this.listaServicoEscopoTarefa;
  }
  
  public void setListaServicoEscopoTarefa(List<ServicoEscopoTarefa> listaServicoEscopoTarefa) {
    this.listaServicoEscopoTarefa = listaServicoEscopoTarefa;
  }
  
  public List<TipoTarefa> getListaTipoTarefa() {
    return this.listaTipoTarefa;
  }
  
  public void setListaTipoTarefa(List<TipoTarefa> listaTipoTarefa) {
    this.listaTipoTarefa = listaTipoTarefa;
  }
  
  public TipoTarefaService getTipoTarefaService() {
    return this.tipoTarefaService;
  }
  
  public void setTipoTarefaService(TipoTarefaService tipoTarefaService) {
    this.tipoTarefaService = tipoTarefaService;
  }
  
  public List<TipoDocumento> getListaTipoDocumento() {
    return this.listaTipoDocumento;
  }
  
  public void setListaTipoDocumento(List<TipoDocumento> listaTipoDocumento) {
    this.listaTipoDocumento = listaTipoDocumento;
  }
  
  public TipoDocumentoService getTipoDocumentoService() {
    return this.tipoDocumentoService;
  }
  
  public void setTipoDocumentoService(TipoDocumentoService tipoDocumentoService) {
    this.tipoDocumentoService = tipoDocumentoService;
  }
  
  public DocumentoEscopoService getDocumentoEscopoService() {
    return this.documentoEscopoService;
  }
  
  public void setDocumentoEscopoService(DocumentoEscopoService documentoEscopoService) {
    this.documentoEscopoService = documentoEscopoService;
  }
  
  public DocumentoEscopo getDocumentoEscopo() {
    return this.documentoEscopo;
  }
  
  public void setDocumentoEscopo(DocumentoEscopo documentoEscopo) {
    this.documentoEscopo = documentoEscopo;
  }
  
  public List<DocumentoEscopo> getListaDocumentoEscopo() {
    return this.listaDocumentoEscopo;
  }
  
  public void setListaDocumentoEscopo(List<DocumentoEscopo> listaDocumentoEscopo) {
    this.listaDocumentoEscopo = listaDocumentoEscopo;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\ServicoEscopoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */