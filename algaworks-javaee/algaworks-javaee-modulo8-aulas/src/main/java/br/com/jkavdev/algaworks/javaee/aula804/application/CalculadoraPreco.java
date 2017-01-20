package br.com.jkavdev.algaworks.javaee.aula804.application;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculadoraPreco {

	@PostConstruct
	public void init() {
		System.out.println("Iniciando calculadora");
	}

	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}

}
