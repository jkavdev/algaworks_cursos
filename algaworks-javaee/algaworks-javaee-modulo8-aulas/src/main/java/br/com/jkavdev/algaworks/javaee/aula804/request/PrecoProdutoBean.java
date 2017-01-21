package br.com.jkavdev.algaworks.javaee.aula804.request;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.aula804.request.CalculadoraPreco;

@Named("precoProdutoRequestBean")
@RequestScoped
public class PrecoProdutoBean {

	@Inject
	private CalculadoraPreco calculadora;
	
	@PostConstruct
	public void init(){
		System.out.println("Iniciando request");
	}
	
	public double getPreco(){
		return calculadora.calcularPreco(12, 4.55);
	}

}
