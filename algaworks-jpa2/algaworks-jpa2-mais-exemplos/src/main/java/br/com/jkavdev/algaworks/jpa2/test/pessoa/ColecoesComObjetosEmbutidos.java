package br.com.jkavdev.algaworks.jpa2.test.pessoa;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Pessoa;
import br.com.jkavdev.algaworks.jpa2.modelos.Telefone;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ColecoesComObjetosEmbutidos extends JunitJpaConfig {

	@Test
	public void salvaPessoaComTelefone() {
		Pessoa pessoa = criaPessoa("Jhonatan");
		pessoa.getTelefones().add(new Telefone("61", "99346554", "55"));
		pessoa.getTelefones().add(new Telefone("61", "99342114", "55"));
		pessoa.getTelefones().add(new Telefone("61", "99333254", "55"));

		beginTransaction();

		getManager().persist(pessoa);

		commit();

	}

	@Test
	public void buscaPessoa() {
		Pessoa pessoa = getManager().find(Pessoa.class, 1L);

		System.out.println("Usuario: " + pessoa.getNome());

		for (Telefone telefone : pessoa.getTelefones()) {
			System.out.println("(" + telefone.getPrefixo() + ")" +
					telefone.getNumero() + 
					(telefone.getRamal() != null ? " x" + telefone.getRamal() : ""));
		}
	}

	public Pessoa criaPessoa(String nome) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);

		return pessoa;
	}

}
