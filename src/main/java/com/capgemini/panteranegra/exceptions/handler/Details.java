package com.capgemini.panteranegra.exceptions.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Details {
    private String mensagem;
    private Integer codigo;
    private String path;
    private LocalDateTime timestamp;

}
