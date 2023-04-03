package br.com.jkavdev.algaworks.ejpa.ecommerce.relacionamentos;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Categoria;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RelacionamentoManyToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoCategoria() {
        final var produto = entityManager.find(Produto.class, 1);
        final var categoria = entityManager.find(Categoria.class, 1);

        entityManager.getTransaction().begin();
        // o relacionamento tem que ser persistido pela entidade pai, no caso produtos
        produto.setCategorias(Arrays.asList(categoria));
        entityManager.getTransaction().commit();

        entityManager.clear();

        final var actualCategoria = entityManager.find(Categoria.class, categoria.getId());
        // sempre sera gerado uma nova consulta caso busquemos uma lista, no qual nao foi indicada
        // na consulta principal, acima
        //por isso eh gerado uma nova consulta ao conferir produtos de categorias
        Assert.assertFalse(actualCategoria.getProdutos().isEmpty());

        final var actualProduto = entityManager.find(Produto.class, produto.getId());
        Assert.assertFalse(actualProduto.getCategorias().isEmpty());
    }

}
