package com.mufic.Final.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CourseInTermId implements Serializable {


    public CourseInTermId(String courseCode, Long termId) {
        this.courseCode = courseCode;
        this.termId = termId;
    }

    private String courseCode;

    private Long termId;


}
