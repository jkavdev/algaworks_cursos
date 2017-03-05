package br.com.jkavdev.algaworks.jpa2.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpa2.daos.FabricanteDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Fabricante;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class FabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDao fabricanteDao;

	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {

		if (fabricante.getNome() == null || "".equals(fabricante.getNome().trim())) {
			throw new NegocioException("O nome do frabricante é obrigatório");
		}

		this.fabricanteDao.salvar(fabricante);
	}

}
