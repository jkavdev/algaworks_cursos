package br.com.jkavdev.algaworks.osworks.api.exceptionhandler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.jkavdev.algaworks.osworks.api.domain.exception.EntidadeNaoEncontradaException;
import br.com.jkavdev.algaworks.osworks.api.domain.exception.NegocioException;
import br.com.jkavdev.algaworks.osworks.api.exceptionhandler.Problema.Campo;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {
		ErrorResponse errorResponse = ErrorResponse.of(ex, HttpStatus.BAD_REQUEST);
		return handleExceptionInternal(ex, errorResponse.getProblema(), new HttpHeaders(), errorResponse.getStatus(),
				request);
	}

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handleNegocio(EntidadeNaoEncontradaException ex, WebRequest request) {
		ErrorResponse errorResponse = ErrorResponse.of(ex, HttpStatus.NOT_FOUND);
		return handleExceptionInternal(ex, errorResponse.getProblema(), new HttpHeaders(), errorResponse.getStatus(),
				request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ArrayList<Campo> campos = new ArrayList<Problema.Campo>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			String nome = ((FieldError) error).getField();
			campos.add(new Problema.Campo(nome, mensagem));
		}

		Problema problema = new Problema(status.value(), "paramêtro inválido", campos);
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}

}
