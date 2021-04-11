package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.CourseInTermDTO;
import com.mufic.Final.api.v2.model.lists.CourseInTermListDTO;

public interface CourseInTermService {
    CourseInTermDTO getById(Long id);

    CourseInTermListDTO getAll();

    CourseInTermDTO createNew(CourseInTermDTO courseInTermDTO);

    CourseInTermDTO saveByDTO(Long id, CourseInTermDTO courseInTermDTO);

    CourseInTermDTO patch(Long id, CourseInTermDTO courseInTermDTO);

    void deleteById(Long id);

}
