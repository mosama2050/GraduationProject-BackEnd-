package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.ProgramLevelDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.ProgramLevelListDTO;
import com.mufic.Final.services.ProgramLevelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(ProgramLevelController.BASE_URL)
public class ProgramLevelController {
    public static final String BASE_URL = "/api/v2/programlevels";

    private final ProgramLevelService programLevelService;

    public ProgramLevelController(ProgramLevelService programLevelService) {
        this.programLevelService = programLevelService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProgramLevelListDTO getList(){
        return programLevelService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ProgramLevelDTO getById(@PathVariable Long id){
        return programLevelService.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProgramLevelDTO createNew(@RequestBody ProgramLevelDTO dto){
        return programLevelService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ProgramLevelDTO updateVendor(@PathVariable Long id, @RequestBody ProgramLevelDTO dto){
        return programLevelService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ProgramLevelDTO patchVendor(@PathVariable Long id, @RequestBody ProgramLevelDTO dto){
        return programLevelService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        programLevelService.deleteById(id);
    }

}
