package br.com.jkavdev.algaworks.algafood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;
import br.com.jkavdev.algaworks.algafood.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

	@Autowired
	private Notificador notificador;

	public void ativar(Cliente cliente) {
		cliente.ativar();

		if (notificador == null) {
			System.out.println("Nao existe notificar mas cliente foi ativado");
		} else {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
		}

	}

}
