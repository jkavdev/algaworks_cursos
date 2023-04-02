package br.com.jkavdev.algaworks.ejpa.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {

    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tabela")
//    @TableGenerator(
//            // nome do gerador de chave primaria
//            name = "tabela",
//            // nome da tabela que vai conter as chaves primarias
//            table = "hibernate_sequences",
//            // nome da coluna que vai conter os nomes das chaves primarias
//            pkColumnName = "sequence_name",
//            // nome do valor da chave primaria dessa entidade
//            pkColumnValue = "categoria",
//            // nome da coluna que contem o valor atual da chave primaria
//            valueColumnName = "next_val",
//            // valor inicial da chave primaria
//            initialValue = 0,
//            // quantas chaves primarias o jpa armazera em memoria
//            allocationSize = 50
//    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String nome;

    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiId;
}
