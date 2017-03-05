package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.AcessorioDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Acessorio;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AcessorioDao acessorioDao;

	private List<Acessorio> Acessorios;
	private Acessorio acessorioSelecionado;

	@PostConstruct
	public void init() {
		Acessorios = acessorioDao.buscarTodos();
	}

	public void excluir() {
		try {
			acessorioDao.excluir(acessorioSelecionado);
			Acessorios.remove(acessorioSelecionado);
			FacesUtil.addSuccessMessage("Acessorio removido com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Acessorio getAcessorioSelecionado() {
		return acessorioSelecionado;
	}

	public void setAcessorioSelecionado(Acessorio AcessorioSelecionado) {
		this.acessorioSelecionado = AcessorioSelecionado;
	}

	public List<Acessorio> getAcessorios() {
		return Acessorios;
	}

}
