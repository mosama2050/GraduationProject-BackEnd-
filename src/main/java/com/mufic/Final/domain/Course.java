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
//@ToString
@Builder
@Entity
@Table(name="course")
public class Course{

    @Id
    @Column(name = "code")
    String code;

    @Column(name = "name_english")
    private String nameEnglish;

    @Column(name = "name_arabic")
    private String nameArabic;

    @Column(name = "hours")
    private int hours;

    @Column(name = "lec_hours", precision = 1)
    private double lecHours;

    @Column(name = "lab_hours", precision = 1)
    private double LabHours;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "force")
    private int force;

    @ManyToOne
    @JoinColumn(name = "programs_id")
    Program program;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pre_course")
    Course preCourse;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "preCourse")
    List<Course> childern;




    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    @OneToMany(mappedBy = "course")
    List<CourseInTerm> courseInTermList;




    public String getParCourse(){
        if(preCourse!=null)
            return preCourse.getCode();
        return "-";
//        return "Hello";
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", nameEnglish='" + nameEnglish + '\'' +
                ", nameArabic='" + nameArabic + '\'' +
                ", hours=" + hours +
                ", lecHours=" + lecHours +
                ", LabHours=" + LabHours +
                ", description='" + description + '\'' +
                ", program=" + program.getNameArabic() +
                ", preCourse=" + preCourse.getCode() +
                ", childern=" + childern +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", courseInTermList=" + courseInTermList +
                '}';
    }

}
