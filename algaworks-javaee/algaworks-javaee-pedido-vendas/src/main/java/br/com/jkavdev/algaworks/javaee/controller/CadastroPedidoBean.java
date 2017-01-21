package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.service.NegocioException;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> itens;

	public CadastroPedidoBean() {
		itens = new ArrayList<Integer>();
		itens.add(1);
	}

	public void salvar() {
		throw new NegocioException("Exceção Negocio: cadastro de pedidos não implementado");
	}

	public List<Integer> getItens() {
		return itens;
	}

}
