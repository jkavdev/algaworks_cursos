package br.com.jkavdev.algaworks.jpa2.consultas.aluguel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.consultas.JunitJpaConfig;
import br.com.jkavdev.algaworks.jpa2.modelo.Aluguel;

public class Consultas extends JunitJpaConfig {

	@Test
	public void buscaAluguelPorData() {
		Calendar dataInicioCalendar = Calendar.getInstance();
		dataInicioCalendar.set(2014, 12, 10, 5, 6);
		Date dataInicio = dataInicioCalendar.getTime();
		
		Calendar dataFimCalendar = Calendar.getInstance();
		dataFimCalendar.set(2015, 12, 10, 5, 6);
		Date dataFim = dataInicioCalendar.getTime();
		
		String jpql = "select a from Aluguel a  where a.dataDevolucao between :dataInicio and :dataFim";

		List<Aluguel> alugueis = getManager().createQuery(jpql, Aluguel.class)
				.setParameter("dataInicio", dataInicio)
				.setParameter("dataFim", dataFim)
				.getResultList();

		for (Aluguel aluguel : alugueis) {
			System.out.println(aluguel.getCodigo() + " - " + aluguel.getValorTotal());
		}
	}

}
