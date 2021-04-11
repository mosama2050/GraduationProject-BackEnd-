package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.PostDTO;
import com.mufic.Final.api.v2.model.lists.PostListDTO;
import com.mufic.Final.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController {
    public static final String BASE_URL = "/api/v2/posts";

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PostListDTO getList(){
        return postService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public PostDTO getById(@PathVariable Long id){
        return postService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO createNew(@RequestBody PostDTO dto){
        return postService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public PostDTO updateVendor(@PathVariable Long id, @RequestBody PostDTO dto){
        return postService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public PostDTO patchVendor(@PathVariable Long id, @RequestBody PostDTO dto){
        return postService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        postService.deleteById(id);
    }

}
