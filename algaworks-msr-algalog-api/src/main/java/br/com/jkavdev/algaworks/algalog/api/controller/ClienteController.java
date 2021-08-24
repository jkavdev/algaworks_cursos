package br.com.jkavdev.algaworks.algalog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.algalog.domain.model.Cliente;
import br.com.jkavdev.algaworks.algalog.domain.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@GetMapping("/clientes")
	private List<Cliente> listar() {
		return repository.findAll();
	}

}
