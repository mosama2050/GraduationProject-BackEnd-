package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.ProgramDTO;
import com.mufic.Final.api.v2.model.lists.ProgramListDTO;

public interface ProgramService {
    ProgramDTO getById(Long id);

    ProgramListDTO getAll();

    ProgramDTO createNew(ProgramDTO programDTO);

    ProgramDTO saveByDTO(Long id, ProgramDTO programDTO);

    ProgramDTO patch(Long id, ProgramDTO programDTO);

    void deleteById(Long id);
}
