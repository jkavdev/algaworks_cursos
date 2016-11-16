package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.daos.CarroDao;
import br.com.jkavdev.algaworks.jpa2.daos.MotoristaDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Aluguel;
import br.com.jkavdev.algaworks.jpa2.modelos.ApoliceSeguro;
import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.modelos.Motorista;
import br.com.jkavdev.algaworks.jpa2.services.AluguelService;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class NovoAluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AluguelService aluguelService;
	@Inject
	private CarroDao carroDao;
	@Inject
	private MotoristaDao motoristaDao;

	private List<Carro> carros;
	private List<Motorista> motoristas;
	private Aluguel aluguel;

	@PostConstruct
	public void init() {
		limparFormulario();
		carros = carroDao.buscarTodos();
		motoristas = motoristaDao.buscarTodos();
	}

	public void salvar() {
		try {
			aluguelService.salvar(aluguel);
			FacesUtil.addSuccessMessage("Aluguel salvo com sucesso!");
			limparFormulario();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	private void limparFormulario() {
		this.aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());
	}

	public List<Carro> getCarros() {
		return carros;
	}
	
	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel Aluguel) {
		this.aluguel = Aluguel;
	}

}
