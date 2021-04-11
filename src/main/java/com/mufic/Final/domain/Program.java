package com.mufic.Final.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "programs")
public class Program extends BaseEntity {

    @Column(name = "name_english")
    private String nameEnglish;

    @Column(name = "name_arabic")
    private String nameArabic;

    @Column(name = "hours")
    private int hours;

    @ManyToOne
    @JoinColumn(name = "under_requirement")
    Program underRequirement;

//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "underRequirement")
//    List<Program> childern;

    @OneToMany(cascade = CascadeType.ALL,
                mappedBy = "program")
    List<Course> courses;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;


    @Builder
    public Program(Long id, String nameEnglish, String nameArabic, int hours, Program underRequirement,
            /*List<Program> childern,*/ List<Course> courses, Date createTime, Date updateTime) {
        super(id);
        this.nameEnglish = nameEnglish;
        this.nameArabic = nameArabic;
        this.hours = hours;
        this.underRequirement = underRequirement;
//        this.childern = childern;
        this.courses = courses;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Program() {
    }
}
