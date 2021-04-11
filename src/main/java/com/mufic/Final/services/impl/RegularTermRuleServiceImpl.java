package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.RegularTermRulesMapper;
import com.mufic.Final.api.v2.model.RegularTermRulesDTO;
import com.mufic.Final.api.v2.model.lists.RegularTermRulesListDTO;
import com.mufic.Final.controllers.v2.RegularTermRulesController;
import com.mufic.Final.domain.Program;
import com.mufic.Final.domain.RegularTermRules;
import com.mufic.Final.repositories.RegularTermRuleRepository;
import com.mufic.Final.services.RegularTermRuleService;
import com.mufic.Final.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RegularTermRuleServiceImpl implements RegularTermRuleService {

    private final RegularTermRulesMapper regularTermRulesMapper;
    private final RegularTermRuleRepository regularTermRuleRepository;

    public RegularTermRuleServiceImpl(RegularTermRulesMapper regularTermRulesMapper, RegularTermRuleRepository regularTermRuleRepository) {
        this.regularTermRulesMapper = regularTermRulesMapper;
        this.regularTermRuleRepository = regularTermRuleRepository;
    }

    @Override
    public RegularTermRulesDTO getById(Long id) {
        return regularTermRuleRepository.findById(id)
            .map(regularTermRulesMapper::objToDTO)
            .map(regularTermRulesDTO -> {
                regularTermRulesDTO.setUrl(getUrl(id));
                return regularTermRulesDTO;
            })
            .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public RegularTermRulesListDTO getAll() {
        return new RegularTermRulesListDTO(
            regularTermRuleRepository.findAll()
            .stream()
            .map(regularTermRulesMapper::objToDTO)
            .map(regularTermRulesDTO -> {
                regularTermRulesDTO.setUrl(getUrl(regularTermRulesDTO.getId()));
                return regularTermRulesDTO;
            })
            .collect(Collectors.toList())
        );
    }

    @Override
    public RegularTermRulesDTO createNew(RegularTermRulesDTO regularTermRulesDTO) {
        RegularTermRules regularTermRules=regularTermRulesMapper.dtoToObj(regularTermRulesDTO);
        return saveAndReturnDTO(regularTermRules);
    }

    private RegularTermRulesDTO saveAndReturnDTO(RegularTermRules regularTermRules) {
        RegularTermRules saved = regularTermRuleRepository.save(regularTermRules);

        RegularTermRulesDTO returnDto= regularTermRulesMapper.objToDTO(saved);

        returnDto.setUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public RegularTermRulesDTO saveByDTO(Long id, RegularTermRulesDTO regularTermRulesDTO) {
        RegularTermRules toSave = regularTermRulesMapper.dtoToObj(regularTermRulesDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public RegularTermRulesDTO patch(Long id, RegularTermRulesDTO regularTermRulesDTO) {
        return null;
    }

    private String getUrl(long id) {
        return RegularTermRulesController.BASE_URL + "/" + id;
    }

}
