package br.com.jkavdev.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import br.com.jkavdev.algaworks.osworks.api.model.OrdemServicoInput;
import br.com.jkavdev.algaworks.osworks.api.model.OrdemServicoModel;
import br.com.jkavdev.algaworks.osworks.domain.GestaoOrdemServicoService;
import br.com.jkavdev.algaworks.osworks.domain.model.OrdemServico;
import br.com.jkavdev.algaworks.osworks.domain.repository.OrdemServicoRepository;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServicoService;

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoModel criar(@Valid @RequestBody OrdemServicoInput osi) {
		OrdemServico ordemServico = toEntity(osi);
		return toModel(gestaoOrdemServicoService.criar(ordemServico));
	}

	@GetMapping
	public List<OrdemServicoModel> listar() {
		return toCollectionModel(ordemServicoRepository.findAll());
	}

	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long ordemServicoId) {

		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);

		if (ordemServico.isPresent()) {
			return ResponseEntity.ok(toModel(ordemServico.get()));
		}

		return ResponseEntity.notFound().build();
	}

	private OrdemServicoModel toModel(OrdemServico ordemServico) {
		return mapper.map(ordemServico, OrdemServicoModel.class);
	}

	private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordensServicos) {
		return ordensServicos.stream().map(os -> toModel(os))
				
				.collect(Collectors.toList());
	}

	private OrdemServico toEntity(OrdemServicoInput ordemServicoInput) {
		return mapper.map(ordemServicoInput, OrdemServico.class);
	}

}
