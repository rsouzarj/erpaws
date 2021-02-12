package Controller;

import ClausulaSQL.ClausulaWhere;
import ClausulaSQL.GeneroCondicaoWhere;
import ClausulaSQL.OperacaoCondicaoWhere;
import ClausulaSQL.TipoCondicaoWhere;
import Colaborador.Colaborador;
import Colaborador.ColaboradorService;
import Empresa.Empresa;
import Equipamento.Equipamento;
import Equipamento.EquipamentoService;
import EquipamentoParceiro.EquipamentoParceiro;
import EquipamentoParceiro.EquipamentoParceiroService;
import NvCertificadoEquipamento.NvCertificadoEquipamento;
import NvCertificadoEquipamento.NvCertificadoEquipamentoService;
import Parceiro.Parceiro;
import Parceiro.ParceiroService;
import Util.Conexao;
import Util.Situacao;
import Util.Util;
import _Teste.DataPorExtenso;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;



@ManagedBean(name="nvCertificadoEquipamentoController")
@ViewScoped
public class NvCertificadoEquipamentoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  NvCertificadoEquipamentoService nvCertificadoEquipamentoService = new NvCertificadoEquipamentoService();
  NvCertificadoEquipamento nvCertificadoEquipamento = new NvCertificadoEquipamento();
  List<NvCertificadoEquipamento> listaNvCertificadoEquipamento = new ArrayList();
  
  ParceiroService parceiroService = new ParceiroService();
  List<Parceiro> listaParceiro = new ArrayList();
  Parceiro parceiro = new Parceiro();
  
  EquipamentoParceiro equipamentoParceiro = new EquipamentoParceiro();
  List<EquipamentoParceiro> listaEquipamentoParceiro = new ArrayList();
 
  EquipamentoParceiroService equipamentoParceiroService = new EquipamentoParceiroService();
  List<EquipamentoParceiro> listaEquipamentoParceiroService = new ArrayList();
  
  String pesquisa = "";
  Integer tela = Integer.valueOf(0);
  Util util = new Util();
  boolean bEquipamento = false;
  
  EquipamentoService equipamentoService = new EquipamentoService();
  List<Equipamento> listaequipamento = new ArrayList();
  Equipamento equipamento = new Equipamento();
  
  ColaboradorService colaboradorService = new ColaboradorService();
  List<Colaborador> listaColaborador = new ArrayList();
  
  private ArrayList<String> equipamentoSelecionado = new ArrayList();
  Long seqEquipamentoSelecionado;
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcOpCertificado() == null) || (this.loginController.usuario.getAcOpCertificado().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
       }
   this.listaParceiro = this.parceiroService.listarParceiro(this.loginController.getUsuario().getSeqUsuario(),"");
   this.listaColaborador = this.colaboradorService.listar(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.ATIVO);
   this.listaequipamento = this.equipamentoService.listarPorParceiro(this.loginController.getEmpresa().getSeqEmpresa(), this.nvCertificadoEquipamento.getSeqParceiro(), Situacao.ATIVO);
   
  }
  
  public void salvar(int pTela) {
    this.nvCertificadoEquipamento.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.nvCertificadoEquipamento = this.nvCertificadoEquipamentoService.salvar(this.nvCertificadoEquipamento);
    listar();
    listarEquipamento();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
    FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(1);
  }
    
 public void novo() {
    this.nvCertificadoEquipamento = new NvCertificadoEquipamento();
    this.tela = 1;
}           
  
  public void listar() {
    this.listaNvCertificadoEquipamento = this.nvCertificadoEquipamentoService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
    listarEquipamento();
}
  
  
  public void listarEquipamento() {
    this.listaequipamento = this.equipamentoService.listarPorParceiro(this.loginController.getEmpresa().getSeqEmpresa(), this.nvCertificadoEquipamento.getSeqParceiro(), Situacao.ATIVO);
}
	
  
 /* public void filtrar() {
    boolean executar = true;
    
    ClausulaWhere condicao = new ClausulaWhere();
    condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "NV_CERTIFICADO_EQUIPAMENTO.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(this.loginController.getEmpresa().getSeqEmpresa()), TipoCondicaoWhere.Numero);
    
    if (this.equipamento != null) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_CERTIFICADO_EQUIPAMENTO.SEQ_NV_CERTIFICADO", GeneroCondicaoWhere.igual, String.valueOf(this.), TipoCondicaoWhere.Numero);
    }
    
    if (this.seqEquipamentoSelecionado != null) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_CERTIFICADO_EQUIPAMENTO.seq_nv_equipamento", GeneroCondicaoWhere.igual, String.valueOf(this.seqEquipamentoSelecionado), TipoCondicaoWhere.Numero);
    }
    
    if (executar == true) {
      this.listaNvCertificadoEquipamento = this.nvCertificadoEquipamentoService.listar(condicao);
    }
  }*/
  
  public void deletar()
  {
    if (this.nvCertificadoEquipamentoService.deletar(this.nvCertificadoEquipamento)) {
      listar();
      this.nvCertificadoEquipamento = new NvCertificadoEquipamento();
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
  
  public void selecionar(NvCertificadoEquipamento pNvCertificadoEquipamento) {
    this.nvCertificadoEquipamento = pNvCertificadoEquipamento;
    System.out.println("seq:" + this.nvCertificadoEquipamento.getSeqCertificado());
    System.out.println("tipo:" + this.nvCertificadoEquipamento.getSeqEquipamento());
    this.listaEquipamentoParceiro = this.equipamentoParceiroService.listarParceiro(this.nvCertificadoEquipamento.getSeqEquipamento());
    this.tela = Integer.valueOf(1);
  }
  
  /*
  public void selecionar(NvVistoria pNvVistoria) {
		this.nvVistoria = pNvVistoria;
		System.out.println("seq:" + this.nvVistoria.getSeqNvVistoria());
		System.out.println("tipo:" + this.nvVistoria.getTipoVistoria());
		this.listaNvTpVistoriaTpCertificado = this.nvTpVistoriaTpCertificadoService.listarPorTipoVistoria(this.nvVistoria.getSeqNvTipoVistoria());
		this.listaUpload = this.uploadService.listar(this.loginController.empresa.getSeqEmpresa(),
				this.nvVistoria.getSeqNvVistoria());
		this.tela = Integer.valueOf(1);
  
  
  */
  
  
  
  
  
  
  public void mudarTela(Integer pTela) {
    this.tela = pTela;
  }
  
  public void imprimir() throws IOException, JRException {
		Conexao conexao = new Conexao();
		Connection conn = Conexao.getConnection();
		Util util = new Util();
		NvCertificadoEquipamento pCertificado = new NvCertificadoEquipamento();           

		HashMap parametro = new HashMap();
		parametro.put("pSeqCertificado",Integer.valueOf(this.nvCertificadoEquipamento.getSeqCertificado()));

		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.responseComplete();
		ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

		JasperPrint jasperPrint = new JasperPrint();

		jasperPrint = JasperFillManager.fillReport(scontext.getRealPath("/relatorio/CERTIFICADO EQUIPAMENTO/CERTIFICADO.jasper"), parametro,
				conn);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.exportReport();
		byte[] bytes = baos.toByteArray();

		if ((bytes != null) && (bytes.length > 0)) {
			HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "inline; filename=\"Certificado.pdf\"");
			response.setContentLength(bytes.length);
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(bytes, 0, bytes.length);
			outputStream.flush();
			outputStream.close();
		}
	}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    /*public void imprimir() throws JRException, IOException {
   
      Conexao conexao = new Conexao();
      Connection conn = Conexao.getConnection();
      HashMap parametro = new HashMap();
      
      parametro.put("pSeqCertificado", Long.valueOf(this.nvCertificadoEquipamento.getSeqCertificado()));
    
  
      
     String caminho = "/relatorio/CERTIFICADO EQUIPAMENTO/CERTIFICADO.jasper";
      
        
      System.out.println("SEQ CERTIFICADO EQUIPAMENTO " + this.nvCertificadoEquipamento.getSeqCertificado());
      FacesContext facesContext = FacesContext.getCurrentInstance();
      facesContext.responseComplete();
      ServletContext scontext = (ServletContext)facesContext.getExternalContext().getContext();
      JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath(caminho), parametro, conn);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      JRPdfExporter exporter = new JRPdfExporter();
      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
      exporter.exportReport();
      byte[] bytes = baos.toByteArray();
      
      if ((bytes != null) && (bytes.length > 0)) {
        HttpServletResponse response = (HttpServletResponse)facesContext.getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline; filename=\"certificadoequipamento.pdf\"");
        response.setContentLength(bytes.length);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
      }
  }*/
  
  
  
  

  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public NvCertificadoEquipamentoService getNvCertificadoEquipamentoService() {
    return this.nvCertificadoEquipamentoService;
  }
  
  public void setNvCertificadoEquipamentoService(NvCertificadoEquipamentoService nvCertificadoEquipamentoService) {
    this.nvCertificadoEquipamentoService = nvCertificadoEquipamentoService;
  }
  
  public NvCertificadoEquipamento getNvCertificadoEquipamento() {
    return this.nvCertificadoEquipamento;
  }
  
  public void setNvCertificadoEquipamento(NvCertificadoEquipamento nvCertificadoEquipamento) {
    this.nvCertificadoEquipamento = nvCertificadoEquipamento;
  }
  
  public List<NvCertificadoEquipamento> getListaNvCertificadoEquipamento() {
    return this.listaNvCertificadoEquipamento;
  }
  
    public void setListaNvCertificadoEquipamento(List<NvCertificadoEquipamento> listaNvCertificadoEquipamento) {
        this.listaNvCertificadoEquipamento = listaNvCertificadoEquipamento;
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

    public List<Parceiro> getListaParceiro() {
        return this.listaParceiro;
    }

    public void setListaParceiro(List<Parceiro> listaParceiro) {
        this.listaParceiro = listaParceiro;
    }

    public EquipamentoService getEquipamentoService() {
        return this.equipamentoService;
    }

    public void setEquipamentoService(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    public List<Equipamento> getListaEquipamento() {
        return this.listaequipamento;
    }

    public void setListaEquipamento(List<Equipamento> listaEquipamento) {
        this.listaequipamento = listaEquipamento;
    }

    public boolean isbEquipamento() {
        return this.bEquipamento;
    }

    public void setbEquipamento(boolean bEquipamento) {
        this.bEquipamento = bEquipamento;
    }

    public ArrayList<String> getEquipamentoSelecionado() {
        return this.equipamentoSelecionado;
    }

    public void setEquipamentoSelecionado(ArrayList<String> equipamentoSelecionado) {
        this.equipamentoSelecionado = equipamentoSelecionado;
    }

    public Long getSeqEquipamentoSelecionada() {
        return this.seqEquipamentoSelecionado;
    }

    public void setSeqEquipamentoSelecionada(Long seqEquipamentoSelecionada) {
        this.seqEquipamentoSelecionado = seqEquipamentoSelecionada;
    }

    public ColaboradorService getColaboradorService() {
        return this.colaboradorService;
    }

    public void setColaboradorService(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    public List<Colaborador> getListaColaborador() {
        return this.listaColaborador;
    }

    public void setListaColaborador(List<Colaborador> listaColaborador) {
        this.listaColaborador = listaColaborador;
    }

    public Util getUtil() {
        return this.util;
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public List<EquipamentoParceiro> getEquipamentoParceiro() {
        return this.listaEquipamentoParceiro;
    }

    public void setEquipamentoParceiro(List<EquipamentoParceiro> listaequipamentoParceiro) {
        this.listaEquipamentoParceiro = listaequipamentoParceiro;
    }

}
