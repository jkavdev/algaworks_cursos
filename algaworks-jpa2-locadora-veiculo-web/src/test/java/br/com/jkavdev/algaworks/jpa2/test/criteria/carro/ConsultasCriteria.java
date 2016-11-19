package br.com.jkavdev.algaworks.jpa2.test.criteria.carro;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ConsultasCriteria extends JunitJpaConfig {

	@Test
	public void projecoes() {
		// Qual o tipo que será retornado da consulta
		CriteriaQuery<String> criteriaQuery = getCriteriaBuilder().createQuery(String.class);

		// De onde estará vindo o resultado da consulta
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		// O que será retornado da consulta
		criteriaQuery.select(carro.<String>get("placa"));

		TypedQuery<String> query = getManager().createQuery(criteriaQuery);
		List<String> placas = query.getResultList();

		for (String placa : placas) {
			System.out.println("Placa: " + placa);
		}
	}

	@Test
	public void consultasComplexas() {
		CriteriaQuery<Object[]> criteriaQuery = getCriteriaBuilder().createQuery(Object[].class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		// Retornando varios resultados da consulta com multiselect
		criteriaQuery.multiselect(carro.get("placa"), carro.get("valorDiaria"));

		TypedQuery<Object[]> query = getManager().createQuery(criteriaQuery);
		List<Object[]> resultado = query.getResultList();

		for (Object[] valores : resultado) {
			System.out.println("Placa " + valores[0] + " valor da diária " + valores[1]);
		}
	}

	@Test
	public void consultasRetornadoTuplas() {
		// Retornaremos uma tupla com os resultados
		CriteriaQuery<Tuple> criteriaQuery = getCriteriaBuilder().createTupleQuery();

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		// Mesmo multiselect, mas desta vez usamo um apelido para termos acesso
		// ao resultado
		criteriaQuery.multiselect(carro.get("placa").alias("placaCarro"), carro.get("valorDiaria").alias("valorCarro"));

		TypedQuery<Tuple> query = getManager().createQuery(criteriaQuery);
		List<Tuple> resultado = query.getResultList();

		// temos acesso ao dado pelo get(apelido)
		for (Tuple tupla : resultado) {
			System.out.println("Placa " + tupla.get("placaCarro") + " valor da diária " + tupla.get("valorCarro"));
		}
	}

	@Test
	public void consultasRetornandoUmObjeto() {
		CriteriaQuery<PrecoCarro> criteriaQuery = getCriteriaBuilder().createQuery(PrecoCarro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		//Informamos com o criteriaBuilder que os resultados serão preenchidos em um construtor
		//Informando o tipo, e seus valores do construtor
		criteriaQuery.select(getCriteriaBuilder().construct(
						PrecoCarro.class, 
						carro.get("placa"), 
						carro.get("valorDiaria")));

		TypedQuery<PrecoCarro> query = getManager().createQuery(criteriaQuery);
		List<PrecoCarro> resultado = query.getResultList();

		for (PrecoCarro precoCarro : resultado) {
			System.out.println("Placa " + precoCarro.getPlaca() + " valor da diária " + precoCarro.getValor());
		}
	}

}
