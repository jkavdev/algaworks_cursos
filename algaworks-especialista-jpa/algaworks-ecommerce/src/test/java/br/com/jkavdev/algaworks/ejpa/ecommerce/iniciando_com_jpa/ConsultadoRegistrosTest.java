package br.com.jkavdev.algaworks.ejpa.ecommerce.iniciando_com_jpa;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultadoRegistrosTest extends EntityManagerTest {

    @Test
    public void buscarPorIdentificador() {
        // consulta eh realizado no momento que chamar o find, diferente do reference que posterga
        final var produto = entityManager.find(Produto.class, 1);

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void buscarPorReference() {
        // enquando nao fizer nenhum acesso a entidade, a consulta nao sera realizada
        final var produto = entityManager.getReference(Produto.class, 1);

        Assert.assertNotNull(produto);
    }

    @Test
    public void atualizarReferencia() {
        final var produto = entityManager.find(Produto.class, 1);
        produto.setNome("novo produto");

        entityManager.refresh(produto);

        Assert.assertNotNull(produto);
        Assert.assertNotEquals("novo produto", produto.getNome());
    }

}