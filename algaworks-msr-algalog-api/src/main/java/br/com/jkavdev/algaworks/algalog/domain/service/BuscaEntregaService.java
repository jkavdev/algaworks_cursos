package br.com.jkavdev.algaworks.algalog.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jkavdev.algaworks.algalog.api.exceptionhandler.EntregaRepository;
import br.com.jkavdev.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;
import br.com.jkavdev.algaworks.algalog.domain.model.Entrega;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;

	@Transactional
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId).orElseThrow(() -> new EntidadeNaoEncontradaException("entrega não encontrada"));
	}

}
