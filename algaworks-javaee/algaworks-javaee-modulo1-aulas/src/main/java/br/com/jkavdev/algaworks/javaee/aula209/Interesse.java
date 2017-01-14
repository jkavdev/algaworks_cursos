package br.com.jkavdev.algaworks.javaee.aula209;

public class Interesse {

	private String nomeIcone;
	private String descricao;

	public Interesse() {
	}

	public Interesse(String descricao, String nomeIcone) {
		this.nomeIcone = nomeIcone;
		this.descricao = descricao;
	}

	public String getNomeIcone() {
		return nomeIcone;
	}

	public void setNomeIcone(String nomeIcone) {
		this.nomeIcone = nomeIcone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
