package com.mufic.Final.api.v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProgramLevelDTO {

    private Long id;

    private String nameEnglish;

    private String nameArabic;

    private int minHours;

    @JsonProperty("programleve_url")
    private String programUrl;

}
