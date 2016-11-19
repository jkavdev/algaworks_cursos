package br.com.jkavdev.algaworks.jpa2.test.criteria.carro;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Acessorio;
import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.modelos.Categoria;
import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class OperacoesEmCascata extends JunitJpaConfig {

	@Test
	public void entidadeTransient() {
		Carro carro = criaCarro("Preto", "DHS-1111");

		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setCategoria(Categoria.SEDAN_GRANDE);
		modeloCarro.setDescricao("Ferrai");

		carro.setModeloCarro(modeloCarro);

		beginTransaction();

		getManager().persist(carro);

		commit();
	}

	@Test
	public void salvandoCarroComAcessorios() {

		Carro carro = criaCarro("Azul", "LOS-1111");

		Acessorio acessorio = criaAcessorio("Acessorio1");
		Acessorio acessorio1 = criaAcessorio("Acessorio2");
		Acessorio acessorio2 = criaAcessorio("Acessorio2");
		
		List<Acessorio> acessorios = new ArrayList<>();

		acessorios.add(acessorio);
		acessorios.add(acessorio1);
		acessorios.add(acessorio2);
		
		carro.setAcessorios(acessorios);

		beginTransaction();

		getManager().persist(carro);

		commit();
	}
	
	@Test
	public void excluirAlguelCarroOrphan(){
		Carro carro = getManager().find(Carro.class, 9L);
		
		//Tentando excluir um objeto da lista de carro
		//Neste caso precisariamos indicar que o objeto da lista pode ser excluido
		//Fazemos isso com orphanRemoval=true, pois estamos retirando aquele aluguel de Carro
		beginTransaction();
		carro.getAlugueis().remove(0);
		commit();
	}

	public Carro criaCarro(String cor, String placa) {
		Carro carro = new Carro();
		carro.setCor(cor);
		carro.setPlaca(placa);

		return carro;
	}

	public Acessorio criaAcessorio(String descricao) {
		Acessorio acessorio = new Acessorio();
		acessorio.setDescricao(descricao);

		return acessorio;
	}

}
