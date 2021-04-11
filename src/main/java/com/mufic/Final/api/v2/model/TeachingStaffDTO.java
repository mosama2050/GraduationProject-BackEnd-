package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeachingStaffDTO{

    private Long id;

    private String nameEnglish;

    private String nameArabic;

    private String nationality;

    private String gender;

    private String religion;

    private Date DOB;

    private String nationalId;

    private String email;

    private String phdDegree;

    private Long user;

    private Long city;

    @JsonProperty("teachingstaff_url")
    private String teachingStaffUrl;

}
