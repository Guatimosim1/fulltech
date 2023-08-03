package com.capgemini.panteranegra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cadeiras")
public class Chair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sessao", nullable = false)
    @JsonIgnore
    private Session session;

    @Column(columnDefinition = "varchar(255)", name = "nome_cliente")
    private String costumerName;

    private Boolean status;
}
