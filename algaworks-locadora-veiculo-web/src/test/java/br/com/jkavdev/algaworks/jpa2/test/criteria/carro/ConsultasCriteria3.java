package br.com.jkavdev.algaworks.jpa2.test.criteria.carro;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ConsultasCriteria3 extends JunitJpaConfig {

	@Test
	public void buscaMediaDasDiariasDosCarros() {
		CriteriaQuery<Double> criteriaQuery = getCriteriaBuilder().createQuery(Double.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);

		criteriaQuery.select(getCriteriaBuilder().avg(carro.<Double>get("valorDiaria")));

		Double total = getManager().createQuery(criteriaQuery).getSingleResult();

		System.out.println("Total das Diarias " + total);
	}

	@Test
	public void buscaCarrosComValoresAcimaDaMedia() {
		// Consulta principal
		CriteriaQuery<Carro> criteriaQuery = getCriteriaBuilder().createQuery(Carro.class);
		// SubConsulta
		Subquery<Double> subquery = criteriaQuery.subquery(Double.class);

		// Consulta principal será feita em Carro
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		// SubConsulta também
		Root<Carro> carroSubQuery = subquery.from(Carro.class);

		// Realizando SubConsulta, retornando a médias das diárias
		subquery.select(getCriteriaBuilder().avg(carroSubQuery.<Double>get("valorDiaria")));

		// Retornando consulta principal
		criteriaQuery.select(carro);
		// Com condição, passando SubConsulta
		criteriaQuery.where(getCriteriaBuilder().greaterThanOrEqualTo(carro.<Double>get("valorDiaria"), subquery));

		TypedQuery<Carro> query = getManager().createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();

		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getValorDiaria());
		}
	}

}
