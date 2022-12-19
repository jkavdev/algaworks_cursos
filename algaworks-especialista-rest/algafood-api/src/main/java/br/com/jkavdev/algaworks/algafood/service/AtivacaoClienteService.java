package br.com.jkavdev.algaworks.algafood.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;
import br.com.jkavdev.algaworks.algafood.notificacao.NivelUrgerncia;
import br.com.jkavdev.algaworks.algafood.notificacao.Notificador;
import br.com.jkavdev.algaworks.algafood.notificacao.TipoDoNotificador;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * implements DisposableBean, InitializingBean - implementando interfaces que disponibilizam callbacks
 *
 */
@Component
public class AtivacaoClienteService implements DisposableBean, InitializingBean {

	/**
	 * como temos varias implementacoes de Notificador, o spring nao sabe qual
	 * injetar uma das formas de contornar o erro, eh transformando em uma lista de beans
	 */
//	@Autowired
//	private List<Notificador> notificadores;
	
	/**
	 * @Qualifier("email") - utilizando o apelido do bean para receber uma instancia
	 */
//	@Qualifier("email")
	
	/**
	 * @TipoDoNotificador(NivelUrgerncia.NORMAL) - utilizando o bean com o identificador definido pela anotacao 
	 */
	@TipoDoNotificador(NivelUrgerncia.NORMAL)	
	@Autowired
	private Notificador notificador;
	
	/**
	 * @PostConstruct - sera chamado depois da construcao do bean 
	 */
	@PostConstruct
	public void init() {
		System.out.println("init");
	}
	
	/**
	 * @PostConstruct - sera chamado antes da destruicao do bean 
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo");

	}

	/**
	 * afterPropertiesSet - sera chamado depois da construcao do bean
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

}
