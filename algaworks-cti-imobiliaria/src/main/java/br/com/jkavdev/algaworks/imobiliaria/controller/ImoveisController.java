package br.com.jkavdev.algaworks.imobiliaria.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.jkavdev.algaworks.imobiliaria.model.Imovel;
import br.com.jkavdev.algaworks.imobiliaria.model.TipoImovel;
import br.com.jkavdev.algaworks.imobiliaria.repository.Imoveis;
import br.com.jkavdev.algaworks.imobiliaria.repository.filter.ImovelFilter;

@Controller
@RequestMapping("/imoveis")
public class ImoveisController {

	@Autowired
	private Imoveis imoveis;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("cadastro-imovel");
		modelAndView.addObject("imovel", new Imovel());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicionar(@Validated Imovel imovel, Errors errors, RedirectAttributes attributes) {
		ModelAndView modelAndView = new ModelAndView();

		if (errors.hasErrors()) {
			modelAndView.setViewName("cadastro-imovel");
			return modelAndView;
		}

		imoveis.guardar(imovel);

		modelAndView.setViewName("redirect:/imoveis/novo");
		attributes.addFlashAttribute("mensagem", "Imóvel cadastrado com sucesso!");

		return modelAndView;
	}

	@ModelAttribute
	public List<TipoImovel> tiposImoveis() {
		return Arrays.asList(TipoImovel.values());
	}

	@RequestMapping("/pesquisa")
	public ModelAndView pesquisa() {
		ModelAndView modelAndView = new ModelAndView("pesquisa-imoveis");
		modelAndView.addObject("filtro", new ImovelFilter());

		return modelAndView;
	}

	@RequestMapping
	public ModelAndView filtrar(@ModelAttribute("filtro") ImovelFilter filtro) {
		ModelAndView modelAndView = new ModelAndView("pesquisa-imoveis");

		List<Imovel> imoveisFiltrados = imoveis.filtrar(filtro);
		modelAndView.addObject(imoveisFiltrados);

		return modelAndView;
	}
}
