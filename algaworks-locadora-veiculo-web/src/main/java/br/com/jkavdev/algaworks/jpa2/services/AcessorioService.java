package br.com.jkavdev.algaworks.jpa2.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpa2.daos.AcessorioDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Acessorio;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class AcessorioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AcessorioDao AcessorioDao;

	@Transactional
	public void salvar(Acessorio acessorio) throws NegocioException {

		if (acessorio.getDescricao() == null || "".equals(acessorio.getDescricao().trim())) {
			throw new NegocioException("O descrição do acessório é obrigatório");
		}

		this.AcessorioDao.salvar(acessorio);
	}

}
