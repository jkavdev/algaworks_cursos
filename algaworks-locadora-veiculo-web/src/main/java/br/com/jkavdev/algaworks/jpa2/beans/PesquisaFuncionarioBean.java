package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.FuncionarioDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Funcionario;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioDao funcionarioDAO;

	private List<Funcionario> funcionarios;

	private Funcionario funcionarioSelecionado;

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void excluir() {
		try {
			funcionarioDAO.excluir(funcionarioSelecionado);
			this.funcionarios.remove(funcionarioSelecionado);
			FacesUtil.addSuccessMessage("Funcionario " + funcionarioSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario FuncionarioSelecionado) {
		this.funcionarioSelecionado = FuncionarioSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		funcionarios = funcionarioDAO.buscarTodos();
	}
}
