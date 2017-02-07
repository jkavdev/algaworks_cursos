package br.com.jkavdev.algaworks.compras.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.jkavdev.algaworks.compras.model.Estado;

public class Estados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Estado> todos() {
		Session session = this.manager.unwrap(Session.class);

		return session.createQuery("from Estado order by nome")
				.setCacheable(true)
				.list();
	}

	public Estado porCodigo(Long codigo) {
		return this.manager.find(Estado.class, codigo);
	}

}
