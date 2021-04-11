package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.TermDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.TermListDTO;
import com.mufic.Final.services.TermService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(TermController.BASE_URL)
public class TermController {
    public static final String BASE_URL = "/api/v2/terms";

    private final TermService termService;

    public TermController(TermService termService) {
        this.termService = termService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TermListDTO getList(){
        return termService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public TermDTO getById(@PathVariable Long id){
        return termService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TermDTO createNew(@RequestBody TermDTO dto){
        return termService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public TermDTO updateVendor(@PathVariable Long id, @RequestBody TermDTO dto){
        return termService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public TermDTO patchVendor(@PathVariable Long id, @RequestBody TermDTO dto){
        return termService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        termService.deleteById(id);
    }

}
