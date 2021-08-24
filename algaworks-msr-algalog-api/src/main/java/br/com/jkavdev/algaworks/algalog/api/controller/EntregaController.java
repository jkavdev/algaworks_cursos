package br.com.jkavdev.algaworks.algalog.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.algalog.domain.model.Entrega;
import br.com.jkavdev.algaworks.algalog.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private SolicitacaoEntregaService service;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Entrega adicionar(@RequestBody @Valid Entrega entrega) {
		return service.solicitar(entrega);
	}

}
