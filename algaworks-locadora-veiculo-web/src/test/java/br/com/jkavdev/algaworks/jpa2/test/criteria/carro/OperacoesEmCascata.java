package br.com.jkavdev.algaworks.jpa2.test.criteria.carro;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.modelos.Categoria;
import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class OperacoesEmCascata extends JunitJpaConfig {

	@Test
	public void entidadeTransient() {
		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setPlaca("DHS-1111");

		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setCategoria(Categoria.SEDAN_GRANDE);
		modeloCarro.setDescricao("Ferrai");

		carro.setModeloCarro(modeloCarro);

		beginTransaction();

		getManager().persist(carro);

		commit();
	}

}
