package com.mufic.Final.api.v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long id;

    private String nameEnglish;

    private String nameArabic;

    String nationality;

    String gender;

    String religion;

    Date DOB;

    String nationalId;

    String guardianName;

    String GuardianJob;

    String email;

    String secSchool;

    String preQualfication;

    Date QuilificationYear;

    double degrees;

    Long guide;

    Long user;

    Long department;

    Long city;

    Long studentInfo;

    @JsonProperty("student_url")
    private String studentUrl;

}
