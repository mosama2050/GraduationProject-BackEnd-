package com.mufic.Final.api.v2.model.lists;

import com.mufic.Final.api.v2.model.StudentInfoDTO;
import com.mufic.Final.domain.StudentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentInfoListDTO {
    List<StudentInfoDTO> studentInfos;

}
