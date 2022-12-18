package br.com.jkavdev.algaworks.di.service;

import br.com.jkavdev.algaworks.di.modelo.Cliente;
import br.com.jkavdev.algaworks.di.modelo.Produto;
import br.com.jkavdev.algaworks.di.notificacao.Notificador;

public class EmissaoNotaFiscalService {

	private Notificador notificador;

	public EmissaoNotaFiscalService(Notificador notificador) {
		super();
		this.notificador = notificador;
	}

	public void emitir(Cliente cliente, Produto produto) {
		notificador.notificar(cliente, "Nota fidscal do produto " + produto.getNome() + " for emitida");
	}

}
