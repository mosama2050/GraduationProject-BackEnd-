package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.UserMapper;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.UserListDTO;
import com.mufic.Final.controllers.v2.UserController;
import com.mufic.Final.domain.Program;
import com.mufic.Final.domain.User;
import com.mufic.Final.repositories.UserRepository;
import com.mufic.Final.services.ResourceNotFoundException;
import com.mufic.Final.services.UserService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getById(Long id) {
        return userRepository.findById(id)
            .map(userMapper::objToDTO)
            .map(userDTO -> {
                userDTO.setUserUrl(getUrl(id));
                return userDTO;
            })
            .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UserListDTO getAll() {
        return new UserListDTO(
            userRepository.findAll()
                .stream()
                .map(userMapper::objToDTO)
                .map(userDTO -> {
                    userDTO.setUserUrl(getUrl(userDTO.getId()));
                    return userDTO;
                })
                .collect(Collectors.toList())
        );
    }


    @Override
    public UserDTO createNew(UserDTO userDTO) {
        User user=userMapper.dtoToObj(userDTO);
        return saveAndReturnDTO(user);
    }

    private UserDTO saveAndReturnDTO(User user) {
        User saved = userRepository.save(user);

        UserDTO returnDto= userMapper.objToDTO(saved);

        returnDto.setUserUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public UserDTO saveByDTO(Long id, UserDTO userDTO) {
        User toSave = userMapper.dtoToObj(userDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public UserDTO patch(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    private String getUrl(long id) {
        return UserController.BASE_URL + "/" + id;
    }

}
