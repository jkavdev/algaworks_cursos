package br.com.jkavdev.algaworks.imobiliaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imoveis")
public class ImoveisController {

	@RequestMapping("/novo")
	public String novo() {
		return "cadastro-imovel";
	}

}
