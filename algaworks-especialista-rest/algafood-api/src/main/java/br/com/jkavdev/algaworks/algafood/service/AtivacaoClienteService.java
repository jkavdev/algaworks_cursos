package br.com.jkavdev.algaworks.algafood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;
import br.com.jkavdev.algaworks.algafood.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

	/**
	 * como temos varias implementacoes de Notificador, o spring nao sabe qual injetar
	 * uma das formas de contornar o erro, eh transformando em uma lista de beans
	 */
	@Autowired
	private List<Notificador> notificadores;

	public void ativar(Cliente cliente) {
		cliente.ativar();

		for (Notificador notificador : notificadores) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
		}

	}

}
