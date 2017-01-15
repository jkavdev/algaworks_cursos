package br.com.jkavdev.algaworks.javaee.aula215;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "perfilUsuarioAutoCompleteBean")
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> paises = new ArrayList<String>();

	private String nome;
	private String pais;

	public PerfilUsuarioBean() {
		paises.add("Alemanha");
		paises.add("Brasil");
		paises.add("Argelia");
		paises.add("Belgica");
		paises.add("Espanha");
		paises.add("Estados Unidos");

	}

	public List<String> sugerirPaises(String consulta) {
		System.out.println("Consultando: " + consulta);
		List<String> paisesSugeridos = new ArrayList<String>();

		for (String pais : paises) {
			if (pais.toLowerCase().startsWith(consulta.toLowerCase())) {
				paisesSugeridos.add(pais);
			}
		}

		return paisesSugeridos;
	}

	public void atualizar() {
		System.out.println("País: " + this.pais);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
