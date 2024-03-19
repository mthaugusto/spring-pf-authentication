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
@Table(name = "TB_PERFIL", uniqueConstraints = {
        @UniqueConstraint(
                name = "UK_NM_PERFIL", columnNames = "NM_PERFIL"
        )
})
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERFIL")
    @SequenceGenerator(name = "SQ_PERFIL", sequenceName = "SQ_PERFIL", allocationSize = 1)
    @Column(name = "ID_PERFIL")
    private Long id;

    @Column(name = "NM_PERFIL")
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_PERFIL_PERMISSOES",
            joinColumns = {
                    @JoinColumn(
                            name = "PERFIL",
                            referencedColumnName = "ID_PERFIL",
                            foreignKey = @ForeignKey(
                                    name = "FK_PERFIL_PERMISSAO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PERMISSAO",
                            referencedColumnName = "ID_PERMISSAO",
                            foreignKey = @ForeignKey(
                                    name = "FK_PERMISSAO_PERFIL"
                            )
                    )
            }
    )
    private Set<Permissao> permissoes = new LinkedHashSet<>();

}
