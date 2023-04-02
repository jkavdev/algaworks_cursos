package br.com.jkavdev.algaworks.ejpa.ecommerce.mapeamento_basico;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Cliente;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void inserirCliente() {
        final var cliente = new Cliente();
        cliente.setId(55);
        cliente.setNome("Maria Estela");
        cliente.setSexo(SexoCliente.FEMININO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        final var expectedCliente = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals(SexoCliente.FEMININO, expectedCliente.getSexo());
    }
}
