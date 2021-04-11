package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.PostMapper;
import com.mufic.Final.api.v2.model.PostDTO;
import com.mufic.Final.api.v2.model.lists.PostListDTO;
import com.mufic.Final.controllers.v2.PostController;
import com.mufic.Final.domain.Post;
import com.mufic.Final.repositories.PostRepository;
import com.mufic.Final.services.PostService;
import com.mufic.Final.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;

    public PostServiceImpl(PostMapper postMapper, PostRepository postRepository) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO getById(Long id) {
        return postRepository.findById(id)
                .map(postMapper::objToDTO)
                .map(postDTO -> {
                    postDTO.setUrl(getUrl(id));
                    return postDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public PostListDTO getAll() {
        return new PostListDTO(
                postRepository.findAll()
                .stream()
                .map(postMapper::objToDTO)
                .map(postDTO -> {
                    postDTO.setUrl(getUrl(postDTO.getId()));
                    return postDTO;
                })
                .collect(Collectors.toList())
        );
    }


    @Override
    public PostDTO createNew(PostDTO postDTO) {
        Post post=postMapper.DtoToObj(postDTO);
        return saveAndReturnDTO(post);
    }

    private PostDTO saveAndReturnDTO(Post post ) {
        Post saved = postRepository.save(post);

        PostDTO returnDto= postMapper.objToDTO(saved);

        returnDto.setUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public PostDTO saveByDTO(Long id, PostDTO postDTO) {
        Post toSave = postMapper.DtoToObj(postDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public PostDTO patch(Long id, PostDTO postDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    private String getUrl(long id) {
        return PostController.BASE_URL + "/" + id;
    }
}
