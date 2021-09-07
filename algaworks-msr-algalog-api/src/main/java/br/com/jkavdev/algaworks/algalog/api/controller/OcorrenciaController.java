package br.com.jkavdev.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.algalog.api.assembler.OcorrenciaAssembler;
import br.com.jkavdev.algaworks.algalog.api.input.OcorrenciaInput;
import br.com.jkavdev.algaworks.algalog.api.model.OcorrenciaModel;
import br.com.jkavdev.algaworks.algalog.domain.model.Entrega;
import br.com.jkavdev.algaworks.algalog.domain.service.BuscaEntregaService;
import br.com.jkavdev.algaworks.algalog.domain.service.RegistroOcorrenciaService;

@RestController
@RequestMapping("entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private RegistroOcorrenciaService ocorrenciaService;

	@Autowired
	private OcorrenciaAssembler mapper;

	@Autowired
	private BuscaEntregaService buscaEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput input) {
		return mapper.toModel(ocorrenciaService.registrar(entregaId, input.getDescricao()));
	}

	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return mapper.toCollectionModel(entrega.getOcorrencias());
	}

}
