package com.capgemini.panteranegra.mappers;

import com.capgemini.panteranegra.entities.Session;
import com.capgemini.panteranegra.models.SessionPostInputDTO;
import com.capgemini.panteranegra.models.SessionPostOutputDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

    private final ModelMapper modelMapper;

    public SessionPostInputDTO sessionEntityToPostInputDto(Session session) {
        return Objects.isNull(session) ? null : modelMapper.map(session, SessionPostInputDTO.class);
    }

    public Session sessionPostInputDtoToEntity(SessionPostInputDTO dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Session.class);
    }

    public SessionPostOutputDTO sessionEntityToPostOutputDto(Session session) {
        return Objects.isNull(session) ? null : modelMapper.map(session, SessionPostOutputDTO.class);
    }
}
