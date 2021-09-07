package br.com.jkavdev.algaworks.algalog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jkavdev.algaworks.algalog.api.exceptionhandler.EntregaRepository;
import br.com.jkavdev.algaworks.algalog.domain.model.Cliente;
import br.com.jkavdev.algaworks.algalog.domain.model.Entrega;
import br.com.jkavdev.algaworks.algalog.domain.model.StatusEntrega;

@Service
public class SolicitacaoEntregaService {

	@Autowired
	private EntregaRepository repository;

	@Autowired
	private ClientesService clientesService;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clientesService.buscar(entrega.getCliente().getId());

		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());

		return repository.save(entrega);
	}

}
