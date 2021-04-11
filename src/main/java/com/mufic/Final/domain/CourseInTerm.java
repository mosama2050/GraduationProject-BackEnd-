package com.mufic.Final.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@Entity
@Table(name= "course_in_term")
public class CourseInTerm extends BaseEntity{


    @ManyToOne
    @JoinColumn(name = "Term_Id")
//    @MapsId("termId")
    private Term term;

    @ManyToOne
    @JoinColumn(name = "Course_Code")
//    @MapsId( "courseCode")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "instructor")
    private TeachingStaff instructor;

    @Column(name = "lecture_day")
    @Enumerated(value = EnumType.ORDINAL)
    private Day lectureDay;

    @Column(name = "lecture_time")
    private int lectureTime;

    @Column(name = "lab_or_groub")
    @Enumerated(value = EnumType.STRING)
    private CourseType courseType;

    @Column(name = "student_cnt")
    private int studentCnt;

    @Column(name = "min_student")
    private int minStudent;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    @OneToMany(mappedBy = "courseInTerm")
    private List<StudentHasCourseInTerm> studentHasCourseInTerms;

    @OneToMany(mappedBy = "courseInTerm")
    private List<Labs> labs;

}
