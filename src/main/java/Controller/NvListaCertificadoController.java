package Controller;

import java.time.temporal.TemporalAccessor;
import org.apache.commons.io.FilenameUtils;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.InputStream;
import java.io.FileNotFoundException;
import org.primefaces.model.DefaultStreamedContent;
import java.io.FileInputStream;
import java.io.OutputStream;
import org.primefaces.model.UploadedFile;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.FileOutputStream;
import java.io.File;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import NvListaCertificado.NvListaCertificado;
import java.util.List;
import NvListaCertificado.NvListaCertificadoService;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "nvListaCertificadoController")
@ViewScoped
public class NvListaCertificadoController
{
    private static final String FILES_PATH = "C:\\Upload\\";
    @ManagedProperty("#{loginController}")
    protected LoginController loginController;
    private NvListaCertificadoService nvListaCertificadoService;
    private List<NvListaCertificado> listaNvListaCertificado;
    private List<NvListaCertificado> listaNvListaCertificadosms;
    private List<NvListaCertificado> listaNvListaCertificadopt;
    private StreamedContent downloadFile;
    NvListaCertificado nvListaCertificado = new NvListaCertificado();
    public NvListaCertificadoController() {
        this.nvListaCertificadoService = new NvListaCertificadoService();
    }
    
    public void iniciar() {
        if (this.loginController.usuario.getAcOrgListArquivo()== null || this.loginController.usuario.getAcOrgListArquivo().equals("-1")) {
            this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
            return;
        }
        this.listar();
    }
    
      public void iniciarsms() {
        if (this.loginController.usuario.getAcOrgListArquivo()== null || this.loginController.usuario.getAcOrgListArquivo().equals("-1")) {
            this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
            return;
        }
        this.listarsms();
    }
      
      
       public void iniciarpt() {
        if (this.loginController.usuario.getAcOrgListArquivo()== null || this.loginController.usuario.getAcOrgListArquivo().equals("-1")) {
            this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
            return;
        }
        this.listarpt();
    }
    
    public void handleFileUpload(final FileUploadEvent event) throws IOException {
        try {
            final UploadedFile uploadedFile = event.getFile();
            final String fileName = uploadedFile.getFileName();
            final String realName = this.getRealName(fileName);
            final File file = new File("C:\\Upload\\", realName);
            final OutputStream out = new FileOutputStream(file);
            out.write(uploadedFile.getContents());
            out.close();
            final NvListaCertificado nvListaCertificado = new NvListaCertificado();
            nvListaCertificado.setNomeArquivo(realName);
            nvListaCertificado.setSeqUsuario(this.loginController.getUsuario().getSeqUsuario());
            nvListaCertificado.setSeqEmpresa(this.loginController.getUsuario().getSeqEmpresa());
            nvListaCertificado.setTipoCertificado("Qualidade");
            this.nvListaCertificadoService.salvar(nvListaCertificado);
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage("Upload completo", "O arquivo " + uploadedFile.getFileName() + " foi salvo!"));
            this.listar();
        }
        catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
    
