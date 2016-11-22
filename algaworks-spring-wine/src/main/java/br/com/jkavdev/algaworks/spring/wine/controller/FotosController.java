package br.com.jkavdev.algaworks.spring.wine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {

	@RequestMapping(method = RequestMethod.POST)
	//@RequestParam("files[]") - nome da variável do UIkit fornece por parâmetro
	public String upload(@RequestParam("files[]") MultipartFile[] files) {

		System.out.println("Nome da Foto: " + files[0].getOriginalFilename());

		return "OK";
	}

}
