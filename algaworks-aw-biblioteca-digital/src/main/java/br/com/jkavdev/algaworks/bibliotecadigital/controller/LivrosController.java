package br.com.jkavdev.algaworks.bibliotecadigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jkavdev.algaworks.bibliotecadigital.model.Livro;
import br.com.jkavdev.algaworks.bibliotecadigital.repository.Livros;

@Controller
@RequestMapping("/livros")
public class LivrosController {

	@Autowired
	private Livros livros;

	@GetMapping
	public String home() {
		return "cadastro-livros";
	}

	@PostMapping
	public String salvar(Livro livro) {
		livros.save(livro);
		System.out.println(">>>> " + livro.getTitulo());

		return "redirect:/livros";
	}

}
