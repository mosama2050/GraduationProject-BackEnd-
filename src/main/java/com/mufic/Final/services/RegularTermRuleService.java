package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.RegularTermRulesDTO;
import com.mufic.Final.api.v2.model.lists.RegularTermRulesListDTO;

public interface RegularTermRuleService {
    RegularTermRulesDTO getById(Long id);

    RegularTermRulesListDTO getAll();

    RegularTermRulesDTO createNew(RegularTermRulesDTO regularTermRulesDTO);

    RegularTermRulesDTO saveByDTO(Long id, RegularTermRulesDTO regularTermRulesDTO);

    RegularTermRulesDTO patch(Long id, RegularTermRulesDTO regularTermRulesDTO);

//    void deleteById(Long id);
}
