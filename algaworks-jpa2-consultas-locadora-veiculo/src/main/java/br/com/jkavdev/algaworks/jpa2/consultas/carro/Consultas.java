package br.com.jkavdev.algaworks.jpa2.consultas.carro;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.consultas.JunitJpaConfig;
import br.com.jkavdev.algaworks.jpa2.modelo.Carro;
import br.com.jkavdev.algaworks.jpa2.modelo.filtro.AluguelCarroInfo;

public class Consultas extends JunitJpaConfig {

	@SuppressWarnings("unused")
	@Test
	public void buscaTodosFabricantes() {
		String modelo = "Fusion";
		String jpqlNaoDaCerto = "select c.acessorios.descricao from Carro c where c.modelo.descricao = :modelo";
		String jpql = "select a.descricao from Carro c join c.acessorios a where c.modeloCarro.descricao = :modelo";
		
		List<String> descricaoAcessorio = getManager().createQuery(jpql, String.class)
				.setParameter("modelo", modelo)
				.getResultList();

		for (String descricao : descricaoAcessorio) {
			System.out.println("Descrição: " + descricao);
		}
	}
	
	@Test
	public void consultasAgregadas(){
		String jpql = "select c, count(a), max(a.valorTotal), avg(a.valorTotal) "
				+ "from Carro c join c.alugueis a "
				+ "group by c "
				+ "having count(a) >= 1";
		
		List<Object[]> resultados = getManager().createQuery(jpql, Object[].class).getResultList();
		
		for (Object[] objects : resultados) {
			System.out.println("Modelo: " + ((Carro) objects[0]).getModeloCarro().getDescricao());
			System.out.println("Quantidade de Alugueis: " + objects[1]);
			System.out.println("Valor Maximo: " + objects[2]);
			System.out.println("Valor Medio: " + objects[3]);
			System.out.println();
		}
	}
	
	@Test
	public void consultasAgregadasComObjetoFiltro(){
		String jpql = "select new "
				+ "br.com.jkavdev.algaworks.jpa2.consultas.carro.AlguelCarroInfo(c, count(a), max(a.valorTotal), avg(a.valorTotal)) "
				+ "from Carro c join c.alugueis a "
				+ "group by c "
				+ "having count(a) >= 1";
		
		List<AluguelCarroInfo> resultados = getManager().createQuery(jpql, AluguelCarroInfo.class).getResultList();
		
		for (AluguelCarroInfo carroInfo : resultados) {
			System.out.println("Modelo: " + carroInfo.getCarro().getModeloCarro().getDescricao());
			System.out.println("Quantidade de Alugueis: " + carroInfo.getTotalAlugueis());
			System.out.println("Valor Maximo: " + carroInfo.getValorMaximo());		
			System.out.println("Valor Medio: " + carroInfo.getValorMedio());
		}
	}	

}
