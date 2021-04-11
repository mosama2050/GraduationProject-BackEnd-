package com.mufic.Final.controllers.v2;

import com.mufic.Final.api.v2.model.CourseDTO;
import com.mufic.Final.api.v2.model.UserDTO;
import com.mufic.Final.api.v2.model.lists.CourseListDTO;
import com.mufic.Final.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(CourseController.BASE_URL)
public class CourseController {
    public static final String BASE_URL = "/api/v2/courses";

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CourseListDTO getList(){
        return courseService.getAll();
    }

    @GetMapping({"/{code}"})
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO getByCode(@PathVariable String code){
        return courseService.getById(code);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createNew(@RequestBody CourseDTO courseDTO){
        return courseService.createNew(courseDTO);
    }


    @PutMapping({"/{code}"})
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO updateVendor(@PathVariable String code, @RequestBody CourseDTO dto){
        return courseService.saveByDTO(code, dto);
    }

    @PatchMapping({"/{code}"})
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO patchVendor(@PathVariable String code, @RequestBody CourseDTO dto){
        return courseService.saveByDTO(code, dto);
    }

    @DeleteMapping({"/{code}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable String code){
        courseService.deleteById(code);
    }



}
