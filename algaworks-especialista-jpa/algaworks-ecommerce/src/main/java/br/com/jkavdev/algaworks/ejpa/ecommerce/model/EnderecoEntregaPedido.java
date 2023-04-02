package br.com.jkavdev.algaworks.ejpa.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class EnderecoEntregaPedido {

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;
}