package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.PointSystemDTO;
import com.mufic.Final.api.v2.model.lists.PointSystemListDTO;

public interface PointSystemService {
    PointSystemDTO getById(Long id);

    PointSystemListDTO getAll();

    PointSystemDTO createNew(PointSystemDTO pointSystemDTO);

    PointSystemDTO saveByDTO(Long id, PointSystemDTO pointSystemDTO);

    PointSystemDTO patch(Long id, PointSystemDTO pointSystemDTO);

    void deleteById(Long id);

}
