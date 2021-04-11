package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.SummerTermRulesDTO;
import com.mufic.Final.domain.SummerTermRules;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SummerTermRulesMapper {
    SummerTermRulesMapper INSTANCE = Mappers.getMapper(SummerTermRulesMapper.class);


    SummerTermRulesDTO objToDTO(SummerTermRules obj);

    SummerTermRules dtoToObj(SummerTermRulesDTO summerTermRulesDTO);
}
