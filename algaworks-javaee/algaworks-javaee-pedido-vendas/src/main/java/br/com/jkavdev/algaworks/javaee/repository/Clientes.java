package br.com.jkavdev.algaworks.javaee.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.javaee.model.Cliente;

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Cliente porId(Long id) {
		return manager.find(Cliente.class, id);
	}

	public List<Cliente> porNome(String nome) {
		return manager.createQuery("from Cliente where upper(nome) like :nome", Cliente.class)
				.setParameter("nome", nome.toUpperCase() + "%")
				.getResultList();
	}

}
