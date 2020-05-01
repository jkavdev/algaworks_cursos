package br.com.jkavdev.algaworks.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class OrdemServicoModel {

	private Long id;
	private String nomeCliente;
	private ResumoClienteModel cliente;
	private String descricao;
	private BigDecimal preco;
	private OffsetDateTime horarioAbertura;
	private OffsetDateTime horarioFinalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public ResumoClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ResumoClienteModel cliente) {
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
