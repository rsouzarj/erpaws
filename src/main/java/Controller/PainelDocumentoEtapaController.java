package Controller;

import Documento.Documento;
import Documento.DocumentoService;
import DocumentoEtapa.DocumentoEtapa;
import DocumentoEtapa.DocumentoEtapaService;
import Equipamento.Equipamento;
import Equipamento.EquipamentoService;
import TipoDocumento.TipoDocumento;
import TipoDocumento.TipoDocumentoService;
import Util.Situacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "processoPainelController")
@ViewScoped
public class PainelDocumentoEtapaController {
	@ManagedProperty("#{loginController}")
	protected LoginController loginController;
	List<Documento> listaDocumento = new ArrayList();
	List<Documento> listaDocumentoFiltrado = new ArrayList();
	DocumentoService processoService = new DocumentoService();

	List<DocumentoEtapa> listaDocumentoEtapa = new ArrayList();
	DocumentoEtapaService processoEtapaService = new DocumentoEtapaService();
	TipoDocumentoService tipoDocumentoService = new TipoDocumentoService();
	TipoDocumento tipoDocumento = new TipoDocumento();
	String id;
	String equipamentos = "";

	List<Equipamento> listaEquipamento = new ArrayList();
	EquipamentoService equipamentoService = new EquipamentoService();

	public PainelDocumentoEtapaController() {
		this.id = "";
	}

	public void listarEtapas() {
		this.listaDocumentoEtapa = this.processoEtapaService.listarPorTipoDocumento(this.id, Situacao.ATIVO);
		this.tipoDocumento = this.tipoDocumentoService.buscarPorId(this.id);
		listarDocumentos((DocumentoEtapa) this.listaDocumentoEtapa.get(0));
                
	}

	public void listarDocumentos(DocumentoEtapa pDocumentoEtapa) {
		
            
                switch (this.id) {
		case "301":
			this.listaDocumento = this.processoService.listarPorEtapaOS(pDocumentoEtapa.getSeqDocumentoEtapa());
			/*filtrarEquipamentos();
			removerRepeticao();*/
			break;
		case "221":
			this.listaDocumento = this.processoService.listarPorEtapaOS(pDocumentoEtapa.getSeqDocumentoEtapa());
			/*filtrarEquipamentos();
			removerRepeticao();*/
			break;
		case "282":
			this.listaDocumento = this.processoService.listarPorEtapaOS(pDocumentoEtapa.getSeqDocumentoEtapa());
			/*filtrarEmbarcacao();
			removerRepeticao();*/
			break;
		case "381":
			this.listaDocumento = this.processoService.listarPorEtapaOC(pDocumentoEtapa.getSeqDocumentoEtapa());
			break;
		case "401":
			this.listaDocumento = this.processoService.listarPorEtapa(pDocumentoEtapa.getSeqDocumentoEtapa());
			removerRepeticaoSeq();
			break;
		default:
			this.listaDocumento = this.processoService.listarPorEtapa(pDocumentoEtapa.getSeqDocumentoEtapa());
		}
	}

	public void filtrarEquipamentos() {
		int count = 0;

		for (Documento lista2 : this.listaDocumento)
			if (count == 0) {
				if (lista2.getEquipamentoNome() != null) {
					this.equipamentos = lista2.getEquipamentoNome();
					lista2.setEquipamentoNome(this.equipamentos);
				}
				count++;
			} else {
				if (lista2.getEquipamentoNome() != null) {
					this.equipamentos = this.equipamentos.concat(", ").concat(lista2.getEquipamentoNome());
					lista2.setEquipamentoNome(this.equipamentos);
				}
				count++;
			}
	}

	public void filtrarEmbarcacao() {
		int count = 0;

		for (Iterator localIterator1 = this.listaDocumento.iterator(); localIterator1.hasNext();) {
			Documento lista = (Documento) localIterator1.next();
			for (Documento lista2 : this.listaDocumento)
				if (lista.getSeqDocumento().equals(lista2.getSeqDocumento())) {
					if (count == 0) {
						if (lista.getNvEmbarcacaoNome() != null) {
							this.equipamentos = lista2.getNvEmbarcacaoNome();
							lista.setNvEmbarcacaoNome(this.equipamentos);
						}
						count++;
					} else {
						if (lista.getNvEmbarcacaoNome() != null) {
							this.equipamentos.concat(", ").concat(lista2.getNvEmbarcacaoNome());
							lista.setNvEmbarcacaoNome(this.equipamentos);
						}
						count++;
					}
				} else {
					count = 0;
					this.equipamentos = "";
				}
		}
		Documento lista;
	}

