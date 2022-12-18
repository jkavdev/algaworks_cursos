package br.com.jkavdev.algaworks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jkavdev.algaworks.algafood.modelo.Cliente;
import br.com.jkavdev.algaworks.algafood.service.AtivacaoClienteService;

/**
 * @Controller - torna esta classe um bean que o spring ira gerenciar
 */
@Controller
public class MeuController {
	
	private AtivacaoClienteService ativacaoCliente;
	
	public MeuController(AtivacaoClienteService ativacaoCliente) {
		this.ativacaoCliente = ativacaoCliente;
		System.out.println("MeuController");
		System.out.println(ativacaoCliente );
	}

	/**
	 * @GetMapping("/hello") - mapeando a forma de acesso a esse endpoint, GET/hello
	 * @ResponseBody - informa que o resultado sera retornado como resposta da requisicao 
	 */
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		
		Cliente jhonatan = new Cliente("jhonatan@gmail.com", "Jhonatan", "61999999999");
		
		ativacaoCliente.ativar(jhonatan);
		
		return "Funcionando teste devtolls................";
	}

}
