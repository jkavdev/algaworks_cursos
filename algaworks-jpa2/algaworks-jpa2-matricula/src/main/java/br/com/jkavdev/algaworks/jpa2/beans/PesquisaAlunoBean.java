package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.AlunoDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Aluno;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoDao alunoDao;

	private List<Aluno> alunos;
	private Aluno alunoSelecionado;

	@PostConstruct
	public void init() {
		alunos = alunoDao.buscarTodos();
	}

	public void excluir() {
		try {
			alunoDao.excluir(alunoSelecionado);
			alunos.remove(alunoSelecionado);
			FacesUtil.addSuccessMessage("Aluno removido com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

}
