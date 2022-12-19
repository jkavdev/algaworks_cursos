package br.com.jkavdev.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jkavdev.algaworks.algafood.notificacao.NotificadorEmail;

//@Configuration
public class NotificacaoConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		return null;
	}

}
