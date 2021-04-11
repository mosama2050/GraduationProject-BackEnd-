package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.TeachingStaffMapper;
import com.mufic.Final.api.v2.model.TeachingStaffDTO;
import com.mufic.Final.api.v2.model.lists.TeachingStaffListDTO;
import com.mufic.Final.controllers.v2.TeachingStaffController;
import com.mufic.Final.domain.Program;
import com.mufic.Final.domain.TeachingStaff;
import com.mufic.Final.repositories.TeachingStaffRepository;
import com.mufic.Final.services.ResourceNotFoundException;
import com.mufic.Final.services.TeachingStaffService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TeachingStaffServiceImpl implements TeachingStaffService {

    private final TeachingStaffMapper teachingStaffMapper;
    private final TeachingStaffRepository teachingStaffRepository;

    public TeachingStaffServiceImpl(TeachingStaffMapper teachingStaffMapper, TeachingStaffRepository teachingStaffRepository) {
        this.teachingStaffMapper = teachingStaffMapper;
        this.teachingStaffRepository = teachingStaffRepository;
    }


    @Override
    public TeachingStaffDTO getById(Long id) {
        return teachingStaffRepository.findById(id)
                .map(teachingStaffMapper::objToDTO)
                .map(teachingStaffDTO -> {
                    teachingStaffDTO.setTeachingStaffUrl(getUrl(id));
                    return teachingStaffDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public TeachingStaffListDTO getAll() {
        return new TeachingStaffListDTO(
                teachingStaffRepository.findAll()
                .stream()
                .map(teachingStaffMapper::objToDTO)
                .map(teachingStaffDTO -> {
                    teachingStaffDTO.setTeachingStaffUrl(getUrl(teachingStaffDTO.getId()));
                    return teachingStaffDTO;
                })
                .collect(Collectors.toList())
        );
    }

    @Override
    public TeachingStaffDTO createNew(TeachingStaffDTO DTO) {
        TeachingStaff teachingStaff=teachingStaffMapper.dtoToObj(DTO);
        return saveAndReturnDTO(teachingStaff);
    }

    private TeachingStaffDTO saveAndReturnDTO(TeachingStaff teachingStaff) {
        TeachingStaff saved = teachingStaffRepository.save(teachingStaff);

        TeachingStaffDTO returnDto= teachingStaffMapper.objToDTO(saved);

        returnDto.setTeachingStaffUrl(getUrl(saved.getId()));

        return returnDto;
    }


    @Override
    public TeachingStaffDTO saveByDTO(Long id, TeachingStaffDTO teachingStaffDTO) {
        TeachingStaff toSave = teachingStaffMapper.dtoToObj(teachingStaffDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public TeachingStaffDTO patch(Long id, TeachingStaffDTO teachingStaffDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        teachingStaffRepository.deleteById(id);
    }

    private String getUrl(long id) {
        return TeachingStaffController.BASE_URL + "/" + id;
    }

}
