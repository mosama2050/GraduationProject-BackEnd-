package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.StudentHasCourseInTermDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.StudentHasCourseInTermListDTO;
import com.mufic.Final.services.StudentHasCourseInTermService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(StudentHasCourseInTermController.BASE_URL)
public class StudentHasCourseInTermController {
    public static final String BASE_URL = "/api/v2/studenthascourseinterm";

    private final StudentHasCourseInTermService studentHasCourseInTermService;

    public StudentHasCourseInTermController(StudentHasCourseInTermService studentHasCourseInTermService) {
        this.studentHasCourseInTermService = studentHasCourseInTermService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public StudentHasCourseInTermListDTO getList(){
        return studentHasCourseInTermService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public StudentHasCourseInTermDTO getById(@PathVariable Long id){
        return studentHasCourseInTermService.getByStudentId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentHasCourseInTermDTO createNew(@RequestBody StudentHasCourseInTermDTO dto){
        return studentHasCourseInTermService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public StudentHasCourseInTermDTO updateVendor(@PathVariable Long id, @RequestBody StudentHasCourseInTermDTO dto){
        return studentHasCourseInTermService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public StudentHasCourseInTermDTO patchVendor(@PathVariable Long id, @RequestBody StudentHasCourseInTermDTO dto){
        return studentHasCourseInTermService.saveByDTO(id, dto);
    }


}
