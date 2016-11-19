package br.com.jkavdev.algaworks.jpa2.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.jkavdev.algaworks.jpa2.daos.FuncionarioDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Funcionario;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class FuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioDao funcionarioDao;

	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {
		this.funcionarioDao.salvar(funcionario);
	}

}
