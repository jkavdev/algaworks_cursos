package br.com.jkavdev.algaworks.spring.wine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jkavdev.algaworks.spring.wine.model.TipoVinho;
import br.com.jkavdev.algaworks.spring.wine.model.Vinho;
import br.com.jkavdev.algaworks.spring.wine.repository.Vinhos;
import br.com.jkavdev.algaworks.spring.wine.service.VinhoService;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private Vinhos vinhos;
	@Autowired
	private VinhoService vinhoService;

	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView modelAndView = new ModelAndView("/vinho/listagem-vinhos");

		modelAndView.addObject("vinhos", vinhos.findAll());

		return modelAndView;
	}

	@RequestMapping("/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView modelAndView = new ModelAndView("/vinho/cadastro-vinho");

		modelAndView.addObject("tipos", TipoVinho.values());

		return modelAndView;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(Vinho vinho) {		
		vinhoService.salvar(vinho);

		return new ModelAndView("redirect:/vinhos/novo");
	}

}