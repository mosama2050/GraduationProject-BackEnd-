package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.ProgramLevelMapper;
import com.mufic.Final.api.v2.model.ProgramLevelDTO;
import com.mufic.Final.api.v2.model.lists.ProgramLevelListDTO;
import com.mufic.Final.controllers.v2.ProgramLevelController;
import com.mufic.Final.domain.ProgramLevel;
import com.mufic.Final.repositories.ProgramLevelRepository;
import com.mufic.Final.services.ProgramLevelService;
import com.mufic.Final.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProgramLevelServiceImpl implements ProgramLevelService {

    private final ProgramLevelMapper programLevelMapper;
    private final ProgramLevelRepository programLevelRepository;

    public ProgramLevelServiceImpl(ProgramLevelMapper programLevelMapper, ProgramLevelRepository programLevelRepository) {
        this.programLevelMapper = programLevelMapper;
        this.programLevelRepository = programLevelRepository;
    }

    @Override
    public ProgramLevelDTO getById(Long id) {
        return programLevelRepository.findById(id)
                .map(programLevelMapper::objToDTO)
                .map(programLevelDTO -> {
                    programLevelDTO.setProgramUrl(getUrl(id));
                    return programLevelDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public ProgramLevelListDTO getAll() {
        return new ProgramLevelListDTO(
                programLevelRepository.findAll()
                .stream()
                .map(programLevelMapper::objToDTO)
                .map(programLevelDTO -> {
                    programLevelDTO.setProgramUrl(getUrl(programLevelDTO.getId()));
                    return programLevelDTO;
                })
                .collect(Collectors.toList())
        );
    }

    @Override
    public ProgramLevelDTO createNew(ProgramLevelDTO programLevelDTO) {
        ProgramLevel programLevel=programLevelMapper.dtoToObj(programLevelDTO);
        return saveAndReturnDTO(programLevel);
    }

    private ProgramLevelDTO saveAndReturnDTO(ProgramLevel programLevel) {
        ProgramLevel saved = programLevelRepository.save(programLevel);

        ProgramLevelDTO returnDto= programLevelMapper.objToDTO(saved);

        returnDto.setProgramUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public ProgramLevelDTO saveByDTO(Long id, ProgramLevelDTO programLevelDTO) {
        return null;
    }

    @Override
    public ProgramLevelDTO patch(Long id, ProgramLevelDTO programLevelDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        programLevelRepository.deleteById(id);
    }

    private String getUrl(long id) {
        return ProgramLevelController.BASE_URL + "/" + id;
    }

}
