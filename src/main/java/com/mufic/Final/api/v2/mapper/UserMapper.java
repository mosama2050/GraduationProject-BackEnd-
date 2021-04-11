package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.domain.ERole;
import com.mufic.Final.domain.Privilege;
import com.mufic.Final.domain.Role;
import com.mufic.Final.domain.User;
import com.mufic.Final.repositories.RoleRepository;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Mapper
public abstract class UserMapper {
//    public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Autowired
    private RoleRepository roleRepository;

    public abstract UserDTO objToDTO(User obj);

    public abstract User dtoToObj(UserDTO userDTO);

    @IterableMapping(elementTargetType = String.class)
    protected abstract List<String> maplistToString(Set<Role> list);

    @IterableMapping(elementTargetType = Role.class)
    protected abstract List<Role> mapToRoles(Set<String> list);

    protected String mapToString(Role privilege){
        return privilege.getName().name();
    }

    public Role mapToRole(String role){
        return roleRepository.findByName(ERole.valueOf(role)).get();
    }

}
