package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.CityMapper;
import com.mufic.Final.api.v2.model.CityDTO;
import com.mufic.Final.api.v2.model.lists.CityListDTO;
import com.mufic.Final.controllers.v2.CityController;
import com.mufic.Final.repositories.CityRepository;
import com.mufic.Final.services.CityService;
import com.mufic.Final.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityMapper cityMapper;
    private final CityRepository cityRepository;

    public CityServiceImpl(CityMapper cityMapper, CityRepository cityRepository) {
        this.cityMapper = cityMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public CityDTO getById(Long id) {
        return cityRepository.findById(id)
            .map(cityMapper::cityToCityDTO)
            .map(cityDTO -> {
                cityDTO.setCityUrl(getUrl(id));
                return cityDTO;
            }
        ).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CityListDTO getAll() {
        return new CityListDTO(
                cityRepository.findAll()
                .stream()
                .map(cityMapper::cityToCityDTO)
                .map(cityDTO -> {
                    cityDTO.setCityUrl(getUrl( cityDTO.getId() ));
                    return cityDTO;
                })
                .collect(Collectors.toList())
        );
    }


    private String getUrl(long id) {
        return CityController.BASE_URL + "/" + id;
    }
}
