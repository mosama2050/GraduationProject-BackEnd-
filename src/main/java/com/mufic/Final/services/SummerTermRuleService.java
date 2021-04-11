package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.SummerTermRulesDTO;
import com.mufic.Final.api.v2.model.lists.SummerTermRulesListDTO;

public interface SummerTermRuleService {

    SummerTermRulesDTO getById(Long id);

    SummerTermRulesListDTO getAll();

    SummerTermRulesDTO createNew(SummerTermRulesDTO summerTermRulesDTO);

    SummerTermRulesDTO saveByDTO(Long id, SummerTermRulesDTO summerTermRulesDTO);

    SummerTermRulesDTO patch(Long id, SummerTermRulesDTO vendorDTO);

    void deleteById(Long id);
}
