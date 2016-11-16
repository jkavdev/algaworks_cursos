package br.com.jkavdev.algaworks.jpa2.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jpa.Transactional;

public class CarroDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public void salvar(Carro carro) {
		this.entityManager.merge(carro);
	}

	public List<Carro> buscarTodos() {
		return this.entityManager.createQuery("from Carro", Carro.class).getResultList();
	}

	public Carro buscarPeloCodigo(Long codigo) {
		return this.entityManager.find(Carro.class, codigo);
	}

	@Transactional
	public void excluir(Carro carro) throws NegocioException {		
		carro = buscarPeloCodigo(carro.getCodigo());
		
		this.entityManager.remove(carro);
		this.entityManager.flush();
	}

	public Carro buscarCarroComAcessorios(Long codigo) {
		return this.entityManager.createQuery("select c from Carro c join c.acessorios where c.codigo = :codigo", Carro.class)
				.setParameter("codigo", codigo)
				.getSingleResult();
	}

}
