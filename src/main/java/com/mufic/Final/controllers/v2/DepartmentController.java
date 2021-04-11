package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.DepartmentDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.DepartmentListDTO;
import com.mufic.Final.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(DepartmentController.BASE_URL)
public class DepartmentController {
    public static final String BASE_URL = "/api/v2/departments";

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public DepartmentListDTO getList(){
        return departmentService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO getById(@PathVariable Long id){
        return departmentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDTO createNew(@RequestBody DepartmentDTO dto){
        return departmentService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO updateVendor(@PathVariable Long id, @RequestBody DepartmentDTO dto){
        return departmentService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO patchVendor(@PathVariable Long id, @RequestBody DepartmentDTO dto){
        return departmentService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        departmentService.deleteById(id);
    }

}
