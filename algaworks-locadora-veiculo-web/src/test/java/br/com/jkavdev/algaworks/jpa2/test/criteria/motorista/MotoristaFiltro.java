package br.com.jkavdev.algaworks.jpa2.test.criteria.motorista;

public class MotoristaFiltro {

	private String nome;
	private Integer totalAlugueis;

	public MotoristaFiltro(String nome, Number totalAlugueis) {
		this.nome = nome;
		this.totalAlugueis = Integer.valueOf(totalAlugueis.intValue());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTotalAlugueis() {
		return totalAlugueis;
	}

	public void setTotalAlugueis(Integer totalAlugueis) {
		this.totalAlugueis = totalAlugueis;
	}

}
