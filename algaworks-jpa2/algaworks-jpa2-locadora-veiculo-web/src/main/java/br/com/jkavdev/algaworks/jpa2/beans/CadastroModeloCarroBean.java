package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.FabricanteDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Categoria;
import br.com.jkavdev.algaworks.jpa2.modelos.Fabricante;
import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;
import br.com.jkavdev.algaworks.jpa2.services.ModeloCarroService;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroService modeloCarroService;
	@Inject
	private FabricanteDao fabricanteDao;

	@Inject
	private ModeloCarro modeloCarro;
	private List<Fabricante> fabricantes;

	@PostConstruct
	public void init() {
		fabricantes = fabricanteDao.buscarTodos();
	}

	public void salvar() {
		try {
			modeloCarroService.salvar(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo salvo com sucesso!");
			limparFormulario();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	private void limparFormulario() {
		this.modeloCarro = new ModeloCarro();
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro fabricante) {
		this.modeloCarro = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	public List<Categoria> getCategorias(){
		return Arrays.asList(Categoria.values());
	}

}
