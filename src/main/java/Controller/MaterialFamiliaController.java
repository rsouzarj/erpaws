package Controller;

import Empresa.Empresa;
import MaterialFamilia.MaterialFamilia;
import MaterialFamilia.MaterialFamiliaService;
import Util.Situacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;








@ManagedBean(name="materialFamiliaController")
@ViewScoped
public class MaterialFamiliaController
{
  @ManagedProperty("#{loginController}")
  protected LoginController loginController;
  MaterialFamiliaService materialFamiliaService = new MaterialFamiliaService();
  MaterialFamilia materialFamilia = new MaterialFamilia();
  List<MaterialFamilia> listaMaterialFamilia = new ArrayList();
  String pesquisa;
  Integer tela = Integer.valueOf(0);
  
  public void salvar(int pTela) {
    this.materialFamilia.setSeqEmpresa(this.loginController.getEmpresa().getSeqEmpresa());
    this.materialFamilia.setDataCadastro(new Date());
    this.materialFamilia = this.materialFamiliaService.salvar(this.materialFamilia);
    int idx = 0;
    idx = this.listaMaterialFamilia.indexOf(this.materialFamilia);
    if (idx == -1) {
      this.listaMaterialFamilia.add(this.materialFamilia);
    } else if (this.listaMaterialFamilia.size() > 0) {
      this.listaMaterialFamilia.remove(this.materialFamilia);
      this.listaMaterialFamilia.add(idx, this.materialFamilia);
    } else {
      this.listaMaterialFamilia.add(idx, this.materialFamilia);
    }
    
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
    this.tela = Integer.valueOf(pTela);
  }
  
  public void novo() {
    this.materialFamilia = new MaterialFamilia();
    this.tela = Integer.valueOf(1);
  }
  
  public void listar() {
    this.listaMaterialFamilia = this.materialFamiliaService.listar(this.loginController.getEmpresa().getSeqEmpresa(), this.pesquisa, Situacao.TODOS);
  }
  
  public void deletar() {
    if (this.materialFamiliaService.deletar(this.materialFamilia)) {
      listar();
      this.materialFamilia = new MaterialFamilia();
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
  
  public void selecionar(MaterialFamilia pMaterialFamilia) {
    this.materialFamilia = pMaterialFamilia;
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
  
  public MaterialFamiliaService getMaterialFamiliaService() {
    return this.materialFamiliaService;
  }
  
  public void setMaterialFamiliaService(MaterialFamiliaService materialFamiliaService) {
    this.materialFamiliaService = materialFamiliaService;
  }
  
  public MaterialFamilia getMaterialFamilia() {
    return this.materialFamilia;
  }
  
  public void setMaterialFamilia(MaterialFamilia materialFamilia) {
    this.materialFamilia = materialFamilia;
  }
  
  public List<MaterialFamilia> getListaMaterialFamilia() {
    return this.listaMaterialFamilia;
  }
  
  public void setListaMaterialFamilia(List<MaterialFamilia> listaMaterialFamilia) {
    this.listaMaterialFamilia = listaMaterialFamilia;
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


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Controller\MaterialFamiliaController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */