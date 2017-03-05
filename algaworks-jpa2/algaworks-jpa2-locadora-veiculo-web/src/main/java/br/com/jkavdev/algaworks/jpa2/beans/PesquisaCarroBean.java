package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.CarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.modeloslazy.LazyCarroDataModel;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroDao carroDao;
	
	private List<Carro> carros = new ArrayList<>();
	private LazyCarroDataModel lazyCarros;	
	private Carro carroSelecionado;
	private Carro carroSelecionadoParaExclusao;

	@PostConstruct
	public void init() {
		lazyCarros = new LazyCarroDataModel(carroDao);
	}

	public void excluir() {
		try {
			carroDao.excluir(carroSelecionadoParaExclusao);
			carros.remove(carroSelecionadoParaExclusao);
			FacesUtil.addSuccessMessage("Carro removido com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void buscarCarroComAcessorios(){
		carroSelecionado = carroDao.buscarCarroComAcessorios(carroSelecionado.getCodigo());
	}
	
	public Carro getCarroSelecionadoParaExclusao() {
		return carroSelecionadoParaExclusao;
	}

	public void setCarroSelecionadoParaExclusao(Carro carroSelecionadoParaExclusao) {
		this.carroSelecionadoParaExclusao = carroSelecionadoParaExclusao;
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}
	
	public LazyCarroDataModel getLazyCarros() {
		return lazyCarros;
	}

	public List<Carro> getCarros() {
		return carros;
	}

}
