package br.com.jkavdev.algaworks.osworks.api.domain;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jkavdev.algaworks.osworks.api.domain.exception.EntidadeNaoEncontradaException;
import br.com.jkavdev.algaworks.osworks.api.domain.exception.NegocioException;
import br.com.jkavdev.algaworks.osworks.api.domain.model.Cliente;
import br.com.jkavdev.algaworks.osworks.api.domain.model.Comentario;
import br.com.jkavdev.algaworks.osworks.api.domain.model.OrdemServico;
import br.com.jkavdev.algaworks.osworks.api.domain.model.StatusOrdemServico;
import br.com.jkavdev.algaworks.osworks.api.domain.repository.ClienteRepository;
import br.com.jkavdev.algaworks.osworks.api.domain.repository.ComentarioRepository;
import br.com.jkavdev.algaworks.osworks.api.domain.repository.OrdemServiceRepository;

@Service
public class GestaoOrdemServiceService {

	@Autowired
	private OrdemServiceRepository ordemServiceRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ComentarioRepository comentarioRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("cliente não encontrado"));

		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());

		return ordemServiceRepository.save(ordemServico);
	}

	public OrdemServico buscar(Long ordemServicoId) {
		OrdemServico ordemServico = ordemServiceRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("ordem de serviço não encontrada!"));
		return ordemServico;
	}

	public void finalizar(Long ordemServicoId) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		ordemServico.finalizar();
		ordemServiceRepository.save(ordemServico);
	}

	public void cancelar(Long ordemServicoId) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		ordemServico.cancelar();
		ordemServiceRepository.save(ordemServico);
	}

	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = buscar(ordemServicoId);

		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);

		return comentarioRepository.save(comentario);
	}

}
