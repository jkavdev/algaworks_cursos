package br.com.jkavdev.algaworks.algafood.notificacao;

import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;

@TipoDoNotificador(NivelUrgerncia.URGENTE)
@Component
public class NotificadorSMS implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do SMS %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
