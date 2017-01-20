package br.com.jkavdev.algaworks.javaee.aula804.session;

import javax.annotation.PostConstruct;

public class CalculadoraPreco {

	@PostConstruct
	public void init() {
		System.out.println("Iniciando calculadora");
	}

	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}

}
