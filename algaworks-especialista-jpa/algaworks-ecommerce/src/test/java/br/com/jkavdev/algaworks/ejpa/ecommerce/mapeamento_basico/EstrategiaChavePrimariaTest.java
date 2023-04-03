package br.com.jkavdev.algaworks.ejpa.ecommerce.mapeamento_basico;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class EstrategiaChavePrimariaTest extends EntityManagerTest {

    @Test
    public void testarEstrategiaAuto() {
        final var categoria = new Categoria();
        categoria.setNome("eletronicos");

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();

        final var expectedCategoria = entityManager.find(Categoria.class, categoria.getId());
        Assert.assertNotNull(expectedCategoria);
        Assert.assertNotNull(expectedCategoria.getId());
    }
}
