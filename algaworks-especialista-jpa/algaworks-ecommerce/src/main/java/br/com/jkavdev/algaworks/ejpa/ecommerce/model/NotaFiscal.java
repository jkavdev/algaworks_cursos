package br.com.jkavdev.algaworks.ejpa.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nota_fiscal")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id", foreignKey = @ForeignKey(name = "fk_nota_fiscal_pedido_pedido_id"))
//    @JoinTable(
//            name = "pedido_nota_fiscal",
//            joinColumns = @JoinColumn(
//                    name = "nota_fiscal_id",
//                    unique = true,
//                    foreignKey = @ForeignKey(name = "fk_pedido_nota_fiscal_nota_fiscal_nota_fiscal_id")
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "pedido_id",
//                    unique = true,
//                    foreignKey = @ForeignKey(name = "fk_pedido_nota_fiscal_nota_pedido_pedido_id")
//            ),
//            // na verdade, nao eh somente a unicidade dos campos combinados, e sim deles combinados e apenas um de cada por linha
//            // sem repeticao, o mesmo pedido nao pode estar em 2 notas, ou vice versa
//            uniqueConstraints = {
//                    @UniqueConstraint(
//                            name = "ck_pedido_nota_fiscal",
//                            columnNames = {"nota_fiscal_id", "pedido_id"}
//                    )
//            }
////            foreignKey = @ForeignKey(name = "fk_pedido_nota_fiscal_nota_fiscal_nota_fiscal_id"),
////            inverseForeignKey = @ForeignKey(name = "fk_pedido_nota_fiscal_nota_pedido_pedido_id")
//    )
    private Pedido pedido;

    private String xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;
}
