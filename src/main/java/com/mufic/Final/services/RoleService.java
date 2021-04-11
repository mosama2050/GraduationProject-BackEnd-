package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.RoleDTO;
import com.mufic.Final.api.v2.model.lists.RoleListDTO;

public interface RoleService {
    RoleDTO getById(Long id);

    RoleListDTO getAll();

    RoleDTO createNew(RoleDTO roleDTO);

    RoleDTO saveByDTO(Long id, RoleDTO roleDTO);

    RoleDTO patch(Long id, RoleDTO roleDTO);

    void deleteById(Long id);
}
