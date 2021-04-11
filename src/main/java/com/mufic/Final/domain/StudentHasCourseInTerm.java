package com.mufic.Final.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "Student_has_course_in_term")
public class StudentHasCourseInTerm{

    @EmbeddedId
    StudentHasCourseInTermID studentHasCourseInTermID;

    @ManyToOne
    @JoinColumn(name = "Student_id")
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_in_term_id")
    @MapsId("courseInTermId")
    private CourseInTerm courseInTerm;

    @Column(name = "lab_attend")
    private int labAttend;

    @Column(name = "lec_attend")
    private int lecAttend;

    @Column(name = "midterm")
    private int midterm;

    @Column(name = "final")
    private int finl;

    @Column(name = "degree")
    private int degree;

    @Column(name = "points")
    private double points;

    @Column(name = "grade")
    private String grade;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    Status status;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

}
