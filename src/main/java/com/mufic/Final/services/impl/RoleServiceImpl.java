package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.RoleMapper;
import com.mufic.Final.api.v2.model.RoleDTO;
import com.mufic.Final.api.v2.model.lists.RoleListDTO;
import com.mufic.Final.controllers.v2.RoleController;
import com.mufic.Final.domain.Program;
import com.mufic.Final.domain.Role;
import com.mufic.Final.repositories.RoleRepository;
import com.mufic.Final.services.ResourceNotFoundException;
import com.mufic.Final.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleMapper roleMapper, RoleRepository roleRepository) {
        this.roleMapper = roleMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDTO getById(Long id) {
        return roleRepository.findById(id)
            .map(roleMapper::objToDTO)
            .map(roleDTO -> {
                roleDTO.setRoleUrl(getUrl(id));
                return roleDTO;
            })
            .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public RoleListDTO getAll() {
        return new RoleListDTO(
                roleRepository.findAll()
                .stream()
                .map(roleMapper::objToDTO)
                .map(roleDTO -> {
                    roleDTO.setRoleUrl(getUrl(roleDTO.getId()));
                    return roleDTO;
                })
                .collect(Collectors.toList())
        );
    }

    @Override
    public RoleDTO createNew(RoleDTO roleDTO) {
        Role role=roleMapper.dtoToObj(roleDTO);
        return saveAndReturnDTO(role);
    }

    private RoleDTO saveAndReturnDTO(Role role) {
        Role saved = roleRepository.save(role);

        RoleDTO returnDto= roleMapper.objToDTO(saved);

        returnDto.setRoleUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public RoleDTO saveByDTO(Long id, RoleDTO roleDTO) {
        Role toSave = roleMapper.dtoToObj(roleDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public RoleDTO patch(Long id, RoleDTO roleDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
    private String getUrl(long id) {
        return RoleController.BASE_URL + "/" + id;
    }

}
