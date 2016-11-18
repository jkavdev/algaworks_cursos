package br.com.jkavdev.algaworks.jpa2.test.criteria.carro;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ConsultasCriteria2 extends JunitJpaConfig {

	@Test
	public void buscaComFuncoes() {
		CriteriaQuery<Carro> criteriaQuery = getCriteriaBuilder().createQuery(Carro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		//Indicamos que será usado o upperCase do buider para retornar os objetos
		Predicate predicate = getCriteriaBuilder().equal(getCriteriaBuilder().upper(carro.<String>get("cor")),
				"branco".toUpperCase());

		//Selecionando resultado
		criteriaQuery.select(carro);
		//Indicando condições para o resultado
		criteriaQuery.where(predicate);

		List<Carro> carros = getManager().createQuery(criteriaQuery).getResultList();

		for (Carro carro2 : carros) {
			System.out.println("Placa " + carro2.getPlaca() + " - " + carro2.getCor());
		}

	}

}
