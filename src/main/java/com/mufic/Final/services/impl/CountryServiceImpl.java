package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.CountryMapper;
import com.mufic.Final.api.v2.model.CountryDTO;
import com.mufic.Final.api.v2.model.lists.CityListDTO;
import com.mufic.Final.api.v2.model.lists.CountryListDTO;
import com.mufic.Final.controllers.v2.CityController;
import com.mufic.Final.controllers.v2.CountryController;
import com.mufic.Final.repositories.CountryRepository;
import com.mufic.Final.services.CountryService;
import com.mufic.Final.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
    }

    @Override
    public CountryDTO getById(Long id) {
        return countryRepository.findById(id)
                .map(countryMapper::countryToCountryDTO)
                .map(countryDTO -> {
                    countryDTO.setCountryUrl(getUrl(id));
                    return countryDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CountryListDTO getAll() {
        return new CountryListDTO(
                countryRepository.findAll()
                .stream()
                .map(countryMapper::countryToCountryDTO)
                .map(countryDTO -> {
                    countryDTO.setCountryUrl(getUrl( countryDTO.getId() ));
                    return countryDTO;
                }).collect(Collectors.toList())
        );
    }

    private String getUrl(long id) {
        return CountryController.BASE_URL + "/" + id;
    }

}
