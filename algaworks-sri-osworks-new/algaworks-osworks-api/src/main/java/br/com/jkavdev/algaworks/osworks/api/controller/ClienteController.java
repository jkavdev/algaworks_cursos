package br.com.jkavdev.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.osworks.api.domain.CadastroClienteService;
import br.com.jkavdev.algaworks.osworks.api.domain.model.Cliente;
import br.com.jkavdev.algaworks.osworks.api.domain.repository.ClienteRepository;
import br.com.jkavdev.algaworks.osworks.api.model.cliente.ClienteInput;
import br.com.jkavdev.algaworks.osworks.api.model.cliente.ClienteModel;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CadastroClienteService cadastroClienteService;

	@GetMapping
	public List<ClienteModel> listar() {
		return toCollectionModel(clienteRepository.findAll());
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable("clienteId") Long clientId) {
		Optional<Cliente> optCliente = clienteRepository.findById(clientId);
		if (optCliente.isPresent()) {
			return ResponseEntity.ok(optCliente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel adicionar(@Valid @RequestBody ClienteInput clienteInput) {
		return toModel(cadastroClienteService.salvar(toEntity(clienteInput)));
	}

	@PutMapping("{clienteId}")
	public ResponseEntity<Void> atualizar(@PathVariable("clienteId") Long clienteId,
			@Valid @RequestBody ClienteInput clienteInput) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		Cliente cliente = toEntity(clienteInput);
		cliente.setId(clienteId);
		cadastroClienteService.salvar(cliente);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable("clienteId") Long clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cadastroClienteService.excluir(clienteId);

		return ResponseEntity.noContent().build();
	}

	private ClienteModel toModel(Cliente cliente) {
		return mapper.map(cliente, ClienteModel.class);
	}

	private List<ClienteModel> toCollectionModel(List<Cliente> clientes) {
		return clientes.stream()
				.map(cliente -> mapper.map(cliente, ClienteModel.class))
				.collect(Collectors.toList());
	}

	private Cliente toEntity(ClienteInput clienteInput) {
		return mapper.map(clienteInput, Cliente.class);
	}

}
