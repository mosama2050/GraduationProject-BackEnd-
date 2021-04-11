package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.CourseInTermDTO;
import com.mufic.Final.api.v2.model.lists.CourseInTermListDTO;
import com.mufic.Final.services.CourseInTermService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(CourseInTermController.BASE_URL)
public class CourseInTermController {
    public static final String BASE_URL = "/api/v2/courseinterm";

    private final CourseInTermService courseInTermService;

    public CourseInTermController(CourseInTermService courseInTermService) {
        this.courseInTermService = courseInTermService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CourseInTermListDTO getList(){
        return courseInTermService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CourseInTermDTO getById(@PathVariable Long id){
        return courseInTermService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseInTermDTO createNew(@RequestBody CourseInTermDTO dto){
        return courseInTermService.createNew(dto);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CourseInTermDTO updateVendor(@PathVariable Long id, @RequestBody CourseInTermDTO dto){
        return courseInTermService.saveByDTO(id, dto);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CourseInTermDTO patchVendor(@PathVariable Long id, @RequestBody CourseInTermDTO dto){
        return courseInTermService.saveByDTO(id, dto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        courseInTermService.deleteById(id);
    }
}
