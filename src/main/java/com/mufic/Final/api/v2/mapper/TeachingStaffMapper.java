package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.TeachingStaffDTO;
import com.mufic.Final.domain.*;
import com.mufic.Final.repositories.CityRepository;
import com.mufic.Final.repositories.UserRepository;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public abstract class TeachingStaffMapper {
//    public TeachingStaffMapper INSTANCE = Mappers.getMapper(TeachingStaffMapper.class);

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserRepository userRepository;

    @Mapping(source = "city.id", target = "city")
    public abstract TeachingStaffDTO objToDTO(TeachingStaff obj);

    public abstract TeachingStaff dtoToObj(TeachingStaffDTO teachingStaffDTO);

    @IterableMapping(elementTargetType = Long.class)
    protected abstract List<Long> maplistToString(List<User> list);

    @IterableMapping(elementTargetType = User.class)
    protected abstract List<User> mapToUsers(List<Long> list);

    protected Long mapToLong(User user){
        return user.getId();
    }

    public City convertToCity(Long id){
        return cityRepository.getOne(id);
    }

    public User convertToUser(Long id){
        return userRepository.getOne(id);
    }


}
