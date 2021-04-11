package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.StudentDTO;
import com.mufic.Final.api.v2.model.lists.StudentListDTO;

public interface StudentService {
    StudentDTO getById(Long id);

    StudentListDTO getAll();

    StudentDTO createNew(StudentDTO studentDTO);

    StudentDTO saveByDTO(Long id, StudentDTO studentDTO);

    StudentDTO patch(Long id, StudentDTO studentDTO);

    void deleteById(Long id);
}
