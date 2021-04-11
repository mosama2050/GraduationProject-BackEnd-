package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.LabMapper;
import com.mufic.Final.api.v2.model.LabDTO;
import com.mufic.Final.api.v2.model.lists.LabListDTO;
import com.mufic.Final.controllers.v2.LabController;
import com.mufic.Final.domain.Department;
import com.mufic.Final.domain.Labs;
import com.mufic.Final.repositories.LabRepository;
import com.mufic.Final.services.LabService;
import com.mufic.Final.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LabServiceImpl implements LabService {

    private final LabMapper labMapper;
    private final LabRepository labRepository;

    public LabServiceImpl(LabMapper labMapper, LabRepository labRepository) {
        this.labMapper = labMapper;
        this.labRepository = labRepository;
    }

    @Override
    public LabDTO getById(Long id) {
        return labRepository.findById(id)
                .map(labMapper::objToDTO)
                .map(labDTO -> {
                    labDTO.setLabUrl(getUrl(id));
                    return labDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public LabListDTO getAll() {
        return new LabListDTO(
                labRepository.findAll()
                .stream()
                .map(labMapper::objToDTO)
                .map(labDTO -> {
                    labDTO.setLabUrl(getUrl(labDTO.getId()));
                    return labDTO;
                })
                .collect(Collectors.toList())
        );
    }

    @Override
    public LabDTO createNew(LabDTO labDTO) {
        Labs labs=labMapper.DtoToObj(labDTO);
        return saveAndReturnDTO(labs);
    }

    private LabDTO saveAndReturnDTO(Labs labs ) {
        Labs saved = labRepository.save(labs);

        LabDTO returnDto= labMapper.objToDTO(saved);

        returnDto.setLabUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public LabDTO saveByDTO(Long id, LabDTO labDTO) {
        Labs toSave = labMapper.DtoToObj(labDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public LabDTO patch(Long id, LabDTO labDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        labRepository.deleteById(id);
    }

    private String getUrl(long id) {
        return LabController.BASE_URL + "/" + id;
    }

}
