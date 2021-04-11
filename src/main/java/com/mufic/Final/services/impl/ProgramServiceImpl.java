package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.ProgramMapper;
import com.mufic.Final.api.v2.model.ProgramDTO;
import com.mufic.Final.api.v2.model.lists.ProgramListDTO;
import com.mufic.Final.controllers.v2.ProgramController;
import com.mufic.Final.domain.Program;
import com.mufic.Final.repositories.ProgramRepository;
import com.mufic.Final.services.ProgramService;
import com.mufic.Final.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramMapper programMapper;
    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramMapper programMapper, com.mufic.Final.repositories.ProgramRepository programRepository) {
        this.programMapper = programMapper;
        this.programRepository = programRepository;
    }


    @Override
    public ProgramDTO getById(Long id) {
        return programRepository.findById(id)
            .map(programMapper::objToDTO)
            .map(ProgramDTO -> {
                ProgramDTO.setProgramUrl(getUrl(id));
                return ProgramDTO;
            })
            .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public ProgramListDTO getAll() {
        return new ProgramListDTO(
            programRepository.findAll()
                .stream()
                .map(programMapper::objToDTO)
                .map(ProgramDTO -> {
                    ProgramDTO.setProgramUrl(getUrl(ProgramDTO.getId()));
                    return ProgramDTO;
                })
                .collect(Collectors.toList())
        );
    }

    @Override
    public ProgramDTO createNew(ProgramDTO programDTO) {
        Program program=programMapper.dtoToObj(programDTO);
        return saveAndReturnDTO(program);
    }

    private ProgramDTO saveAndReturnDTO(Program program) {
        Program saved = programRepository.save(program);

        ProgramDTO returnDto= programMapper.objToDTO(saved);

        returnDto.setProgramUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public ProgramDTO saveByDTO(Long id, ProgramDTO programDTO) {
        Program toSave = programMapper.dtoToObj(programDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public ProgramDTO patch(Long id, ProgramDTO programDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        programRepository.deleteById(id);
    }
    private String getUrl(long id) {
        return ProgramController.BASE_URL + "/" + id;
    }

}
