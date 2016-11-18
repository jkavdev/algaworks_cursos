package br.com.jkavdev.algaworks.jpa2.test.criteria.carro;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ConsultasCriteria2 extends JunitJpaConfig {

	@Test
	public void buscaComFuncoes() {
		CriteriaQuery<Carro> criteriaQuery = getCriteriaBuilder().createQuery(Carro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		// Indicamos que será usado o upperCase do buider para retornar os
		// objetos
		Predicate predicate = getCriteriaBuilder().equal(getCriteriaBuilder().upper(carro.<String>get("cor")),
				"branco".toUpperCase());

		// Selecionando resultado
		criteriaQuery.select(carro);
		// Indicando condições para o resultado
		criteriaQuery.where(predicate);

		List<Carro> carros = getManager().createQuery(criteriaQuery).getResultList();

		for (Carro carro2 : carros) {
			System.out.println("Placa " + carro2.getPlaca() + " - " + carro2.getCor());
		}
	}

	@Test
	public void buscaComOrdenacao() {
		CriteriaQuery<Carro> criteriaQuery = getCriteriaBuilder().createQuery(Carro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		// Indicando uma ordem decrescente sobre valorDiaria
		Order order = getCriteriaBuilder().desc(carro.get("valorDiaria"));

		criteriaQuery.select(carro);
		// Adicionando ordem
		criteriaQuery.orderBy(order);

		List<Carro> carros = getManager().createQuery(criteriaQuery).getResultList();

		for (Carro carro2 : carros) {
			System.out.println("Placa: " + carro2.getPlaca() + " - " + carro2.getValorDiaria());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Test
	public void buscaComFetch() {
		CriteriaQuery<Carro> criteriaQuery = getCriteriaBuilder().createQuery(Carro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		//Retornando ModeloCarro junto com a consulta do Carro
		Join<Carro, ModeloCarro> fetch = (Join) carro.fetch("modeloCarro");

		criteriaQuery.select(carro);

		List<Carro> carros = getManager().createQuery(criteriaQuery).getResultList();

		for (Carro carro2 : carros) {
			System.out.println("Placa: " + carro2.getPlaca() + " - " + carro2.getModeloCarro().getDescricao());
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void buscaComJoin() {
		CriteriaQuery<Carro> criteriaQuery = getCriteriaBuilder().createQuery(Carro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		//Indicando join de ModeloCarro para filtro apenas
		Join<Carro, ModeloCarro> modelo = (Join) carro.join("modeloCarro");
		
		criteriaQuery.select(carro);
		//Realizando filtro
		criteriaQuery.where(getCriteriaBuilder().equal(modelo.get("descricao"), "Punto"));

		List<Carro> carros = getManager().createQuery(criteriaQuery).getResultList();

		for (Carro carro2 : carros) {
			System.out.println("Placa: " + carro2.getPlaca() + " - " + carro2.getModeloCarro().getDescricao());
		}
	}

}
