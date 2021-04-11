package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.UserListDTO;

public interface UserService {
    UserDTO getById(Long id);

    UserListDTO getAll();

    UserDTO createNew(UserDTO userDTO);

    UserDTO saveByDTO(Long id, UserDTO userDTO);

    UserDTO patch(Long id, UserDTO userDTO);

    void deleteById(Long id);
}
