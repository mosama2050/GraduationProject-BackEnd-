package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.LabDTO;
import com.mufic.Final.api.v2.model.lists.LabListDTO;
import com.mufic.Final.services.LabService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(LabController.BASE_URL)
public class LabController {
    public static final String BASE_URL = "/api/v2/labs";

    private final LabService labService;

    public LabController(LabService labService) {
        this.labService = labService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public LabListDTO getList(){
        return labService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public LabDTO getById(@PathVariable Long id){
        return labService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LabDTO createNew(@RequestBody LabDTO dto){
        return labService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public LabDTO updateVendor(@PathVariable Long id, @RequestBody LabDTO dto){
        return labService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public LabDTO patchVendor(@PathVariable Long id, @RequestBody LabDTO dto){
        return labService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        labService.deleteById(id);
    }

}
