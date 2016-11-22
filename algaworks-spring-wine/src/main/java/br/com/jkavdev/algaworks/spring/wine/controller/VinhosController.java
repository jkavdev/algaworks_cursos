package br.com.jkavdev.algaworks.spring.wine.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(vinho);
		}

		vinhoService.salvar(vinho);
		
		attributes.addFlashAttribute("mensagem", "Vinho salvo com sucesso!");

		return new ModelAndView("redirect:/vinhos/novo");
	}

}