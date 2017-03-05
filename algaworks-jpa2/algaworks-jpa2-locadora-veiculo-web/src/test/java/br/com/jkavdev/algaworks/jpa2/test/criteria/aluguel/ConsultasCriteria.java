package br.com.jkavdev.algaworks.jpa2.test.criteria.aluguel;

import java.math.BigDecimal;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Aluguel;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ConsultasCriteria extends JunitJpaConfig {

	@Test
	public void funcoesDeAgregacoes() {
		CriteriaQuery<BigDecimal> criteriaQuery = getCriteriaBuilder().createQuery(BigDecimal.class);

		Root<Aluguel> aluguel = criteriaQuery.from(Aluguel.class);
		//As operações do sql vem do CriteriaBuilder: like, sum, count, etc.
		criteriaQuery.select(getCriteriaBuilder().sum(aluguel.<BigDecimal>get("valorTotal")));

		TypedQuery<BigDecimal> query = getManager().createQuery(criteriaQuery);
		BigDecimal valorTotal = query.getSingleResult();

		System.out.println("Valor total dos aluguéis: " + valorTotal);
	}

}
