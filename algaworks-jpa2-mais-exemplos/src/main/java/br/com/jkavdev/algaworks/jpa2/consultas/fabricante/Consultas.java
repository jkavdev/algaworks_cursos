package br.com.jkavdev.algaworks.jpa2.consultas.fabricante;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.consultas.JunitJpaConfig;
import br.com.jkavdev.algaworks.jpa2.modelo.Fabricante;

public class Consultas extends JunitJpaConfig {

	@Test
	public void buscaTodosFabricantes() {
		List<Fabricante> fabricantes = getManager().createQuery("select f from Fabricante f", Fabricante.class)
				.getResultList();

		for (Fabricante fabricante : fabricantes) {
			System.out.println("Fabricante: " + fabricante.getNome());
		}
	}

	@Test
	public void buscaNomesFabricantes() {
		List<String> nomeFabricantes = getManager().createQuery("select f.nome from Fabricante f", String.class)
				.getResultList();

		for (String nome : nomeFabricantes) {
			System.out.println("Fabricante: " + nome);
		}
	}

	@Test
	public void buscarFabricanteComCriteria() {
		CriteriaBuilder criteriaBuilder = getManager().getCriteriaBuilder();
		CriteriaQuery<Fabricante> criteriaQuery = criteriaBuilder.createQuery(Fabricante.class);
		criteriaQuery.from(Fabricante.class);

		List<Fabricante> fabricantes = getManager().createQuery(criteriaQuery).getResultList();
		
		for (Fabricante fabricante : fabricantes) {
			System.out.println("Fabricante: " + fabricante.getNome());
		}
	}
	
	@Test
	public void buscarFabricanteComCriteriaLike() {
		CriteriaBuilder criteriaBuilder = getManager().getCriteriaBuilder();
		CriteriaQuery<Fabricante> criteriaQuery = criteriaBuilder.createQuery(Fabricante.class);
		
		Root<Fabricante> f = criteriaQuery.from(Fabricante.class);
		criteriaQuery.select(f);
		
		criteriaQuery.where(criteriaBuilder.like(f.<String>get("nome"), "F%"));

		List<Fabricante> fabricantes = getManager().createQuery(criteriaQuery).getResultList();
		
		for (Fabricante fabricante : fabricantes) {
			System.out.println("Fabricante: " + fabricante.getNome());
		}
	}

}
