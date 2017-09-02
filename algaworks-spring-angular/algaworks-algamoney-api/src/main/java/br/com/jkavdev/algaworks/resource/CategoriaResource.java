package br.com.jkavdev.algaworks.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.model.Categoria;
import br.com.jkavdev.algaworks.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	@GetMapping("/comConteudo")
	public ResponseEntity<?> listarComCodigo() {
		List<Categoria> categorias = categoriaRepository.findAll();
		
		//podemos retornar um status junto com o conteudo requisitado
		//aqui estamos verificando se retornou alguma coisa
		//se sim devolva o resultado com o status de ok
		
		//se nao tiver nada, devolva um resultado indicando que nao foi encontrado nada
		//mas fica estranho retornar o 404
//		return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.notFound().build();
		
		//Podemos devolver um status que indica que nao houve uma resposta para o conteudo requisitado
		//mas mesmo assim, continuamos a ter um resultado como vazio e apenas o status retornado
		//muitas das vezes podemos apenas retornar o conteudo vazio mesmo
		//categorias = {}
		return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
	}

}
