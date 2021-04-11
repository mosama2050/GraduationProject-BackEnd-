package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.PrivilegeDTO;
import com.mufic.Final.domain.Privilege;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrivilegeMapper {
    PrivilegeMapper INSTANCE = Mappers.getMapper(PrivilegeMapper.class);


    PrivilegeDTO objToDTO(Privilege obj);

    Privilege dtoToobj(PrivilegeDTO privilegeDTO);
}
