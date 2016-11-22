package br.com.jkavdev.algaworks.spring.wine.model;

public enum TipoVinho {
	
	BRANCO("Branco"),  
	TINTO("Tinto"), 
	ROSE("Rosé");
	
	private String descricao;

	private TipoVinho(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
