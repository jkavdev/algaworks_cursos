package br.com.jkavdev.algaworks.jpa2.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.jpa2.modelos.Fabricante;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class FabricanteDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public void salvar(Fabricante fabricante) {
		this.entityManager.merge(fabricante);
	}

	public List<Fabricante> buscarTodos() {
		return this.entityManager.createQuery("from Fabricante", Fabricante.class).getResultList();
	}

	public Fabricante buscarPeloCodigo(Long codigo) {
		return this.entityManager.find(Fabricante.class, codigo);
	}

	@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException {		
		fabricante = buscarPeloCodigo(fabricante.getCodigo());
		
		this.entityManager.remove(fabricante);
		this.entityManager.flush();
	}

}
