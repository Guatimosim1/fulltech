package com.capgemini.panteranegra.models;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionResponseDTO {
    private Long id;
    private String startingTime;
    private String endingTime;
    private String movieName;
    private Set<ChairOutputDTO> chairs;
}
