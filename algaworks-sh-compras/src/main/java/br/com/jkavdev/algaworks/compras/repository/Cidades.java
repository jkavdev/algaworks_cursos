package br.com.jkavdev.algaworks.compras.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.jkavdev.algaworks.compras.model.Cidade;
import br.com.jkavdev.algaworks.compras.model.Estado;

public class Cidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManagerFactory factory;

	public List<Cidade> porEstado(Estado estado) {
		EntityManager manager = this.factory.createEntityManager();

		List<Cidade> cidadesPorEstado = manager.createQuery("From Cidade c where c.estado = :estado", Cidade.class)
				.setParameter("estado", estado)
				.getResultList();
		
		manager.close();

		return cidadesPorEstado;
	}

}
