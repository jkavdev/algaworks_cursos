package br.com.jkavdev.algaworks.javaee.aula803;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.aula803.service.CalculadoraPreco;

@Named
public class PrecoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CalculadoraPreco calculadora;
	
	public double getPreco(){
		return calculadora.calcularPreco(12, 4.55);
	}

}
