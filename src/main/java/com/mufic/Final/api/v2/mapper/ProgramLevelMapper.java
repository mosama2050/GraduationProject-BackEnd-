package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.ProgramLevelDTO;
import com.mufic.Final.domain.ProgramLevel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgramLevelMapper {
    ProgramLevelMapper INSTANCE = Mappers.getMapper(ProgramLevelMapper.class);


    ProgramLevelDTO objToDTO(ProgramLevel obj);


    ProgramLevel dtoToObj(ProgramLevelDTO programLevelDTO);
}
