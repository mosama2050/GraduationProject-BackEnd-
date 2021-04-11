package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.CityDTO;
import com.mufic.Final.api.v2.model.lists.CityListDTO;

public interface CityService {
    CityDTO getById(Long id);

    CityListDTO getAll();

//    DTO createNew(DTO DTO);
//
//    DTO saveByDTO(Long id, VendorDTO vendorDTO);
//
//    DTO patch(Long id, DTO vendorDTO);
//
//    void deleteById(Long id);
}
