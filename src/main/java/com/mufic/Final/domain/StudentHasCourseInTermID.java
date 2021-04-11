package com.mufic.Final.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
//@Builder
@Embeddable
public class StudentHasCourseInTermID implements Serializable{

    @Builder
    public StudentHasCourseInTermID(Long StudentId, Long courseInTermId) {
        super();
        this.studentId = StudentId;
        this.courseInTermId = courseInTermId;
    }

    private Long studentId;
    private Long courseInTermId;

}
