package br.com.jkavdev.algaworks.javaee.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.javaee.model.Cliente;
import br.com.jkavdev.algaworks.javaee.repository.Clientes;
import br.com.jkavdev.algaworks.javaee.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	private Clientes clientes;

	public ClienteConverter() {
		this.clientes = CDIServiceLocator.getBean(Clientes.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;

		if (value != null) {
			System.out.println("getAsObject....");
			retorno = clientes.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Cliente) value).getId();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
