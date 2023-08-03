package com.capgemini.panteranegra.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "cadeiras")
public class Chair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sessao")
    private Session session;

    @Column(columnDefinition = "varchar(5)", name = "nome_cliente")
    private String clientName;

    private Boolean status;
}
