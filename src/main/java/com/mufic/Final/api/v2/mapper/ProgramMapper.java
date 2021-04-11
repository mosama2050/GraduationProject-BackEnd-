package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.ProgramDTO;
import com.mufic.Final.domain.Course;
import com.mufic.Final.domain.CourseInTerm;
import com.mufic.Final.domain.Program;
import com.mufic.Final.repositories.CourseRepository;
import com.mufic.Final.repositories.ProgramRepository;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public abstract class ProgramMapper {
//    public ProgramMapper INSTANCE = Mappers.getMapper(ProgramMapper.class);


    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ProgramRepository programRepository;

    @Mapping(source = "underRequirement.id", target = "underRequirement")
    public abstract ProgramDTO objToDTO(Program obj);


    public abstract Program dtoToObj(ProgramDTO programDTO);
//
//    @IterableMapping(elementTargetType = String.class)
//    protected abstract List<String> maplistToString(List<Course> list);
//
//    @IterableMapping(elementTargetType = Course.class)
//    protected abstract List<Course> toCourses(List<String> list);
//
//    protected String mapToString(Course course){
//        return course.getCode();
//    }
//
//    protected Course mapToCourse(String code){
//        return courseRepository.getOne(code);
//    }

    public Program toProgram(Long id){
        return programRepository.getOne(id);
    }

}
