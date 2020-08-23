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

import br.com.jkavdev.algaworks.osworks.api.domain.GestaoOrdemServiceService;
import br.com.jkavdev.algaworks.osworks.api.domain.model.Comentario;
import br.com.jkavdev.algaworks.osworks.api.domain.model.OrdemServico;
import br.com.jkavdev.algaworks.osworks.api.model.comentario.ComentarioInput;
import br.com.jkavdev.algaworks.osworks.api.model.comentario.ComentarioModel;

@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {

	@Autowired
	private GestaoOrdemServiceService gestaoOrdemServico;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	public ComentarioModel adicionar(@PathVariable("ordemServicoId") Long ordemServicoId,
			@Valid @RequestBody ComentarioInput comentarioInput) {
		return toModel(gestaoOrdemServico.adicionarComentario(ordemServicoId, comentarioInput.getDescricao()));
	}

	@GetMapping
	public List<ComentarioModel> listar(@PathVariable("ordemServicoId") Long ordemServicoId) {
		OrdemServico ordemServico = gestaoOrdemServico.buscar(ordemServicoId);
		return toCollectionModel(ordemServico.getComentarios());
	}

	private ComentarioModel toModel(Comentario comentario) {
		return mapper.map(comentario, ComentarioModel.class);
	}

	private List<ComentarioModel> toCollectionModel(List<Comentario> comentarios) {
		return comentarios.stream()
				.map(comentario -> mapper.map(comentario, ComentarioModel.class))
				.collect(Collectors.toList());
	}

}
