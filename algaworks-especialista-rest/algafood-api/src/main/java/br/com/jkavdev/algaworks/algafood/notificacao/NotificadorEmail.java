package br.com.jkavdev.algaworks.algafood.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;

/**
 * @Primary - define que este bean tera prioridade na hora de criar um bean de Notificador
 * ignorando os outros possiveis beans
 *
 */

//@Primary

/**
 * @Qualifier("email") - define um apelido para o bean
 *
 */
@Qualifier("email")	
@Component
public class NotificadorEmail implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
