package br.com.jkavdev.algaworks.algafood;

import org.springframework.context.annotation.Bean;

import br.com.jkavdev.algaworks.algafood.notificacao.NotificadorEmail;
import br.com.jkavdev.algaworks.algafood.service.AtivacaoClienteService;

/**
 * @Configuration - define essa classe como um bean de configuracao
 *
 */
//@Configuration
public class AlgaConfig {

	/**
	 * @Bean - define que esse metodo retornara um bean gerenciavel ao spring
	 */
	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		return notificador;
	}

	/**
	 * @Bean - define que esse metodo retornara um bean gerenciavel ao spring
	 */
	@Bean
	public AtivacaoClienteService ativacaoClienteService() {
		/**
		 * new AtivacaoClienteService(notificadorEmail()) - passando o metodo que define um bean de notificacao
		 */
		AtivacaoClienteService ativacaoClienteService = new AtivacaoClienteService(notificadorEmail());
		return ativacaoClienteService;
	}

}
