package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.CourseMapper;
import com.mufic.Final.api.v2.model.CourseDTO;
import com.mufic.Final.api.v2.model.lists.CourseListDTO;
import com.mufic.Final.controllers.v2.CourseController;
import com.mufic.Final.domain.Course;
import com.mufic.Final.repositories.CourseRepository;
import com.mufic.Final.services.CourseService;
import com.mufic.Final.services.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseMapper courseMapper, CourseRepository courseRepository) {
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDTO getById(String code) {
        return courseRepository.findById(code)
                .map(courseMapper::courseToCourseDTO)
                .map(courseDTO -> {
                    courseDTO.setCourseUrl(getUrl(code));
                    return courseDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CourseListDTO getAll() {
        return new CourseListDTO(
                courseRepository.findAll()
                    .stream()
                    .map(courseMapper::courseToCourseDTO)
                    .map(courseDTO -> {
                        courseDTO.setCourseUrl(getUrl(courseDTO.getCode()));
                        return courseDTO;
                    }).collect(Collectors.toList())
        );
    }

    @Override
    public CourseDTO createNew(CourseDTO courseDTO) {

        Course course=courseMapper.CourseDtoTocourse(courseDTO);
//        log.info(course.toString());
        return saveAndReturnDTO(course);
//        return null;
    }

    private CourseDTO saveAndReturnDTO(Course course) {
        Course saved = courseRepository.save(course);

         CourseDTO returnDto= courseMapper.courseToCourseDTO(saved);

        returnDto.setCourseUrl(getUrl(saved.getCode()));

        return returnDto;
    }

    @Override
    public CourseDTO saveByDTO(String code, CourseDTO courseDTO) {
        Course toSave = courseMapper.CourseDtoTocourse(courseDTO);
        toSave.setCode(code);

        return saveAndReturnDTO(toSave);
    }

    @Override
    public CourseDTO patch(String code, CourseDTO courseDTO) {
        return courseRepository.findById(code)
            .map(vendor -> {
                //todo if more properties, add more if statements
                if(courseDTO.getNameArabic() != null){
                    vendor.setNameArabic(courseDTO.getNameArabic());
                }
                if(courseDTO.getNameEnglish() != null){
                    vendor.setNameEnglish(courseDTO.getNameEnglish());
                }

                return saveAndReturnDTO(vendor);
            }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteById(String code) {
        courseRepository.deleteById(code);
    }

    private String getUrl(String code) {
        return CourseController.BASE_URL + "/" + code;
    }

}
