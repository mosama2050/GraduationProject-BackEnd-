package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.ProgramLevelDTO;
import com.mufic.Final.api.v2.model.lists.ProgramLevelListDTO;

public interface ProgramLevelService {
    ProgramLevelDTO getById(Long id);

    ProgramLevelListDTO getAll();

    ProgramLevelDTO createNew(ProgramLevelDTO programLevelDTO);

    ProgramLevelDTO saveByDTO(Long id, ProgramLevelDTO programLevelDTO);

    ProgramLevelDTO patch(Long id, ProgramLevelDTO programLevelDTO);

    void deleteById(Long id);
}
