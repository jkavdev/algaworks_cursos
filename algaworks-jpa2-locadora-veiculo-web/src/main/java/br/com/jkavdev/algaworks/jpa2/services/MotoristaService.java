package br.com.jkavdev.algaworks.jpa2.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpa2.daos.MotoristaDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Motorista;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class MotoristaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MotoristaDao motoristaDao;
	
	@Transactional
	public void salvar(Motorista motorista) throws NegocioException {
		this.motoristaDao.salvar(motorista);
	}

}
