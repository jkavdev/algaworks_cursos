package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.AluguelDao;
import br.com.jkavdev.algaworks.jpa2.daos.ModeloCarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Aluguel;
import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;

@Named
@ViewScoped
public class PesquisaAluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelDao aluguelDao;
	@Inject
	private ModeloCarroDao modeloCarroDao;

	private Aluguel aluguel;
	private Carro carro;
	private List<Aluguel> alugueis;
	private List<ModeloCarro> modelosCarro;

	@PostConstruct
	public void init() {
		this.aluguel = new Aluguel();
		this.carro = new Carro();
		this.modelosCarro = this.modeloCarroDao.buscarTodos();
		this.alugueis = new ArrayList<>();
	}

	public void pesquisar() {
		this.alugueis = aluguelDao.buscarPorDataDeEntregaEModeloCarro(this.aluguel.getDataEntrega(),
				this.carro.getModeloCarro());
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public List<ModeloCarro> getModelosCarro() {
		return modelosCarro;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
