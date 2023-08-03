package com.capgemini.panteranegra.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionPostOutputDTO {

    private Long id;
    private String startingTime;
    private String endingTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ChairDTO> chairs = new ArrayList<>();

    private String movieName;
}
