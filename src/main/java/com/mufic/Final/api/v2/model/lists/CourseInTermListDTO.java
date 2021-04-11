package com.mufic.Final.api.v2.model.lists;

import com.mufic.Final.api.v2.model.CourseInTermDTO;
import com.mufic.Final.domain.CourseInTerm;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseInTermListDTO {
    List<CourseInTermDTO> courseInTerms;

}
