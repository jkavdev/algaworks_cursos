package br.com.jkavdev.algaworks.jpa2.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class JunitJpaConfig {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}

	public EntityManager getManager() {
		return manager;
	}
	
	public CriteriaBuilder getCriteriaBuilder(){
		return this.manager.getCriteriaBuilder();
	}

}
