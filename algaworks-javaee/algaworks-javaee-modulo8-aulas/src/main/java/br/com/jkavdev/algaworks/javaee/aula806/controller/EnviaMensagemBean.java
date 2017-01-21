package br.com.jkavdev.algaworks.javaee.aula806.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.aula806.service.Mensageiro;
import br.com.jkavdev.algaworks.javaee.aula806.service.Urgente;

@Named
@RequestScoped
public class EnviaMensagemBean {

	@Inject
//	@Default
	
	@Urgente
	private Mensageiro mensageiro;

	private String texto;

	public void enviarMensagem() {
		mensageiro.enviarMensagem(texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
