package br.com.jkavdev.algaworks.jpa2.modelos;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {

	private String prefixo;
	private String numero;
	private String ramal;

	public Telefone() {
		super();
	}

	public Telefone(String prefixo, String numero, String ramal) {
		this();
		this.prefixo = prefixo;
		this.numero = numero;
		this.ramal = ramal;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

}
