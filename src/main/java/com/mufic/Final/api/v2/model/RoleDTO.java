package com.mufic.Final.api.v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {

    private Long id;

    private String name;

    private String description;

    private List<String> privileges;

    @JsonProperty("role_url")
    private String roleUrl;

}
