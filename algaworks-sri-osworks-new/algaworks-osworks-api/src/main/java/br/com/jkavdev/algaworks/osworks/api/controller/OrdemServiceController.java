package br.com.jkavdev.algaworks.osworks.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.osworks.api.domain.GestaoOrdemServiceService;
import br.com.jkavdev.algaworks.osworks.api.domain.model.OrdemServico;
import br.com.jkavdev.algaworks.osworks.api.domain.repository.OrdemServiceRepository;
import br.com.jkavdev.algaworks.osworks.api.model.ordemservico.OrdemServicoInput;
import br.com.jkavdev.algaworks.osworks.api.model.ordemservico.OrdemServicoModel;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServiceController {

	@Autowired
	private OrdemServiceRepository ordemServicoRepository;

	@Autowired
	private GestaoOrdemServiceService gestaoOrdemServico;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoModel criar(@Valid @RequestBody OrdemServicoInput ordemServicoInput) {
		return toModel(gestaoOrdemServico.criar(toEntity(ordemServicoInput)));
	}

	@GetMapping
	public List<OrdemServicoModel> listar() {
		return toCollectionModel(ordemServicoRepository.findAll());
	}

	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServicoModel> buscar(@PathVariable("ordemServicoId") Long ordemServicoId) {
		OrdemServico ordemServico = gestaoOrdemServico.buscar(ordemServicoId);
		return ResponseEntity.ok(toModel(ordemServico));
	}

	@PutMapping("/{ordemServicoId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable("ordemServicoId") Long ordemServicoId) {
		gestaoOrdemServico.finalizar(ordemServicoId);
	}

	@PutMapping("/{ordemServicoId}/cancelamento")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cancelar(@PathVariable("ordemServicoId") Long ordemServicoId) {
		gestaoOrdemServico.cancelar(ordemServicoId);
	}

	private OrdemServicoModel toModel(OrdemServico ordemServico) {
		return mapper.map(ordemServico, OrdemServicoModel.class);
	}

	private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordensServico) {
		return ordensServico.stream()
				.map(ordemServico -> mapper.map(ordemServico, OrdemServicoModel.class))
				.collect(Collectors.toList());
	}

	private OrdemServico toEntity(OrdemServicoInput ordemServicoInput) {
		return mapper.map(ordemServicoInput, OrdemServico.class);
	}

}
