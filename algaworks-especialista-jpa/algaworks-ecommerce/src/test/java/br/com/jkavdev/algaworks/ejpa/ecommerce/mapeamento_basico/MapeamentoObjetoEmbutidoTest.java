package br.com.jkavdev.algaworks.ejpa.ecommerce.mapeamento_basico;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.EnderecoEntregaPedido;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Pedido;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {

    @Test
    public void analisarMapeamentoEmbutidoTest() {
        EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
        endereco.setCep("321");
        endereco.setBairro("321");
        endereco.setCidade("321");
        endereco.setComplemento("321");
        endereco.setNumero("321");
        endereco.setLogradouro("321");

        final var pedido = new Pedido();
        pedido.setId(1);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(new BigDecimal("500"));
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setEndereco(endereco);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        final var expectedPedido = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(expectedPedido);
        Assert.assertEquals(endereco.getNumero(), expectedPedido.getEndereco().getNumero());
        Assert.assertEquals(endereco.getBairro(), expectedPedido.getEndereco().getBairro());
        Assert.assertEquals(endereco.getCidade(), expectedPedido.getEndereco().getCidade());
        Assert.assertEquals(endereco.getComplemento(), expectedPedido.getEndereco().getComplemento());
        Assert.assertEquals(endereco.getCep(), expectedPedido.getEndereco().getCep());
        Assert.assertEquals(endereco.getLogradouro(), expectedPedido.getEndereco().getLogradouro());
    }
}
