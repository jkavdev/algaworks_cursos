package br.com.jkavdev.algaworks.jpa2.jboss.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.jkavdev.algaworks.jpa2.jboss.modelo.Cliente;

@Stateless
public class CadastroClienteEJB {

	@PersistenceContext(unitName = "projetoJbossPU")
	private EntityManager entityManager;

	public void salvar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	public List<Cliente> buscarTodos() {
		return this.entityManager.createQuery("from Cliente", Cliente.class).getResultList();
	}

}
