package br.com.jkavdev.algaworks.di.notificacao;

import br.com.jkavdev.algaworks.di.modelo.Cliente;

public class NotificadorSMS implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do SMS %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
