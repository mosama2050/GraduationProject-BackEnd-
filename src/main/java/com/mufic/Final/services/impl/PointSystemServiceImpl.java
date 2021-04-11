package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.PointSystemMapper;
import com.mufic.Final.api.v2.model.PointSystemDTO;
import com.mufic.Final.api.v2.model.lists.PointSystemListDTO;
import com.mufic.Final.controllers.v2.PointSystemController;
import com.mufic.Final.domain.Department;
import com.mufic.Final.domain.PointSystem;
import com.mufic.Final.repositories.PointSystemRepository;
import com.mufic.Final.services.PointSystemService;
import com.mufic.Final.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PointSystemServiceImpl implements PointSystemService {

    private final PointSystemMapper pointSystemMapper;
    private final PointSystemRepository pointSystemRepository;

    public PointSystemServiceImpl(PointSystemMapper pointSystemMapper, PointSystemRepository pointSystemRepository) {
        this.pointSystemMapper = pointSystemMapper;
        this.pointSystemRepository = pointSystemRepository;
    }

    @Override
    public PointSystemDTO getById(Long id) {
        return pointSystemRepository.findById(id)
                .map(pointSystemMapper::objToDTO)
                .map(pointSystemDTO -> {
                    pointSystemDTO.setPointSystemUrl(getUrl(id));
                    return pointSystemDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public PointSystemListDTO getAll() {
        return new PointSystemListDTO(
                pointSystemRepository.findAll()
                .stream()
                .map(pointSystemMapper::objToDTO)
                .map(pointSystemDTO -> {
                    pointSystemDTO.setPointSystemUrl(getUrl(pointSystemDTO.getId()));
                    return pointSystemDTO;
                })
                .collect(Collectors.toList())
        );
    }

    @Override
    public PointSystemDTO createNew(PointSystemDTO pointSystemDTO) {
        PointSystem pointSystem=pointSystemMapper.dtoToObj(pointSystemDTO);
        return saveAndReturnDTO(pointSystem);
    }

    private PointSystemDTO saveAndReturnDTO(PointSystem pointSystem) {
        PointSystem saved = pointSystemRepository.save(pointSystem);

        PointSystemDTO returnDto= pointSystemMapper.objToDTO(saved);

        returnDto.setPointSystemUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public PointSystemDTO saveByDTO(Long id, PointSystemDTO pointSystemDTO) {
        PointSystem toSave = pointSystemMapper.dtoToObj(pointSystemDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public PointSystemDTO patch(Long id, PointSystemDTO pointSystemDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        pointSystemRepository.deleteById(id);
    }
    private String getUrl(long id) {
        return PointSystemController.BASE_URL + "/" + id;
    }

}
