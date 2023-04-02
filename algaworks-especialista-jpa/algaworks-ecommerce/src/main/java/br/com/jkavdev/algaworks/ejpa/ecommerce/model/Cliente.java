package br.com.jkavdev.algaworks.ejpa.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
// precisamos do construtor padrao, caso queiramos trazer essa entidade do banco de dados
// pois criamos um construtor com parametros
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    @EqualsAndHashCode.Include
    private Integer id;

    private String nome;

    private SexoCliente sexo;

    public Cliente(String nome) {
        this.nome = nome;
    }

}
