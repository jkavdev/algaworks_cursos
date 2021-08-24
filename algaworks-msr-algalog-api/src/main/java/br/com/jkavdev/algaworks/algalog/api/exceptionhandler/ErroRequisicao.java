package br.com.jkavdev.algaworks.algalog.api.exceptionhandler;

import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroRequisicao {

	private int status;

	private String titulo;

	private LocalTime dataHora;

	private List<Campo> campos;

	@AllArgsConstructor
	@Getter
	public static class Campo {
		private String nome;
		private String mensagem;
	}

}
