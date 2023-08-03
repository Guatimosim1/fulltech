package com.capgemini.panteranegra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sessoes")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(5)", name = "horario_inicio")
    private String startingTime;

    @Column(columnDefinition = "varchar(5)", name = "horario_fim")
    private String endingTime;

}
