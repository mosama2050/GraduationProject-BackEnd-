package com.mufic.Final.api.v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseInTermDTO {


    private Long id;
    private Long term;

    private String course;

    private Long instructor;

    private String lectureDay;

    private int lectureTime;

    private String courseType;

    private int studentCnt;

    private int minStudent;

    @JsonProperty("courseinterm_url")
    private String courseInTermUrl;

}
