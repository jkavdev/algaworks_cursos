package br.com.jkavdev.algaworks.javaee.aula604;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "produtosConfirmBean")
@ViewScoped
public class ProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> produtos = new ArrayList<String>();
	private String produtoSelecionado;

	public ProdutosBean() {
		produtos.add("Arroz");
		produtos.add("Queijo");
		produtos.add("Feijão");
	}

	public void excluirProduto() {
		produtos.remove(produtoSelecionado);
	}

	public List<String> getProdutos() {
		return produtos;
	}

	public String getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(String produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}
