package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.StudentDTO;
import com.mufic.Final.domain.*;
import com.mufic.Final.repositories.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class StudentMapper {
//    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Autowired
    private TeachingStaffRepository teachingStaffRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StudentInfoRepository studentInfoRepository;


    @Mapping(source = "guide.id", target = "guide")
    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "department.id", target = "department")
    @Mapping(source = "city.id", target = "city")
    @Mapping(source = "studentInfo.id", target = "studentInfo")
    public abstract StudentDTO objToDTO(Student obj);


    public abstract Student dtoToObj(StudentDTO studentDTO);

    public TeachingStaff convertToGuide(Long id){
        return teachingStaffRepository.findById(id).orElse(null);
    }
    public User convertToUser(Long id){
        return userRepository.getOne(id);
    }
    public Department convertToDepartment(Long id){
        return departmentRepository.getOne(id);
    }
    public City convertToCity(Long id){
        return cityRepository.getOne(id);
    }
    public StudentInfo convertTo(Long id){
        return studentInfoRepository.getOne(id);
    }

}
