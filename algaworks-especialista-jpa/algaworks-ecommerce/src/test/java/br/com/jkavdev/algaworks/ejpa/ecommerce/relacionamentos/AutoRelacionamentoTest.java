package br.com.jkavdev.algaworks.ejpa.ecommerce.relacionamentos;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Categoria;
import org.junit.Assert;
import org.junit.Test;

public class AutoRelacionamentoTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoCategoria() {
        final var categoriaPai = new Categoria();
        categoriaPai.setNome("eletronicos");

        final var categoriaFilha = new Categoria();
        categoriaFilha.setNome("celulares");

        categoriaFilha.setCategoriaPai(categoriaPai);

        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoriaFilha);
        entityManager.getTransaction().commit();

        entityManager.clear();

        final var actualCategoriaFilha = entityManager.find(Categoria.class, categoriaFilha.getId());
        Assert.assertNotNull(actualCategoriaFilha.getCategoriaPai());

        final var actualCategoriaPai = entityManager.find(Categoria.class, categoriaPai.getId());
        Assert.assertFalse(actualCategoriaPai.getCategorias().isEmpty());
    }

}
