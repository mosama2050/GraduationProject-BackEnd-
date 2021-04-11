package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.StateDTO;
import com.mufic.Final.api.v2.model.lists.StateListDTO;
import com.mufic.Final.services.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(StateController.BASE_URL)
public class StateController {
    public static final String BASE_URL = "/api/v2/states";

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public StateListDTO getList(){
        return stateService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public StateDTO getById(@PathVariable Long id){
        return stateService.getById(id);
    }

}
