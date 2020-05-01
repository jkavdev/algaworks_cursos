package br.com.jkavdev.algaworks.osworks.domain;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jkavdev.algaworks.osworks.domain.exception.EntidadeNaoEncontradaException;
import br.com.jkavdev.algaworks.osworks.domain.exception.NegocioException;
import br.com.jkavdev.algaworks.osworks.domain.model.Cliente;
import br.com.jkavdev.algaworks.osworks.domain.model.Comentario;
import br.com.jkavdev.algaworks.osworks.domain.model.OrdemServico;
import br.com.jkavdev.algaworks.osworks.domain.model.StatusOrderServico;
import br.com.jkavdev.algaworks.osworks.domain.repository.ClienteRepository;
import br.com.jkavdev.algaworks.osworks.domain.repository.ComentarioRepository;
import br.com.jkavdev.algaworks.osworks.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ComentarioRepository comentarioRepository;

	public OrdemServico criar(OrdemServico ordemServico) {

		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("cliente não encontrato"));

		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrderServico.ABERTA);
		ordemServico.setHorarioAbertura(OffsetDateTime.now());

		return ordemServicoRepository.save(ordemServico);
	}

	public Comentario adicionarComentario(Long id, String descricao) {

		OrdemServico ordemServico = ordemServicoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ordem servico nao encontrada"));

		var comentario = new Comentario();
		comentario.setDescricao(descricao);
		comentario.setHorarioEnvio(OffsetDateTime.now());
		comentario.setOrdemServico(ordemServico);

		return comentarioRepository.save(comentario);
	}

}
