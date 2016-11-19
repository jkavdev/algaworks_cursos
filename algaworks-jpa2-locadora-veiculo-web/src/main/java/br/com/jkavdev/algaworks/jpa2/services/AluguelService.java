package br.com.jkavdev.algaworks.jpa2.services;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpa2.daos.AluguelDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Aluguel;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class AluguelService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelDao aluguelDao;

	@Transactional
	public void salvar(Aluguel aluguel) throws NegocioException {

		if (aluguel.getCarro() == null) {
			throw new NegocioException("O carro é obrigatório");
		}
		
		aluguel.setDataPedido(Calendar.getInstance());

		this.aluguelDao.salvar(aluguel);
	}

}
