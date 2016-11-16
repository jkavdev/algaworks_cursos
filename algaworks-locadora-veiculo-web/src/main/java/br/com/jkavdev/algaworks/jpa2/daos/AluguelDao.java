package br.com.jkavdev.algaworks.jpa2.daos;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.jpa2.modelos.Aluguel;

public class AluguelDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public void salvar(Aluguel aluguel) {
		this.entityManager.merge(aluguel);
	}

}
