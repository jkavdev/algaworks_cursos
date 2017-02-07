package br.com.jkavdev.algaworks.compras.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.compras.model.Fornecedor;
import br.com.jkavdev.algaworks.compras.util.jpa.Transactional;

public class Fornecedores implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void adicionar(Fornecedor fornecedor) {
		manager.persist(fornecedor);
	}

	public List<Fornecedor> todosTodosComCidadeEEstado() {
		return this.manager.createQuery("from Fornecedor f inner join fetch f.cidade c inner join fetch c.estado",
				Fornecedor.class).getResultList();
	}

}
