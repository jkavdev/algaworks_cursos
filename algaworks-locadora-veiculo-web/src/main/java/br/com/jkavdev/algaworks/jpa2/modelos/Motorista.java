package br.com.jkavdev.algaworks.jpa2.modelos;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("motorista")
public class Motorista extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String numeroCNH;

	@Column(name = "numero_cnh")
	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

}
