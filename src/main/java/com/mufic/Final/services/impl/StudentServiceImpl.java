package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.StudentMapper;
import com.mufic.Final.api.v2.model.StudentDTO;
import com.mufic.Final.api.v2.model.lists.StudentListDTO;
import com.mufic.Final.controllers.v2.StudentController;
import com.mufic.Final.domain.Program;
import com.mufic.Final.domain.Student;
import com.mufic.Final.repositories.StudentRepository;
import com.mufic.Final.services.ResourceNotFoundException;
import com.mufic.Final.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO getById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::objToDTO)
                .map(studentDTO -> {
                    studentDTO.setStudentUrl(getUrl(id));
                    return studentDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public StudentListDTO getAll() {
        return new StudentListDTO(
            studentRepository.findAll()
            .stream()
            .map(studentMapper::objToDTO)
            .map(studentDTO -> {
                studentDTO.setStudentUrl(getUrl(studentDTO.getId()));
                return studentDTO;
            })
            .collect(Collectors.toList())
        );
    }

    @Override
    public StudentDTO createNew(StudentDTO studentDTO) {
        Student student=studentMapper.dtoToObj(studentDTO);
        return saveAndReturnDTO(student);
    }

    private StudentDTO saveAndReturnDTO(Student student) {
        Student saved = studentRepository.save(student);

        StudentDTO returnDto= studentMapper.objToDTO(saved);

        returnDto.setStudentUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public StudentDTO saveByDTO(Long id, StudentDTO studentDTO) {
        Student toSave = studentMapper.dtoToObj(studentDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public StudentDTO patch(Long id, StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    private String getUrl(long id) {
        return StudentController.BASE_URL + "/" + id;
    }

}
