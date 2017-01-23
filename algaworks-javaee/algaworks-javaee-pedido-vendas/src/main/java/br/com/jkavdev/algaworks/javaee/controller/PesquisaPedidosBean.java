package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.model.Pedido;
import br.com.jkavdev.algaworks.javaee.model.StatusPedido;
import br.com.jkavdev.algaworks.javaee.repository.Pedidos;
import br.com.jkavdev.algaworks.javaee.repository.filter.PedidoFilter;

@Named
@ViewScoped
public class PesquisaPedidosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;

	private PedidoFilter filtro;

	private List<Pedido> pedidosFiltrados;

	public PesquisaPedidosBean() {
		filtro = new PedidoFilter();
		pedidosFiltrados = new ArrayList<Pedido>();
	}

	public void pesquisar() {
		pedidosFiltrados = pedidos.filtrados(filtro);
	}
	
	public StatusPedido[] getStatuses(){
		return StatusPedido.values();
	}

	public PedidoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(PedidoFilter filtro) {
		this.filtro = filtro;
	}

	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

}
