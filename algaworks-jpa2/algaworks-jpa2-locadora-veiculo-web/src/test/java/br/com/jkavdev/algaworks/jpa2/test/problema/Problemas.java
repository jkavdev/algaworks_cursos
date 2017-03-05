package br.com.jkavdev.algaworks.jpa2.test.problema;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class Problemas extends JunitJpaConfig {

	@Test
	public void problemaNMaisUm() {
		//Resolvemos trazendo a entidade na mesma consulta, Carro e ModeloCarro
		TypedQuery<Carro> typedQuery = getManager().createQuery("from Carro c inner join fetch c.modeloCarro", Carro.class);
		List<Carro> carros = typedQuery.getResultList();

		for (Carro carro : carros) {
			System.out.println("Placa: " + carro.getPlaca() + " - " + carro.getModeloCarro().getDescricao());
		}
	}

}
