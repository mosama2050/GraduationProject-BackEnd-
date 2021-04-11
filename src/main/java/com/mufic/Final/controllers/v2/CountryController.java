package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.CityDTO;
import com.mufic.Final.api.v2.model.CountryDTO;
import com.mufic.Final.api.v2.model.lists.CityListDTO;
import com.mufic.Final.api.v2.model.lists.CountryListDTO;
import com.mufic.Final.services.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(CountryController.BASE_URL)
public class CountryController {
    public static final String BASE_URL = "/api/v2/countries";

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CountryListDTO getList(){
        return countryService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CountryDTO getById(@PathVariable Long id){
        return countryService.getById(id);
    }


}
