package br.com.jkavdev.algaworks.compras.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.jkavdev.algaworks.compras.model.Estado;

public class Estados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManagerFactory factory;

	public List<Estado> todos() {
		EntityManager manager = this.factory.createEntityManager();

		List<Estado> todosEstados = manager.createQuery("from Estado order by nome", Estado.class).getResultList();

		manager.close();

		return todosEstados;
	}

	public Estado porCodigo(Long codigo) {
		EntityManager manager = this.factory.createEntityManager();
		
		Estado estadoEncontrado = manager.find(Estado.class, codigo);
		
		manager.close();
		
		return estadoEncontrado;
	}

}
