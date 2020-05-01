package br.com.jkavdev.algaworks.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.jkavdev.algaworks.osworks.domain.ValidationGroups;

@Entity(name = "ordem_servico")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	@NotNull
	@ManyToOne
	private Cliente cliente;

	private String descricao;

	@NotNull
	private BigDecimal preco;

	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusOrderServico status;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime horarioAbertura;

	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime horarioFinalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public StatusOrderServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrderServico status) {
		this.status = status;
	}

	public OffsetDateTime getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(OffsetDateTime horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public OffsetDateTime getHorarioFinalizacao() {
		return horarioFinalizacao;
	}

	public void setHorarioFinalizacao(OffsetDateTime horarioFinalizacao) {
		this.horarioFinalizacao = horarioFinalizacao;
	}

}
