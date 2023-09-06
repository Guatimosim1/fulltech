package com.capgemini.panteranegra.factory;

import com.capgemini.panteranegra.entities.Chair;
import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import com.capgemini.panteranegra.models.SessionResponseDTO;

import java.util.ArrayList;
import java.util.List;

public final class SessionFactory {
    private SessionFactory() {}
    public static Session toEntity(SessionPostInputDTO request) {
        List<Chair> chairs = new ArrayList<>();
        for(int i=0; i<30; i++) {
            chairs.add(new Chair());
        }
        Session session = new Session().builder()
                .movieName(request.getMovieName())
                .startingTime(request.getStartingTime())
                .endingTime(request.getEndingTime())
                .image(request.getImage())
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
                .image(session.getImage())
                .chairs(ChairFactory.toOutputDTO(session.getChairs()))
                .build();

    }
}
