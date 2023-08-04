package com.capgemini.panteranegra.factory;

import com.capgemini.panteranegra.entities.Chair;
import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;

import java.util.HashSet;
import java.util.Set;

public final class SessionFactory {
    private SessionFactory() {}
    public static Session toEntity(SessionPostInputDTO request) {
        Set<Chair> chairs = new HashSet<>();
        for(int i=0; i<30; i++) {
            chairs.add(new Chair());
        }
        return new Session().builder()
                .movieName(request.getMovieName())
                .startingTime(request.getStartingTime())
                .endingTime(request.getEndingTime())
                .chairs(chairs)
                .build();
    }
}
