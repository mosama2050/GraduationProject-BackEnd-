package com.mufic.Final.api.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LabDTO{

    private Long id;

    private Long courseInTerm;

    private String labDay;

    private int labTime;

    private Long teachingStaff;

    private int studentCnt;

    private int maxStudent;

    @JsonProperty("lab_url")
    private String labUrl;

}
