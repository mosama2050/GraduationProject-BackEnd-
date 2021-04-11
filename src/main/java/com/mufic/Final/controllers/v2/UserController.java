package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.UserListDTO;
import com.mufic.Final.domain.User;
import com.mufic.Final.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/api/v2/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getList(){
        return userService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createNew(@RequestBody UserDTO dto){
        return userService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateVendor(@PathVariable Long id, @RequestBody UserDTO dto){
        return userService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO patchVendor(@PathVariable Long id, @RequestBody UserDTO dto){
        return userService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        userService.deleteById(id);
    }

}
