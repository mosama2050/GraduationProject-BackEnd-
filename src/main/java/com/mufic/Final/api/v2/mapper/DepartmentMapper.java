package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.DepartmentDTO;
import com.mufic.Final.domain.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDTO departmentToDepartmentDTO(Department obj);

    Department dtoToObj(DepartmentDTO departmentDTO);


}
