package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.RoleDTO;
import com.mufic.Final.domain.Course;
import com.mufic.Final.domain.Privilege;
import com.mufic.Final.domain.Role;
import com.mufic.Final.repositories.PrivilegeRepository;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public abstract class RoleMapper {
//    public RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Autowired
    private PrivilegeRepository privilegeRepository;

    public abstract RoleDTO objToDTO(Role obj);

    public abstract Role dtoToObj(RoleDTO obj);

    @IterableMapping(elementTargetType = String.class)
    protected abstract List<String> maplistToString(List<Privilege> list);

    @IterableMapping(elementTargetType = Privilege.class)
    protected abstract List<Privilege> mapToPrivileges(List<String> list);

    protected String mapToString(Privilege privilege){
        return privilege.getName().name();
    }

    protected Privilege mapToString(String privilege){
        return privilegeRepository.findByName(privilege);
    }
}
