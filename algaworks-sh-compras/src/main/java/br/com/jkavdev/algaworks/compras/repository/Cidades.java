package br.com.jkavdev.algaworks.compras.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.compras.model.Cidade;
import br.com.jkavdev.algaworks.compras.model.Estado;

public class Cidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Cidade> porEstado(Estado estado) {
		return this.manager.createQuery("From Cidade c where c.estado = :estado", Cidade.class)
				.setParameter("estado", estado)
				.getResultList();
	}

	public Cidade porCodigo(Long codigo) {
		return this.manager.find(Cidade.class, codigo);
	}

}
