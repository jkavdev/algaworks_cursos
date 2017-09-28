package br.com.jkavdev.algaworks.patrimonio.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.algaworks.patrimonio.model.Item;
import br.com.jkavdev.algaworks.patrimonio.repository.ItemRepository;

@RestController
//definindo quem tem acesso as informacoes de item
//definido no arquivo de configuracao do spring
@CrossOrigin("${origem-permitida}")
public class ItemResource {

	@Autowired
	private ItemRepository itemRepository;

	//podemos definir a mesma uri para os metodos de item
	//diferenciando apenas os metodos https utilizados
	@GetMapping("/itens")
	public List<Item> listar() {
		return itemRepository.findAll();
	}
	
	@PostMapping("/itens")
	public Item adicionar(@RequestBody @Valid Item item) {
		return itemRepository.save(item);
	}

}
