package br.com.jkavdev.algaworks.bibliotecadigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jkavdev.algaworks.bibliotecadigital.model.Livro;
import br.com.jkavdev.algaworks.bibliotecadigital.repository.Livros;

@Controller
@RequestMapping("/livros")
public class LivrosController {

	@Autowired
	private Livros livros;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("cadastro-livros");
		modelAndView.addObject("livros", livros.findAll());

		return modelAndView;
	}

	@PostMapping
	public String salvar(Livro livro) {
		livros.save(livro);

		return "redirect:/livros";
	}

}
