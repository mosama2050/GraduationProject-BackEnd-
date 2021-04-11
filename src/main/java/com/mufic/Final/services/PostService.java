package com.mufic.Final.services;

import com.mufic.Final.api.v2.model.PostDTO;
import com.mufic.Final.api.v2.model.lists.PostListDTO;
import org.springframework.stereotype.Service;


public interface PostService {

    PostDTO getById(Long id);

    PostListDTO getAll();

    PostDTO createNew(PostDTO postDTO);

    PostDTO saveByDTO(Long id, PostDTO postDTO);

    PostDTO patch(Long id, PostDTO postDTO);

    void deleteById(Long id);
}
