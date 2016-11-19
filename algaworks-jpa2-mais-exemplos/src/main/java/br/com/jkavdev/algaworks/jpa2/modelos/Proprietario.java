package br.com.jkavdev.algaworks.jpa2.modelos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Proprietario {

	public String nome;
	public String telefone;
	public String email;

	public Proprietario() {
	}

	@Column(name = "nome_proprietario")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "telefone_proprietario")
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "email_proprietario")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}