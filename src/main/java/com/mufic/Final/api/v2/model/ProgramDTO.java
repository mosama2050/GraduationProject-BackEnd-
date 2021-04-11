package com.mufic.Final.api.v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProgramDTO {

    private Long id;

    private String nameEnglish;

    private String nameArabic;

    private int hours;

    int underRequirement;

//    List<String> courses;

    @JsonProperty("program_url")
    private String programUrl;
}
