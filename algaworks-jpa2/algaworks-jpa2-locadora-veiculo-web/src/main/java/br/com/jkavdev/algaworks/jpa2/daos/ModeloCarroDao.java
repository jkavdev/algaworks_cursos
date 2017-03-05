package br.com.jkavdev.algaworks.jpa2.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class ModeloCarroDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public void salvar(ModeloCarro modeloCarro) {
		this.entityManager.merge(modeloCarro);
	}

	public List<ModeloCarro> buscarTodos() {
		return this.entityManager.createQuery("from ModeloCarro", ModeloCarro.class).getResultList();
	}

	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return this.entityManager.find(ModeloCarro.class, codigo);
	}

	@Transactional
	public void excluir(ModeloCarro modeloCarro) throws NegocioException {
		modeloCarro = buscarPeloCodigo(modeloCarro.getCodigo());

		try {
			this.entityManager.remove(modeloCarro);
			this.entityManager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Modelo não pôde ser excluído!" + e.getMessage());
		}
	}

}
