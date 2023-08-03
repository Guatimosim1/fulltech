package com.capgemini.panteranegra.factory;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;

public final class SessionFactory {
    private SessionFactory() {}
    public static Session toEntity(SessionPostInputDTO request) {
        return new Session().builder()
                .movieName(request.getMovieName())
                .startingTime(request.getStartingTime())
                .endingTime(request.getEndingTime())
                .build();
    }
}
