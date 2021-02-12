package Controller;

import ClausulaSQL.ClausulaWhere;
import ClausulaSQL.GeneroCondicaoWhere;
import ClausulaSQL.OperacaoCondicaoWhere;
import ClausulaSQL.TipoCondicaoWhere;
import Empresa.Empresa;
import Parceiro.Parceiro;
import Parceiro.ParceiroService;
import TipoParceiro.TipoParceiro;
import TipoParceiro.TipoParceiroService;
import Usuario.Usuario;
import Util.Situacao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;








@ManagedBean(name="painelParceiroController")
@ViewScoped
public class PainelParceiroController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  ParceiroService parceiroService = new ParceiroService();
  List<Parceiro> listaParceiro = new ArrayList();
  
  TipoParceiroService tipoParceiroService = new TipoParceiroService();
  List<TipoParceiro> listaTipoParceiro = new ArrayList();
  
  Long seqTipoParceiroSelecionado;
  
  boolean bTipoParceiro = true;
  boolean bUf = true;
  
  public void iniciar()
  {
    if ((this.loginController.usuario.getAcRelParceiro() == null) || (this.loginController.usuario.getAcRelParceiro().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    this.listaTipoParceiro = this.tipoParceiroService.listar(this.loginController.getEmpresa().getSeqEmpresa(), Situacao.TODOS);
  }
  
  public void filtrar() {
    ClausulaWhere condicao = new ClausulaWhere();
    
    condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "parceiro.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(this.loginController.getEmpresa().getSeqEmpresa()), TipoCondicaoWhere.Numero);
    
    if (this.seqTipoParceiroSelecionado != null) {
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "parceiro.seq_tipo_parceiro", GeneroCondicaoWhere.igual, String.valueOf(this.seqTipoParceiroSelecionado), TipoCondicaoWhere.Numero);
    }
    
    this.listaParceiro = this.parceiroService.listarParceiroFiltro(condicao);
  }
  
  public void selecionarParceiro(Parceiro pParceiro)
  {
    this.loginController.mudarPagina("/parceiro/parceiro.jsf?id=" + pParceiro.getSeqParceiro());
  }
  

  public LoginController getLoginController()
  {
    return this.loginController;
  }
  
  public void setLoginController(LoginController loginController) {
    this.loginController = loginController;
  }
  
  public ParceiroService getParceiroService() {
    return this.parceiroService;
  }
  
  public void setParceiroService(ParceiroService parceiroService) {
    this.parceiroService = parceiroService;
  }
  
  public List<Parceiro> getListaParceiro() {
    return this.listaParceiro;
  }
  
  public void setListaParceiro(List<Parceiro> listaParceiro) {
    this.listaParceiro = listaParceiro;
  }
  
  public TipoParceiroService getTipoParceiroService() {
    return this.tipoParceiroService;
  }
  
  public void setTipoParceiroService(TipoParceiroService tipoParceiroService) {
    this.tipoParceiroService = tipoParceiroService;
  }
  
  public List<TipoParceiro> getListaTipoParceiro() {
    return this.listaTipoParceiro;
  }
  
  public void setListaTipoParceiro(List<TipoParceiro> listaTipoParceiro) {
    this.listaTipoParceiro = listaTipoParceiro;
  }
  
  public Long getSeqTipoParceiroSelecionado() {
    return this.seqTipoParceiroSelecionado;
  }
  
  public void setSeqTipoParceiroSelecionado(Long seqTipoParceiroSelecionado) {
    this.seqTipoParceiroSelecionado = seqTipoParceiroSelecionado;
  }
  
  public boolean isbTipoParceiro() {
    return this.bTipoParceiro;
  }
  
  public void setbTipoParceiro(boolean bTipoParceiro) {
    this.bTipoParceiro = bTipoParceiro;
  }
  
  public boolean isbUf() {
    return this.bUf;
  }
  
  public void setbUf(boolean bUf) {
    this.bUf = bUf;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\PainelParceiroController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */