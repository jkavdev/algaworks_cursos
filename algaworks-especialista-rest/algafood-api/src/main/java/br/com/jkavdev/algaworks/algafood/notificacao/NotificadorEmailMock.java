package br.com.jkavdev.algaworks.algafood.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;

/**
 * @Primary - define que este bean tera prioridade na hora de criar um bean de Notificador
 * ignorando os outros possiveis beans
 */

//@Primary

/**
 * @Qualifier("email") - define um apelido para o bean
 */
//@Qualifier("email")	

/**
 * @TipoDoNotificador(NivelUrgerncia.NORMAL) - utilizando a definicao do apelido pela anotacao
 */
@TipoDoNotificador(NivelUrgerncia.NORMAL)
@Profile("dev")
@Component
public class NotificadorEmailMock implements Notificador {
	
	public NotificadorEmailMock() {
		System.out.println("NotificadorEmailMock");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("MOCK: Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
