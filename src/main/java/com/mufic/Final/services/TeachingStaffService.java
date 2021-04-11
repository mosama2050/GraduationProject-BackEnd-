package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.TeachingStaffDTO;
import com.mufic.Final.api.v2.model.lists.TeachingStaffListDTO;

public interface TeachingStaffService {

    TeachingStaffDTO getById(Long id);

    TeachingStaffListDTO getAll();

    TeachingStaffDTO createNew(TeachingStaffDTO DTO);

    TeachingStaffDTO saveByDTO(Long id,TeachingStaffDTO teachingStaffDTO);

    TeachingStaffDTO patch(Long id, TeachingStaffDTO teachingStaffDTO);

    void deleteById(Long id);
}
