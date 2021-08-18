package br.com.jkavdev.algaworks.algalog.ap.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroRequisicao {

	private int status;
	private LocalDateTime horario;
	private String titulo;
	private List<Campo> campos;

	public ErroRequisicao() {
		this.horario = LocalDateTime.now();
	}

	@AllArgsConstructor
	@Getter
	public static class Campo {
		private String nome;
		private String mensagem;
	}

}
