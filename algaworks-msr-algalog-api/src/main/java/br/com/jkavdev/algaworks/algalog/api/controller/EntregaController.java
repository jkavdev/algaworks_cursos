package br.com.jkavdev.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.algalog.api.exceptionhandler.EntregaRepository;
import br.com.jkavdev.algaworks.algalog.domain.model.Entrega;
import br.com.jkavdev.algaworks.algalog.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private SolicitacaoEntregaService service;

	@Autowired
	private EntregaRepository repository;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Entrega adicionar(@RequestBody @Valid Entrega entrega) {
		return service.solicitar(entrega);
	}

	@GetMapping
	public List<Entrega> listar() {
		return repository.findAll();
	}

	@GetMapping("{entregaId}")
	public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {
		return repository.findById(entregaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
