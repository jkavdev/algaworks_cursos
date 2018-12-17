package br.com.jkavdev.algaworks.fullstack.vendas.resource;

import br.com.jkavdev.algaworks.fullstack.vendas.model.Produto;
import br.com.jkavdev.algaworks.fullstack.vendas.repository.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosResource {

    @Autowired
    private Produtos produtos;

    @GetMapping
    public List<Produto> listar() {
        return produtos.findAll();
    }

}
