package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.StudentHasCourseInTermDTO;
import com.mufic.Final.api.v2.model.lists.StudentHasCourseInTermListDTO;

public interface StudentHasCourseInTermService {
    StudentHasCourseInTermDTO getByStudentId(Long id);

    StudentHasCourseInTermListDTO getAll();

    StudentHasCourseInTermDTO createNew(StudentHasCourseInTermDTO studentHasCourseInTermDTO);

    StudentHasCourseInTermDTO saveByDTO(Long id, StudentHasCourseInTermDTO studentHasCourseInTermDTO );

    StudentHasCourseInTermDTO patch(Long id, StudentHasCourseInTermDTO studentHasCourseInTermDTO);

    void deleteByStudentId(Long id);
}
