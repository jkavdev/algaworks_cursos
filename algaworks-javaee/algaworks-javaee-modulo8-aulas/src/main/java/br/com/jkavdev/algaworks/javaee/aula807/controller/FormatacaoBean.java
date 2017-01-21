package br.com.jkavdev.algaworks.javaee.aula807.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.aula807.service.Brasil;

@Named
@RequestScoped
public class FormatacaoBean {

	@Inject
//	@Default
	
	@Brasil
	private DateFormat formatadorData;

	private Date dataInformada;
	private String dataFormatada;

	public void enviar() {
		dataFormatada = formatadorData.format(dataInformada);
	}

	public String getDataFormatada() {
		return dataFormatada;
	}

	public Date getDataInformada() {
		return dataInformada;
	}
	
	public void setDataInformada(Date dataInformada) {
		this.dataInformada = dataInformada;
	}

}
