package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.RegularTermRulesDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.RegularTermRulesListDTO;
import com.mufic.Final.services.RegularTermRuleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(RegularTermRulesController.BASE_URL)
public class RegularTermRulesController {
    public static final String BASE_URL = "/api/v2/regulartermrules";

    private final RegularTermRuleService regularTermRuleService;

    public RegularTermRulesController(RegularTermRuleService regularTermRuleService) {
        this.regularTermRuleService = regularTermRuleService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RegularTermRulesListDTO getList(){
        return regularTermRuleService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public RegularTermRulesDTO getById(@PathVariable Long id){
        return regularTermRuleService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegularTermRulesDTO createNew(@RequestBody RegularTermRulesDTO dto){
        return regularTermRuleService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public RegularTermRulesDTO updateVendor(@PathVariable Long id, @RequestBody RegularTermRulesDTO dto){
        return regularTermRuleService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public RegularTermRulesDTO patchVendor(@PathVariable Long id, @RequestBody RegularTermRulesDTO dto){
        return regularTermRuleService.saveByDTO(id, dto);
    }


}
