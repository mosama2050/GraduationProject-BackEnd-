package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.CityDTO;
import com.mufic.Final.api.v2.model.lists.CityListDTO;
import com.mufic.Final.services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(CityController.BASE_URL)
public class CityController {
    public static final String BASE_URL = "/api/v2/cities";

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CityListDTO getList(){
        return cityService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CityDTO getById(@PathVariable Long id){
        return cityService.getById(id);
    }



}