    public void handleFileUploadSMS(final FileUploadEvent event) throws IOException {
        try {
            final UploadedFile uploadedFile = event.getFile();
            final String fileName = uploadedFile.getFileName();
            final String realName = this.getRealName(fileName);
            final File file = new File("C:\\Upload\\", realName);
            final OutputStream out = new FileOutputStream(file);
            out.write(uploadedFile.getContents());
            out.close();
            final NvListaCertificado nvListaCertificado = new NvListaCertificado();
            nvListaCertificado.setNomeArquivo(realName);
            nvListaCertificado.setSeqUsuario(this.loginController.getUsuario().getSeqUsuario());
            nvListaCertificado.setSeqEmpresa(this.loginController.getUsuario().getSeqEmpresa());
            nvListaCertificado.setTipoCertificado("SMS");
            this.nvListaCertificadoService.salvar(nvListaCertificado);
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage("Upload completo", "O arquivo " + uploadedFile.getFileName() + " foi salvo!"));
            this.listarsms();
        }
        catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
    public void handleFileUploadPT(final FileUploadEvent event) throws IOException {
        try {
            final UploadedFile uploadedFile = event.getFile();
            final String fileName = uploadedFile.getFileName();
            final String realName = this.getRealName(fileName);
            final File file = new File("C:\\Upload\\", realName);
            final OutputStream out = new FileOutputStream(file);
            out.write(uploadedFile.getContents());
            out.close();
            final NvListaCertificado nvListaCertificado = new NvListaCertificado();
            nvListaCertificado.setNomeArquivo(realName);
            nvListaCertificado.setSeqUsuario(this.loginController.getUsuario().getSeqUsuario());
            nvListaCertificado.setSeqEmpresa(this.loginController.getUsuario().getSeqEmpresa());
            nvListaCertificado.setTipoCertificado("Procedimento Técnico");
            this.nvListaCertificadoService.salvar(nvListaCertificado);
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage("Upload completo", "O arquivo " + uploadedFile.getFileName() + " foi salvo!"));
            this.listarpt();
        }
        catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
    
    
    public void download(final NvListaCertificado nvListaCertificado) {
        InputStream stream = null;
        try {
            stream = new FileInputStream("C:\\Upload\\" + nvListaCertificado.getNomeArquivo());
            this.downloadFile = (StreamedContent)new DefaultStreamedContent(stream, "application/pdf", nvListaCertificado.getNomeArquivo());
        }
        catch (FileNotFoundException e) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
    
    public void remover(final NvListaCertificado nvListaCertificado) {
        try {
            this.nvListaCertificadoService.deletar(nvListaCertificado);
            new File("C:\\Upload\\" + nvListaCertificado.getNomeArquivo()).delete();
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage("Arquivo deletado"));
            this.listar();
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
    
      public void removersms(final NvListaCertificado nvListaCertificado) {
        try {
            this.nvListaCertificadoService.deletar(nvListaCertificado);
            new File("C:\\Upload\\" + nvListaCertificado.getNomeArquivo()).delete();
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage("Arquivo deletado"));
            this.listarsms();
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
    
      public void removerpt(final NvListaCertificado nvListaCertificado) {
        try {
            this.nvListaCertificadoService.deletar(nvListaCertificado);
            new File("C:\\Upload\\" + nvListaCertificado.getNomeArquivo()).delete();
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage("Arquivo deletado"));
            this.listarpt();
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }
    
    
    
    
    
    public StreamedContent getDownloadFile() {
        return this.downloadFile;
    }
    
    public void listar() {
        this.setListaNvListaCertificado(this.nvListaCertificadoService.listarql(this.loginController.getEmpresa().getSeqEmpresa()));
    }
    
     public void listarsms() {
        this.setListaNvListaCertificadosms(this.nvListaCertificadoService.listarsms(this.loginController.getEmpresa().getSeqEmpresa()));
    }
    
     public void listarpt() {
        this.setListaNvListaCertificadopt(this.nvListaCertificadoService.listarpt(this.loginController.getEmpresa().getSeqEmpresa()));
    }
    
    private String getRealName(final String fileName) {
        final LocalDateTime now = LocalDateTime.now();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        return String.format("%s_%s.%s", FilenameUtils.getBaseName(fileName).trim(), formatter.format(now), FilenameUtils.getExtension(fileName));
    }
    
    public static void main(final String[] args) {
        final String fileName = "teste .pdf";
        final LocalDateTime now = LocalDateTime.now();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String.format("%s_%s.%s", FilenameUtils.getBaseName(fileName).trim(), formatter.format(now), FilenameUtils.getExtension(fileName));
    }
    
    public void setLoginController(final LoginController loginController) {
        this.loginController = loginController;
    }
    
    public LoginController getLoginController() {
        return this.loginController;
    }
    
    public List<NvListaCertificado> getListaNvListaCertificado() {
        return this.listaNvListaCertificado;
    }
    
    public void setListaNvListaCertificado(final List<NvListaCertificado> listaNvListaCertificado) {
        this.listaNvListaCertificado = listaNvListaCertificado;
    }
    
      public List<NvListaCertificado> getListaNvListaCertificadosms() {
        return this.listaNvListaCertificadosms;
    }
    
    public void setListaNvListaCertificadosms(final List<NvListaCertificado> listaNvListaCertificadosms) {
        this.listaNvListaCertificadosms = listaNvListaCertificadosms;
    }
    
    public List<NvListaCertificado> getListaNvListaCertificadopt() {
        return this.listaNvListaCertificadopt;
    }
    
    public void setListaNvListaCertificadopt(final List<NvListaCertificado> listaNvListaCertificadopt) {
        this.listaNvListaCertificadopt = listaNvListaCertificadopt;
    }
    
    public NvListaCertificado getNvListaCertificado() {
        return this.nvListaCertificado;
    }
}




