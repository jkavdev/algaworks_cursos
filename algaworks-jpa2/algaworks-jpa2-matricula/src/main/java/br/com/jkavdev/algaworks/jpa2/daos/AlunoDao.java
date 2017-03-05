package br.com.jkavdev.algaworks.jpa2.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.jpa2.modelos.Aluno;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class AlunoDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public void salvar(Aluno aluno) {
		this.entityManager.merge(aluno);
	}

	public List<Aluno> buscarTodos() {
		return this.entityManager.createQuery("from Aluno", Aluno.class).getResultList();
	}

	public Aluno buscarPeloCodigo(Long codigo) {
		return this.entityManager.find(Aluno.class, codigo);
	}

	@Transactional
	public void excluir(Aluno Aluno) throws NegocioException {		
		Aluno = buscarPeloCodigo(Aluno.getCodigo());
		
		this.entityManager.remove(Aluno);
		this.entityManager.flush();
	}

}
