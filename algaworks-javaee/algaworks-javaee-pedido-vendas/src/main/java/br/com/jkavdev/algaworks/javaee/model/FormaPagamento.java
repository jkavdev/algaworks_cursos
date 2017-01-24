package br.com.jkavdev.algaworks.javaee.model;

public enum FormaPagamento {

	DINHEIRO("Dinheiro"), 
	CARTAO_CREDITO("Cartão de crédito"), 
	CARTAO_DEBIITO("Cartão de débito"), 
	CHEQUE("Cheque"), 
	BOLETO_BANCARIO("Boleto bancário"), 
	DEPOSITO_BANCARIO("Depósito bancário");

	private String descricao;

	private FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
