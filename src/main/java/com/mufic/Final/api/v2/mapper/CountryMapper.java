package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.CountryDTO;
import com.mufic.Final.domain.City;
import com.mufic.Final.domain.Country;
import com.mufic.Final.domain.State;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class CountryMapper {
//    public CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);


    public abstract CountryDTO countryToCountryDTO(Country country);

    @IterableMapping(elementTargetType = String.class)
    protected abstract List<String> mapCitiesToString(List<City> cities);

    @IterableMapping(elementTargetType = String.class)
    protected abstract List<String> mapStatesToString(List<State> states);

    protected String mapCityToString(City city) {
        return city.getName();
    }

    protected String mapStateToString(State state) {
        return state.getName();
    }
}
