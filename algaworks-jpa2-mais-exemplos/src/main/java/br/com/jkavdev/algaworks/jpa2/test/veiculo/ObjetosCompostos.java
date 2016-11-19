package br.com.jkavdev.algaworks.jpa2.test.veiculo;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpa2.modelos.Proprietario;
import br.com.jkavdev.algaworks.jpa2.modelos.Veiculo;
import br.com.jkavdev.algaworks.jpa2.modelos.VeiculoPK;
import br.com.jkavdev.algaworks.jpa2.test.JunitJpaConfig;

public class ObjetosCompostos extends JunitJpaConfig {

	@Test
	public void salvaVeiculo() {
		Veiculo veiculo = criaVeiculo("Ford", "Fusion");
		veiculo.setCodigo(new VeiculoPK("OKK-556", "Brasilia"));
		
		Proprietario proprietario = criaProprietario("Jhonantan", "91940433", "jhonatankolen@gmail.com");
		
		veiculo.setProprietario(proprietario);

		beginTransaction();

		getManager().persist(veiculo);

		commit();
	}

	@Test
	public void buscandoVeiculo() {
		Veiculo veiculo = getManager().find(Veiculo.class, new VeiculoPK("OKK-556", "Planaltina"));

		System.out.println(veiculo.getFabricante() + " - " + veiculo.getModelo());
	}

	public Proprietario criaProprietario(String nome, String telefone, String email) {
		Proprietario proprietario = new Proprietario();
		proprietario.setEmail(email);
		proprietario.setNome(nome);
		proprietario.setTelefone(telefone);

		return proprietario;
	}

	public Veiculo criaVeiculo(String fabricante, String modelo) {
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante(fabricante);
		veiculo.setModelo(modelo);

		return veiculo;
	}

}
