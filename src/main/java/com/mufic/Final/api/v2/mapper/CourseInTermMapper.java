package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.CourseInTermDTO;
import com.mufic.Final.domain.Course;
import com.mufic.Final.domain.CourseInTerm;
import com.mufic.Final.domain.TeachingStaff;
import com.mufic.Final.domain.Term;
import com.mufic.Final.repositories.CourseRepository;
import com.mufic.Final.repositories.TeachingStaffRepository;
import com.mufic.Final.repositories.TermRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class CourseInTermMapper {
//    CourseInTermMapper INSTANCE = Mappers.getMapper(CourseInTermMapper.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TermRepository termRepository;

    @Autowired
    private TeachingStaffRepository teachingStaffRepository;

    @Mapping(source = "term.id", target = "term")
    @Mapping(source = "course.code", target = "course")
    @Mapping(source = "instructor.id", target = "instructor")
    public abstract CourseInTermDTO courseInTermToCourseInTermDTO(CourseInTerm courseInTerm);


    public abstract CourseInTerm DtoToObj(CourseInTermDTO courseInTermDTO);

    Term toTerm(Long id){
        return termRepository.getOne(id);
    }

    Course toCourse(String code){
        return courseRepository.getOne(code);
    }
    TeachingStaff toTeachingStaff(Long id){
        return teachingStaffRepository.getOne(id);
    }






}
