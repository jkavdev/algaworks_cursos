package br.com.jkavdev.algaworks.ejpa.ecommerce.iniciando_com_jpa;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void inserirOPrimeiroObjetoEBuscandoEmMemoria() {
        final var produto = new Produto();

        produto.setId(2);
        produto.setNome("qualquer");
        produto.setDescricao("qualquer");
        produto.setPreco(new BigDecimal(500));

        entityManager.persist(produto);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        // hibernate buscara a entidade da memoria, pois nao teve nenhuma acao que obrigue a de fator ir no banco de dados
        final var expectedProduto = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(expectedProduto);
    }

    @Test
    public void inserirOPrimeiroObjetoEBuscandoNoBanco() {
        final var produto = new Produto();

        produto.setId(3);
        produto.setNome("qualquer");
        produto.setDescricao("qualquer");
        produto.setPreco(new BigDecimal(500));

        // a operacao de insercao nao precisa estar exatamente entre abertura e fechamento de uma transacao
        // a acao de insercao eh portergada ate o momento que alguem crie uma transacao
        // caso nao criada a transacao a entidade nao eh salva
        entityManager.persist(produto);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        entityManager.clear();

        // hibernate ira de fato no banco fazer a busca devido ao limpar do entity manager
        final var expectedProduto = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(expectedProduto);
    }

    @Test
    public void inserirOPrimeiroObjetoSemTransacao() {
        final var produto = new Produto();

        produto.setId(4);
        produto.setNome("qualquer");
        produto.setDescricao("qualquer");
        produto.setPreco(new BigDecimal(500));

        // a operacao de insercao foi postergada ate o final
        // todo o processamento que o hibernate encontrar com essa entidade, buscara dos dados em memoria
        // pois nao houve nenhuma acao, que obrigue o hibernate ir ao banco de dados de fato
        entityManager.persist(produto);

        // por isso no momento que tentamos consultar a entidade e buscada da memoria,
        // ela nem foi passada para o banco de dados
        final var expectedProduto = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(expectedProduto);
    }

    @Test
    public void inserirOPrimeiroObjetoEBuscandoNoBancoFlush() {
        final var produto = new Produto();

        produto.setId(5);
        produto.setNome("qualquer");
        produto.setDescricao("qualquer");
        produto.setPreco(new BigDecimal(500));

        // a operacao de insercao nao precisa estar exatamente entre abertura e fechamento de uma transacao
        // a acao de insercao eh portergada ate o momento que alguem crie uma transacao
        // caso nao criada a transacao a entidade nao eh salva
        entityManager.persist(produto);

        entityManager.getTransaction().begin();
        // o flush precisa estar entre a criacao e finalizacao da transacao
        // sincroniza o contexto com o banco de dados
        entityManager.flush();
        entityManager.getTransaction().commit();

        // hibernate buscara a entidade da memoria, pois nao teve nenhuma acao que obrigue a de fator ir no banco de dados
        final var expectedProduto = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(expectedProduto);
    }

}
