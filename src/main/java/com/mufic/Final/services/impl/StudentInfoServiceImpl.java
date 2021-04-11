package com.mufic.Final.services.impl;

import com.mufic.Final.api.v2.mapper.StudentInfoMapper;
import com.mufic.Final.api.v2.model.StudentInfoDTO;
import com.mufic.Final.api.v2.model.lists.StudentInfoListDTO;
import com.mufic.Final.controllers.v2.StudentInfoController;
import com.mufic.Final.domain.Program;
import com.mufic.Final.domain.StudentInfo;
import com.mufic.Final.repositories.StudentInfoRepository;
import com.mufic.Final.services.ResourceNotFoundException;
import com.mufic.Final.services.StudentInfoService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    private final StudentInfoMapper studentInfoMapper;
    private final StudentInfoRepository studentInfoRepository;

    public StudentInfoServiceImpl(StudentInfoMapper studentInfoMapper, StudentInfoRepository studentInfoRepository) {
        this.studentInfoMapper = studentInfoMapper;
        this.studentInfoRepository = studentInfoRepository;
    }

    @Override
    public StudentInfoDTO getById(Long id) {
        return studentInfoRepository.findById(id)
                .map(studentInfoMapper::objToDTO)
                .map(studentInfoDTO -> {
                    studentInfoDTO.setStudentInfoUrl(getUrl(id));
                    return studentInfoDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public StudentInfoListDTO getAll() {
        return new StudentInfoListDTO(
                studentInfoRepository.findAll()
                .stream()
                .map(studentInfoMapper::objToDTO)
                .map(studentInfoDTO -> {
                    studentInfoDTO.setStudentInfoUrl(getUrl(studentInfoDTO.getId()));
                    return studentInfoDTO;
                })
                .collect(Collectors.toList())
        );
    }

    @Override
    public StudentInfoDTO createNew(StudentInfoDTO studentInfoDTO) {
        StudentInfo studentInfo=studentInfoMapper.dtoToObj(studentInfoDTO);
        return saveAndReturnDTO(studentInfo);
    }

    private StudentInfoDTO saveAndReturnDTO(StudentInfo studentInfo) {
        StudentInfo saved = studentInfoRepository.save(studentInfo);

        StudentInfoDTO returnDto= studentInfoMapper.objToDTO(saved);

        returnDto.setStudentInfoUrl(getUrl(saved.getId()));

        return returnDto;
    }

    @Override
    public StudentInfoDTO saveByDTO(Long id, StudentInfoDTO studentInfoDTO) {
        StudentInfo toSave = studentInfoMapper.dtoToObj(studentInfoDTO);
        toSave.setId(id);
        return saveAndReturnDTO(toSave);
    }

    @Override
    public StudentInfoDTO patch(Long id, StudentInfoDTO studentInfoDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        studentInfoRepository.deleteById(id);
    }

    private String getUrl(long id) {
        return StudentInfoController.BASE_URL + "/" + id;
    }

}
