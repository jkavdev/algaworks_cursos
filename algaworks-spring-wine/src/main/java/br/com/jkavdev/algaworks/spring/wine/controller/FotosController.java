package br.com.jkavdev.algaworks.spring.wine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.jkavdev.algaworks.spring.wine.dto.Foto;
import br.com.jkavdev.algaworks.spring.wine.service.VinhoService;

@RestController
@RequestMapping("/fotos")
public class FotosController {

	@Autowired
	private VinhoService vinhoService;

	@RequestMapping(value = "{codigo}", method = RequestMethod.POST)
	// @RequestParam("files[]") - nome da variável do UIkit fornece por parâmetro
	public Foto upload(@PathVariable Long codigo, @RequestParam("files[]") MultipartFile[] files) {		
		return new Foto(vinhoService.adicionarFoto(codigo, files[0]));
	}

}
