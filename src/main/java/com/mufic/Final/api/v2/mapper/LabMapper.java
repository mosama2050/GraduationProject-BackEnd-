package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.LabDTO;
import com.mufic.Final.domain.CourseInTerm;
import com.mufic.Final.domain.Labs;
import com.mufic.Final.domain.TeachingStaff;
import com.mufic.Final.repositories.CourseInTermRepository;
import com.mufic.Final.repositories.CourseRepository;
import com.mufic.Final.repositories.TeachingStaffRepository;
import com.mufic.Final.services.CourseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class LabMapper {
//    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    @Autowired
    private CourseInTermRepository courseInTermRepository;

    @Autowired
    private TeachingStaffRepository teachingStaffRepository;

    @Mapping(source = "courseInTerm.id", target = "courseInTerm")
    @Mapping(source = "teachingStaff.id", target = "teachingStaff")
    public abstract LabDTO objToDTO(Labs obj);


    public abstract Labs DtoToObj(LabDTO labDTO);

    public CourseInTerm toCourseInTerm(Long id){
        return courseInTermRepository.getOne(id);
    }

    public TeachingStaff toTeachingStaff(Long id){
        return teachingStaffRepository.getOne(id);
    }



}
