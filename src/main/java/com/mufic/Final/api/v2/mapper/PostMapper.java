package com.mufic.Final.api.v2.mapper;

import com.mufic.Final.api.v2.model.PostDTO;
import com.mufic.Final.domain.Post;
import com.mufic.Final.domain.User;
import com.mufic.Final.repositories.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class PostMapper {

    @Autowired private UserRepository userRepository;

    @Mapping(source = "user.id", target = "user")
    public abstract PostDTO objToDTO(Post obj);

    public abstract Post DtoToObj(PostDTO postDTO);


    User toUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

}
