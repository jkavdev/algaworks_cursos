package br.com.jkavdev.algaworks.osworks.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jkavdev.algaworks.osworks.domain.exception.NegocioException;
import br.com.jkavdev.algaworks.osworks.domain.model.Cliente;
import br.com.jkavdev.algaworks.osworks.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {

		Cliente existente = clienteRepository.findByEmail(cliente.getEmail());

		if (existente != null && !existente.equals(cliente)) {
			throw new NegocioException("já existe um cliente cadastrado com este e-mail.");
		}

		return clienteRepository.save(cliente);
	}

	public void remover(Long id) {
		clienteRepository.deleteById(id);
	}

}
