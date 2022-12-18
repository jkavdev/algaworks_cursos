package br.com.jkavdev.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jkavdev.algaworks.algafood.notificacao.Notificador;
import br.com.jkavdev.algaworks.algafood.service.AtivacaoClienteService;

//@Configuration
public class ServiceConfig {

	/**
	 * ativacaoClienteService(Notificador notificador) - quando precisamos de um bean que nao eh definido na classe
	 * podemos passar o bean requirido como argumento do metodo que o spring ira fornecer uma instancia ao metodo
	 */
	@Bean
	public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
		AtivacaoClienteService ativacaoClienteService = new AtivacaoClienteService(notificador);
		return ativacaoClienteService;
	}

}
