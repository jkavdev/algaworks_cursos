package br.com.jkavdev.algaworks.jpa2.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.jpa2.modelos.Acessorio;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class AcessorioDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public void salvar(Acessorio acessorio) {
		this.entityManager.merge(acessorio);
	}

	public List<Acessorio> buscarTodos() {
		return this.entityManager.createQuery("from Acessorio", Acessorio.class).getResultList();
	}

	public Acessorio buscarPeloCodigo(Long codigo) {
		return this.entityManager.find(Acessorio.class, codigo);
	}

	@Transactional
	public void excluir(Acessorio acessorio) throws NegocioException {		
		acessorio = buscarPeloCodigo(acessorio.getCodigo());
		
		this.entityManager.remove(acessorio);
		this.entityManager.flush();
	}

}
