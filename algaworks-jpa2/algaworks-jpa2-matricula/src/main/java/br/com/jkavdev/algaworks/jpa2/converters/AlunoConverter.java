package br.com.jkavdev.algaworks.jpa2.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.jpa2.daos.AlunoDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Aluno;
import br.com.jkavdev.algaworks.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(value = "AlunoConverter", forClass = Aluno.class)
public class AlunoConverter implements Converter {

	private AlunoDao alunoDao;

	public AlunoConverter() {
		this.alunoDao = CDIServiceLocator.getBean(AlunoDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aluno retorno = null;

		if (value != null) {
			retorno = alunoDao.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Aluno) value).getCodigo();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
