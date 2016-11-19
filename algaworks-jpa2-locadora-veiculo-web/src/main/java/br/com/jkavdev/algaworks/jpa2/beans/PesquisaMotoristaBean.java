package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.MotoristaDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Motorista;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MotoristaDao motoristaDAO;
	
	private List<Motorista> motoristas = new ArrayList<>();
	
	private Motorista motoristaSelecionado;
	
	public List<Motorista> getMotoristas() {
		return motoristas;
	}
	
	public void excluir() {
		try {
			motoristaDAO.excluir(motoristaSelecionado);
			this.motoristas.remove(motoristaSelecionado);
			FacesUtil.addSuccessMessage("Motorista " + motoristaSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Motorista getMotoristaSelecionado() {
		return motoristaSelecionado;
	}
	public void setMotoristaSelecionado(Motorista motoristaSelecionado) {
		this.motoristaSelecionado = motoristaSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		motoristas = motoristaDAO.buscarTodos();
	}
}
