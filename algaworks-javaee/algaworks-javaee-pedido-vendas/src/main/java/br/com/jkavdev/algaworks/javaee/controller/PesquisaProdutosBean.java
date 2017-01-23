package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.model.Produto;
import br.com.jkavdev.algaworks.javaee.repository.Produtos;
import br.com.jkavdev.algaworks.javaee.repository.filter.ProdutoFilter;
import br.com.jkavdev.algaworks.javaee.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	private Produto produtoSelecionado;
	private ProdutoFilter filtro;

	private List<Produto> produtosFiltrados;

	public PesquisaProdutosBean() {
		filtro = new ProdutoFilter();
	}

	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}
	
	public void excluir(){
		produtos.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessagem("Produto " + produtoSelecionado.getSku() + " excluído com sucesso");
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(ProdutoFilter filtro) {
		this.filtro = filtro;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

}
