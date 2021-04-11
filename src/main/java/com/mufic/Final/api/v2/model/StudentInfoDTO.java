package com.mufic.Final.api.v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentInfoDTO {

    private Long id;

    private int student;

    private int  totalHours;

    private double GPA;

    private int gpa2Cnt;

    @JsonProperty("studentinfo_url")
    private String studentInfoUrl;
}
