package Controller;

import Empresa.Empresa;
import PlanoItem.PlanoItem;
import PlanoItem.PlanoItemService;
import Util.Situacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "planoItemController")
@ViewScoped
public class PlanoItemController {
	@ManagedProperty("#{loginController}")
	protected LoginController loginController;
	PlanoItemService planoItemService = new PlanoItemService();
	PlanoItem planoItem = new PlanoItem();
	PlanoItem planoItemItens = new PlanoItem();
	List<PlanoItem> listaPlanoItem = new ArrayList();
	List<PlanoItem> listaNomePlanoItem = new ArrayList();
	String pesquisa = "";
	Integer tela = Integer.valueOf(0);

	public void iniciar() {
	}

	public void salvar(int pTela) {
		List<PlanoItem> listaAtual = new ArrayList();

		for (PlanoItem nomePlano : this.listaNomePlanoItem) {
			nomePlano.setIdentificacaoLista(this.planoItem.getIdentificacaoLista());
			nomePlano.setSituacao(this.planoItem.getSituacao());
			nomePlano.setSeqEmpresa(this.loginController.empresa.getSeqEmpresa());
			nomePlano = this.planoItemService.salvar(nomePlano);
			listaAtual.add(nomePlano);
		}

		if (this.planoItem.getSeqPlanoItem() != null) {
			deletarItensRemovidos(listaAtual);
		}
		listar();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro armazenado com sucesso.", ""));
		this.tela = Integer.valueOf(pTela);
	}

	public void deletarItensRemovidos(List<PlanoItem> listaAtual) {
		List<PlanoItem> listaAntiga = this.planoItemService.listar(this.loginController.getEmpresa().getSeqEmpresa(),
				this.planoItem.getIdentificacaoLista(), Situacao.TODOS);

		for (PlanoItem antiga : listaAntiga) {
			boolean encontrou = false;
			for (PlanoItem atual : listaAtual) {
				if (antiga.getSeqPlanoItem().equals(atual.getSeqPlanoItem())) {
					encontrou = true;
				}
			}
			if (!encontrou) {
				this.planoItemService.deletar(antiga);
			}
		}
	}

	public void novo() {
		this.planoItem = new PlanoItem();
		this.tela = Integer.valueOf(1);
	}

	public void listar() {
		this.listaPlanoItem = this.planoItemService.listar(this.loginController.getEmpresa().getSeqEmpresa(),
				this.pesquisa, Situacao.TODOS);
		removerRepeticao();
	}

	public void removerRepeticao() {
		List<PlanoItem> lista = new ArrayList();
		int count = 0;

		for (Iterator localIterator1 = this.listaPlanoItem.iterator(); localIterator1.hasNext();) {
			PlanoItem lista1 = (PlanoItem) localIterator1.next();
			for (PlanoItem lista2 : this.listaPlanoItem) {
				if (count == 0) {
					if (lista1.getIdentificacaoLista().equals(lista2.getIdentificacaoLista())) {
						count++;
						if (!lista.contains(lista2)) {
							lista.add(lista2);
						}
					}
				} else if (lista1.getIdentificacaoLista().equals(lista2.getIdentificacaoLista())) {
					count++;
				} else {
					count = 0;
				}
			}
		}
		PlanoItem lista1;
		this.listaPlanoItem = lista;
	}

	public void deletar() {
		if (this.planoItemService.deletar(this.planoItem)) {
			listar();
			this.planoItem = new PlanoItem();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado com sucesso.", ""));
			this.tela = Integer.valueOf(0);
			listar();
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao excluir registro.", ""));
		}
	}

	public void fecharTela() throws IOException {
		this.loginController.mudarPagina("/principal/ principal.jsf");
	}

	public void selecionar(PlanoItem pPlanoItem) {
		this.listaNomePlanoItem.clear();
		this.listaPlanoItem = this.planoItemService.listar(this.loginController.getEmpresa().getSeqEmpresa(),
				pPlanoItem.getIdentificacaoLista(), Situacao.TODOS);

		for (PlanoItem lista : this.listaPlanoItem) {
			this.listaNomePlanoItem.add(lista);
		}

		this.planoItem = pPlanoItem;
		this.tela = Integer.valueOf(1);
	}

	public void mudarTela(Integer pTela) {
		listar();
		this.tela = pTela;
	}

	public void salvarPlanoItem() {
		this.listaNomePlanoItem.add(this.planoItemItens);
		this.planoItemItens = new PlanoItem();
	}

	public void selecionarPlanoItem(PlanoItem pPlanoItem) {
		this.planoItemItens = pPlanoItem;

		this.listaNomePlanoItem.remove(pPlanoItem);
	}

	public void removerPlanoItem(PlanoItem pPlanoItem) {
		this.listaNomePlanoItem.remove(pPlanoItem);
	}

	public LoginController getLoginController() {
		return this.loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public PlanoItemService getPlanoItemService() {
		return this.planoItemService;
	}

	public void setPlanoItemService(PlanoItemService planoItemService) {
		this.planoItemService = planoItemService;
	}

	public PlanoItem getPlanoItem() {
		return this.planoItem;
	}

	public void setPlanoItem(PlanoItem planoItem) {
		this.planoItem = planoItem;
	}

	public List<PlanoItem> getListaPlanoItem() {
		return this.listaPlanoItem;
	}

	public void setListaPlanoItem(List<PlanoItem> listaPlanoItem) {
		this.listaPlanoItem = listaPlanoItem;
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

	public PlanoItem getPlanoItemItens() {
		return this.planoItemItens;
	}

	public void setPlanoItemItens(PlanoItem planoItemItens) {
		this.planoItemItens = planoItemItens;
	}

	public List<PlanoItem> getListaNomePlanoItem() {
		return this.listaNomePlanoItem;
	}

	public void setListaNomePlanoItem(List<PlanoItem> listaNomePlanoItem) {
		this.listaNomePlanoItem = listaNomePlanoItem;
	}
}

/*
 * Location: C:\Users\diogo\Documents\workspace\others\prod
 * erp\deploy\erp3.war!\WEB-INF\classes\Controller\PlanoItemController.class
 * Java compiler version: 7 (51.0) JD-Core Version: 0.7.1
 */