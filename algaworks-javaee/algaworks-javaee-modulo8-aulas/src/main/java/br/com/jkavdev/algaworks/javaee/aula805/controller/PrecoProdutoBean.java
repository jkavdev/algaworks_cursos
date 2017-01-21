package br.com.jkavdev.algaworks.javaee.aula805.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.aula805.service.CalculadoraPreco;

@Named("precoProdutoInjection")
public class PrecoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CalculadoraPreco calculadora;

	public PrecoProdutoBean() {

	}

	// O inject pode ser declarado no contrutor e no set da propriedade

	// @Inject
	// public PrecoProdutoBean(CalculadoraPreco calculadora) {
	// this.calculadora = calculadora;
	// }

	public double getPreco() {
		return calculadora.calcularPreco(12, 4.55);
	}

	// @Inject
	// public void setCalculadora(CalculadoraPreco calculadora) {
	// this.calculadora = calculadora;
	// }

}
