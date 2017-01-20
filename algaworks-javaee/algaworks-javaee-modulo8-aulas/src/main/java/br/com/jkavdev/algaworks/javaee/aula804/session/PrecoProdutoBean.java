package br.com.jkavdev.algaworks.javaee.aula804.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.aula803.service.CalculadoraPreco;

@Named("precoProdutoSessionBean")
@SessionScoped
public class PrecoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CalculadoraPreco calculadora;
	
	@PostConstruct
	public void init(){
		System.out.println("Iniciando session");
	}
	
	public double getPreco(){
		return calculadora.calcularPreco(12, 4.55);
	}

}
