package br.com.jkavdev.algaworks.jpa2.modelos;

public enum Pagamento {
	
	AVISTA("À Vista"),
	PARCELADO("Parecelado 2 vezes");
	
	private String descricao;

	private Pagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
