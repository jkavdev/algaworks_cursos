package br.com.jkavdev.algaworks.osworks.api.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus status;
	private Problema problema;

	public ErrorResponse(HttpStatus status, Problema problema) {
		this.status = status;
		this.problema = problema;
	}

	public static <T extends RuntimeException> ErrorResponse of(T erro, HttpStatus status) {
		return new ErrorResponse(status, new Problema(status.value(), erro.getMessage()));
	}

	public HttpStatus getStatus() {
		return status;
	}

	public Problema getProblema() {
		return problema;
	}

}
