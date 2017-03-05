package br.com.jkavdev.algaworks.jpa2.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpa2.daos.AlunoDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Aluno;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class AlunoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoDao AlunoDao;

	@Transactional
	public void salvar(Aluno Aluno) throws NegocioException {

		if (Aluno.getNome() == null || "".equals(Aluno.getNome().trim())) {
			throw new NegocioException("O nome do aluno é obrigatório");
		}

		this.AlunoDao.salvar(Aluno);
	}

}
