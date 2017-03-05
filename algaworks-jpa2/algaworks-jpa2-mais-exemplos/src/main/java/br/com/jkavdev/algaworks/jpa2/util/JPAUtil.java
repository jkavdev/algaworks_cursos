package br.com.jkavdev.algaworks.jpa2.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");

	public static EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

}
