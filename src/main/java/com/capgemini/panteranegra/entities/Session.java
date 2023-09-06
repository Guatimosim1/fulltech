package com.capgemini.panteranegra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "sessoes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @Column(columnDefinition = "TEXT")
    private String image;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "session")
    private List<Chair> chairs;

}
