package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.modelos.Aluno;
import br.com.jkavdev.algaworks.jpa2.services.AlunoService;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoService alunoService;

	@Inject
	private Aluno aluno;

	public void salvar() {
		try {
			alunoService.salvar(aluno);
			FacesUtil.addSuccessMessage("Aluno salvo com sucesso!");
			limparFormulario();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	private void limparFormulario() {
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno Aluno) {
		this.aluno = Aluno;
	}

}
