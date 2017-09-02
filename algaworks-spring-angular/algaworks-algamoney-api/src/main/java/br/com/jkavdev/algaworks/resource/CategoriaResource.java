package br.com.jkavdev.algaworks.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	//podemos gerar com retorno com o ResponseStatus, 
	//aqui indicamos que foi criado um recurso
	// @ResponseStatus(HttpStatus.CREATED)
	//O spring ja realiza a conversao do conteudo que esta vindo para uma categoria
	public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);

		//a especificacao rest define que se um recurso eh criado
		//entao devemos retorna sua Location, seu caminho de acesso, devolvido no header da requisicao
		//podemos utilizar ServletUriComponentsBuilder.fromCurrentRequestUri() facilitador
		//que obterar a url atual e adicionara o id da categoria criada
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(categoriaSalva.getId()).toUri();
		//e com o response indicamos o parametro location
		// http://localhost:8080/categorias/12
		response.setHeader("Location", uri.toASCIIString());

		//comum ainda, eh retornar o recurso criado como resposta da requisicao
		//podemos realizar isso com o ResponseEntity, indicando que foi criado
		//passando a uri de acesso, e no corpo da requisicao o recurso criado
		return ResponseEntity.created(uri).body(categoriaSalva);
	}

	@GetMapping("/{codigo}")
	public Categoria buscarPeloId(@PathVariable Long codigo) {
		return categoriaRepository.findOne(codigo);
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
