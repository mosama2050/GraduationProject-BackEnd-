package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.StudentHasCourseInTermMapper;
import com.mufic.Final.api.v2.model.StudentHasCourseInTermDTO;
import com.mufic.Final.api.v2.model.lists.StudentHasCourseInTermListDTO;
import com.mufic.Final.repositories.StudentHasCourseInTermRepository;
import com.mufic.Final.services.StudentHasCourseInTermService;
import org.springframework.stereotype.Service;

@Service
public class StudentHasCourseInTermServiceImpl implements StudentHasCourseInTermService {

    private final StudentHasCourseInTermRepository studentHasCourseInTermRepository;
    private final StudentHasCourseInTermMapper studentHasCourseInTermMapper;

    public StudentHasCourseInTermServiceImpl(StudentHasCourseInTermRepository studentHasCourseInTermRepository, StudentHasCourseInTermMapper studentHasCourseInTermMapper) {
        this.studentHasCourseInTermRepository = studentHasCourseInTermRepository;
        this.studentHasCourseInTermMapper = studentHasCourseInTermMapper;
    }

    @Override
    public StudentHasCourseInTermDTO getByStudentId(Long id) {
        return null;
    }

    @Override
    public StudentHasCourseInTermListDTO getAll() {
        return null;
    }

    @Override
    public StudentHasCourseInTermDTO createNew(StudentHasCourseInTermDTO studentHasCourseInTermDTO) {
        return null;
    }

    @Override
    public StudentHasCourseInTermDTO saveByDTO(Long id, StudentHasCourseInTermDTO studentHasCourseInTermDTO) {
        return null;
    }

    @Override
    public StudentHasCourseInTermDTO patch(Long id, StudentHasCourseInTermDTO studentHasCourseInTermDTO) {
        return null;
    }

    @Override
    public void deleteByStudentId(Long id) {

    }
}
