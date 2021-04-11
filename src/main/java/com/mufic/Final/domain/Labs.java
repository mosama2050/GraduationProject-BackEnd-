package com.mufic.Final.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "labs")
public class Labs extends BaseEntity{


    @ManyToOne
    @JoinColumn(name = "course_in_Term_id")
    private CourseInTerm courseInTerm;

    @Column(name = "lab_day")
    @Enumerated(value = EnumType.ORDINAL)
    private Day labDay;

    @Column(name = "lab_time")
    private int labTime;

    @ManyToOne
    @JoinColumn(name = "Teaching_staff_id")
    private TeachingStaff teachingStaff;

    @Column(name = "student_cnt")
    private int studentCnt;

    @Column(name = "max_student")
    private int maxStudent;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;


}
