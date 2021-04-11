package com.mufic.Final.api.v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class CityDTO{

    private Long id;

    private String name;

    private int state;

    private String stateCode;

    private int country;

    private String countryCode;

    private double latitude;

    private double longitude;

    private boolean flag;

    private String wikiDataId;

    @JsonProperty("vendor_url")
    private String cityUrl;

}
