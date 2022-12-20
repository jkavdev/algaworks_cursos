package br.com.jkavdev.algaworks.algafood.modelo;

public class Cliente {

	private String email;
	private String nome;
	private String telefone;
	private boolean ativo;
	
	public Cliente(String email, String nome, String telefone) {
		super();
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getEmail() {
		return this.email;
	}
	public String getTelefone() {
		return telefone;
	}
	public boolean isAtivo() {
		return ativo;
	}
	
	public void ativar() {
		this.ativo = true;
	}

}
