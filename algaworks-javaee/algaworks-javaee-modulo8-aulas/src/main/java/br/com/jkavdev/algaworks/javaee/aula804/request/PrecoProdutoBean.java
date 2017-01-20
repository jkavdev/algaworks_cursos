package br.com.jkavdev.algaworks.javaee.aula804.request;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.aula803.service.CalculadoraPreco;

@Named("precoProdutoRequestBean")
@RequestScoped
public class PrecoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

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
