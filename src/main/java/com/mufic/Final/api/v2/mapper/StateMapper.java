package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.StateDTO;
import com.mufic.Final.domain.City;
import com.mufic.Final.domain.CourseInTerm;
import com.mufic.Final.domain.State;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class StateMapper {
//    public StateMapper INSTANCE = Mappers.getMapper(StateMapper.class);

    @Mapping(source = "country.id", target = "country")
    public abstract StateDTO objToDTO(State obj);

    @IterableMapping(elementTargetType = String.class)
    protected abstract List<Long> maplistToString(List<City> list);

    protected String mapToString(City city) {
        return city.getName();
    }
}
