package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.StudentHasCourseInTermDTO;
import com.mufic.Final.domain.StudentHasCourseInTerm;
import com.mufic.Final.domain.StudentHasCourseInTermID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentHasCourseInTermMapper {
    StudentHasCourseInTermMapper INSTANCE = Mappers.getMapper(StudentHasCourseInTermMapper.class);

    @Mapping(source = "studentHasCourseInTermID.courseInTermId", target = "courseInTermId")
    @Mapping(source = "studentHasCourseInTermID.studentId", target = "studentId")
    StudentHasCourseInTermDTO objToDTO(StudentHasCourseInTerm obj);

    @Mapping(target = "studentHasCourseInTermID.courseInTermId", source = "courseInTermId")
    @Mapping(target = "studentHasCourseInTermID.studentId", source = "studentId")
    StudentHasCourseInTerm dtoToObj(StudentHasCourseInTermDTO studentHasCourseInTermDTO);
}
