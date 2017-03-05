package br.com.jkavdev.algaworks.jpa2.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpa2.daos.ModeloCarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class ModeloCarroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroDao modeloCarroDao;

	@Transactional
	public void salvar(ModeloCarro modeloCarro) throws NegocioException {

		if (modeloCarro.getDescricao() == null || "".equals(modeloCarro.getDescricao().trim())) {
			throw new NegocioException("A descrição do modelo é obrigatória");
		}

		if (modeloCarro.getFabricante() == null) {
			throw new NegocioException("O frabricante é obrigatório");
		}

		this.modeloCarroDao.salvar(modeloCarro);
	}

}
