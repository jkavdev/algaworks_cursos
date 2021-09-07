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
import br.com.jkavdev.algaworks.algalog.api.model.DestinarioModel;
import br.com.jkavdev.algaworks.algalog.api.model.EntregaModel;
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
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return repository.findById(entregaId).map(entrega -> {

			EntregaModel model = new EntregaModel();
			model.setDataFinalizacao(entrega.getDataFinalizacao());
			model.setDataPedido(entrega.getDataPedido());
			model.setId(entrega.getId());
			model.setNomeCliente(entrega.getCliente().getNome());
			model.setStatus(entrega.getStatus());
			model.setTaxa(entrega.getTaxa());
			
			DestinarioModel destinarioModel = new DestinarioModel();
			destinarioModel.setBairro(entrega.getDestinatario().getBairro());
			destinarioModel.setComplemento(entrega.getDestinatario().getComplemento());
			destinarioModel.setLogradouro(entrega.getDestinatario().getLogradouro());
			destinarioModel.setNome(entrega.getDestinatario().getNome());
			destinarioModel.setNumero(entrega.getDestinatario().getNumero());
			
			model.setDestinario(destinarioModel);

			return ResponseEntity.ok(model);
		}).orElse(ResponseEntity.notFound().build());
	}

}
