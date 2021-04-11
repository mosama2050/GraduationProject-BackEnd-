package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.CityDTO;
import com.mufic.Final.domain.City;
import com.mufic.Final.domain.State;
import com.mufic.Final.repositories.StateRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CityMapper {
//    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);



//    StateRepository
    @Mapping(source = "state.id", target = "state")
    @Mapping(source = "country.id", target = "country")
    public abstract CityDTO cityToCityDTO(City city);

}
