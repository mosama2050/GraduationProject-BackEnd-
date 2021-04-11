package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.RegularTermRulesDTO;
import com.mufic.Final.domain.RegularTermRules;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegularTermRulesMapper {
    RegularTermRulesMapper INSTANCE = Mappers.getMapper(RegularTermRulesMapper.class);

    RegularTermRulesDTO objToDTO(RegularTermRules obj);

    RegularTermRules dtoToObj(RegularTermRulesDTO regularTermRulesDTO);
}
