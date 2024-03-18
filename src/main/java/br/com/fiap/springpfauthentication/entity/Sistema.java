package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_SISTEMA")
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SISTEMA")
    @SequenceGenerator(name = "SQ_SISTEMA", sequenceName = "SQ_SISTEMA", allocationSize = 1)
    @Column(name = "ID_SISTEMA")
    private Long id;


    @Column(name = "NM_SISTEMA")
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_RESPONSABILIDADE",
            joinColumns = {
                    @JoinColumn(
                            name = "SISTEMA",
                            referencedColumnName = "ID_SISTEMA",
                            foreignKey = @ForeignKey(
                                    name = "FK_RESPONSABILIDADE_SISTEMA"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "USUARIO",
                            referencedColumnName = "ID_USUARIO",
                            foreignKey = @ForeignKey(
                                    name = "FK_RESPONSABILIDADE_USUARIO"
                            )
                    )
            }

    )
    private Set<Usuario> responsaveis = new LinkedHashSet<>();
}
