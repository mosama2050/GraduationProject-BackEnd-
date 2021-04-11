package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.StudentInfoDTO;
import com.mufic.Final.api.v2.model.lists.StudentInfoListDTO;

public interface StudentInfoService {
    StudentInfoDTO getById(Long id);

    StudentInfoListDTO getAll();

    StudentInfoDTO createNew(StudentInfoDTO studentInfoDTO);

    StudentInfoDTO saveByDTO(Long id, StudentInfoDTO studentInfoDTO);

    StudentInfoDTO patch(Long id, StudentInfoDTO studentInfoDTO);

    void deleteById(Long id);
}
