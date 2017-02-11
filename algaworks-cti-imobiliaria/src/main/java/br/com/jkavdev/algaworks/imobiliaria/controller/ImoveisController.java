package br.com.jkavdev.algaworks.imobiliaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.jkavdev.algaworks.imobiliaria.model.Imovel;
import br.com.jkavdev.algaworks.imobiliaria.model.TipoImovel;
import br.com.jkavdev.algaworks.imobiliaria.repository.Imoveis;

@Controller
@RequestMapping("/imoveis")
public class ImoveisController {

	@Autowired
	private Imoveis imoveis;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("cadastro-imovel");
		modelAndView.addObject("imovel", new Imovel());
		modelAndView.addObject(TipoImovel.values());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicionar(Imovel imovel, RedirectAttributes attributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/imoveis/novo");
		attributes.addFlashAttribute("mensagem", "Imóvel cadastrado com sucesso!");

		imoveis.guardar(imovel);

		return modelAndView;
	}

}
