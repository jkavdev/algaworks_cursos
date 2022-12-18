package br.com.jkavdev.algaworks.algafood.notificacao;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;

public interface Notificador {

	public void notificar(Cliente cliente, String mensagem);

}
