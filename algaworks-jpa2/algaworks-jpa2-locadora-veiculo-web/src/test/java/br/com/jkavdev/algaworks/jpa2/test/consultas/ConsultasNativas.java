package br.com.jkavdev.algaworks.jpa2.test.consultas;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ConsultasNativas extends JunitJpaConfig {

	@SuppressWarnings("unchecked")
	@Test
	public void consultaNativa() {
		Query nativeQuery = getManager().createNativeQuery("select * from Carros", Carro.class);
		List<Carro> carros = nativeQuery.getResultList();

		for (Carro carro : carros) {
			System.out.println("Placa: " + carro.getPlaca());
		}
	}

}
