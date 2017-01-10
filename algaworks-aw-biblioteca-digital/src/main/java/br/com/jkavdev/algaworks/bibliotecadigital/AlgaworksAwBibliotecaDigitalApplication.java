package br.com.jkavdev.algaworks.bibliotecadigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AlgaworksAwBibliotecaDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgaworksAwBibliotecaDigitalApplication.class, args);
	}
	
	@RequestMapping("/")
	public String ola(){
		return "Olá Spring boot";
	}
	
}
