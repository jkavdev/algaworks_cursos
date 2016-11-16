package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.AcessorioDao;
import br.com.jkavdev.algaworks.jpa2.daos.ModeloCarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Acessorio;
import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;
import br.com.jkavdev.algaworks.jpa2.services.CarroService;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroService carroService;
	@Inject
	private ModeloCarroDao modeloCarroDao;
	@Inject
	private AcessorioDao acessorioDao;

	private List<ModeloCarro> modeloCarros;
	private List<Acessorio> acessorios;

	@Inject
	private Carro carro;

	@PostConstruct
	public void init() {
		modeloCarros = modeloCarroDao.buscarTodos();
		acessorios = acessorioDao.buscarTodos();
	}

	public void salvar() {
		try {
			carroService.salvar(carro);
			FacesUtil.addSuccessMessage("Carro salvo com sucesso!");
			limpaFormulario();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	private void limpaFormulario() {
		carro = new Carro();
	}

	public List<ModeloCarro> getModeloCarros() {
		return modeloCarros;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
