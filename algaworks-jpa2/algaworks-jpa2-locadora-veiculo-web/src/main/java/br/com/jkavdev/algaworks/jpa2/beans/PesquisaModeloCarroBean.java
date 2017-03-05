package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.ModeloCarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroDao modeloCarroDao;

	private List<ModeloCarro> modeloCarros;
	private ModeloCarro modeloCarroSelecionado;

	@PostConstruct
	public void init() {
		modeloCarros = modeloCarroDao.buscarTodos();
	}

	public void excluir() {
		try {
			modeloCarroDao.excluir(modeloCarroSelecionado);
			modeloCarros.remove(modeloCarroSelecionado);
			FacesUtil.addSuccessMessage("Modelo removido com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public ModeloCarro getModeloCarroSelecionado() {
		return modeloCarroSelecionado;
	}

	public void setModeloCarroSelecionado(ModeloCarro fabricanteSelecionado) {
		this.modeloCarroSelecionado = fabricanteSelecionado;
	}

	public List<ModeloCarro> getModeloCarros() {
		return modeloCarros;
	}

}
