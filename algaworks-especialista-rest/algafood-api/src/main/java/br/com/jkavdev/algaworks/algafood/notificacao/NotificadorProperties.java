package br.com.jkavdev.algaworks.algafood.notificacao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @ConfigurationProperties("notificador.email") - definindo que essa classe representara as propriedade que iniciarem com notificador.email 
 */
@Component
@ConfigurationProperties("notificador.email")
public class NotificadorProperties {

	/**
	 * endereco smtp do servidor host
	 */
	private String hostServidor;

	/**
	 * porta do servidor host
	 */
	private Integer portaServidor;

	public String getHostServidor() {
		return hostServidor;
	}

	public void setHostServidor(String hostServidor) {
		this.hostServidor = hostServidor;
	}

	public Integer getPortaServidor() {
		return portaServidor;
	}

	public void setPortaServidor(Integer portaServidor) {
		this.portaServidor = portaServidor;
	}

}
