package br.com.jkavdev.algaworks.algafood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;
import br.com.jkavdev.algaworks.algafood.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

	/**
	 * @Autowired - podemos indicar pelo atributo
	 */
//	@Autowired
	private Notificador notificador;

	/**
	 * @Autowired - a classe pode haver mais de um construtor, mas o contrutor que deve preencher o bean tem que ser definido com @Autowired
	 */
	@Autowired(required = false)
	public AtivacaoClienteService(Notificador notificador) {
		super();
		this.notificador = notificador;
		System.out.println(notificador);
	}
	
	public AtivacaoClienteService(String qualquer) {
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		if(notificador == null) {
			System.out.println("Nao existe notificar mas cliente foi ativado");
		} else {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
		}
		
	}
	
	/**
	 * @Autowired - podemos injetar um bean pelo setter do atribunto, neste caso a classe precisa ter o construtor padrao 
	 */
//	@Autowired
	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}

}
