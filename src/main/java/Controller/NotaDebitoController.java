package Controller;

import ClausulaSQL.ClausulaWhere;
import ClausulaSQL.GeneroCondicaoWhere;
import ClausulaSQL.OperacaoCondicaoWhere;
import ClausulaSQL.TipoCondicaoWhere;
import Conta.Conta;
import Conta.ContaService;
import Documento.Documento;
import Documento.DocumentoService;
import Empresa.Empresa;
import Financeiro.Financeiro;
import Financeiro.FinanceiroService;
import Material.Material;
import Material.MaterialService;
import Parceiro.Parceiro;
import Parceiro.ParceiroService;
import UnidadeNegocio.UnidadeNegocio;
import UnidadeNegocio.UnidadeNegocioService;
import Usuario.Usuario;
import Util.Conexao;
import Util.CurrencyWriter;
import Util.Situacao;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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








@ManagedBean(name="notaDebitoController")
@ViewScoped
public class NotaDebitoController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  List<Financeiro> listaFinanceiro = new ArrayList();
  FinanceiroService financeiroService = new FinanceiroService();
  Financeiro financeiro = new Financeiro();
  
  Documento documento = new Documento();
  List<Documento> listaDocumento = new ArrayList();
  DocumentoService documentoService = new DocumentoService();
  
  UnidadeNegocio unidadeNegocio = new UnidadeNegocio();
  UnidadeNegocioService unidadeNegocioService = new UnidadeNegocioService();
  List<UnidadeNegocio> listaUnidadeNegocio = new ArrayList();
  
  List<Conta> listaConta = new ArrayList();
  ContaService contaService = new ContaService();
  
  List<Parceiro> listaParceiro = new ArrayList();
  List<Parceiro> listaParceiroFuncionario = new ArrayList();
  ParceiroService parceiroService = new ParceiroService();
  


  List<Material> listaMaterial = new ArrayList();
  MaterialService materialService = new MaterialService();
  
  boolean porDataLancamento;
  
  String dataLancamentoInicial;
  
  String dataLancamentoFinal;
  
  boolean porDataVencimento;
  String dataVencimentoInicial;
  String dataVencimentoFinal;
  String seqParceiroSelecionado;
  String seqColaboradorSelecionado;
  boolean id;
  Integer tela = Integer.valueOf(0);
  

  public void salvar(int pTela)
  {
    this.financeiro.setSeqEmpresa(this.loginController.usuario.getSeqEmpresa());
    
    if (this.financeiro.getOcorrencias() == null) {
      this.financeiro.setOcorrencias(Integer.valueOf(0));
    }
    if (this.financeiro.getIntervaloNumero() == null) {
      this.financeiro.setIntervaloNumero(Integer.valueOf(0));
    }
    if (this.financeiro.getParcelaInicio() == null) {
      this.financeiro.setParcelaInicio(Integer.valueOf(0));
    }
    if (this.financeiro.getParcelaFim() == null) {
      this.financeiro.setParcelaFim(Integer.valueOf(0));
    }
    if (this.financeiro.getSeqFinanceiro() == null) {
      this.financeiro.setOrigemLCM("7");
      this.financeiro = this.financeiroService.salvar(this.financeiro);
      String numeroFaturamento = this.financeiro.getSeqFinanceiro();
      

      this.financeiro.setSeqFinanceiro(null);
      this.financeiro.setOrigemLCM("1");
      this.financeiro.setOutrasInformacoes("Lançamento gerado à partir da Nota de Débito, N.º: " + numeroFaturamento + ".");
      this.financeiro = this.financeiroService.salvar(this.financeiro);
    } else {
      this.financeiro.setOrigemLCM("7");
      this.financeiro = this.financeiroService.salvar(this.financeiro);
    }
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
  }
  
  public void deletar()
  {
    if (this.financeiroService.deletar(this.financeiro)) {
      this.financeiro = new Financeiro();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
      this.tela = Integer.valueOf(0);
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
    }
  }
  
  public void novo() {
    this.id = false;
    this.financeiro = new Financeiro();
    
    this.documento = new Documento();
    this.unidadeNegocio = new UnidadeNegocio();
    
    this.financeiro.setDataLancamento(new Date());
    
    this.financeiro.setSeqUsuario(this.loginController.usuario.getSeqUsuario());
    this.financeiro.setResponsavel(this.loginController.usuario.getUsuario());
    
    this.tela = Integer.valueOf(1);
  }
  
  public void cancelar() {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String dataCancelamento = formato.format(new Date());
    
    String msg = "'".concat(this.financeiro.getMotivoCancelamento()).concat("'. Por:").concat(this.loginController.getUsuario().getUsuario()).concat(". Data de Cancelamento:").concat(dataCancelamento);
    this.financeiro.setMotivoCancelamento(msg);
    this.financeiro.setEtapa("CANCELADO");
    this.financeiro = this.financeiroService.salvar(this.financeiro);
  }
  
  public void mudarTela(Integer pTela)
  {
    this.financeiro = new Financeiro();
    this.tela = pTela;
  }
  

  public void selecionar(Financeiro pFinanceiro)
  {
    this.id = true;
    this.financeiro = ((Financeiro)this.financeiroService.listar(this.loginController.getUsuario().getSeqEmpresa(), pFinanceiro.getSeqFinanceiro()).get(0));
    if (this.financeiro.getSeqUnidadeNegocio() != null) {
      this.unidadeNegocio = ((UnidadeNegocio)this.unidadeNegocioService.listarPorSeq(this.loginController.empresa.getSeqEmpresa(), this.financeiro.getSeqUnidadeNegocio(), Situacao.ATIVO).get(0));
      if (this.unidadeNegocio.getCnpj() == null) {
        this.unidadeNegocio.setCnpj("S/Nº.");
      }
    } else {
      this.unidadeNegocio = new UnidadeNegocio();
    }
    
    if (this.financeiro.getOrigemLCM().equals("7")) {
      this.tela = Integer.valueOf(1);
      return;
    }
    
    this.tela = Integer.valueOf(1);
  }
  
  public void listarNotaDebito() {
    ClausulaWhere condicao = new ClausulaWhere();
    
    condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "financeiro.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(this.loginController.getEmpresa().getSeqEmpresa()), TipoCondicaoWhere.Numero);
    condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.ORIGEM_LCM", GeneroCondicaoWhere.igual, String.valueOf("7"), TipoCondicaoWhere.Texto);
    
    if (isPorDataLancamento() == true) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.data_cadastro", GeneroCondicaoWhere.MaiorIgual, this.dataLancamentoInicial, TipoCondicaoWhere.Data);
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.data_cadastro", GeneroCondicaoWhere.MenorIgual, this.dataLancamentoFinal, TipoCondicaoWhere.Data);
    }
    if (isPorDataVencimento() == true) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.data_vencimento", GeneroCondicaoWhere.MaiorIgual, this.dataVencimentoInicial, TipoCondicaoWhere.Data);
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.data_vencimento", GeneroCondicaoWhere.MenorIgual, this.dataVencimentoFinal, TipoCondicaoWhere.Data);
    }
    
    if (this.seqParceiroSelecionado != null) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.seq_parceiro", GeneroCondicaoWhere.igual, String.valueOf(this.seqParceiroSelecionado), TipoCondicaoWhere.Texto);
    }
    if (this.seqColaboradorSelecionado != null) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.seq_colaborador", GeneroCondicaoWhere.igual, String.valueOf(this.seqColaboradorSelecionado), TipoCondicaoWhere.Texto);
    }
    
    this.listaFinanceiro = this.financeiroService.listarFiltro(condicao);
  }
  

  public void buscarContratada()
  {
    for (UnidadeNegocio un : this.listaUnidadeNegocio)
    {
      if (un.getSeqUnidadeNegocio().equals(this.financeiro.getSeqUnidadeNegocio())) {
        if (un.getCnpj() == null) {
          this.unidadeNegocio = un;
          this.unidadeNegocio.setCnpj("S/Nº.");
        } else {
          this.unidadeNegocio = un;
        }
      } else if (this.financeiro.getSeqUnidadeNegocio() == null) {
        this.unidadeNegocio = new UnidadeNegocio();
      }
    }
  }
  
  public void iniciarNotaDebito()
  {
    if ((this.loginController.usuario.getAcFinNotaDebito() == null) || (this.loginController.usuario.getAcFinNotaDebito().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    
    ClausulaWhere condicao = new ClausulaWhere();
    
    condicao.AdicionarCondicaoManual(" where (documento.seq_documento_etapa = 508 or documento.seq_documento_etapa = 505 or documento.seq_documento_etapa = 502 or documento.seq_documento_etapa = 441 or documento.seq_documento_etapa =268 or documento.seq_documento_etapa =265 or documento.seq_documento_etapa =262 or documento.seq_documento_etapa = 241 ) and documento.seq_empresa = 61");
    
    this.listaDocumento = this.documentoService.listarDocumentoFiltro(condicao);
    
    this.listaParceiroFuncionario = this.parceiroService.listarParceiroTipo(this.loginController.usuario.getSeqUsuario(), "702");
    this.listaUnidadeNegocio = this.unidadeNegocioService.listar(this.loginController.empresa.getSeqEmpresa(), "", Situacao.ATIVO);
    this.listaConta = this.contaService.listar(this.loginController.usuario.getSeqEmpresa(), "", Situacao.ATIVO);
    this.listaParceiro = this.parceiroService.listarParceiro(this.loginController.usuario.getSeqUsuario(), "");
    this.listaMaterial = this.materialService.listarPorReferencia(this.loginController.empresa.getSeqEmpresa(), "Reembolsos de Despesas", Situacao.ATIVO);
  }
  
  public void imprimirNotaDebito() throws IOException, JRException {
    Conexao conexao = new Conexao();
    Connection conn = Conexao.getConnection();
    String colaboradorNome = "";
    String valor = this.financeiro.getValor().setScale(2, RoundingMode.HALF_EVEN).toString().replace(".", ",");
    
    String numeracao = String.format("%04d", new Object[] { Integer.valueOf(this.financeiro.getSeqFinanceiro()) }).concat("-").concat(String.valueOf(new Date().getYear() + 1900).substring(2));
    
    CurrencyWriter cw = CurrencyWriter.getInstance();
    SimpleDateFormat formatarDate = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy'.'");
    
    for (Parceiro c : this.listaParceiro) {
      if (c.getSeqParceiro().equals(this.financeiro.getSeqColaborador())) {
        colaboradorNome = c.getNome();
      }
    }
    HashMap parametro = new HashMap();
    parametro.put("SeqFinanceiro", Integer.valueOf(this.financeiro.getSeqFinanceiro()));
    parametro.put("valorPorExtenso", cw.write(this.financeiro.getValor()));
    parametro.put("dataAtual", formatarDate.format(this.financeiro.getDataEmissao()));
    parametro.put("nome_colaborador", colaboradorNome);
    parametro.put("valor", valor);
    parametro.put("numeracao", numeracao);
    

    System.out.println("valor" + this.financeiro.getValor().setScale(2, RoundingMode.HALF_EVEN));
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    facesContext.responseComplete();
    ServletContext scontext = (ServletContext)facesContext.getExternalContext().getContext();
    
    JasperPrint jasperPrint = new JasperPrint();
    jasperPrint = JasperFillManager.fillReport(scontext.getRealPath("/relatorio/aws/ND/ND.jasper"), parametro, conn);
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    JRPdfExporter exporter = new JRPdfExporter();
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
    exporter.exportReport();
    byte[] bytes = baos.toByteArray();
    
    if ((bytes != null) && (bytes.length > 0)) {
      HttpServletResponse response = (HttpServletResponse)facesContext.getExternalContext().getResponse();
      response.setContentType("application/pdf");
      response.setHeader("Content-disposition", "inline; filename=\"NotaDebito.pdf\"");
      response.setContentLength(bytes.length);
      ServletOutputStream outputStream = response.getOutputStream();
      outputStream.write(bytes, 0, bytes.length);
      outputStream.flush();
      outputStream.close();
    }
  }
  
  public void buscarDadosProposta() {
    this.documento = this.documentoService.buscarPorID(this.loginController.empresa.getSeqEmpresa(), this.financeiro.getSeqDocumento());
    
    this.financeiro.setSeqParceiro(this.documento.getSeqParceiro());
    this.financeiro.setSeqConta(this.documento.getSeqConta());
    this.financeiro.setSeqColaborador(this.documento.getSeqAssColaborador());
    this.financeiro.setSeqUnidadeNegocio(this.documento.getSeqUnidadeNegocio());
    
    System.out.println(this.financeiro.getSeqUnidadeNegocio());
    System.out.println(this.documento.getSeqUnidadeNegocio());
    
    if (this.financeiro.getSeqUnidadeNegocio() != null) {
      buscarContratada();
    }
  }
  



  public void limiteData()
  {
    if (this.financeiro.getDataVencimento() != null) {
      System.out.println(this.financeiro.getDataVencimento());
      if (this.financeiro.getDataEmissao().after(this.financeiro.getDataVencimento())) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data de Emissão não pode ser superior a Data de Vencimento.", ""));
        return;
      }
    }
  }
  

  public List<Financeiro> getListaFinanceiro()
  {
    return this.listaFinanceiro;
  }
  
  public void setListaFinanceiro(List<Financeiro> listaFinanceiro) {
    this.listaFinanceiro = listaFinanceiro;
  }
  
  public FinanceiroService getFinanceiroService() {
    return this.financeiroService;
  }
  
  public void setFinanceiroService(FinanceiroService financeiroService) {
    this.financeiroService = financeiroService;
  }
  
  public Financeiro getFinanceiro() {
    return this.financeiro;
  }
  
  public void setFinanceiro(Financeiro financeiro) {
    this.financeiro = financeiro;
  }
  
  public Documento getDocumento() {
    return this.documento;
  }
  
  public void setDocumento(Documento documento) {
    this.documento = documento;
  }
  
  public List<Documento> getListaDocumento() {
    return this.listaDocumento;
  }
  
  public void setListaDocumento(List<Documento> listaDocumento) {
    this.listaDocumento = listaDocumento;
  }
  
  public DocumentoService getDocumentoService() {
    return this.documentoService;
  }
  
  public void setDocumentoService(DocumentoService documentoService) {
    this.documentoService = documentoService;
  }
  
  public List<Conta> getListaConta() {
    return this.listaConta;
  }
  
  public void setListaConta(List<Conta> listaConta) {
    this.listaConta = listaConta;
  }
  
  public ContaService getContaService() {
    return this.contaService;
  }
  
  public void setContaService(ContaService contaService) {
    this.contaService = contaService;
  }
  
  public List<Parceiro> getListaParceiro() {
    return this.listaParceiro;
  }
  
  public void setListaParceiro(List<Parceiro> listaParceiro) {
    this.listaParceiro = listaParceiro;
  }
  
  public ParceiroService getParceiroService() {
    return this.parceiroService;
  }
  
  public void setParceiroService(ParceiroService parceiroService) {
    this.parceiroService = parceiroService;
  }
  
  public List<Parceiro> getListaParceiroFuncionario() {
    return this.listaParceiroFuncionario;
  }
  
  public void setListaParceiroFuncionario(List<Parceiro> listaParceiroFuncionario) {
    this.listaParceiroFuncionario = listaParceiroFuncionario;
  }
  
  public List<Material> getListaMaterial() {
    return this.listaMaterial;
  }
  
  public void setListaMaterial(List<Material> listaMaterial) {
    this.listaMaterial = listaMaterial;
  }
  
  public MaterialService getMaterialService() {
    return this.materialService;
  }
  
  public void setMaterialService(MaterialService materialService) {
    this.materialService = materialService;
  }
  
  public boolean isPorDataLancamento() {
    return this.porDataLancamento;
  }
  
  public void setPorDataLancamento(boolean porDataLancamento) {
    this.porDataLancamento = porDataLancamento;
  }
  
  public String getDataLancamentoInicial() {
    return this.dataLancamentoInicial;
  }
  
  public void setDataLancamentoInicial(String dataLancamentoInicial) {
    this.dataLancamentoInicial = dataLancamentoInicial;
  }
  
  public String getDataLancamentoFinal() {
    return this.dataLancamentoFinal;
  }
  
  public void setDataLancamentoFinal(String dataLancamentoFinal) {
    this.dataLancamentoFinal = dataLancamentoFinal;
  }
  
  public boolean isPorDataVencimento() {
    return this.porDataVencimento;
  }
  
  public void setPorDataVencimento(boolean porDataVencimento) {
    this.porDataVencimento = porDataVencimento;
  }
  
  public String getDataVencimentoInicial() {
    return this.dataVencimentoInicial;
  }
  
  public void setDataVencimentoInicial(String dataVencimentoInicial) {
    this.dataVencimentoInicial = dataVencimentoInicial;
  }
  
  public String getDataVencimentoFinal() {
    return this.dataVencimentoFinal;
  }
  
  public void setDataVencimentoFinal(String dataVencimentoFinal) {
    this.dataVencimentoFinal = dataVencimentoFinal;
  }
  
  public String getSeqParceiroSelecionado() {
    return this.seqParceiroSelecionado;
  }
  
  public void setSeqParceiroSelecionado(String seqParceiroSelecionado) {
    this.seqParceiroSelecionado = seqParceiroSelecionado;
  }
  
  public String getSeqColaboradorSelecionado() {
    return this.seqColaboradorSelecionado;
  }
  
  public void setSeqColaboradorSelecionado(String seqColaboradorSelecionado) {
    this.seqColaboradorSelecionado = seqColaboradorSelecionado;
  }
  
  public LoginController getLoginController() {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public boolean isId() {
    return this.id;
  }
  
  public void setId(boolean id) {
    this.id = id;
  }
  
  public Integer getTela() {
    return this.tela;
  }
  
  public void setTela(Integer tela) {
    this.tela = tela;
  }
  
  public UnidadeNegocio getUnidadeNegocio() {
    return this.unidadeNegocio;
  }
  
  public void setUnidadeNegocio(UnidadeNegocio unidadeNegocio) {
    this.unidadeNegocio = unidadeNegocio;
  }
  
  public UnidadeNegocioService getUnidadeNegocioService() {
    return this.unidadeNegocioService;
  }
  
  public void setUnidadeNegocioService(UnidadeNegocioService unidadeNegocioService) {
    this.unidadeNegocioService = unidadeNegocioService;
  }
  
  public List<UnidadeNegocio> getListaUnidadeNegocio() {
    return this.listaUnidadeNegocio;
  }
  
  public void setListaUnidadeNegocio(List<UnidadeNegocio> listaUnidadeNegocio) {
    this.listaUnidadeNegocio = listaUnidadeNegocio;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\NotaDebitoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */