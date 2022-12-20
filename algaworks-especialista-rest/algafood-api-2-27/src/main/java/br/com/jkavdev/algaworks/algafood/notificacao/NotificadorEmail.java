package br.com.jkavdev.algaworks.algafood.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	/**
	 * @Value("${notificador.email.host-servidor}") - acessando propriedade definida no arquivo de propriedades
	 */
	@Value("${notificador.email.host-servidor}")
	private String host;
	
	@Value("${notificador.email.porta-servidor}")
	private Integer portaHost;
	
	/**
	 * utilizando classe que encapsula as propriedades de notificador
	 */
	@Autowired
	private NotificadorProperties notificadorProperties;
	
	public NotificadorEmail() {
		System.out.println("NotificadorEmail " + host + " " + portaHost);
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("NotificadorEmail " + host + " " + portaHost);
		System.out.println("NotificadorEmail " + notificadorProperties.getHostServidor() + " " + notificadorProperties.getPortaServidor());
		
		System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
