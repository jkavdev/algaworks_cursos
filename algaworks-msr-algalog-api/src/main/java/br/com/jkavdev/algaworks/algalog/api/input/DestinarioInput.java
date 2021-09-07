package br.com.jkavdev.algaworks.algalog.api.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinarioInput {

	@NotBlank
	@Size(max = 60)
	private String nome;

	@NotBlank
	@Size(max = 255)
	private String logradouro;

	@NotBlank
	@Size(max = 30)
	private String numero;

	@NotBlank
	@Size(max = 60)
	private String complemento;

	@NotBlank
	@Size(max = 30)
	private String bairro;

}
