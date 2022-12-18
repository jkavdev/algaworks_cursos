package br.com.jkavdev.algaworks.algafood.notificacao;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;

/**
 * @Component - torna essa classe um bean gerenciavel pelo spring
 */
//@Component
public class NotificadorEmail implements Notificador {

	private boolean caixaAlta;
	private String hostSmtp;

	public NotificadorEmail(String hostServidorSmtp) {
		this.hostSmtp = hostServidorSmtp;
		System.out.println("NotificadorEmail");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		if (caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		System.out.printf("Notificando %s através do e-mail %s usando SMTP %s: %s\n", cliente.getNome(),
				cliente.getEmail(), hostSmtp, mensagem);
	}

}
