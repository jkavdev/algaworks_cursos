package br.com.jkavdev.algaworks.javaee.aula804.dependent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named("calculadoraPrecoDependent")
@Dependent
public class CalculadoraPreco {

	@PostConstruct
	public void init() {
		System.out.println("Iniciando calculadora");
	}

	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}

}
