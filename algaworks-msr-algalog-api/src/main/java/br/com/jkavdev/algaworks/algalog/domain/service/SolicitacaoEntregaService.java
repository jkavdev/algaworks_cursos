package br.com.jkavdev.algaworks.algalog.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jkavdev.algaworks.algalog.domain.model.Entrega;
import br.com.jkavdev.algaworks.algalog.domain.model.StatusEntrega;
import br.com.jkavdev.algaworks.algalog.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
	
	@Autowired
	private EntregaRepository repository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return repository.save(entrega);
	}

}
