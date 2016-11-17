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
		return this.entityManager.createNamedQuery("Carro.buscarTodos", Carro.class).getResultList();
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
		return this.entityManager.createNamedQuery("Carro.buscarCarroComAcessorios", Carro.class)
				.setParameter("codigo", codigo)
				.getSingleResult();
	}

	public List<Carro> buscarComPaginacao(int primeiroRegistro, int totalDeRegistro) {
		return this.entityManager.createNamedQuery("Carro.buscarTodos", Carro.class)
				.setFirstResult(primeiroRegistro)
				.setMaxResults(totalDeRegistro)
				.getResultList();
	}

	public Long buscarQuantidadeDeCarros() {
		return this.entityManager.createQuery("select count(c) from Carro c", Long.class)
				.getSingleResult();
	}

	// select * from carro limit 4 - trara apenas 4 resultados
	// select * from carro limit 4,2 - trara 2 resultados a partir do 5 resultado

}
