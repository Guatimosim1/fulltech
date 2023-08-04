package com.capgemini.panteranegra.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "sessoes")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(5)", name = "horario_inicio")
    private String startingTime;

    @Column(columnDefinition = "varchar(5)", name = "horario_fim")
    private String endingTime;

    @Column(columnDefinition = "varchar(255)", name = "nome_filme")
    private String movieName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "session")
    private Set<Chair> chairs;
}
