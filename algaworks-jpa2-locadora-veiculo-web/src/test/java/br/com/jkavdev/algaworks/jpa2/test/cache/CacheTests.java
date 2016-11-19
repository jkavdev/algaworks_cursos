package br.com.jkavdev.algaworks.jpa2.test.cache;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class CacheTests extends JunitJpaConfig {

	@Test
	public void cachePrimeiroNivel() {
		List<Carro> carros = getManager().createQuery("from Carro", Carro.class).getResultList();

		for (Carro carro : carros) {
			System.out.println(carro.getCodigo() + " - " + carro.getPlaca());
		}

		// Obrigando o EntityManager realizar outra consulta, se não ele
		// reaproveita o entitymanager aberto com as entidades gerenciadas por
		getManager().close();
		setManager(getFactory().createEntityManager());

		System.out.println("============================================");
		Carro carro = getManager().find(Carro.class, 1L);
		System.out.println(carro.getCodigo() + " - " + carro.getPlaca());
	}

}
