package br.com.jkavdev.algaworks.algalog.ap.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteResource {
	
	@GetMapping("/clientes")
	private List<Cliente> listar(){
		
		Cliente cliente = new Cliente();
		cliente.setNome("Jhonatan");
		cliente.setTelefone("99999999");
		cliente.setId(1L);
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Jhonatan");
		cliente2.setTelefone("99999999");
		cliente2.setId(1L);
		
		return Arrays.asList(cliente, cliente2);
	}

}
