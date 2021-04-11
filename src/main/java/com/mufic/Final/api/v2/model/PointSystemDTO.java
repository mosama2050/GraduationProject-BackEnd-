package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PointSystemDTO {

    private Long id;

    private String nameEnglish;

    private String nameArabic;

    private int degreeLow;

    private int degreeHigh;

    private double points;

    @JsonProperty("pointsystem_url")
    private String pointSystemUrl;
}
