package Controller;

import DocumentoEtapa.DocumentoEtapa;
import DocumentoEtapa.DocumentoEtapaService;
import Empresa.Empresa;
import TipoDocumento.TipoDocumento;
import TipoDocumento.TipoDocumentoService;
import TipoDocumentoGerar.TipoDocumentoGerar;
import TipoDocumentoGerar.TipoDocumentoGerarService;
import TipoTarefa.TipoTarefa;
import TipoTarefa.TipoTarefaService;
import Usuario.Usuario;
import Util.PastaDisco;
import Util.Situacao;
import Util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.model.UploadedFile;





@ManagedBean(name="tipoDocumentoController")
@ViewScoped
public class TipoDocumentoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  TipoDocumentoService tipoDocumentoService = new TipoDocumentoService();
  TipoDocumento tipoDocumento = new TipoDocumento();
  List<TipoDocumento> listaTipoDocumento = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  Util util = new Util();
  
  DocumentoEtapaService processoEtapaService = new DocumentoEtapaService();
  List<DocumentoEtapa> listaDocumentoEtapa = new ArrayList();
  DocumentoEtapa processoEtapa = new DocumentoEtapa();
  
  TipoTarefaService tipoTarefaService = new TipoTarefaService();
  List<TipoTarefa> listaTipoTarefa = new ArrayList();
  
  TipoDocumentoGerarService tipoDocumentoGerarService = new TipoDocumentoGerarService();
  TipoDocumentoGerar tipoDocumentoGerar = new TipoDocumentoGerar();
  List<TipoDocumentoGerar> listaTipoDocumentoGerar = new ArrayList();
  List<TipoDocumento> listaTipoDocumento2 = new ArrayList();
  
  UploadedFile arquivoTemplate = null;
  String nomeArquivoAntigo = "";
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcCadTdocumento() == null) || (this.loginController.usuario.getAcCadTdocumento().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    this.listaTipoDocumento2 = this.tipoDocumentoService.listarTodos(this.loginController.getEmpresa().getSeqEmpresa(), "");
  }
  
  public void salvar(int pTela) throws FileNotFoundException {
    this.tipoDocumento.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.tipoDocumento.setDataCadastro(new Date());
    
    this.tipoDocumento = this.tipoDocumentoService.salvar(this.tipoDocumento);
    

    listar();
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  

  public void salvarArquivo()
  {
    File arquivoOriginal = new File("c:\\temp\\erp\\" + String.valueOf(new StringBuilder().append(this.loginController.getEmpresa().getSeqEmpresa()).append("\\").append(PastaDisco.Template).append("\\").append(this.nomeArquivoAntigo).toString()));
    if ((this.nomeArquivoAntigo != "") && 
      (!this.nomeArquivoAntigo.equals(this.tipoDocumento.getNome() + ".docx"))) {
      File arquivoDestino = new File("c:\\temp\\erp\\" + String.valueOf(new StringBuilder().append(this.loginController.getEmpresa().getSeqEmpresa()).append("\\").append(PastaDisco.Template).append("\\").append(this.tipoDocumento.getNome()).append(".docx").toString()));
      arquivoOriginal.renameTo(arquivoDestino);
    }
    
    try
    {
      System.out.println("==> " + this.arquivoTemplate.getSize());
      if (this.arquivoTemplate.getSize() > 0L) {
        arquivoOriginal.delete();
        this.util.copiarArquivoDisco(this.loginController.getEmpresa().getSeqEmpresa(), PastaDisco.Template, this.tipoDocumento.getNome() + ".docx", this.arquivoTemplate.getInputstream());
      }
    } catch (IOException ex) {
      Logger.getLogger(TipoDocumentoController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void downloadTemplate() throws IOException
  {
    if (!this.util.localizarArquivo(this.loginController.getEmpresa().getSeqEmpresa(), this.tipoDocumento.getNome() + ".docx", PastaDisco.Template)) {
      return;
    }
    
    File file = new File("c:\\temp\\erp\\" + this.loginController.getEmpresa().getSeqEmpresa() + "\\Template\\" + this.tipoDocumento.getNome() + ".docx");
    HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    
    response.setHeader("Content-Disposition", "attachment;filename=" + this.tipoDocumento.getNome() + ".docx");
    response.setContentLength((int)file.length());
    ServletOutputStream out = null;
    try {
      FileInputStream input = new FileInputStream(file);
      byte[] buffer = new byte['Ѐ'];
      out = response.getOutputStream();
      int i = 0;
      while ((i = input.read(buffer)) != -1) {
        out.write(buffer);
        out.flush();
      }
      FacesContext.getCurrentInstance().getResponseComplete(); return;
    } catch (IOException err) {
      err.printStackTrace();
    } finally {
      try {
        if (out != null) {
          out.close();
        }
      } catch (IOException err) {
        err.printStackTrace();
      }
    }
  }
  
  public void novo()
  {
    this.tipoDocumento = new TipoDocumento();
    this.listaDocumentoEtapa = new ArrayList();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaTipoDocumento = this.tipoDocumentoService.listarTodos(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa);
  }
  
  public void deletar() {
    if (this.tipoDocumentoService.deletar(this.tipoDocumento)) {
      listar();
      this.tipoDocumento = new TipoDocumento();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
      this.tela = Integer.valueOf(0);
      listar();
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
    }
  }
  
  public void listarGerar()
  {
    this.listaTipoDocumentoGerar = this.tipoDocumentoGerarService.listarGerar(this.tipoDocumento.getSeqTipoDocumento());
  }
  
  public void salvarGerar() {
    this.tipoDocumentoGerar.setSeqTipoDocumentoPai(this.tipoDocumento.getSeqTipoDocumento());
    this.tipoDocumentoGerarService.salvar(this.tipoDocumentoGerar);
    novoGerar();
    listarGerar();
  }
  
  public void deletarGerar(TipoDocumentoGerar p) {
    this.tipoDocumentoGerarService.deletar(p);
    listarGerar();
  }
  
  public void SelecionarGerar(TipoDocumentoGerar p) {
    this.tipoDocumentoGerar = p;
  }
  
  public void novoGerar() {
    this.tipoDocumentoGerar = new TipoDocumentoGerar();
  }
  
  public void fecharTela() throws IOException
  {
    this.loginController.mudarPagina("/principal/ principal.jsf");
  }
  
  public void selecionar(TipoDocumento pTipoDocumento) {
    this.tipoDocumento = pTipoDocumento;
    listarGerar();
    
    this.nomeArquivoAntigo = "";
    this.arquivoTemplate = null;
    





    this.listaDocumentoEtapa = this.processoEtapaService.listarPorTipoDocumento(this.tipoDocumento.getSeqTipoDocumento(), Situacao.TODOS);
    
    this.tela = Integer.valueOf(1);
  }
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  
  public void novoEtapaDocumento() {
    this.processoEtapa = new DocumentoEtapa();
  }
  
  public void selecionarEtapaDocumento(DocumentoEtapa pDocumentoEtapa) {
    this.processoEtapa = pDocumentoEtapa;
  }
  
  public void salvarEtapaDocumento() {
    this.processoEtapa.setSeqTipoDocumento(this.tipoDocumento.getSeqTipoDocumento());
    this.processoEtapa.setDataCadastro(new Date());
    this.processoEtapa.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    
    this.processoEtapaService.salvar(this.processoEtapa);
    
    this.listaDocumentoEtapa = this.processoEtapaService.listarPorTipoDocumento(this.tipoDocumento.getSeqTipoDocumento(), Situacao.TODOS);
    this.processoEtapa = new DocumentoEtapa();
  }
  
  public void deletarEtapaDocumento(DocumentoEtapa processoEtapa) {
    this.processoEtapaService.deletar(processoEtapa);
    this.listaDocumentoEtapa = this.processoEtapaService.listarPorTipoDocumento(this.tipoDocumento.getSeqTipoDocumento(), Situacao.TODOS);
  }
  
  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public TipoDocumentoService getTipoDocumentoService() {
    return this.tipoDocumentoService;
  }
  
  public void setTipoDocumentoService(TipoDocumentoService tipoDocumentoService) {
    this.tipoDocumentoService = tipoDocumentoService;
  }
  
  public TipoDocumento getTipoDocumento() {
    return this.tipoDocumento;
  }
  
  public void setTipoDocumento(TipoDocumento tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }
  
  public List<TipoDocumento> getListaTipoDocumento() {
    return this.listaTipoDocumento;
  }
  
  public void setListaTipoDocumento(List<TipoDocumento> listaTipoDocumento) {
    this.listaTipoDocumento = listaTipoDocumento;
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
  
  public DocumentoEtapaService getDocumentoEtapaService() {
    return this.processoEtapaService;
  }
  
  public void setDocumentoEtapaService(DocumentoEtapaService processoEtapaService) {
    this.processoEtapaService = processoEtapaService;
  }
  
  public List<DocumentoEtapa> getListaDocumentoEtapa() {
    return this.listaDocumentoEtapa;
  }
  
  public void setListaDocumentoEtapa(List<DocumentoEtapa> listaDocumentoEtapa) {
    this.listaDocumentoEtapa = listaDocumentoEtapa;
  }
  
  public DocumentoEtapa getDocumentoEtapa() {
    return this.processoEtapa;
  }
  
  public void setDocumentoEtapa(DocumentoEtapa processoEtapa) {
    this.processoEtapa = processoEtapa;
  }
  
  public DocumentoEtapaService getProcessoEtapaService() {
    return this.processoEtapaService;
  }
  
  public void setProcessoEtapaService(DocumentoEtapaService processoEtapaService) {
    this.processoEtapaService = processoEtapaService;
  }
  
  public DocumentoEtapa getProcessoEtapa() {
    return this.processoEtapa;
  }
  
  public void setProcessoEtapa(DocumentoEtapa processoEtapa) {
    this.processoEtapa = processoEtapa;
  }
  
  public UploadedFile getArquivoTemplate() {
    return this.arquivoTemplate;
  }
  
  public void setArquivoTemplate(UploadedFile arquivoTemplate) {
    this.arquivoTemplate = arquivoTemplate;
  }
  
  public Util getUtil() {
    return this.util;
  }
  
  public void setUtil(Util util) {
    this.util = util;
  }
  
  public String getNomeArquivoAntigo() {
    return this.nomeArquivoAntigo;
  }
  
  public void setNomeArquivoAntigo(String nomeArquivoAntigo) {
    this.nomeArquivoAntigo = nomeArquivoAntigo;
  }
  
  public TipoTarefaService getTipoTarefaService() {
    return this.tipoTarefaService;
  }
  
  public void setTipoTarefaService(TipoTarefaService tipoTarefaService) {
    this.tipoTarefaService = tipoTarefaService;
  }
  
  public List<TipoTarefa> getListaTipoTarefa() {
    return this.listaTipoTarefa;
  }
  
  public void setListaTipoTarefa(List<TipoTarefa> listaTipoTarefa) {
    this.listaTipoTarefa = listaTipoTarefa;
  }
  
  public TipoDocumentoGerar getTipoDocumentoGerar() {
    return this.tipoDocumentoGerar;
  }
  
  public void setTipoDocumentoGerar(TipoDocumentoGerar tipoDocumentoGerar) {
    this.tipoDocumentoGerar = tipoDocumentoGerar;
  }
  
  public List<TipoDocumentoGerar> getListaTipoDocumentoGerar() {
    return this.listaTipoDocumentoGerar;
  }
  
  public void setListaTipoDocumentoGerar(List<TipoDocumentoGerar> listaTipoDocumentoGerar) {
    this.listaTipoDocumentoGerar = listaTipoDocumentoGerar;
  }
  
  public TipoDocumentoGerarService getTipoDocumentoGerarService() {
    return this.tipoDocumentoGerarService;
  }
  
  public void setTipoDocumentoGerarService(TipoDocumentoGerarService tipoDocumentoGerarService) {
    this.tipoDocumentoGerarService = tipoDocumentoGerarService;
  }
  
  public List<TipoDocumento> getListaTipoDocumento2() {
    return this.listaTipoDocumento2;
  }
  
  public void setListaTipoDocumento2(List<TipoDocumento> listaTipoDocumento2) {
    this.listaTipoDocumento2 = listaTipoDocumento2;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\TipoDocumentoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */