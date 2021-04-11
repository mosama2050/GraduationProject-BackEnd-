package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.CourseDTO;
import com.mufic.Final.domain.Course;
import com.mufic.Final.domain.Department;
import com.mufic.Final.domain.Program;
import com.mufic.Final.repositories.CourseRepository;
import com.mufic.Final.repositories.DepartmentRepository;
import com.mufic.Final.repositories.ProgramRepository;
import com.mufic.Final.services.ProgramService;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public abstract class CourseMapper {
//    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Mapping(source = "program.id", target = "program")
    @Mapping(source = "preCourse.code", target = "preCourse")
    public abstract CourseDTO courseToCourseDTO(Course course);


    public abstract Course CourseDtoTocourse(CourseDTO course);

    @IterableMapping(elementTargetType = String.class)
    protected abstract List<String> mapDepartmentToList(List<Department> obj);

    protected String mapDepartmentToString(Department obj) {
        return obj.getCode();
    }

    protected Program Toprogram(Long id){
        return programRepository.findById(id).orElse(null);
    }

    protected Course toCourse(String code){
//        if(code==null || code.equals("")) return null;
        return courseRepository.findById(code).orElse( null);
    }
}
