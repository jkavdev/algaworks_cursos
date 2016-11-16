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
	
	@Test
	public void buscaModeloFiltradoFabricante(){
		String fabricanteNome = "Fiat";
		String jpql = "select mc.descricao from ModeloCarro mc where mc.fabricante.nome = :nome";
		
		List<String> descricaoModelos = getManager().createQuery(jpql, String.class)
				.setParameter("nome", fabricanteNome)
				.getResultList();
		
		for (String descricao : descricaoModelos) {
			System.out.println("Descricao: " + descricao);
		}
	}

}
