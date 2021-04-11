package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.DepartmentDTO;
import com.mufic.Final.api.v2.model.lists.DepartmentListDTO;

public interface DepartmentService {
    DepartmentDTO getById(Long id);

    DepartmentListDTO getAll();

    DepartmentDTO createNew(DepartmentDTO departmentDTO);

    DepartmentDTO saveByDTO(Long id, DepartmentDTO departmentDTO);

    DepartmentDTO patch(Long id, DepartmentDTO departmentDTO);

    void deleteById(Long id);

}
