package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.com.jkavdev.algaworks.javaee.model.Categoria;
import br.com.jkavdev.algaworks.javaee.model.Produto;
import br.com.jkavdev.algaworks.javaee.repository.Categorias;
import br.com.jkavdev.algaworks.javaee.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;

	private Produto produto;
	private Categoria categoriaPai;

	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;

	public CadastroProdutosBean() {
		produto = new Produto();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			System.out.println("Inicializando....");
			categoriasRaizes = categorias.raizes();
		}
	}
	
	public void carregarSubcategorias(){
		System.out.println("carregarSubcategorias....");
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}

	public void salvar() {
		System.out.println("Categoria pai selecionada: " + categoriaPai.getDescricao());
		System.out.println("Categoria selecionada: " + produto.getCategoria().getDescricao());
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
