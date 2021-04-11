package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.LabDTO;
import com.mufic.Final.api.v2.model.lists.LabListDTO;

public interface LabService {
    LabDTO getById(Long id);

    LabListDTO getAll();

    LabDTO createNew(LabDTO labDTO);

    LabDTO saveByDTO(Long id, LabDTO labDTO);

    LabDTO patch(Long id, LabDTO labDTO);

    void deleteById(Long id);

}
