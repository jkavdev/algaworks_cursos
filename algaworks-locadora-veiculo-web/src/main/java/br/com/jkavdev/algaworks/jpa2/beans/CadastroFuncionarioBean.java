package br.com.jkavdev.algaworks.jpa2.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpa2.modelos.Funcionario;
import br.com.jkavdev.algaworks.jpa2.modelos.Sexo;
import br.com.jkavdev.algaworks.jpa2.services.FuncionarioService;
import br.com.jkavdev.algaworks.jpa2.services.NegocioException;
import br.com.jkavdev.algaworks.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	
	@Inject
	private FuncionarioService funcionarioService;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
	}
	
	public void salvar() {
		try {
			this.funcionarioService.salvar(funcionario);
			FacesUtil.addSuccessMessage("Funcionario salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	public void limpar() {
		this.funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario Funcionario) {
		this.funcionario = Funcionario;
	}
	
	public List<Sexo> getSexo(){
		return Arrays.asList(Sexo.values());
	}

}
