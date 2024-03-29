package br.com.jkavdev.algaworks.ejpa.ecommerce.relacionamentos;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoOneToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoCliente() {
        final var cliente = entityManager.find(Cliente.class, 1);

        final var pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(BigDecimal.TEN);
        // para que o relacionamento seja efetivado, precisamos apenas o dono do relacionamento
        // faca o ligamento entre as duas entidades
        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        final var actualCliente = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertFalse(actualCliente.getPedidos().isEmpty());
    }

    @Test
    public void verificarRelacionamentoPedido() {
        final var cliente = entityManager.find(Cliente.class, 1);
        final var produto = entityManager.find(Produto.class, 1);

        final var pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(BigDecimal.TEN);
        pedido.setCliente(cliente);

        final var item = new ItemPedido();
        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(50);
        item.setPrecoProduto(new BigDecimal(50000));

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(item);
        entityManager.getTransaction().commit();

        entityManager.clear();

        final var expectedPedido = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertFalse(expectedPedido.getItens().isEmpty());
    }

}
