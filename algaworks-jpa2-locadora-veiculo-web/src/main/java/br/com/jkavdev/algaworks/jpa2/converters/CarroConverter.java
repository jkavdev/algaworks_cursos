package br.com.jkavdev.algaworks.jpa2.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.jpa2.daos.CarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Carro;
import br.com.jkavdev.algaworks.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter {

	private CarroDao carroDao;

	public CarroConverter() {
		this.carroDao = CDIServiceLocator.getBean(CarroDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Carro retorno = null;

		if (value != null) {
			retorno = carroDao.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Carro) value).getCodigo();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
