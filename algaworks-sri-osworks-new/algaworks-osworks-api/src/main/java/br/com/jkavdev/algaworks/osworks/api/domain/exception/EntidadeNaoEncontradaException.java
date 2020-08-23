package br.com.jkavdev.algaworks.osworks.api.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}

}
