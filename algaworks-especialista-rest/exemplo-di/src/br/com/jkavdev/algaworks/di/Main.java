package br.com.jkavdev.algaworks.di;

import br.com.jkavdev.algaworks.di.modelo.Cliente;
import br.com.jkavdev.algaworks.di.notificacao.NotificadorEmail;
import br.com.jkavdev.algaworks.di.service.AtivacaoClienteService;

public class Main {
	
	public static void main(String[] args) {
		
		Cliente jhonatan = new Cliente("jhonatan@gmail.com", "Jhonatan", "61999999999");
		Cliente natalia = new Cliente("natalia@gmail.com", "Natalia", "61999999999");
		
		AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(new NotificadorEmail());
		ativacaoCliente.ativar(natalia);
		ativacaoCliente.ativar(jhonatan);
		
	}

}
