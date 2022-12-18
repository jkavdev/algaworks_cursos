package br.com.jkavdev.algaworks.di.notificacao;

import br.com.jkavdev.algaworks.di.modelo.Cliente;

public interface Notificador {

	public void notificar(Cliente cliente, String mensagem);

}
