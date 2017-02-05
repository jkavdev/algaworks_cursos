package br.com.jkavdev.algaworks.compras.util.jpa;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManagerFactory factory;

	public EntityManagerProducer() {
		factory = Persistence.createEntityManagerFactory("comprasPU");
	}

	@Produces
	@RequestScoped
	public EntityManagerFactory createEntityManagerFactory() {
		return factory;
	}

}
