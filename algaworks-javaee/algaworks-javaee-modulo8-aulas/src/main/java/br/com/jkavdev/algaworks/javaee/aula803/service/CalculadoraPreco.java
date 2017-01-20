package br.com.jkavdev.algaworks.javaee.aula803.service;

import javax.inject.Named;

@Named("calculadoraPrecoController")
public class CalculadoraPreco {
	
	public double calcularPreco(int quantidade, double precoUnitario){
		return quantidade * precoUnitario;
	}

}
