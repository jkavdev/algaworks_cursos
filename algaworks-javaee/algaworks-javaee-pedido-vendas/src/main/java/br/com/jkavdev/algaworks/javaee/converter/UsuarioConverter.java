package br.com.jkavdev.algaworks.javaee.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.javaee.model.Usuario;
import br.com.jkavdev.algaworks.javaee.repository.Usuarios;
import br.com.jkavdev.algaworks.javaee.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	private Usuarios usuarios;

	public UsuarioConverter() {
		this.usuarios = CDIServiceLocator.getBean(Usuarios.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null) {
			System.out.println("getAsObject....");
			retorno = usuarios.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Usuario) value).getId();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
