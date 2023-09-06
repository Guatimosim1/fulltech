package com.capgemini.panteranegra.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionPostOutputDTO {

    private Long id;
    private String startingTime;
    private String endingTime;
    private String movieName;
    private byte[] image;
}
