package Controller;

import ClausulaSQL.ClausulaWhere;
import ClausulaSQL.GeneroCondicaoWhere;
import ClausulaSQL.OperacaoCondicaoWhere;
import ClausulaSQL.TipoCondicaoWhere;
import Conta.Conta;
import Conta.ContaService;
import Documento.Documento;
import Documento.DocumentoService;
import DocumentoOcorrencia.DocumentoOcorrencia;
import DocumentoOcorrencia.DocumentoOcorrenciaService;
import Empresa.Empresa;
import Equipamento.Equipamento;
import Equipamento.EquipamentoService;
import Financeiro.Financeiro;
import Financeiro.FinanceiroService;
import FinanceiroEquipamento.FinanceiroEquipamento;
import FinanceiroEquipamento.FinanceiroEquipamentoService;
import FormaPagamento.FormaPagamento;
import FormaPagamento.FormaPagamentoService;
import Parceiro.Parceiro;
import Parceiro.ParceiroService;
import Usuario.Usuario;
import Util.Conexao;
import Util.CurrencyWriter;
import Util.Situacao;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
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
import org.apache.commons.lang.StringUtils;






@ManagedBean(name="RLBMController")
@ViewScoped
public class RLBMController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  FinanceiroService financeiroService = new FinanceiroService();
  Financeiro financeiro = new Financeiro();
  Financeiro financeiroQuitacao = new Financeiro();
  List<Financeiro> listaFinanceiro = new ArrayList();
  
  Parceiro parceiro = new Parceiro();
  List<Parceiro> listaParceiro = new ArrayList();
  ParceiroService parceiroService = new ParceiroService();
  
  List<Equipamento> listaEquipamento = new ArrayList();
  EquipamentoService equipamentoService = new EquipamentoService();
  
  List<Conta> listaConta = new ArrayList();
  ContaService contaService = new ContaService();
  
  FinanceiroEquipamento financeiroEquipamento = new FinanceiroEquipamento();
  List<FinanceiroEquipamento> listaFinanceiroEquipamento = new ArrayList();
  List<FinanceiroEquipamento> listaFinanceiroEquipamentoDeletado = new ArrayList();
  FinanceiroEquipamentoService FinanceiroEquipamentoService = new FinanceiroEquipamentoService();
  
  List<FormaPagamento> listaFormaPagamento = new ArrayList();
  FormaPagamentoService formaPagamentoService = new FormaPagamentoService();
  
  Documento documento = new Documento();
  List<Documento> listaDocumento = new ArrayList();
  List<Documento> listaTodosDocumentos = new ArrayList();
  DocumentoService documentoService = new DocumentoService();
  DocumentoOcorrenciaService documentoOcorrenciaService = new DocumentoOcorrenciaService();
  
  boolean porDataEmissao;
  
  String dataEmissaoInicial;
  
  String dataEmissaoFinal;
  
  boolean porDataVencimento;
  String dataVencimentoInicial;
  String dataVencimentoFinal;
  String seqParceiroSelecionado;
  String seqContaSelecionada;
  Integer tela = Integer.valueOf(0);
  
  public void iniciar() {
    if ((this.loginController.usuario.getAcFinRLBM() == null) || (this.loginController.usuario.getAcFinRLBM().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    
    ClausulaWhere condicaoDoc = new ClausulaWhere();
    ClausulaWhere condicaoParc = new ClausulaWhere();
    
    condicaoDoc.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "documento.seq_documento_etapa", GeneroCondicaoWhere.igual, String.valueOf(441), TipoCondicaoWhere.Numero);
    condicaoDoc.AdicionarCondicao(OperacaoCondicaoWhere.and, "documento.seq_tipo_documento", GeneroCondicaoWhere.igual, String.valueOf(401), TipoCondicaoWhere.Numero);
    condicaoDoc.AdicionarCondicao(OperacaoCondicaoWhere.and, "documento.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(this.loginController.empresa.getSeqEmpresa()), TipoCondicaoWhere.Numero);
    
    condicaoParc.AdicionarCondicaoManual(" where (parceiro.seq_tipo_parceiro = 0 or parceiro.seq_tipo_parceiro = 641) and parceiro.seq_empresa = 61");
    
    this.listaParceiro = this.parceiroService.listarParceiroFiltro(condicaoParc);
    this.listaFormaPagamento = this.formaPagamentoService.listar(this.loginController.empresa.getSeqEmpresa(), "", Situacao.ATIVO);
    this.listaConta = this.contaService.listar(this.loginController.empresa.getSeqEmpresa(), "", Situacao.ATIVO);
    

    this.listaTodosDocumentos = this.documentoService.listarFiltro(condicaoDoc);
    for (Documento listaTodosDocumento : this.listaTodosDocumentos) {
      if ((listaTodosDocumento.getIdRevisao().longValue() == 0L) && (listaTodosDocumento.getIdComplementar().longValue() > 0L)) {
        listaTodosDocumento.setEstadoBM(" - Complementar nº".concat(listaTodosDocumento.getIdComplementar().toString()));
        this.listaDocumento.add(listaTodosDocumento);
      }
      if ((listaTodosDocumento.getIdRevisao().longValue() > 0L) && (listaTodosDocumento.getIdComplementar().longValue() == 0L)) {
        listaTodosDocumento.setEstadoBM(" - Revisado nº".concat(listaTodosDocumento.getIdRevisao().toString()));
        this.listaDocumento.add(listaTodosDocumento);
      }
      if ((listaTodosDocumento.getSequencia() == 0) && (listaTodosDocumento.getIdComplementar().longValue() == 0L) && (listaTodosDocumento.getIdRevisao().longValue() == 0L)) {
        this.listaDocumento.add(listaTodosDocumento);
      }
    }
  }
  

  public void salvar(int pTela)
  {
    String codigo = "";
    
    if (this.listaFinanceiroEquipamento.isEmpty()) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O Recibo precisa ter ao menos um equipamento locado.", ""));
      return;
    }
    
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
    
    if (this.financeiro.getSeqFinanceiro() == null)
    {
      this.financeiro.setOrigemLCM("8");
      this.financeiro = this.financeiroService.salvar(this.financeiro);
      
      codigo = this.financeiro.getSeqFinanceiro();
      

      this.financeiro.setSeqFinanceiro(null);
      this.financeiro.setOrigemLCM("0");
      this.financeiro.setOutrasInformacoes("Faturamento gerado a partir do RLBM nº " + codigo);
      this.financeiroService.salvar(this.financeiro);
      

      this.financeiro.setSeqFinanceiro(null);
      this.financeiro.setOrigemLCM("1");
      this.financeiro.setDescricao("Faturamento gerado a partir do RLBM nº " + codigo);
      this.financeiro.setOutrasInformacoes(null);
      this.financeiroService.salvar(this.financeiro);
    } else {
      this.financeiro.setOrigemLCM("8");
      this.financeiro = this.financeiroService.salvar(this.financeiro);
      codigo = this.financeiro.getSeqFinanceiro();
    }
    
    if (this.financeiro.getSeqDocumento() != null) {
      for (Documento doc : this.listaDocumento) {
        if (doc.getSeqDocumento().equals(this.financeiro.getSeqDocumento())) {
          String etapaAnterior = doc.getEtapa();
          doc.setSeqDocumentoEtapa("542");
          doc = this.documentoService.salvar(doc);
          

          DocumentoOcorrencia documentoOcorrencia = new DocumentoOcorrencia();
          documentoOcorrencia.setSeqDocumento(doc.getSeqDocumento());
          documentoOcorrencia.setTipo("Automática");
          documentoOcorrencia.setDescricao("Ocorrência de Mudança de Etapa <br/> Etapa Anterior: " + etapaAnterior + "<br> Etapa Posterior: Faturado.<br/>");
          documentoOcorrencia.setSeqUsuario(this.loginController.getUsuario().getSeqUsuario());
          this.documentoOcorrenciaService.salvar(documentoOcorrencia);
        }
      }
    }
    System.out.println("seq:" + codigo);
    for (FinanceiroEquipamento fe : this.listaFinanceiroEquipamento)
    {
      fe.setSeqFinanceiro(codigo);
      this.FinanceiroEquipamentoService.salvar(fe);
    }
    
    if (!this.listaFinanceiroEquipamentoDeletado.isEmpty()) {
      for (FinanceiroEquipamento fed : this.listaFinanceiroEquipamentoDeletado) {
        this.FinanceiroEquipamentoService.deletar(fed);
      }
    }
    this.tela = Integer.valueOf(pTela);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
  }
  
  public void novo()
  {
    this.financeiro = new Financeiro();
    
    this.documento = new Documento();
    this.listaFinanceiroEquipamento.clear();
    this.listaEquipamento.clear();
    
    this.financeiro.setSeqUsuario(this.loginController.usuario.getSeqUsuario());
    this.financeiro.setResponsavel(this.loginController.usuario.getUsuario());
    
    this.tela = Integer.valueOf(1);
  }
  


  public void listar()
  {
    ClausulaWhere condicao = new ClausulaWhere();
    
    condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "financeiro.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(this.loginController.getEmpresa().getSeqEmpresa()), TipoCondicaoWhere.Numero);
    condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.ORIGEM_LCM", GeneroCondicaoWhere.igual, String.valueOf("8"), TipoCondicaoWhere.Texto);
    
    if (isPorDataEmissao() == true) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.data_emissao", GeneroCondicaoWhere.MaiorIgual, this.dataEmissaoInicial, TipoCondicaoWhere.Data);
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.data_emissao", GeneroCondicaoWhere.MenorIgual, this.dataEmissaoFinal, TipoCondicaoWhere.Data);
    }
    
    if (isPorDataVencimento() == true) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.data_vencimento", GeneroCondicaoWhere.MaiorIgual, this.dataVencimentoInicial, TipoCondicaoWhere.Data);
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.data_vencimento", GeneroCondicaoWhere.MenorIgual, this.dataVencimentoFinal, TipoCondicaoWhere.Data);
    }
    
    if (this.seqParceiroSelecionado != null) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.seq_parceiro", GeneroCondicaoWhere.igual, String.valueOf(this.seqParceiroSelecionado), TipoCondicaoWhere.Numero);
    }
    if (this.seqContaSelecionada != null) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "financeiro.seq_conta", GeneroCondicaoWhere.igual, String.valueOf(this.seqContaSelecionada), TipoCondicaoWhere.Numero);
    }
    
    this.listaFinanceiro = this.financeiroService.listarFiltro(condicao);
  }
  
  public void cancelar() {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String dataCancelamento = formato.format(new Date());
    
    String msg = "'".concat(this.financeiro.getMotivoCancelamento()).concat("'. Por:").concat(this.loginController.getUsuario().getUsuario()).concat(". Data de Cancelamento:").concat(dataCancelamento);
    this.financeiro.setMotivoCancelamento(msg);
    this.financeiro.setEtapa("CANCELADO");
    this.financeiro = this.financeiroService.salvar(this.financeiro);
  }
  
  public void deletar()
  {
    System.out.println("APAGAR");
    if (this.financeiroService.deletar(this.financeiro)) {
      listar();
      this.financeiro = new Financeiro();
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
  

  public void selecionar(Financeiro pFinanceiro)
  {
    this.financeiro = ((Financeiro)this.financeiroService.listar(this.loginController.getUsuario().getSeqEmpresa(), pFinanceiro.getSeqFinanceiro()).get(0));
    this.financeiro.setValor(new BigDecimal(0));
    
    this.listaFinanceiroEquipamento = this.FinanceiroEquipamentoService.listar(this.financeiro.getSeqFinanceiro());
    for (FinanceiroEquipamento lfe : this.listaFinanceiroEquipamento) {
      this.financeiro.setValor(this.financeiro.getValor().add(lfe.getValor()));
      System.out.println(lfe.getNomeEquipamento() + lfe.getValor());
      System.out.println("---------------------");
    }
    this.listaEquipamento = this.equipamentoService.listarPorParceiro(this.loginController.empresa.getSeqEmpresa(), this.financeiro.getSeqParceiro(), Situacao.ATIVO);
    this.tela = Integer.valueOf(1);
  }
  



  public void mudarTela(Integer pTela)
  {
    this.financeiro = new Financeiro();
    this.tela = pTela;
  }
  
  public void selecionarDocumento() {
    if (this.financeiro.getSeqDocumento() != null) {
      for (Documento doc : this.listaDocumento) {
        if (doc.getSeqDocumento().equals(this.financeiro.getSeqDocumento())) {
          this.financeiro.setSeqParceiro(doc.getSeqParceiro());
          listarEquipamentos();
        }
      }
    }
  }
  
  public void listarEquipamentos() {
    if (this.financeiro.getSeqParceiro() != null) {
      this.listaEquipamento = this.equipamentoService.listarPorParceiro(this.loginController.empresa.getSeqEmpresa(), this.financeiro.getSeqParceiro(), Situacao.ATIVO);
    }
  }
  
  public void selecionarEquipamento(FinanceiroEquipamento pFinanceiroEquipamento) {
    this.financeiroEquipamento = pFinanceiroEquipamento;
    this.listaFinanceiroEquipamento.remove(pFinanceiroEquipamento);
    this.financeiro.setValor(this.financeiro.getValor().subtract(pFinanceiroEquipamento.getValor()));
  }
  
  public void salvarEquipamento()
  {
    for (Equipamento e : this.listaEquipamento) {
      if (e.getSeqEquipamento().equals(this.financeiroEquipamento.getSeqEquipamento())) {
        this.financeiroEquipamento.setNomeEquipamento(e.getNome());
      }
    }
    
    this.listaFinanceiroEquipamento.add(this.financeiroEquipamento);
    this.financeiro.setValor(new BigDecimal(0));
    for (FinanceiroEquipamento lfe : this.listaFinanceiroEquipamento) {
      this.financeiro.setValor(this.financeiro.getValor().add(lfe.getValor()));
    }
    
    this.financeiroEquipamento = new FinanceiroEquipamento();
  }
  
  public void removerEquipamento(FinanceiroEquipamento pFinanceiroEquipamento) {
    if (pFinanceiroEquipamento.getSeqFinanceiroEquipamento() != null) {
      this.listaFinanceiroEquipamentoDeletado.add(pFinanceiroEquipamento);
    }
    this.listaFinanceiroEquipamento.remove(pFinanceiroEquipamento);
    
    this.financeiro.setValor(this.financeiro.getValor().subtract(pFinanceiroEquipamento.getValor()));
  }
  
  public void imprimir() throws IOException, JRException {
    Conexao conexao = new Conexao();
    Connection conn = Conexao.getConnection();
    
    if (this.financeiro.getValor() == null) {
      this.financeiro.setValor(new BigDecimal(0));
    }
    
    CurrencyWriter cw = CurrencyWriter.getInstance();
    Date data = new Date(System.currentTimeMillis());
    SimpleDateFormat formatarDate = new SimpleDateFormat("MMMMM' 'yyyy'.'");
    

    HashMap parametro = new HashMap();
    parametro.put("seqFinanceiro", this.financeiro.getSeqFinanceiro());
    parametro.put("valorPorExtenso", StringUtils.capitalize(cw.write(this.financeiro.getValor())));
    


    FacesContext facesContext = FacesContext.getCurrentInstance();
    facesContext.responseComplete();
    ServletContext scontext = (ServletContext)facesContext.getExternalContext().getContext();
    
    JasperPrint jasperPrint = new JasperPrint();
    
    jasperPrint = JasperFillManager.fillReport(scontext.getRealPath("/relatorio/aws/RLBM/RLBM.jasper"), parametro, conn);
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    JRPdfExporter exporter = new JRPdfExporter();
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
    exporter.exportReport();
    byte[] bytes = baos.toByteArray();
    
    if ((bytes != null) && (bytes.length > 0)) {
      HttpServletResponse response = (HttpServletResponse)facesContext.getExternalContext().getResponse();
      response.setContentType("application/pdf");
      response.setHeader("Content-disposition", "inline; filename=\"RLBM.pdf\"");
      response.setContentLength(bytes.length);
      ServletOutputStream outputStream = response.getOutputStream();
      outputStream.write(bytes, 0, bytes.length);
      outputStream.flush();
      outputStream.close();
    }
  }
  
  public void limiteData() {
    if ((this.financeiro.getDataVencimento() != null) && 
      (this.financeiro.getDataEmissao().after(this.financeiro.getDataVencimento()))) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data de Emissão não pode ser superior a Data de Vencimento.", ""));
      return;
    }
    
    if ((this.financeiro.getDataPeriodoInicialRLBM() != null) && 
      (this.financeiro.getDataPeriodoInicialRLBM().after(this.financeiro.getDataPeriodoFinalRLBM()))) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data de Período Inicial não pode ser superior a Data de Período Final.", ""));
      return;
    }
  }
  



  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
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
  
  public Financeiro getFinanceiroQuitacao() {
    return this.financeiroQuitacao;
  }
  
  public void setFinanceiroQuitacao(Financeiro financeiroQuitacao) {
    this.financeiroQuitacao = financeiroQuitacao;
  }
  
  public List<Financeiro> getListaFinanceiro() {
    return this.listaFinanceiro;
  }
  
  public void setListaFinanceiro(List<Financeiro> listaFinanceiro) {
    this.listaFinanceiro = listaFinanceiro;
  }
  
  public Parceiro getParceiro() {
    return this.parceiro;
  }
  
  public void setParceiro(Parceiro parceiro) {
    this.parceiro = parceiro;
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
  
  public List<Documento> getListaTodosDocumentos() {
    return this.listaTodosDocumentos;
  }
  
  public void setListaTodosDocumentos(List<Documento> listaTodosDocumentos) {
    this.listaTodosDocumentos = listaTodosDocumentos;
  }
  
  public DocumentoService getDocumentoService() {
    return this.documentoService;
  }
  
  public void setDocumentoService(DocumentoService documentoService) {
    this.documentoService = documentoService;
  }
  
  public boolean isPorDataEmissao() {
    return this.porDataEmissao;
  }
  
  public void setPorDataEmissao(boolean porDataEmissao) {
    this.porDataEmissao = porDataEmissao;
  }
  
  public String getDataEmissaoInicial() {
    return this.dataEmissaoInicial;
  }
  
  public void setDataEmissaoInicial(String dataEmissaoInicial) {
    this.dataEmissaoInicial = dataEmissaoInicial;
  }
  
  public String getDataEmissaoFinal() {
    return this.dataEmissaoFinal;
  }
  
  public void setDataEmissaoFinal(String dataEmissaoFinal) {
    this.dataEmissaoFinal = dataEmissaoFinal;
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
  
  public Integer getTela() {
    return this.tela;
  }
  
  public void setTela(Integer tela) {
    this.tela = tela;
  }
  
  public List<FormaPagamento> getListaFormaPagamento() {
    return this.listaFormaPagamento;
  }
  
  public void setListaFormaPagamento(List<FormaPagamento> listaFormaPagamento) {
    this.listaFormaPagamento = listaFormaPagamento;
  }
  
  public FormaPagamentoService getFormaPagamentoService() {
    return this.formaPagamentoService;
  }
  
  public void setFormaPagamentoService(FormaPagamentoService formaPagamentoService) {
    this.formaPagamentoService = formaPagamentoService;
  }
  
  public List<Equipamento> getListaEquipamento() {
    return this.listaEquipamento;
  }
  
  public void setListaEquipamento(List<Equipamento> listaEquipamento) {
    this.listaEquipamento = listaEquipamento;
  }
  
  public EquipamentoService getEquipamentoService() {
    return this.equipamentoService;
  }
  
  public void setEquipamentoService(EquipamentoService equipamentoService) {
    this.equipamentoService = equipamentoService;
  }
  
  public FinanceiroEquipamento getFinanceiroEquipamento() {
    return this.financeiroEquipamento;
  }
  
  public void setFinanceiroEquipamento(FinanceiroEquipamento financeiroEquipamento) {
    this.financeiroEquipamento = financeiroEquipamento;
  }
  
  public List<FinanceiroEquipamento> getListaFinanceiroEquipamento() {
    return this.listaFinanceiroEquipamento;
  }
  
  public void setListaFinanceiroEquipamento(List<FinanceiroEquipamento> listaFinanceiroEquipamento) {
    this.listaFinanceiroEquipamento = listaFinanceiroEquipamento;
  }
  
  public FinanceiroEquipamentoService getFinanceiroEquipamentoService() {
    return this.FinanceiroEquipamentoService;
  }
  
  public void setFinanceiroEquipamentoService(FinanceiroEquipamentoService FinanceiroEquipamentoService) {
    this.FinanceiroEquipamentoService = FinanceiroEquipamentoService;
  }
  
  public List<FinanceiroEquipamento> getListaFinanceiroEquipamentoDeletado() {
    return this.listaFinanceiroEquipamentoDeletado;
  }
  
  public void setListaFinanceiroEquipamentoDeletado(List<FinanceiroEquipamento> listaFinanceiroEquipamentoDeletado) {
    this.listaFinanceiroEquipamentoDeletado = listaFinanceiroEquipamentoDeletado;
  }
  
  public String getSeqParceiroSelecionado() {
    return this.seqParceiroSelecionado;
  }
  
  public void setSeqParceiroSelecionado(String seqParceiroSelecionado) {
    this.seqParceiroSelecionado = seqParceiroSelecionado;
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
  
  public String getSeqContaSelecionada() {
    return this.seqContaSelecionada;
  }
  
  public void setSeqContaSelecionada(String seqContaSelecionada) {
    this.seqContaSelecionada = seqContaSelecionada;
  }
  
  public DocumentoOcorrenciaService getDocumentoOcorrenciaService() {
    return this.documentoOcorrenciaService;
  }
  
  public void setDocumentoOcorrenciaService(DocumentoOcorrenciaService documentoOcorrenciaService) {
    this.documentoOcorrenciaService = documentoOcorrenciaService;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\RLBMController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */