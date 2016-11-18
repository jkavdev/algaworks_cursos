package br.com.jkavdev.algaworks.jpa2.test.criteria;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ConsultasCriteria extends JunitJpaConfig {
	
	@Test
	public void projecoes(){
		//Qual o tipo que será retornado da consulta
		CriteriaQuery<String> criteriaQuery = getCriteriaBuilder().createQuery(String.class);
		
		//De onde estará vindo o resultado da consulta
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		//O que será retornado da consulta
		criteriaQuery.select(carro.<String>get("placa"));
		
		TypedQuery<String> query = getManager().createQuery(criteriaQuery);
		List<String> placas = query.getResultList();
		
		for (String placa : placas) {
			System.out.println("Placa: " + placa);
		}
	}

}
