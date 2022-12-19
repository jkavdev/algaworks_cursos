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

/**
 * @Profile("prod") - definindo o profile que esse bean sera registrado
 * se o profile setado ao rodar o projeto for diferente desse, esse bean nem sera registrado
 */
@Profile("prod")
@Component
public class NotificadorEmail implements Notificador {
	
	public NotificadorEmail() {
		System.out.println("NotificadorEmail");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
