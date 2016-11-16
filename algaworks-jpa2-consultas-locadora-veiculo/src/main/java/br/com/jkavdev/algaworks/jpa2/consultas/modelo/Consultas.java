package br.com.jkavdev.algaworks.jpa2.consultas.modelo;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.consultas.JunitJpaConfig;

public class Consultas extends JunitJpaConfig {

	@Test
	public void buscaNomesFabricantesPeloModeloCarro() {
		String jpql = "select mc.fabricante.nome  from ModeloCarro mc";
		
		List<String> nomefabricantes = getManager().createQuery(jpql, String.class)
				.getResultList();

		for (String nome : nomefabricantes) {
			System.out.println("Fabricante: " + nome);
		}
	}

}
