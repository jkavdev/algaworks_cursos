package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.com.jkavdev.algaworks.javaee.model.Categoria;
import br.com.jkavdev.algaworks.javaee.model.Produto;
import br.com.jkavdev.algaworks.javaee.repository.Categorias;
import br.com.jkavdev.algaworks.javaee.service.CadastroProdutoService;
import br.com.jkavdev.algaworks.javaee.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	@Inject
	private CadastroProdutoService cadastroProdutoService;

	private Produto produto;
	private Categoria categoriaPai;

	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;

	public CadastroProdutosBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			System.out.println("Inicializando....");
			categoriasRaizes = categorias.raizes();
		}
	}

	public void carregarSubcategorias() {
		System.out.println("carregarSubcategorias....");
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}

	private void limpar() {
		produto = new Produto();
		categoriaPai = null;
		subcategorias = new ArrayList<>();
	}

	public void salvar() {
		produto = cadastroProdutoService.salvar(produto);
		limpar();

		FacesUtil.addInfoMessagem("Produto salvo com sucesso!");
	}

	public Produto getProduto() {
		return produto;
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

}
