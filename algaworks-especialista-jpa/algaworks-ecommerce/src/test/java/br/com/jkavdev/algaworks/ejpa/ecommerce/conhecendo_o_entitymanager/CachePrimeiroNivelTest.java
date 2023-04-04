package br.com.jkavdev.algaworks.ejpa.ecommerce.conhecendo_o_entitymanager;

import br.com.jkavdev.algaworks.ejpa.ecommerce.EntityManagerTest;
import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Produto;
import org.junit.Test;

public class CachePrimeiroNivelTest extends EntityManagerTest {

    @Test
    public void verificarCache() {
        final var produto = entityManager.find(Produto.class, 1);
        System.out.println(produto);

        System.out.println("------------------------------------------");

        // a segunda consulta ira busca o objeto da memoria, pois o mesmo esta na memoria do jpa
        // e nao teve nenhuma alteracao que indicasse para o jpa busca o mesmo no banco de dados

        //cache de primeiro nivel, eh quando o jpa busca a entidade da memoria, pois o mesmo esta no contexto, na memoria
        // caso nao estivesse a busca iria no banco de dados, e a salvaria na memoria, se repentindo os mesmos passos de busca
        final var produtoBuscado = entityManager.find(Produto.class, 1);
        System.out.println(produtoBuscado);
    }
}
