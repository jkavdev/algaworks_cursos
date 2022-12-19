package br.com.jkavdev.algaworks.algafood.service;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;

/**
 * classe pojo representando o evento de cliente ativado
 */

public class ClienteAtivadoEvent {

	private Cliente cliente;

	public ClienteAtivadoEvent(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
