package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.PrivilegeDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.PrivilegeListDTO;
import com.mufic.Final.services.PrivilegeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(PrivilegeController.BASE_URL)
public class PrivilegeController {
    public static final String BASE_URL = "/api/v2/privilege";

    private final PrivilegeService privilegeService;

    public PrivilegeController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PrivilegeListDTO getList(){
        return privilegeService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public PrivilegeDTO getById(@PathVariable Long id){
        return privilegeService.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrivilegeDTO createNew(@RequestBody PrivilegeDTO dto){
        return privilegeService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public PrivilegeDTO updateVendor(@PathVariable Long id, @RequestBody PrivilegeDTO dto){
        return privilegeService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public PrivilegeDTO patchVendor(@PathVariable Long id, @RequestBody PrivilegeDTO dto){
        return privilegeService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        privilegeService.deleteById(id);
    }
}
