package br.com.jkavdev.algaworks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Controller - torna esta classe um bean que o spring ira gerenciar
 */
@Controller
public class MeuController {
	
	public MeuController() {
		System.out.println("MeuController");
	}
	
	/**
	 * @GetMapping("/hello") - mapeando a forma de acesso a esse endpoint, GET/hello
	 * @ResponseBody - informa que o resultado sera retornado como resposta da requisicao 
	 */
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Funcionando teste devtolls................";
	}

}
