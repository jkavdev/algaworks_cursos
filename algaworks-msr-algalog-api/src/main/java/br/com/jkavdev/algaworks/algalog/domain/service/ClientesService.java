package br.com.jkavdev.algaworks.algalog.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jkavdev.algaworks.algalog.domain.exception.NegocioException;
import br.com.jkavdev.algaworks.algalog.domain.model.Cliente;
import br.com.jkavdev.algaworks.algalog.domain.repository.ClienteRepository;

@Service
public class ClientesService {

	@Autowired
	private ClienteRepository repository;

	@Transactional
	public Cliente salvar(Cliente cliente) {
		Optional<Cliente> c = repository.findByEmail(cliente.getEmail());

		if (c.isPresent()) {
			throw new NegocioException("email já utilizado!");
		}

		return repository.save(cliente);
	}

}
