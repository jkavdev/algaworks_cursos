package br.com.jkavdev.algaworks.jpa2.test.produto;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.exercicio.CategoriaProduto;
import br.com.jkavdev.algaworks.jpa2.modelos.exercicio.Produto;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ProdutoCategriaTest extends JunitJpaConfig {

	@Test
	public void salvarProduto() {
		Produto computador = criaProduto("Sofa");

		beginTransaction();
		getManager().persist(computador);
		commit();
	}

	@Test
	public void salvarCategoria() {
		CategoriaProduto eletro = criaCategoria("Eletrodomestico");

		beginTransaction();
		getManager().persist(eletro);
		commit();
	}

	@Test
	public void salvarProdutoComCategoria() {
		Produto computador = criaProduto("Mesa");
		CategoriaProduto eletro = criaCategoria("Movel");

		computador.setCategoria(eletro);

		beginTransaction();
		getManager().persist(computador);
		commit();
	}

	@Test
	public void salvarProdutosEmCategoria() {
		CategoriaProduto categoriaProduto = getManager().find(CategoriaProduto.class, 4L);

		beginTransaction();

		List<Produto> produtos = getManager().createQuery("from Produto", Produto.class).getResultList();
		for (Produto produto : produtos) {
			produto.setCategoria(categoriaProduto);
		}

		categoriaProduto.setProdutos(produtos);

		getManager().merge(categoriaProduto);

		commit();

	}

	@Test
	public void removendoProdutoDeCategoria() {
		CategoriaProduto categoriaProduto = getManager().find(CategoriaProduto.class, 4L);

		beginTransaction();

		categoriaProduto.getProdutos().remove(0);

		for (Produto produto : categoriaProduto.getProdutos()) {
			System.out.println(produto.getNome());
		}

		commit();
	}

	public Produto criaProduto(String nome) {
		Produto produto = new Produto();
		produto.setNome(nome);

		return produto;
	}

	public CategoriaProduto criaCategoria(String nome) {
		CategoriaProduto categoria = new CategoriaProduto();
		categoria.setNome(nome);

		return categoria;
	}

}
