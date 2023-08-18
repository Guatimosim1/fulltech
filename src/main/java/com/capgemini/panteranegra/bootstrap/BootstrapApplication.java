package com.capgemini.panteranegra.bootstrap;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.repositores.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@RequiredArgsConstructor
public class BootstrapApplication implements CommandLineRunner {

    private final SessionRepository sessionRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSessionsData();
    }

    private void loadSessionsData() {
        Session s1 = Session.builder()
                .startingTime("20:00")
                .endingTime("21:50")
                .movieName("Spider-Man")
                .build();

        Session s2 = Session.builder()
                .startingTime("21:50")
                .endingTime("23:00")
                .movieName("Barbie")
                .build();

        Session s3 = Session.builder()
                .startingTime("23:00")
                .endingTime("01:00")
                .movieName("Oppenheimer")
                .build();

        sessionRepository.saveAll(Arrays.asList(s1, s2, s3));
    }
}
