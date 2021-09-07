package br.com.jkavdev.algaworks.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.jkavdev.algaworks.algalog.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {

	private Long id;

	private String nomeCliente;
	
	private DestinarioModel destinario;

	private BigDecimal taxa;

	private StatusEntrega status;

	private OffsetDateTime dataPedido;

	private OffsetDateTime dataFinalizacao;

}
