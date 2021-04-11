package com.mufic.Final.api.v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentHasCourseInTermDTO {

    private Long studentId;

    private Long courseInTermId;


    private int labAttend;

    private int lecAttend;

    private int midterm;

    private int finl;

    private int degree;

    private double points;

    private String grade;

    String status;

    @JsonProperty("studenthascourseinterm_url")
    private String studentHasCourseInTermUrl;

}
