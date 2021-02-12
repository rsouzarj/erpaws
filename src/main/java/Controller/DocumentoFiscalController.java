package Controller;

import DocumentoFiscal.DocumentoFiscal;
import DocumentoFiscal.DocumentoFiscalService;
import Empresa.Empresa;
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







@ManagedBean(name="documentoFiscalController")
@ViewScoped
public class DocumentoFiscalController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  DocumentoFiscalService documentoFiscalService = new DocumentoFiscalService();
  DocumentoFiscal documentoFiscal = new DocumentoFiscal();
  List<DocumentoFiscal> listaDocumentoFiscal = new ArrayList();
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcFinDocFiscal() == null) || (this.loginController.usuario.getAcFinDocFiscal().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
  }
  
  public void salvar(int pTela)
  {
    this.documentoFiscal.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.documentoFiscal = this.documentoFiscalService.salvar(this.documentoFiscal);
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.documentoFiscal = new DocumentoFiscal();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaDocumentoFiscal = this.documentoFiscalService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.documentoFiscalService.deletar(this.documentoFiscal)) {
      listar();
      this.documentoFiscal = new DocumentoFiscal();
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
  
  public void selecionar(DocumentoFiscal pDocumentoFiscal) {
    this.documentoFiscal = pDocumentoFiscal;
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
  
  public DocumentoFiscalService getDocumentoFiscalService() {
    return this.documentoFiscalService;
  }
  
  public void setDocumentoFiscalService(DocumentoFiscalService documentoFiscalService) {
    this.documentoFiscalService = documentoFiscalService;
  }
  
  public DocumentoFiscal getDocumentoFiscal() {
    return this.documentoFiscal;
  }
  
  public void setDocumentoFiscal(DocumentoFiscal documentoFiscal) {
    this.documentoFiscal = documentoFiscal;
  }
  
  public List<DocumentoFiscal> getListaDocumentoFiscal() {
    return this.listaDocumentoFiscal;
  }
  
  public void setListaDocumentoFiscal(List<DocumentoFiscal> listaDocumentoFiscal) {
    this.listaDocumentoFiscal = listaDocumentoFiscal;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\DocumentoFiscalController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */