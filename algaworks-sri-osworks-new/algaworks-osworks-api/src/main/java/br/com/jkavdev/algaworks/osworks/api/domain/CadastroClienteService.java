package br.com.jkavdev.algaworks.osworks.api.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jkavdev.algaworks.osworks.api.domain.exception.NegocioException;
import br.com.jkavdev.algaworks.osworks.api.domain.model.Cliente;
import br.com.jkavdev.algaworks.osworks.api.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("já existe um cliente cadastrado com este email: " + cliente.getEmail());
		}

		return clienteRepository.save(cliente);
	}

	public void excluir(Long clienteId) {
		if (clienteRepository.countOrdensServicoPorCliente(clienteId) > 0) {
			throw new NegocioException("já existem ordens de serviço atribuídas ao cliente");
		}

		clienteRepository.deleteById(clienteId);
	}

}
