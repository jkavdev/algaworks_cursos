package br.com.jkavdev.algaworks.javaee.aula806.service;

@Urgente
public class MensageiroSms implements Mensageiro {

	@Override
	public void enviarMensagem(String mensagem) {
		System.out.println("Enviando mensagem por SMS: " + mensagem);
	}

}
