package br.com.jkavdev.algaworks.jpa2.test.criteria.motorista;

import java.util.Calendar;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Aluguel;
import br.com.jkavdev.algaworks.jpa2.modelos.Motorista;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ConsultasCriteria extends JunitJpaConfig {

	// Por exemplo, crie uma consulta, em um método de teste mesmo (por
	// enquanto, no próximo você irá fazer em telas JSF), quais são os
	// motoristas que mais alugaram carros no último mês?

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void busca2() {
		//Tipo que será retornado
		CriteriaQuery<MotoristaFiltro> criteriaQuery = getCriteriaBuilder().createQuery(MotoristaFiltro.class);
		
		//Será realizado um select em Alguel
		Root<Aluguel> aluguel = criteriaQuery.from(Aluguel.class);
		//E um join em Motorista
		Join<Aluguel, Motorista> motorista = (Join) aluguel.join("motorista");

		//Consultando o nome do motorista
		Path<String> motoristaNome = motorista.<String>get("nome");

		//Criando os parâmetros para passar na consulta
		ParameterExpression<Calendar> dataEntregaInicial = getCriteriaBuilder().parameter(Calendar.class, "dataInicial");
		ParameterExpression<Calendar> dataEntregaFinal = getCriteriaBuilder().parameter(Calendar.class, "dataFinal");
		
		//Criando a condição, que retornará apenas os resultados entre as data que passar
		Predicate between = getCriteriaBuilder().between(aluguel.<Calendar>get("dataPedido"), dataEntregaInicial, dataEntregaFinal);

		//A consulta retornara um  MotoristaFitro instanciado com os resultados da consulta
		criteriaQuery.select(getCriteriaBuilder().construct(
				MotoristaFiltro.class, 
				motoristaNome,
				getCriteriaBuilder().count(aluguel)));

		//Filtros e agrupamento da busca
		criteriaQuery.where(between);
		criteriaQuery.groupBy(motoristaNome);

		TypedQuery<MotoristaFiltro> query = getManager().createQuery(criteriaQuery);

		//Criando datas de inicio e fim de mês
		Calendar dataInicial = Calendar.getInstance();
		dataInicial.set(Calendar.HOUR_OF_DAY, 0);
		dataInicial.set(Calendar.MINUTE, 0);
		dataInicial.set(Calendar.SECOND, 0);
		dataInicial.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));

		Calendar dataFinal = Calendar.getInstance();
		dataFinal.set(Calendar.HOUR_OF_DAY, 23);
		dataFinal.set(Calendar.MINUTE, 59);
		dataFinal.set(Calendar.SECOND, 59);
		dataFinal.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));

		//Passando datas criadas para a busca
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);

		List<MotoristaFiltro> resultados = query.getResultList();

		for (MotoristaFiltro motoristaFiltro : resultados) {
			System.out.println("Motorista: " + motoristaFiltro.getNome() + " total de alugueis "
					+ motoristaFiltro.getTotalAlugueis());
		}
	}

}
