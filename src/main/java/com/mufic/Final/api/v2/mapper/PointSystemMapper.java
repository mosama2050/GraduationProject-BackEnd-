package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.PointSystemDTO;
import com.mufic.Final.domain.PointSystem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PointSystemMapper {
    PointSystemMapper INSTANCE = Mappers.getMapper(PointSystemMapper.class);


    PointSystemDTO objToDTO(PointSystem obj);


    PointSystem dtoToObj(PointSystemDTO pointSystemDTO);
}