	public void removerRepeticao() {
		List<Documento> lista = new ArrayList();
		int count = 0;

		for (Iterator localIterator1 = this.listaDocumento.iterator(); localIterator1.hasNext();) {
			Documento lista1 = (Documento) localIterator1.next();
			for (Documento lista2 : this.listaDocumento) {
				if (count == 0) {
					if (lista1.getCodigo().equals(lista2.getCodigo())) {
						count++;
						if (!lista.contains(lista2)) {
							lista.add(lista2);
						}
					}
				} else if (lista1.getCodigo().equals(lista2.getCodigo())) {
					count++;
				} else {
					count = 0;
				}
			}
		}
		Documento lista1;
		this.listaDocumento = lista;
	}

	public void removerRepeticaoSeq() {
		List<Documento> lista = new ArrayList();
		int count = 0;

		for (Iterator localIterator1 = this.listaDocumento.iterator(); localIterator1.hasNext();) {
			Documento lista1 = (Documento) localIterator1.next();
			for (Documento lista2 : this.listaDocumento) {
				if (count == 0) {
					if (lista1.getSeqDocumento().equals(lista2.getSeqDocumento())) {
						count++;
						if (!lista.contains(lista2)) {
							lista.add(lista2);
						}
					}
				} else if (lista1.getSeqDocumento().equals(lista2.getSeqDocumento())) {
					count++;
				} else {
					count = 0;
				}
			}
		}
		Documento lista1;
		this.listaDocumento = lista;
	}

	public void abrirDocumento(Documento pDocumento) {
		try {
			FacesContext ctx = FacesContext.getCurrentInstance();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(ctx.getExternalContext().getRequestContextPath() + "/documento/documento.jsf?idDocumento="
							+ pDocumento.getSeqDocumento() + "&idTipoDocumento=" + pDocumento.getSeqTipoDocumento());
		} catch (IOException ex) {
			Logger.getLogger(PainelDocumentoEtapaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public LoginController getLoginController() {
		return this.loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DocumentoEtapa> getListaDocumentoEtapa() {
		return this.listaDocumentoEtapa;
	}

	public void setListaDocumentoEtapa(List<DocumentoEtapa> listaDocumentoEtapa) {
		this.listaDocumentoEtapa = listaDocumentoEtapa;
	}

	public DocumentoEtapaService getDocumentoEtapaService() {
		return this.processoEtapaService;
	}

	public void setDocumentoEtapaService(DocumentoEtapaService processoEtapaService) {
		this.processoEtapaService = processoEtapaService;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public TipoDocumentoService getTipoDocumentoService() {
		return this.tipoDocumentoService;
	}

	public void setTipoDocumentoService(TipoDocumentoService tipoDocumentoService) {
		this.tipoDocumentoService = tipoDocumentoService;
	}

	public List<Documento> getListaDocumento() {
		return this.listaDocumento;
	}

	public void setListaDocumento(List<Documento> listaDocumento) {
		this.listaDocumento = listaDocumento;
	}

	public List<Documento> getListaDocumentoFiltrado() {
		return this.listaDocumentoFiltrado;
	}

	public void setListaDocumentoFiltrado(List<Documento> listaDocumentoFiltrado) {
		this.listaDocumentoFiltrado = listaDocumentoFiltrado;
	}

	public DocumentoService getDocumentoService() {
		return this.processoService;
	}

	public void setDocumentoService(DocumentoService processoService) {
		this.processoService = processoService;
	}

	public DocumentoService getProcessoService() {
		return this.processoService;
	}

	public void setProcessoService(DocumentoService processoService) {
		this.processoService = processoService;
	}

	public DocumentoEtapaService getProcessoEtapaService() {
		return this.processoEtapaService;
	}

	public void setProcessoEtapaService(DocumentoEtapaService processoEtapaService) {
		this.processoEtapaService = processoEtapaService;
	}

	public String getEquipamentos() {
		return this.equipamentos;
	}

	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
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
}

/*
 * Location: C:\Users\diogo\Documents\workspace\others\prod
 * erp\deploy\erp3.war!\WEB-INF\classes\Controller\
 * PainelDocumentoEtapaController.class Java compiler version: 7 (51.0) JD-Core
 * Version: 0.7.1
 */