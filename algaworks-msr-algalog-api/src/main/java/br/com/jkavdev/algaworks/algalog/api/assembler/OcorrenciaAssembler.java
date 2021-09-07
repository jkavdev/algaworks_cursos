package br.com.jkavdev.algaworks.algalog.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algalog.api.model.OcorrenciaModel;
import br.com.jkavdev.algaworks.algalog.domain.model.Ocorrencia;

@Component
public class OcorrenciaAssembler {

	@Autowired
	private ModelMapper mapper;

	public OcorrenciaModel toModel(Ocorrencia entrega) {
		return mapper.map(entrega, OcorrenciaModel.class);
	}

	public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream().map(this::toModel).toList();
	}

}
