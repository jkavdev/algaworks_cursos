package br.com.jkavdev.algaworks.javaee.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pedidoPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

//		 Cliente jhonatan = new Cliente();
//		 jhonatan.setNome("Jhonatan");
//		 jhonatan.setEmail("jhonatan@gmail.com");
//		 jhonatan.setDocumentoReceitaFederal("3168437");
//		 jhonatan.setTipo(TipoPessoa.FISICA);
//		
//		 Endereco endereco = new Endereco();
//		 endereco.setLogradouro("Qr 12 casa 15");
//		 endereco.setNumero("15");
//		 endereco.setComplemento("Casa");
//		 endereco.setCep("73754012");
//		 endereco.setCidade("Planaltina");
//		 endereco.setUf("GO");
//		 endereco.setCliente(jhonatan);
//		
//		 jhonatan.getEnderecos().add(endereco);
//		
//		 manager.persist(jhonatan);

		transaction.commit();

	}

}
