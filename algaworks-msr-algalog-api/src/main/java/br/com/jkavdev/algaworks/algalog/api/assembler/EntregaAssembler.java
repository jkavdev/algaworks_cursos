package br.com.jkavdev.algaworks.algalog.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algalog.api.model.EntregaModel;
import br.com.jkavdev.algaworks.algalog.domain.model.Entrega;

@Component
public class EntregaAssembler {

	@Autowired
	private ModelMapper mapper;

	public EntregaModel toModel(Entrega entrega) {
		return mapper.map(entrega, EntregaModel.class);
	}

	public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream().map(this::toModel).toList();
	}

}
