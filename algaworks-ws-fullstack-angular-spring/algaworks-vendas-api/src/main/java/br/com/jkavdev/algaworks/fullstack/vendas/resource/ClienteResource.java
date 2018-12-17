package br.com.jkavdev.algaworks.fullstack.vendas.resource;

import br.com.jkavdev.algaworks.fullstack.vendas.model.Cliente;
import br.com.jkavdev.algaworks.fullstack.vendas.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private Clientes clientes;

    @GetMapping
    public List<Cliente> listar() {
        return clientes.findAll();
    }

}
