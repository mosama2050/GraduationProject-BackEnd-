package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.PrivilegeDTO;
import com.mufic.Final.api.v2.model.lists.PrivilegeListDTO;

public interface PrivilegeService {
    PrivilegeDTO getById(Long id);

    PrivilegeListDTO getAll();

    PrivilegeDTO createNew(PrivilegeDTO privilegeDTO);

    PrivilegeDTO saveByDTO(Long id, PrivilegeDTO privilegeDTO);

    PrivilegeDTO patch(Long id, PrivilegeDTO privilegeDTO);

    void deleteById(Long id);

}
