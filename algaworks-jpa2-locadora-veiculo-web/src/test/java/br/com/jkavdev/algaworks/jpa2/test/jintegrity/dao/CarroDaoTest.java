package br.com.jkavdev.algaworks.jpa2.test.jintegrity.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

import br.com.jkavdev.algaworks.jpa2.daos.CarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Carro;

public class CarroDaoTest {

	private JIntegrity helper = new JIntegrity();
	private CarroDao carroDao;

	@Before
	public void init() {
		// Limpara as tabelas indicadas no arquivo de configuração
		helper.cleanAndInsert();

		this.carroDao = new CarroDao();
		// Retornando o EntityManager atual
		this.carroDao.setEntityManager(JPAHelper.currentEntityManager());
	}

	@Test
	public void buscarCarro() {
		Carro carro = this.carroDao.buscarPeloCodigo(1L);

		assertEquals(1L, carro.getCodigo().longValue());
		assertEquals("AAA-1111", carro.getPlaca());
	}

}
