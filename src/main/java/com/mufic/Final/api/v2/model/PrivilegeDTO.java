package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrivilegeDTO{

    private Long id;

    private String name;

    @JsonProperty("privilege_url")
    private String privilegeUrl;

}
