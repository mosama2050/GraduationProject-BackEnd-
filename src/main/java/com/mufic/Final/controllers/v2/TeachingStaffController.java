package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.TeachingStaffDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.TeachingStaffListDTO;
import com.mufic.Final.services.TeachingStaffService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(TeachingStaffController.BASE_URL)
public class TeachingStaffController {
    public static final String BASE_URL = "/api/v2/teachingstaffs";

    private final TeachingStaffService teachingStaffService;

    public TeachingStaffController(TeachingStaffService teachingStaffService) {
        this.teachingStaffService = teachingStaffService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TeachingStaffListDTO getList(){
        return teachingStaffService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public TeachingStaffDTO getById(@PathVariable Long id){
        return teachingStaffService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeachingStaffDTO createNew(@RequestBody TeachingStaffDTO dto){
        return teachingStaffService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public TeachingStaffDTO updateVendor(@PathVariable Long id, @RequestBody TeachingStaffDTO dto){
        return teachingStaffService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public TeachingStaffDTO patchVendor(@PathVariable Long id, @RequestBody TeachingStaffDTO dto){
        return teachingStaffService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        teachingStaffService.deleteById(id);
    }

}
