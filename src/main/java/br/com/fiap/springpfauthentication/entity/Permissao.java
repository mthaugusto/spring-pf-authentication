package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_PERMISSAO", uniqueConstraints = {
        @UniqueConstraint(
                name = "UK_NM_PERMISSAO_SISTEMA", columnNames = {"SISTEMA", "NM_PERMISSAO"}
        )
})
public class Permissao {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERMISSAO")
    @SequenceGenerator(name = "SQ_PERMISSAO", sequenceName = "SQ_PERMISSAO", allocationSize = 1)
    @Column(name = "ID_PERMISSAO")
    private Long id;


    @Column(name = "NM_PERMISSAO")
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "SISTEMA",
            referencedColumnName = "ID_SISTEMA",
            foreignKey = @ForeignKey(
                    name = "FK_PERMISSAO_SISTEMA"
            )
    )
    private Sistema sistema;
}
