package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.modelos.Acessorio;
import br.com.jkavdev.algaworks.jpa2.services.AcessorioService;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AcessorioService acessorioService;

	@Inject
	private Acessorio acessorio;

	public void salvar() {
		try {
			acessorioService.salvar(acessorio);
			FacesUtil.addSuccessMessage("Acessorio salvo com sucesso!");
			limparFormulario();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	private void limparFormulario() {
		this.acessorio = new Acessorio();
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio Acessorio) {
		this.acessorio = Acessorio;
	}

}
