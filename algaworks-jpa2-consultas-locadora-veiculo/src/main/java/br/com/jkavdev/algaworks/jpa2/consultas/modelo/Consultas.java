package br.com.jkavdev.algaworks.jpa2.consultas.modelo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.consultas.JunitJpaConfig;
import br.com.jkavdev.algaworks.jpa2.modelo.Categoria;

public class Consultas extends JunitJpaConfig {

	@Test
	public void buscaNomesFabricantesPeloModeloCarro() {
		String jpql = "select mc.fabricante.nome from ModeloCarro mc";
		
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
	
	@Test
	public void buscaModeloFiltroEmFabricanteECategoria(){
		String fabricanteNome = "Fiat";
		List<Categoria> categorias = Arrays.asList(
				Categoria.SEDAN_GRANDE, 
				Categoria.HATCH_MEDIO);
		String jpql = "select mc.descricao from ModeloCarro mc where mc.fabricante.nome = :nome and mc.categoria in :categorias";
		
		List<String> descricaoModelos = getManager().createQuery(jpql, String.class)
				.setParameter("nome", fabricanteNome)
				.setParameter("categorias", categorias)
				.getResultList();
		
		for (String descricao : descricaoModelos) {
			System.out.println("Descricao: " + descricao);
		}
	}
	
	@Test
	public void buscaDescricaoECategoriaDeModeloCarro(){
		String jpql = "select mc.descricao, mc.categoria from ModeloCarro mc ";
		
		List<Object[]> resultados = getManager().createQuery(jpql, Object[].class)
				.getResultList();
		
		for (Object[] objects : resultados) {
			System.out.println("Descrição: " + objects[0] + " e Categoria: " + objects[1]);
		}
	}
	
	@Test
	public void buscaPassandoParametros(){
		String fabricanteNome = "Fiat";
//		String jpql1 = "select mc.descricao from ModeloCarro mc where mc.fabricante.nome = ?1";
		String jpql = "select mc.descricao from ModeloCarro mc where mc.fabricante.nome = :nome";
		
		List<String> descricaoModelos = getManager().createQuery(jpql, String.class)
//				.setParameter(1, fabricanteNome)
				.setParameter("nome", fabricanteNome)
				.getResultList();
		
		for (String descricao : descricaoModelos) {
			System.out.println("Descricao: " + descricao);
		}
	}

}
