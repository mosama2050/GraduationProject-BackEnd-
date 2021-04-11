package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.CountryDTO;
import com.mufic.Final.api.v2.model.lists.CountryListDTO;

public interface CountryService {
    CountryDTO getById(Long id);

    CountryListDTO getAll();
//
//    CountryDTO createNew(CountryDTO DTO);
//
//    CountryDTO saveByDTO(Long id, CountryDTO vendorDTO);
//
//    CountryDTO patch(Long id, CountryDTO vendorDTO);
//
//    void deleteById(Long id);

}
