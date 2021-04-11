package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.StateMapper;
import com.mufic.Final.api.v2.model.StateDTO;
import com.mufic.Final.api.v2.model.lists.StateListDTO;
import com.mufic.Final.controllers.v2.CityController;
import com.mufic.Final.controllers.v2.RoleController;
import com.mufic.Final.controllers.v2.StateController;
import com.mufic.Final.repositories.StateRepository;
import com.mufic.Final.services.ResourceNotFoundException;
import com.mufic.Final.services.StateService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    private final StateMapper stateMapper;
    private final StateRepository stateRepository;

    public StateServiceImpl(StateMapper stateMapper, StateRepository stateRepository) {
        this.stateMapper = stateMapper;
        this.stateRepository = stateRepository;
    }


    @Override
    public StateDTO getById(Long id) {
        return stateRepository.findById(id)
                .map(stateMapper::objToDTO)
                .map(stateDTO -> {
                    stateDTO.setStateUrl(getUrl(id));
                    return stateDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public StateListDTO getAll() {
        return new StateListDTO(
                stateRepository.findAll()
                .stream()
                .map(stateMapper::objToDTO)
                .map(stateDTO -> {
                    stateDTO.setStateUrl(stateDTO.getStateUrl());
                    return stateDTO;
                })
                .collect(Collectors.toList())
        );
    }

    private String getUrl(long id) {
        return StateController.BASE_URL + "/" + id;
    }

}
