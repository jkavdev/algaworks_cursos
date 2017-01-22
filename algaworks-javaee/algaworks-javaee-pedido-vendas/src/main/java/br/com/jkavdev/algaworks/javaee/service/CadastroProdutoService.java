package br.com.jkavdev.algaworks.javaee.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.javaee.model.Produto;
import br.com.jkavdev.algaworks.javaee.repository.Produtos;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	public Produto salvar(Produto produto) {
		System.out.println("porSku....");
		Produto produtoExistente = produtos.porSku(produto.getSku());

		if (produtoExistente != null) {
			throw new NegocioException("Já existe um produto com o SKU informado.");
		}

		return produtos.guardar(produto);
	}

}
