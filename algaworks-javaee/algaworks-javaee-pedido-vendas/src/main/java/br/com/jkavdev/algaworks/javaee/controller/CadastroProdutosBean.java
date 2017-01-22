package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.model.Produto;

@Named
@ViewScoped
public class CadastroProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;

	public CadastroProdutosBean() {
		produto = new Produto();
	}

	public void cadastrar() {

	}

	public Produto getProduto() {
		return produto;
	}

}
