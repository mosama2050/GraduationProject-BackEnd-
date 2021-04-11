package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegularTermRulesDTO {

    private Long id;

    private int gpaLow;

    private int gpaHigh;

    private int hourMin;

    private int hourMax;

    private int hourSpMin;

    private int hourSpMax;

    @JsonProperty("regulartermRule_url")
    private String Url;

}
