package br.com.jkavdev.algaworks.algafood.notificacao;

import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;

/**
 * @Component - torna essa classe um bean gerenciavel pelo spring
 */
@Component
public class NotificadorSMS implements Notificador {
	
	public NotificadorSMS() {
		System.out.println("NotificadorSMS");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do SMS %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
