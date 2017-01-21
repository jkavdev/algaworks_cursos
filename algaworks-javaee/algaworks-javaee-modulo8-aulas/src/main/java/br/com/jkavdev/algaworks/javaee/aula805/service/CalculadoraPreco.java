package br.com.jkavdev.algaworks.javaee.aula805.service;

import javax.inject.Named;

@Named("calculadoraPrecoInjection")
public class CalculadoraPreco {
	
	public double calcularPreco(int quantidade, double precoUnitario){
		return quantidade * precoUnitario;
	}

}
