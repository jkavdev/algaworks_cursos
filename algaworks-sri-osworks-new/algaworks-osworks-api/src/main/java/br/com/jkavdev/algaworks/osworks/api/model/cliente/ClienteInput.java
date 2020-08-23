package br.com.jkavdev.algaworks.osworks.api.model.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteInput {

	@NotBlank
	@Size(max = 60)
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(max = 20)
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
