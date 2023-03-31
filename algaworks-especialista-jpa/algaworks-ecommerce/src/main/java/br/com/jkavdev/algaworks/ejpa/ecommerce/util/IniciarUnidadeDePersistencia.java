package br.com.jkavdev.algaworks.ejpa.ecommerce.util;

import br.com.jkavdev.algaworks.ejpa.ecommerce.model.Produto;

import javax.persistence.Persistence;

public class IniciarUnidadeDePersistencia {

    public static void main(String[] args) {
        final var entityManagerFactory =
                Persistence.createEntityManagerFactory("Ecommerce-PU");
        final var entityManager = entityManagerFactory.createEntityManager();

        final var produto = entityManager.find(Produto.class, 1);

        System.out.println(produto);

        entityManager.clear();
        entityManagerFactory.close();
    }
}
