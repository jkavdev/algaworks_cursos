<<<<<<< HEAD
package br.com.jkavdev.algaworks.spring.wine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jkavdev.algaworks.spring.wine.repository.Vinhos;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private Vinhos vinhos;

	@RequestMapping("/novo")
	public String novo() {
		return "/vinho/cadastro-vinho";
	}

	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView modelAndView = new ModelAndView("/vinho/listagem-vinhos");
		
		modelAndView.addObject("vinhos", vinhos.findAll());

		return modelAndView;
	}

}
=======
package br.com.jkavdev.algaworks.spring.wine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@RequestMapping("/novo")
	public String novo() {
		return "/vinho/cadastro-vinho";
	}
	
	@RequestMapping
	public String pesquisa() {
		return "/vinho/listagem-vinhos";
	}
	
}
>>>>>>> branch 'master' of https://github.com/jkavdev/algaworks_cursos.git
