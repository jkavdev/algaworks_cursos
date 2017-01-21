package br.com.jkavdev.algaworks.javaee.aula806.service;

import javax.enterprise.inject.Default;

@Default
public class MensageiroCorreio implements Mensageiro {

	@Override
	public void enviarMensagem(String mensagem) {
		System.out.println("Enviando mensagem por correio: " + mensagem);
	}

}
