package br.com.jkavdev.algaworks.algafood.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algafood.notificacao.NivelUrgerncia;
import br.com.jkavdev.algaworks.algafood.notificacao.Notificador;
import br.com.jkavdev.algaworks.algafood.notificacao.TipoDoNotificador;
import br.com.jkavdev.algaworks.algafood.service.ClienteAtivadoEvent;

/**
 * componente responsavel por definir o que sera executado do event handler de cliente ativado 
 */

@Component
public class NotificacaoService {
	
	@TipoDoNotificador(NivelUrgerncia.NORMAL)
	@Autowired
	private Notificador notificador;
	
	/**
	 * @EventListener - anotacao que indica que esse metodo sera ouvinte do evento ClienteAtivadoEvent
	 */
	@EventListener
	public void clienteAtivadoEvent(ClienteAtivadoEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo");
	}

}
