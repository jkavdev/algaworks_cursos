package br.com.jkavdev.algaworks.osworks.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.osworks.api.model.ComentarioInput;
import br.com.jkavdev.algaworks.osworks.api.model.ComentarioModel;
import br.com.jkavdev.algaworks.osworks.domain.GestaoOrdemServicoService;
import br.com.jkavdev.algaworks.osworks.domain.exception.EntidadeNaoEncontradaException;
import br.com.jkavdev.algaworks.osworks.domain.model.Comentario;
import br.com.jkavdev.algaworks.osworks.domain.model.OrdemServico;
import br.com.jkavdev.algaworks.osworks.domain.repository.OrdemServicoRepository;

@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentariosController {

	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServicoService;

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	public ComentarioModel adicionar(@PathVariable Long ordemServicoId,
			@Valid @RequestBody ComentarioInput comentario) {
		return toModel(gestaoOrdemServicoService.adicionarComentario(ordemServicoId, comentario.getDescricao()));
	}

	@GetMapping
	public List<ComentarioModel> listar(@PathVariable Long ordemServicoId) {
		OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ordem servico nao encontrada"));
		return toCollectionModel(ordemServico.getComentarios());
	}

	private ComentarioModel toModel(Comentario comentario) {
		return mapper.map(comentario, ComentarioModel.class);
	}

	private List<ComentarioModel> toCollectionModel(List<Comentario> comentarios) {
		return comentarios.stream().map(c -> toModel(c)).collect(Collectors.toList());
	}

}
