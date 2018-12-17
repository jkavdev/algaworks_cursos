package br.com.jkavdev.algaworks.fullstack.vendas.resource;

import br.com.jkavdev.algaworks.fullstack.vendas.model.Venda;
import br.com.jkavdev.algaworks.fullstack.vendas.repository.Vendas;
import br.com.jkavdev.algaworks.fullstack.vendas.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendasResource {

    @Autowired
    private Vendas vendas;
    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> listar() {
        return vendas.findAll();
    }

    @PostMapping
    public Venda adicionar(@RequestBody @Valid Venda venda) {
        return vendaService.adicionar(venda);
    }

}
