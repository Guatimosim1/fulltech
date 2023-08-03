package com.capgemini.panteranegra.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionPostInputDTO {

    private String startingTime;
    private String endingTime;
    private String movieName;
}
