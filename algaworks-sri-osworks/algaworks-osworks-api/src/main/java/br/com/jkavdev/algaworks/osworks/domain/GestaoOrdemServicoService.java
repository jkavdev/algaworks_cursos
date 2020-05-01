package br.com.jkavdev.algaworks.osworks.domain;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jkavdev.algaworks.osworks.domain.exception.NegocioException;
import br.com.jkavdev.algaworks.osworks.domain.model.Cliente;
import br.com.jkavdev.algaworks.osworks.domain.model.OrdemServico;
import br.com.jkavdev.algaworks.osworks.domain.model.StatusOrderServico;
import br.com.jkavdev.algaworks.osworks.domain.repository.ClienteRepository;
import br.com.jkavdev.algaworks.osworks.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public OrdemServico criar(OrdemServico ordemServico) {

		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("cliente não encontrato"));

		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrderServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());

		return ordemServicoRepository.save(ordemServico);
	}

}
