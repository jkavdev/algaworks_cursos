package br.com.jkavdev.algaworks.algalog.ap.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.jkavdev.algaworks.algalog.ap.exceptionhandler.ErroRequisicao.Campo;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Campo> campos = ex.getBindingResult().getAllErrors().stream()
				.map(error -> new ErroRequisicao.Campo(((FieldError) error).getField(),
						messageSource.getMessage(error, LocaleContextHolder.getLocale())))
				.collect(Collectors.toList());

		ErroRequisicao erro = new ErroRequisicao();
		erro.setCampos(campos);
		erro.setStatus(status.value());
		erro.setTitulo("Campo(s) inválido(s)");

		return handleExceptionInternal(ex, erro, headers, status, request);
	}

}
