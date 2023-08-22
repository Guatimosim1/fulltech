package com.capgemini.panteranegra.factory;

import com.capgemini.panteranegra.entities.Chair;
import com.capgemini.panteranegra.models.ChairOutputDTO;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ChairFactory {
    private ChairFactory() {}

    public static ChairOutputDTO toOutputDTO(Chair chair) {
        return new ChairOutputDTO(chair.getCostumerName(), chair.getStatus());
    }

    public static Set<ChairOutputDTO> toOutputDTO(Collection<Chair> chairs) {
        return chairs.stream().map(ChairFactory::toOutputDTO).collect(Collectors.toSet());
    }
}
