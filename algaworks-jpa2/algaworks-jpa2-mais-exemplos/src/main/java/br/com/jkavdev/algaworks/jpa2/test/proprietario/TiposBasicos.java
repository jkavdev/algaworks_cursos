package br.com.jkavdev.algaworks.jpa2.test.proprietario;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Usuario;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class TiposBasicos extends JunitJpaConfig {

	@Test
	public void salvaUsuarioComTelefone() {
		Usuario usuario = criaUsuario("Jhonatan");
		usuario.getTelefones().add("91940455");
		usuario.getTelefones().add("99346554");
		usuario.getTelefones().add("93254125");

		beginTransaction();

		getManager().persist(usuario);

		commit();

	}

	@Test
	public void buscaUsuario() {
		Usuario usuario = getManager().find(Usuario.class, 1L);

		System.out.println("Usuario: " + usuario.getNome());

		for (String telefone : usuario.getTelefones()) {
			System.out.println("Telefone: " + telefone);
		}
	}

	public Usuario criaUsuario(String nome) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);

		return usuario;
	}

}
