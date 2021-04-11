package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SummerTermRulesDTO {

    private Long id;

    private int gpaLow;

    private int gpaHigh;

    private int hourMin;

    private int hourMax;

    private int hourSpMin;

    private int hourSpMax;

    @JsonProperty("summertermrule_url")
    private String summerTermRuleUrl;

}
