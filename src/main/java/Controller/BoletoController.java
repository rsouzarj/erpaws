package Controller;

import Conta.Conta;
import Conta.ContaService;
import Documento.Documento;
import Documento.DocumentoService;
import DocumentoItemFinanceiro.DocumentoItemFinanceiro;
import DocumentoItemFinanceiro.DocumentoItemFinanceiroService;
import Empresa.Empresa;
import Empresa.EmpresaService;
import Parceiro.Parceiro;
import Parceiro.ParceiroService;
import Util.Utilitario;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;









@ManagedBean(name="boletoController")
@ViewScoped
public class BoletoController
{
  String seqDocumento;
  
  public void imprimirBoleto()
  {
    BoletoController cobranca = new BoletoController();
    Boleto boleto = cobranca.gerarBoleto(this.seqDocumento);
    
    BoletoViewer boletoViewer = new BoletoViewer(boleto);
    byte[] pdfAsBytes = boletoViewer.getPdfAsByteArray();
    
    HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    try {
      response.setContentType("application/pdf");
      response.setHeader("Content-Disposition", "inline; filename=boleto.pdf");
      OutputStream output = response.getOutputStream();
      output.write(pdfAsBytes);
      response.flushBuffer();
      FacesContext.getCurrentInstance().responseComplete();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public Boleto gerarBoleto(String pSeqDocumento)
  {
    Utilitario util = new Utilitario();
    
    boolean contraApresentacao = false;
    
    DocumentoService documentoService = new DocumentoService();
    Documento documento = documentoService.buscarPorID("64", pSeqDocumento);
    
    DocumentoItemFinanceiroService documentoItemFinanceiroService = new DocumentoItemFinanceiroService();
    DocumentoItemFinanceiro documentoItemFinanceiro = documentoItemFinanceiroService.buscar(pSeqDocumento);
    
    EmpresaService empresaService = new EmpresaService();
    Empresa empresa = empresaService.buscarEmpresaPorID(documentoItemFinanceiro.getSeqEmpresa());
    
    ParceiroService parceiroService = new ParceiroService();
    Parceiro parceiro = parceiroService.buscar("64", documento.getCodigo());
    
    ContaService contaService = new ContaService();
    Conta conta = contaService.buscar(documentoItemFinanceiro.getSeqConta());
    





    Cedente cedente = new Cedente(empresa.getRazaoSocial(), empresa.getCnpj());
    



    Sacado sacado = new Sacado(parceiro.getCodigo() + " - " + parceiro.getNome() + " ");
    
    Endereco enderecoSac = new Endereco();
    

    enderecoSac.setCep(new CEP(parceiro.getCep()));
    enderecoSac.setLogradouro(parceiro.getCidade() + " - " + parceiro.getUf());
    enderecoSac.setBairro(parceiro.getLogradouro());
    enderecoSac.setLocalidade("  ," + parceiro.getNumero() + " " + parceiro.getComplemento() + " - " + parceiro.getBairro());
    
    sacado.addEndereco(enderecoSac);
    





    ContaBancaria contaBancaria = null;
    if (conta.getBanco().equals("Bradesco")) {
      contaBancaria = new ContaBancaria(BancosSuportados.BANCO_BRADESCO.create());
    }
    











    contaBancaria.setNumeroDaConta(new NumeroDaConta(Integer.valueOf(conta.getCodigoCedente()), conta.getDvCedente()));
    contaBancaria.setCarteira(new Carteira(Integer.valueOf(conta.getCarteira())));
    
    contaBancaria.setAgencia(new Agencia(Integer.valueOf(conta.getAgencia()), conta.getAgenciaDv()));
    
    Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
    titulo.setNumeroDoDocumento(String.valueOf(documento.getSeqDocumento()));
    
    titulo.setValor(documentoItemFinanceiro.getValor());
    titulo.setDataDoDocumento(new Date());
    
    titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
    
    titulo.setDesconto(BigDecimal.ZERO);
    titulo.setDeducao(BigDecimal.ZERO);
    titulo.setMora(BigDecimal.ZERO);
    titulo.setAcrecimo(BigDecimal.ZERO);
    titulo.setValorCobrado(BigDecimal.ZERO);
    
    titulo.setDataDoVencimento(documento.getDataPrevisaoConclusao());
    







    Boleto boleto = null;
    if (conta.getBanco().equals("Bradesco")) {
      titulo.setNossoNumero(String.format("%011d", new Object[] { documento.getSeqDocumento() }));
      titulo.setDigitoDoNossoNumero(util.BRADESCOcalcularDigitoVerificadorNossoNumero(String.format("%011d", new Object[] { documento.getSeqDocumento() })));
      boleto = new Boleto(titulo);
    }
   
    if (contraApresentacao == true) {
      boleto.addTextosExtras("txtFcDataVencimentoNovo", "CONTRA-APRESENTAÇÃO");
      boleto.addTextosExtras("txtFcDataVencimentoNovo2", "CONTRA-APRESENTAÇÃO");
      boleto.addTextosExtras("txtFcValorDocumento", "");
      boleto.addTextosExtras("txtFcDescontoAbatimento", "");
      boleto.addTextosExtras("txtFcMoraMulta", "");
      boleto.addTextosExtras("txtFcOutroAcrescimo", "");
      boleto.addTextosExtras("txtFcOutraDeducao", "");
      boleto.addTextosExtras("txtFcValorCobrado", "");
    }
    else {
      SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
      String dataVencimento = formataData.format(documento.getDataPrevisaoConclusao());
      
      boleto.addTextosExtras("txtFcDataVencimentoNovo", dataVencimento);
      boleto.addTextosExtras("txtFcDataVencimentoNovo2", dataVencimento);
    }
    
    boleto.setLocalPagamento("Pagável preferencialmente na Rede " + conta.getBanco().toUpperCase() + ", ou em todas as redes bancárias");
    
    if (contraApresentacao == true) {
      boleto.setInstrucaoAoSacado("Trata-se de um boleto contra-apresentação, que poderá ser pago em qualquer data, mesmo após o vencimento.");
      boleto.setInstrucao1("Sr. Caixa, trata-se de uma doação. Pode ser recolhido mesmo após o vencimento");
      boleto.setInstrucao2("em qualquer banco, isento de juros e multas");
    }
    else
    {
      boleto.setInstrucaoAoSacado("Sr. Caixa, não receber após o vencimento!");
      boleto.setInstrucao1("Sr. Caixa, não receber após o vencimento!");
    }
    





    return boleto;
  }
  
  public String getSeqDocumento() {
    return this.seqDocumento;
  }
  
  public void setSeqDocumento(String seqDocumento) {
    this.seqDocumento = seqDocumento;
  }
}

