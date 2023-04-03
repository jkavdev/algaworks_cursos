package br.com.jkavdev.algaworks.ejpa.ecommerce.relacionamentos;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.NotaFiscal;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.PagamentoCartao;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Pedido;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.StatusPagamento;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoPedidoPagamento() {
        final var pedido = entityManager.find(Pedido.class, 1);

        final var pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setPedido(pedido);
        pagamentoCartao.setNumero("32121");
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        entityManager.clear();

        final var actualPedido = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(actualPedido.getPagamentoCartao());

        final var actualPagamento = entityManager.find(PagamentoCartao.class, pagamentoCartao.getId());
        Assert.assertNotNull(actualPagamento.getPedido());
    }

    @Test
    public void verificarRelacionamentoPedidoNotaFiscal() {
        final var pedido = entityManager.find(Pedido.class, 1);

        final var notaFiscal = new NotaFiscal();
        notaFiscal.setPedido(pedido);
        notaFiscal.setXml("xmlxlm");
        notaFiscal.setDataEmissao(new Date());

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        final var actualPedido = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(actualPedido.getNotaFiscal());

        final var actualNota = entityManager.find(NotaFiscal.class, notaFiscal.getId());
        Assert.assertNotNull(actualNota.getPedido());
    }

}
