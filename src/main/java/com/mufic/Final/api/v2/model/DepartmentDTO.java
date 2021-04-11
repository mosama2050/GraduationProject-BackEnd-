package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Collection;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO{

    private Long id;

    private String nameEnglish;

    private String nameArabic;

    private String code;

    private int graduationProjectHours;

    private int graduationHours;

    private int minTerms;

    private int maxDegreeOnFail;

    @JsonProperty("Department_url")
    private String departmentUrl;

}
