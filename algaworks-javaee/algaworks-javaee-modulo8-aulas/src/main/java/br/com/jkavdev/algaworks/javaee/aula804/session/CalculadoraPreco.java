package br.com.jkavdev.algaworks.javaee.aula804.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named("calculadoraPrecoSession")
public class CalculadoraPreco implements Serializable {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		System.out.println("Iniciando calculadora");
	}

	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}

}
