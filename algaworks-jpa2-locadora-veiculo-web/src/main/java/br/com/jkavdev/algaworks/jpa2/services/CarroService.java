package br.com.jkavdev.algaworks.jpa2.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpa2.daos.CarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class CarroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroDao carroDao;

	@Transactional
	public void salvar(Carro carro) throws NegocioException {

		if (carro.getPlaca() == null || "".equals(carro.getPlaca().trim())) {
			throw new NegocioException("O placa do carro é obrigatório");
		}

		if (carro.getModeloCarro() == null) {
			throw new NegocioException("O modelo do carro é obrigatório");
		}

		this.carroDao.salvar(carro);
	}

}
