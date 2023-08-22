package com.capgemini.panteranegra.factory;

import com.capgemini.panteranegra.entities.Chair;
import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import com.capgemini.panteranegra.models.SessionPostOutputDTO;
import com.capgemini.panteranegra.models.SessionResponseDTO;

import java.util.HashSet;
import java.util.Set;

public final class SessionFactory {
    private SessionFactory() {}
    public static Session toEntity(SessionPostInputDTO request) {
        Set<Chair> chairs = new HashSet<>();
        for(int i=0; i<30; i++) {
            chairs.add(new Chair());
        }
        Session session = new Session().builder()
                .movieName(request.getMovieName())
                .startingTime(request.getStartingTime())
                .endingTime(request.getEndingTime())
                .build();
        chairs.stream().forEach(chair -> chair.setSession(session));
        session.setChairs(chairs);
        return session;
    }

    public static SessionResponseDTO toOutputDTO(Session session) {
        return new SessionResponseDTO().builder()
                .id(session.getId())
                .movieName(session.getMovieName())
                .startingTime(session.getStartingTime())
                .endingTime(session.getEndingTime())
                .chairs(ChairFactory.toOutputDTO(session.getChairs()))
                .build();

    }
}
