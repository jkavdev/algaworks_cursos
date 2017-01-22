package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.model.Pedido;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pedido pedido;
	private List<Integer> itens;

	public CadastroPedidoBean() {
		pedido = new Pedido();
		itens = new ArrayList<Integer>();
		itens.add(1);
	}

	public void salvar() {
	}

	public Pedido getPedido() {
		return pedido;
	}

	public List<Integer> getItens() {
		return itens;
	}

}
