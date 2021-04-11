package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.StudentInfoDTO;
import com.mufic.Final.domain.Student;
import com.mufic.Final.domain.StudentInfo;
import com.mufic.Final.repositories.StudentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class StudentInfoMapper {
//    StudentInfoMapper INSTANCE = Mappers.getMapper(StudentInfoMapper.class);

    @Autowired
    StudentRepository studentRepository;

    @Mapping(source = "student.id", target = "student")
    public abstract StudentInfoDTO objToDTO(StudentInfo obj);


    public abstract StudentInfo dtoToObj(StudentInfoDTO studentInfoDTO);

    public Student mapToStudent(Long id){
        return studentRepository.getOne(id);
    }


}
