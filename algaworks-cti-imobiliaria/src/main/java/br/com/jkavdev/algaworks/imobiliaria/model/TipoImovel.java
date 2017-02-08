package br.com.jkavdev.algaworks.imobiliaria.model;

public enum TipoImovel {
	
	APARTAMENTO("Apartamento"),
	TERRENO("Terreno"),
	CASA("Casa"),
	COMODO_COMERCIAL("Cômodo comercial");
	
	private String descricao;

	private TipoImovel(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
