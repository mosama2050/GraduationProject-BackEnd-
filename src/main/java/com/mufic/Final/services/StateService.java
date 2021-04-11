package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.StateDTO;
import com.mufic.Final.api.v2.model.lists.StateListDTO;

public interface StateService {
    StateDTO getById(Long id);

    StateListDTO getAll();
//
//    StateDTO createNew(StateDTO stateDTO);
//
//    StateDTO saveByDTO(Long id, StateDTO stateDTO);
//
//    StateDTO patch(Long id, StateDTO stateDTO);
//
//    void deleteById(Long id);
}
