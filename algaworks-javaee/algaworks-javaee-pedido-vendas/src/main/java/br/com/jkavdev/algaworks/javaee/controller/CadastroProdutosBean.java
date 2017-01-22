package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.model.Categoria;
import br.com.jkavdev.algaworks.javaee.model.Produto;
import br.com.jkavdev.algaworks.javaee.repository.Categorias;

@Named
@ViewScoped
public class CadastroProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;

	private Produto produto;
	private List<Categoria> categoriasRaizes;

	public CadastroProdutosBean() {
		produto = new Produto();
	}

	public void inicializar() {
		System.out.println("Inicializando.....");
		categoriasRaizes = categorias.raizes();
	}

	public void cadastrar() {

	}

	public Produto getProduto() {
		return produto;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

}
