package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.StudentDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.StudentListDTO;
import com.mufic.Final.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(StudentController.BASE_URL)
public class StudentController {
    public static final String BASE_URL = "/api/v2/students";

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public StudentListDTO getList(){
        return studentService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO getById(@PathVariable Long id){
        return studentService.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createNew(@RequestBody StudentDTO dto){
        return studentService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO updateVendor(@PathVariable Long id, @RequestBody StudentDTO dto){
        return studentService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO patchVendor(@PathVariable Long id, @RequestBody StudentDTO dto){
        return studentService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        studentService.deleteById(id);
    }

}
