package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    String code;

    private String nameEnglish;

    private String nameArabic;

    private int hours;

    private double lecHours;

    private double labHours;

    private String description;

    private int force;

    Long program;

    String preCourse;

    @JsonProperty("course_url")
    private String courseUrl;

}
