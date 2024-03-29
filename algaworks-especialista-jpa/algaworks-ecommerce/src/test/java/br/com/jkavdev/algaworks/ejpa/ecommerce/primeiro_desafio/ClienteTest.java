package br.com.jkavdev.algaworks.ejpa.ecommerce.primeiro_desafio;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class ClienteTest extends EntityManagerTest {

    @Test
    public void inserirCliente() {
        final var cliente = new Cliente("Mario Gentili");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        final var expectedCliente = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals("Mario Gentili", expectedCliente.getNome());
    }

    @Test
    public void buscandoCliente() {
        final var cliente = new Cliente("Mario Gentili");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        final var expectedCliente = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertEquals("Mario Gentili", expectedCliente.getNome());
    }

    @Test
    public void atualizandoCliente() {
        final var cliente = new Cliente("Pedro Paulo");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        final var clienteSalvo = entityManager.find(Cliente.class, cliente.getId());
        clienteSalvo.setNome("Pedro Paulo Piz");

        entityManager.getTransaction().begin();
        entityManager.merge(clienteSalvo);
        entityManager.getTransaction().commit();

        Assert.assertEquals("Pedro Paulo Piz", clienteSalvo.getNome());
    }

    @Test
    public void removerCliente() {
        final var cliente = new Cliente("Mario Gentili");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        final var exceptedCliente = entityManager.find(Cliente.class, cliente.getId());

        Assert.assertNull(exceptedCliente);
    }

}