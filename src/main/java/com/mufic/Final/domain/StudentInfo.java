package com.mufic.Final.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "student_info")
public class StudentInfo extends BaseEntity{

//    @Builder
/*    public StudentInfo(Long id, byte[] img, int totalHours, double GPA, int gpa2Cnt, TeachingStaff guide, User user,
                       Department department, City city, boolean enabled, Date updateTime, Student student) {
        super(id);
        this.img = img;
        this.totalHours = totalHours;
        this.GPA = GPA;
        this.gpa2Cnt = gpa2Cnt;
        this.guide = guide;
        this.user = user;
        this.department = department;
        this.city = city;
        this.enabled = enabled;
        this.updateTime = updateTime;
        this.student = student;
    }
*/

    @Column(name="total_hours")
    private int  totalHours;

    @Column(name = "GPA")
    private double GPA;

    @Column(name = "gpa2_cnt")
    private int gpa2Cnt;

    @OneToOne(mappedBy = "studentInfo")
    private Student student;


}
