package br.com.jkavdev.algaworks.di.service;

import br.com.jkavdev.algaworks.di.modelo.Cliente;
import br.com.jkavdev.algaworks.di.notificacao.Notificador;

public class AtivacaoClienteService {

	private Notificador notificador;

	public AtivacaoClienteService(Notificador notificador) {
		super();
		this.notificador = notificador;
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
	}

}
