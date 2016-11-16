package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.FabricanteDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Fabricante;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDao fabricanteDao;

	private List<Fabricante> fabricantes;
	private Fabricante fabricanteSelecionado;

	@PostConstruct
	public void init() {
		fabricantes = fabricanteDao.buscarTodos();
	}

	public void excluir() {
		try {
			fabricanteDao.excluir(fabricanteSelecionado);
			fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante removido com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

}
