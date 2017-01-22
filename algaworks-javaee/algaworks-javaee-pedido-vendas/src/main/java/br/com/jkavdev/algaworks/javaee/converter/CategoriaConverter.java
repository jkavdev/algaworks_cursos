package br.com.jkavdev.algaworks.javaee.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.javaee.model.Categoria;
import br.com.jkavdev.algaworks.javaee.repository.Categorias;
import br.com.jkavdev.algaworks.javaee.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

	private Categorias categorias;

	public CategoriaConverter() {
		this.categorias = CDIServiceLocator.getBean(Categorias.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;

		if (value != null) {
			System.out.println("getAsObject....");
			retorno = categorias.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Categoria) value).getId();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
