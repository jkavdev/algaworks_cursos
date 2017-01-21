package br.com.jkavdev.algaworks.javaee.aula804.dependent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.aula804.dependent.CalculadoraPreco;

@Named("precoProdutoDependentBean")
@Dependent
public class PrecoProdutoBean {

	@Inject
	private CalculadoraPreco calculadora;

	@PostConstruct
	public void init() {
		System.out.println("Iniciando dependent");
	}

	public double getPreco() {
		return calculadora.calcularPreco(12, 4.55);
	}

}
