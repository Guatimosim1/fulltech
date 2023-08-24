package com.capgemini.panteranegra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "cadeiras")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Chair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sessao", nullable = false)
    private Session session;

    @Column(columnDefinition = "varchar(255)", name = "nome_cliente")
    private String costumerName;

    private Boolean status = false;
}
