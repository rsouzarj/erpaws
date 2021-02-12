package Controller;

import Empresa.Empresa;
import Material.Material;
import Material.MaterialService;
import MaterialFamilia.MaterialFamilia;
import MaterialFamilia.MaterialFamiliaService;
import MaterialPreco.MaterialPreco;
import MaterialPreco.MaterialPrecoService;
import Usuario.Usuario;
import Util.Situacao;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;






@ManagedBean(name="materialController")
@ViewScoped
public class MaterialController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  MaterialService materialService = new MaterialService();
  Material material = new Material();
  List<Material> listaMaterial = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  MaterialPrecoService materialPrecoService = new MaterialPrecoService();
  MaterialPreco materialPreco = new MaterialPreco();
  List<MaterialPreco> listaMaterialPreco = new ArrayList();
  
  MaterialFamiliaService materialFamiliaService = new MaterialFamiliaService();
  List<MaterialFamilia> listaMaterialFamilia = new ArrayList();
  

  public void iniciar()
  {
    if ((this.loginController.usuario.getAcComServico() == null) || (this.loginController.usuario.getAcComServico().equals("-1"))) {
      this.loginController.mudarPagina("/organizacional/acessonegado.jsf");
      return;
    }
    
    this.listaMaterialFamilia = this.materialFamiliaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), "", Situacao.ATIVO);
  }
  
  public void salvar(int pTela) {
    this.material.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.material.setDataCadastro(new Date());
    this.material.setCodigo(".");
    this.material = this.materialService.salvar(this.material);
    this.materialPrecoService.salvar(this.listaMaterialPreco);
    int idx = 0;
    idx = this.listaMaterial.indexOf(this.material);
    
    System.out.println("IDX: " + idx);
    if (idx == -1) {
      this.listaMaterial.add(this.material);
    } else if (this.listaMaterial.size() > 0) {
      this.listaMaterial.remove(this.material);
      this.listaMaterial.add(idx, this.material);
    } else {
      this.listaMaterial.add(idx, this.material);
    }
    
    this.listaMaterialPreco = this.materialPrecoService.listarPorMaterial(this.material, Situacao.TODOS);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.material = new Material();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaMaterial = this.materialService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa.toUpperCase(), Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.materialService.deletar(this.material)) {
      listar();
      this.material = new Material();
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
  
  public void selecionar(Material pMaterial) {
    this.material = pMaterial;
    this.listaMaterialPreco = this.materialPrecoService.listarPorMaterial(pMaterial, Situacao.TODOS);
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
  
  public MaterialService getMaterialService() {
    return this.materialService;
  }
  
  public void setMaterialService(MaterialService materialService) {
    this.materialService = materialService;
  }
  
  public Material getMaterial() {
    return this.material;
  }
  
  public void setMaterial(Material material) {
    this.material = material;
  }
  
  public List<Material> getListaMaterial() {
    return this.listaMaterial;
  }
  
  public void setListaMaterial(List<Material> listaMaterial) {
    this.listaMaterial = listaMaterial;
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
  
  public MaterialPrecoService getMaterialPrecoService() {
    return this.materialPrecoService;
  }
  
  public void setMaterialPrecoService(MaterialPrecoService materialPrecoService) {
    this.materialPrecoService = materialPrecoService;
  }
  
  public MaterialPreco getMaterialPreco() {
    return this.materialPreco;
  }
  
  public void setMaterialPreco(MaterialPreco materialPreco) {
    this.materialPreco = materialPreco;
  }
  
  public List<MaterialPreco> getListaMaterialPreco() {
    return this.listaMaterialPreco;
  }
  
  public void setListaMaterialPreco(List<MaterialPreco> listaMaterialPreco) {
    this.listaMaterialPreco = listaMaterialPreco;
  }
  
  public MaterialFamiliaService getMaterialFamiliaService() {
    return this.materialFamiliaService;
  }
  
  public void setMaterialFamiliaService(MaterialFamiliaService materialFamiliaService) {
    this.materialFamiliaService = materialFamiliaService;
  }
  
  public List<MaterialFamilia> getListaMaterialFamilia() {
    return this.listaMaterialFamilia;
  }
  
  public void setListaMaterialFamilia(List<MaterialFamilia> listaMaterialFamilia) {
    this.listaMaterialFamilia = listaMaterialFamilia;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\MaterialController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */