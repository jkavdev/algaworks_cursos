package br.com.jkavdev.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	private List<Cliente> listar() {

		Cliente cliente = new Cliente();
		cliente.setEmail("jhonatan@email.com");
		cliente.setNome("Jhonatan");
		cliente.setTelefone("9999999999");

		return Arrays.asList(cliente);
	}

}
