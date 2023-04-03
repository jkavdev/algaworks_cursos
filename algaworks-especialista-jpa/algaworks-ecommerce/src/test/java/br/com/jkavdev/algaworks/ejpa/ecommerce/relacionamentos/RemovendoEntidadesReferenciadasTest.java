package br.com.jkavdev.algaworks.ejpa.ecommerce.relacionamentos;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

public class RemovendoEntidadesReferenciadasTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoCategoria() {
        final var pedido = entityManager.find(Pedido.class, 1);

        Assert.assertFalse(pedido.getItens().isEmpty());

        entityManager.getTransaction().begin();
        // para que possamos remover pedido, temos que remover todas as entidades que tem relacionamentos com pedido
        // se nao havera registros que tem referencia a pedido, sem de fato o pedido existir
        pedido.getItens().forEach(i -> entityManager.remove(i));
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        final var actualPedido = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNull(actualPedido);
    }

}
